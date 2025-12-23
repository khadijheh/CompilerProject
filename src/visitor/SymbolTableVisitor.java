package visitor;

import symbol.SymbolTable;
import symbol.Symbol;
import symbol.Scope;
import ast.base.BaseNode;

import ast.python.expressions.*;
import ast.python.statements.*;
import ast.python.other.*;

import ast.web.*;
import ast.web.html.*;
import ast.web.css.*;
import ast.web.jinja.*;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.reflect.Method;

public class SymbolTableVisitor implements ASTVisitor<Void> {
    private final SymbolTable symbolTable;
    private int currentLine;
    private int currentColumn;
    private boolean isInsideClassAttribute = false;
    private boolean isInsideJinjaExpression = false;


    public SymbolTableVisitor() {
        this.symbolTable = new SymbolTable();
        this.currentLine = 1;
        this.currentColumn = 1;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    private void setPosition(BaseNode node) {
        this.currentLine = node.getLine();
        this.currentColumn = node.getColumn();
    }

    private void defineSymbol(String name, Symbol.SymbolType type) {
        defineSymbol(name, type, null);
    }

    private void defineSymbol(String name, Symbol.SymbolType type, Object value) {
        if (shouldIgnoreSymbol(name)) {
            return;
        }
        symbolTable.defineSymbol(name, type, currentLine, currentColumn, value);
    }

    private boolean shouldIgnoreSymbol(String name) {
        if (name == null || name.isBlank()) return true;

        return switch (name) {
            case "{{", "}}", "POST", "GET", "multipart/form-data",
                 "stylesheet", "confirm", "return",
                 "(", ")", "[", "]", "{", "}", ",", ":" -> true;
            default -> false;
        };
    }

    private String getNodeName(BaseNode node, String methodName) {
        try {
            Method method = node.getClass().getMethod(methodName);
            Object result = method.invoke(node);
            if (result instanceof String) {
                return (String) result;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private Object getFieldValue(Object obj, String fieldName) {
        try {
            Method method = obj.getClass().getMethod("get" +
                    fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            return method.invoke(obj);
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public Void visit(FileInputNode node) {
        setPosition(node);
        symbolTable.enterScope("file_input", Scope.ScopeType.MODULE);

        if (node.getStatements() != null) {
            for (BaseNode stmt : node.getStatements()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(SimpleStmtNode node) {
        setPosition(node);
        if (node.getStmt() != null) {
            node.getStmt().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SimpleStmtLineNode node) {
        setPosition(node);
        if (node.getStatements() != null) {
            for (BaseNode stmt : node.getStatements()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(CompoundStmtNode node) {
        setPosition(node);
        if (node.getStmt() != null) {
            node.getStmt().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefNode node) {
        setPosition(node);
        String functionName = getNodeName(node, "getName");

        if (functionName != null) {
            symbolTable.enterScope(functionName, Scope.ScopeType.FUNCTION);
            defineSymbol(functionName, Symbol.SymbolType.FUNCTION);

            if (node.getParams() != null) {
                node.getParams().accept(this);
            }

            if (node.getBody() != null) {
                for (BaseNode stmt : node.getBody()) {
                    if (stmt != null) {
                        stmt.accept(this);
                    }
                }
            }

            symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ClassDefNode node) {
        setPosition(node);
        String className = getNodeName(node, "getName");

        if (className != null) {
            symbolTable.enterScope(className, Scope.ScopeType.CLASS);
            defineSymbol(className, Symbol.SymbolType.CLASS);

            if (node.getBaseClasses() != null) {
                for (BaseNode baseClass : node.getBaseClasses()) {
                    if (baseClass != null) {
                        baseClass.accept(this);
                    }
                }
            }

            if (node.getBody() != null) {
                for (BaseNode stmt : node.getBody()) {
                    if (stmt != null) {
                        stmt.accept(this);
                    }
                }
            }

            symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ParameterListNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getParameters");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object param : (List<?>) result) {
                    if (param instanceof String) {
                        defineSymbol((String) param, Symbol.SymbolType.PARAMETER);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(IfStmtNode node) {
        setPosition(node);

        symbolTable.enterScope("if_block", Scope.ScopeType.CONDITIONAL);

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        if (node.getThenBody() != null) {
            for (BaseNode stmt : node.getThenBody()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }

        symbolTable.exitScope();

        try {
            Method method = node.getClass().getMethod("getElifBranches");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object branch : (List<?>) result) {
                    symbolTable.enterScope("elif_block", Scope.ScopeType.CONDITIONAL);

                    if (branch instanceof IfStmtNode.IfBranch) {
                        IfStmtNode.IfBranch elifBranch = (IfStmtNode.IfBranch) branch;

                        if (elifBranch.getCondition() != null) {
                            elifBranch.getCondition().accept(this);
                        }

                        if (elifBranch.getBody() != null) {
                            for (BaseNode stmt : elifBranch.getBody()) {
                                if (stmt != null) {
                                    stmt.accept(this);
                                }
                            }
                        }
                    }

                    symbolTable.exitScope();
                }
            }
        } catch (Exception ignored) {
        }

        try {
            Method method = node.getClass().getMethod("getElseBody");
            Object result = method.invoke(node);
            if (result instanceof List && !((List<?>) result).isEmpty()) {
                symbolTable.enterScope("else_block", Scope.ScopeType.CONDITIONAL);

                for (Object stmt : (List<?>) result) {
                    if (stmt instanceof BaseNode) {
                        ((BaseNode) stmt).accept(this);
                    }
                }

                symbolTable.exitScope();
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public Void visit(ForStmtNode node) {
        setPosition(node);
        symbolTable.enterScope("for_loop", Scope.ScopeType.LOOP);

        if (node.getTarget() != null) {
            node.getTarget().accept(this);
        }

        if (node.getIterable() != null) {
            node.getIterable().accept(this);
        }

        if (node.getBody() != null) {
            for (BaseNode stmt : node.getBody()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(WhileStmtNode node) {
        setPosition(node);
        symbolTable.enterScope("while_loop", Scope.ScopeType.LOOP);

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        if (node.getBody() != null) {
            for (BaseNode stmt : node.getBody()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(WithStmtNode node) {
        setPosition(node);
        symbolTable.enterScope("with_block", Scope.ScopeType.WITH_BLOCK);

        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }

        String alias = getNodeName(node, "getAlias");
        if (alias != null && !alias.isEmpty()) {
            defineSymbol(alias, Symbol.SymbolType.VARIABLE);
        }

        if (node.getBody() != null) {
            for (BaseNode stmt : node.getBody()) {
                if (stmt != null) {
                    stmt.accept(this);
                }
            }
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(NameNode node) {
        setPosition(node);
        String name = getNodeName(node, "getName");
        if (name != null && !name.equals("__name__")) {
            defineSymbol(name, Symbol.SymbolType.VARIABLE);
        }
        return null;
    }

    @Override
    public Void visit(AttributeNode node) {
        setPosition(node);
        String attributeName = getNodeName(node, "getAttribute");
        if (attributeName != null) {
            defineSymbol(attributeName, Symbol.SymbolType.ATTRIBUTE);
        }

        if (node.getObject() != null) {
            node.getObject().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(CallNode node) {
        setPosition(node);

        String functionName = null;

        if (node.getFunction() instanceof NameNode) {
            functionName = ((NameNode) node.getFunction()).getName();
        } else if (node.getFunction() instanceof AttributeNode) {
            functionName = ((AttributeNode) node.getFunction()).getAttribute();
        }

        if (node.getFunction() != null) {
            node.getFunction().accept(this);
        }
        if (node.getArgs() != null) {
            for (int i = 0; i < node.getArgs().size(); i++) {
                ExprNode arg = node.getArgs().get(i);

                if (arg instanceof StringNode) {
                    String value = ((StringNode) arg).getValue();

                    if ("render_template".equals(functionName) && i == 0) {

                        defineSymbol(value, Symbol.SymbolType.TEMPLATE_REF);
                    }
                    else if ("redirect".equals(functionName) && i == 0) {

                        defineSymbol("Redirect to: " + value , Symbol.SymbolType.URL_PATTERN);
                    }
                }
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }

        if (node.getNamedArgs() != null) {
            node.getNamedArgs().accept(this);
        }

        return null;
    }


    @Override
    public Void visit(BinaryOpNode node) {
        setPosition(node);
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryOpNode node) {
        setPosition(node);
        if (node.getOperand() != null) node.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {
        setPosition(node);
        if (node.getLeft() != null) node.getLeft().accept(this);

        try {
            Method method = node.getClass().getMethod("getComparisons");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object comp : (List<?>) result) {
                    if (comp instanceof ComparisonNode.ComparisonOp) {
                        ComparisonNode.ComparisonOp comparison = (ComparisonNode.ComparisonOp) comp;
                        if (comparison.getRight() != null) {
                            comparison.getRight().accept(this);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public Void visit(ListLiteralNode node) {
        setPosition(node);
        if (node.getElements() != null) {
            for (ExprNode elem : node.getElements()) {
                if (elem != null) {
                    elem.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(IndexNode node) {
        setPosition(node);
        if (node.getObject() != null) node.getObject().accept(this);

        if (node.getIndex() instanceof StringNode) {
            String key = getNodeName((StringNode) node.getIndex(), "getValue");
            if (key != null) {

                defineSymbol(key, Symbol.SymbolType.VARIABLE);
            }
        }

        if (node.getIndex() != null) node.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(NamedArgListNode node) {
        setPosition(node);
        try {
            Method getNamesMethod = node.getClass().getMethod("getNames");
            Method getValuesMethod = node.getClass().getMethod("getValues");

            Object namesResult = getNamesMethod.invoke(node);
            Object valuesResult = getValuesMethod.invoke(node);

            if (namesResult instanceof List && valuesResult instanceof List) {
                List<?> names = (List<?>) namesResult;
                List<?> values = (List<?>) valuesResult;

                for (int i = 0; i < Math.min(names.size(), values.size()); i++) {
                    if (names.get(i) instanceof String) {
                        defineSymbol((String) names.get(i), Symbol.SymbolType.VARIABLE);
                    }
                    if (values.get(i) instanceof ExprNode) {
                        ((ExprNode) values.get(i)).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(AssignNode node) {
        setPosition(node);
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }

        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmtNode node) {
        setPosition(node);
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ImportStmtNode node) {
        setPosition(node);
        try {
            Method getModuleMethod = node.getClass().getMethod("getModule");
            Method getImportsMethod = node.getClass().getMethod("getImports");
            Method isFromImportMethod = node.getClass().getMethod("isFromImport");

            Object moduleResult = getModuleMethod.invoke(node);
            Object importsResult = getImportsMethod.invoke(node);
            Object isFromImportResult = isFromImportMethod.invoke(node);

            if (moduleResult instanceof String && !((String) moduleResult).isEmpty()) {
                defineSymbol((String) moduleResult,
                        Boolean.TRUE.equals(isFromImportResult) ?
                                Symbol.SymbolType.MODULE : Symbol.SymbolType.IMPORT);
            }

            if (importsResult instanceof List) {
                for (Object importName : (List<?>) importsResult) {
                    if (importName instanceof String) {
                        defineSymbol((String) importName, Symbol.SymbolType.IMPORT);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(PassNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(NumberNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(BoolNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(NoneNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(ArgListNode node) {
        setPosition(node);
        if (node.getPositional() != null) {
            for (ExprNode arg : node.getPositional()) {
                if (arg != null) {
                    arg.accept(this);
                }
            }
        }

        if (node.getNamed() != null) {
            node.getNamed().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(NamedDecoratorArgsNode node) {
        setPosition(node);

        try {
            Method getNamesMethod = node.getClass().getMethod("getNames");
            Method getValuesMethod = node.getClass().getMethod("getValues");

            Object namesResult = getNamesMethod.invoke(node);
            Object valuesResult = getValuesMethod.invoke(node);

            if (namesResult instanceof List && valuesResult instanceof List) {
                List<?> names = (List<?>) namesResult;
                List<?> values = (List<?>) valuesResult;

                for (int i = 0; i < Math.min(names.size(), values.size()); i++) {
                    if (names.get(i) instanceof String) {
                        defineSymbol((String) names.get(i),
                                Symbol.SymbolType.DECORATOR_KEYWORD);
                    }

                    if (values.get(i) instanceof ExprNode) {
                        ((ExprNode) values.get(i)).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {}

        return null;
    }

    @Override
    public Void visit(DecoratorNode node) {
        setPosition(node);
        String decoratorName = getNodeName(node, "getName");

        if (decoratorName != null) {
            if (symbolTable.resolveInCurrentScope(decoratorName) != null) {

                String uniqueName = decoratorName + " (" + currentLine + ")";
                defineSymbol(uniqueName, Symbol.SymbolType.DECORATOR);
            } else {

                defineSymbol(decoratorName, Symbol.SymbolType.DECORATOR);
            }
        }

        if (node.getArgs() != null) {
            node.getArgs().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(DecoratorArgsNode node) {
        setPosition(node);

        List<ExprNode> positional = node.getPositional();
        if (positional != null) {
            for (ExprNode arg : positional) {

                if (arg instanceof StringNode) {
                    String value = getNodeName((StringNode) arg, "getValue");
                    if (value != null) {

                        defineSymbol(value, Symbol.SymbolType.URL_PATTERN);
                    }
                }

                if (arg != null) {
                    arg.accept(this);
                }
            }
        }

        NamedDecoratorArgsNode named = node.getNamed();
        if (named != null) {
            named.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(DecoratedDefNode node) {

        List<DecoratorNode> decorators = node.getDecorators();
        if (decorators != null) {
            for (DecoratorNode decorator : decorators) {
                if (decorator != null) {
                    setPosition(decorator);
                    decorator.accept(this);
                }
            }
        }
        if (node.getDefinition() != null) {
            setPosition(node.getDefinition());
            node.getDefinition().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(TemplateNode node) {
        setPosition(node);
        symbolTable.enterScope("template", Scope.ScopeType.TEMPLATE);

        if (node.getContent() != null) {
            for (ContentItemNode item : node.getContent()) {
                if (item != null) {
                    item.accept(this);
                }
            }
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(ContentHtmlElement node) {
        setPosition(node);
        if (node.getElement() != null) {
            node.getElement().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ContentHtmlText node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(ContentJinjaExpression node) {
        setPosition(node);
        isInsideJinjaExpression = true;
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        isInsideJinjaExpression = false;
        return null;
    }

    @Override
    public Void visit(ContentJinjaBlock node) {
        setPosition(node);
        if (node.getBlock() != null) {
            node.getBlock().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ContentJinjaComment node) {
        setPosition(node);
        if (node.getComment() != null) {
            node.getComment().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ContentCssStyle node) {
        setPosition(node);
        if (node.getCssStyle() != null) {
            node.getCssStyle().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VoidElementNode node) {
        setPosition(node);
        String tagName = getNodeName(node, "getTagName");
        if (tagName != null) {
            defineSymbol(tagName, Symbol.SymbolType.HTML_ELEMENT, "<" + tagName + ">");
        }

        try {
            Method method = node.getClass().getMethod("getAttributes");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object attr : (List<?>) result) {
                    if (attr instanceof BaseNode) {
                        ((BaseNode) attr).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public Void visit(NormalElementNode node) {
        setPosition(node);
        String tagName = getNodeName(node, "getTagName");
        if (tagName != null) {
            defineSymbol(tagName, Symbol.SymbolType.HTML_ELEMENT, "<" + tagName + ">");
        }

        try {
            Method method = node.getClass().getMethod("getAttributes");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object attr : (List<?>) result) {
                    if (attr instanceof BaseNode) {
                        ((BaseNode) attr).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }

        symbolTable.enterScope(tagName != null ? tagName + "_element" : "element",
                Scope.ScopeType.HTML_ELEMENT);

        try {
            Method method = node.getClass().getMethod("getContent");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object item : (List<?>) result) {
                    if (item instanceof ContentItemNode) {
                        ((ContentItemNode) item).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(HtmlAttributeAssignment node) {
        setPosition(node);

        String attrName = getNodeName(node, "getName");

        if (attrName != null) {
            defineSymbol(attrName, Symbol.SymbolType.HTML_ATTRIBUTE);

            if ("class".equals(attrName)) {
                isInsideClassAttribute = true;
                extractClassesFromAttributeValue(node);
                isInsideClassAttribute = false;
            }

            if ("name".equals(attrName)) {
                Object val = node.getValue();
                String extracted = extractTextFromValue(val);
                if (extracted != null && !isFileLike(extracted)) {
                    defineSymbol(extracted, Symbol.SymbolType.VARIABLE);
                }
            }

            if ("href".equals(attrName) ||
                    "src".equals(attrName) ||
                    "action".equals(attrName) ||
                    "onsubmit".equals(attrName)) {
                extractJinjaSymbolsFromAttributeValue(node);
            }
        }

        if (node.getValue() != null && !(node.getValue() instanceof AttrTextNode)) {
            node.getValue().accept(this);
        }

        return null;
    }

    private void extractClassesFromAttributeValue(HtmlAttributeAssignment node) {
        try {
            Object value = getFieldValue(node, "value");
            if (value != null) {
                extractClassesFromValueObject(value);
            }
        } catch (Exception ignored) {
        }
    }

    private void extractJinjaSymbolsFromAttributeValue(HtmlAttributeAssignment node) {
        try {
            Object value = getFieldValue(node, "value");
            if (value != null) {
                extractJinjaSymbolsFromValue(value);
            }
        } catch (Exception ignored) {
        }
    }

    private void extractClassesFromValueObject(Object value) {
        if (value == null) return;

        String text = extractTextFromValue(value);
        if (text != null && !text.trim().isEmpty()) {
            extractCssClassesFromText(text);
        }

        try {
            Method getContentMethod = value.getClass().getMethod("getContent");
            Object content = getContentMethod.invoke(value);
            if (content instanceof List) {
                for (Object item : (List<?>) content) {
                    if (item instanceof AttrTextNode) {
                        String itemText = getNodeName((AttrTextNode) item, "getText");
                        if (itemText != null) {
                            extractCssClassesFromText(itemText);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void extractJinjaSymbolsFromValue(Object value) {
        if (value == null) return;

        String text = extractTextFromValue(value);
        if (text != null) {
            extractSymbolsFromText(text);
        }

        try {
            Method getContentMethod = value.getClass().getMethod("getContent");
            Object content = getContentMethod.invoke(value);
            if (content instanceof List) {
                for (Object item : (List<?>) content) {
                    if (item instanceof AttrJinjaExpressionNode) {
                        ((AttrJinjaExpressionNode) item).accept(this);
                    } else if (item instanceof AttrTextNode) {
                        String itemText = getNodeName((AttrTextNode) item, "getText");
                        if (itemText != null) {
                            extractSymbolsFromText(itemText);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    private String extractTextFromValue(Object value) {
        if (value == null) return null;

        if (value instanceof AttrTextNode) {
            return getNodeName((AttrTextNode) value, "getText");
        }

        try {
            Method getContent = value.getClass().getMethod("getContent");
            Object content = getContent.invoke(value);

            if (content instanceof List) {
                for (Object o : (List<?>) content) {
                    if (o instanceof AttrTextNode) {
                        return getNodeName((AttrTextNode) o, "getText");
                    }
                }
            }
        } catch (Exception ignored) {}

        return null;
    }

    private void extractCssClassesFromText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        String[] classes = text.trim().split("\\s+");
        for (String className : classes) {
            className = className.trim();
            if (!className.isEmpty() && !className.startsWith("{{") && !className.endsWith("}}")) {
                defineSymbol("." + className, Symbol.SymbolType.CSS_SELECTOR);
            }
        }
    }

    private void extractSymbolsFromText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        Pattern jinjaPattern = Pattern.compile("\\{\\{([^}]+)\\}\\}|\\{%([^%]+)%\\}");
        Matcher matcher = jinjaPattern.matcher(text);

        while (matcher.find()) {
            String expression = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            if (expression != null) {
                extractSymbolsFromJinjaExpression(expression.trim());
            }
        }
    }

    @Override
    public Void visit(HtmlAttributeBoolean node) {
        setPosition(node);
        String attributeName = getNodeName(node, "getName");
        if (attributeName != null) {
            defineSymbol(attributeName, Symbol.SymbolType.HTML_ATTRIBUTE);
        }
        return null;
    }

    @Override
    public Void visit(DoubleQuotedValue node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getContent");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object contentItem : (List<?>) result) {
                    if (contentItem instanceof BaseNode) {
                        ((BaseNode) contentItem).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(SingleQuotedValue node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getContent");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object contentItem : (List<?>) result) {
                    if (contentItem instanceof BaseNode) {
                        ((BaseNode) contentItem).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(AttrTextNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(AttrJinjaExpressionNode node) {
        setPosition(node);
        isInsideJinjaExpression = true;
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
        isInsideJinjaExpression = false;
        return null;
    }

    @Override
    public Void visit(AttrJinjaBlockNode node) {
        setPosition(node);
        if (node.getBlock() != null) {
            node.getBlock().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(AttrJinjaCommentNode node) {
        setPosition(node);
        if (node.getComment() != null) {
            node.getComment().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(HtmlTextNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(CssStyleNode node) {
        setPosition(node);
        symbolTable.enterScope("css_style", Scope.ScopeType.CSS_RULE);

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(CssBodyNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getChildren");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object child : (List<?>) result) {
                    if (child instanceof BaseNode) {
                        ((BaseNode) child).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(CssRuleNode node) {
        setPosition(node);
        symbolTable.enterScope("css_rule", Scope.ScopeType.CSS_RULE);

        if (node.getSelectors() != null) {
            node.getSelectors().accept(this);
        }

        if (node.getDeclarations() != null) {
            node.getDeclarations().accept(this);
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(CssSelectorListNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getSelectors");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object selector : (List<?>) result) {
                    if (selector instanceof CssSelectorNode) {
                        ((CssSelectorNode) selector).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(CssSelectorNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getParts");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object part : (List<?>) result) {
                    if (part instanceof BaseNode) {
                        ((BaseNode) part).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(SelectorPartNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getSimpleSelectors");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object selector : (List<?>) result) {
                    if (selector instanceof BaseNode) {
                        ((BaseNode) selector).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(TypeSelectorNode node) {
        setPosition(node);
        String name = getNodeName(node, "getName");
        if (name != null) {
            defineSymbol(name, Symbol.SymbolType.CSS_SELECTOR);
        }
        return null;
    }

    @Override
    public Void visit(AttributeSelectorNode node) {
        setPosition(node);
        String attribute = getNodeName(node, "getAttribute");
        String value = getNodeName(node, "getValue");

        if (attribute != null) {
            String selector = "[" + attribute + (value != null ? "=\"" + value + "\"" : "") + "]";
            defineSymbol(selector, Symbol.SymbolType.CSS_SELECTOR);
        }
        return null;
    }

    @Override
    public Void visit(ClassSelectorNode node) {
        setPosition(node);
        if (isInsideClassAttribute) {
            String className = getNodeName(node, "getClassName");
            if (className != null) {
                defineSymbol("." + className, Symbol.SymbolType.CSS_SELECTOR);
            }
        }
        return null;
    }

    @Override
    public Void visit(IdSelectorNode node) {
        setPosition(node);
        String idName = getNodeName(node, "getIdName");
        if (idName != null) {
            defineSymbol("#" + idName, Symbol.SymbolType.CSS_SELECTOR);
        }
        return null;
    }

    @Override
    public Void visit(PseudoSelectorNode node) {
        setPosition(node);
        String pseudo = getNodeName(node, "getPseudo");
        if (pseudo != null) {
            defineSymbol(":" + pseudo, Symbol.SymbolType.CSS_SELECTOR);
        }
        return null;
    }

    @Override
    public Void visit(CssDeclarationNode node) {
        setPosition(node);
        String property = getNodeName(node, "getProperty");
        if (property != null) {
            defineSymbol(property, Symbol.SymbolType.CSS_PROPERTY);
        }

        try {
            Method method = node.getClass().getMethod("getValue");
            Object result = method.invoke(node);
            if (result instanceof BaseNode) {
                ((BaseNode) result).accept(this);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(CssValueNode node) {
        setPosition(node);
        try {
            Method method = node.getClass().getMethod("getAtoms");
            Object result = method.invoke(node);
            if (result instanceof List) {
                for (Object atom : (List<?>) result) {
                    if (atom instanceof BaseNode) {
                        ((BaseNode) atom).accept(this);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(CssValueAtomNode node) {
        setPosition(node);
        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {
        setPosition(node);
        isInsideJinjaExpression = true;
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        isInsideJinjaExpression = false;
        return null;
    }

    @Override
    public Void visit(JinjaExprBodyNode node) {
        setPosition(node);
        String expression = getNodeName(node, "getExpression");
        if (expression != null) {
            extractSymbolsFromJinjaExpression(expression);
        }
        return null;
    }

    @Override
    public Void visit(JinjaBlockNode node) {
        setPosition(node);
        symbolTable.enterScope("jinja_block", Scope.ScopeType.JINJA_BLOCK);

        if (node.getInner() != null) {
            node.getInner().accept(this);
        }

        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(ForStartNode node) {
        setPosition(node);
        symbolTable.enterScope("jinja_for", Scope.ScopeType.LOOP);

        try {
            Method getVariablesMethod = node.getClass().getMethod("getVariables");
            Object vars = getVariablesMethod.invoke(node);

            if (vars instanceof List) {
                for (Object v : (List<?>) vars) {
                    if (v instanceof String) {
                        defineSymbol((String) v, Symbol.SymbolType.VARIABLE);
                    }
                }
            }
        } catch (Exception ignored) {}

        try {
            Method getIterableMethod = node.getClass().getMethod("getIterable");
            Object iterable = getIterableMethod.invoke(node);

            if (iterable instanceof String) {
                defineSymbol((String) iterable, Symbol.SymbolType.VARIABLE);
            }
        } catch (Exception ignored) {}

        return null;
    }

    @Override
    public Void visit(ForEndNode node) {
        setPosition(node);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(IfStartNode node) {
        setPosition(node);
        symbolTable.enterScope("jinja_if", Scope.ScopeType.CONDITIONAL);

        try {
            Method getConditionMethod = node.getClass().getMethod("getCondition");
            Object result = getConditionMethod.invoke(node);
            if (result instanceof String) {
                extractSymbolsFromJinjaExpression((String) result);
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public Void visit(ElifPartNode node) {
        setPosition(node);
        symbolTable.exitScope();
        symbolTable.enterScope("jinja_elif", Scope.ScopeType.CONDITIONAL);

        try {
            Method getConditionMethod = node.getClass().getMethod("getCondition");
            Object result = getConditionMethod.invoke(node);
            if (result instanceof String) {
                extractSymbolsFromJinjaExpression((String) result);
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public Void visit(ElsePartNode node) {
        setPosition(node);
        symbolTable.exitScope();
        symbolTable.enterScope("jinja_else", Scope.ScopeType.CONDITIONAL);
        return null;
    }

    @Override
    public Void visit(EndIfPartNode node) {
        setPosition(node);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(SetStmtNode node) {
        setPosition(node);
        try {
            Method getAssignmentMethod = node.getClass().getMethod("getAssignment");
            Object result = getAssignmentMethod.invoke(node);
            if (result instanceof String) {
                String assignment = (String) result;
                if (assignment.contains("=")) {
                    String[] parts = assignment.split("=", 2);
                    if (parts.length == 2) {
                        String varName = parts[0].trim();
                        defineSymbol(varName, Symbol.SymbolType.VARIABLE);
                        extractSymbolsFromJinjaExpression(parts[1].trim());
                    }
                } else {
                    defineSymbol(assignment.trim(), Symbol.SymbolType.VARIABLE);
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(WebSimpleStmtNode node) {
        setPosition(node);
        try {
            Method getStatementMethod = node.getClass().getMethod("getStatement");
            Object result = getStatementMethod.invoke(node);
            if (result instanceof String) {
                extractSymbolsFromJinjaExpression((String) result);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(JinjaBlockExprNode node) {
        setPosition(node);
        try {
            Method getExpressionMethod = node.getClass().getMethod("getExpression");
            Object result = getExpressionMethod.invoke(node);
            if (result instanceof String) {
                extractSymbolsFromJinjaExpression((String) result);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public Void visit(JinjaCommentNode node) {
        setPosition(node);
        return null;
    }

    private void extractSymbolsFromJinjaExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) return;

        String expr = expression.trim();

        Pattern functionPattern = Pattern.compile("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\(");
        Matcher functionMatcher = functionPattern.matcher(expr);
        while (functionMatcher.find()) {
            String functionName = functionMatcher.group(1);
            if (!functionName.isEmpty() && !isReservedWord(functionName)) {
                defineSymbol(functionName, Symbol.SymbolType.BUILTIN_FUNCTION);
            }
        }

        String exprWithoutStrings = expr.replaceAll("'[^']*'", " ")
                .replaceAll("\"[^\"]*\"", " ");

        Pattern variablePattern = Pattern.compile("\\b([a-zA-Z_][a-zA-Z0-9_]*(?:\\.[a-zA-Z_][a-zA-Z0-9_]*)*)\\b");
        Matcher variableMatcher = variablePattern.matcher(exprWithoutStrings);

        while (variableMatcher.find()) {
            String symbol = variableMatcher.group(1);
            if (symbol.isEmpty() || isReservedWord(symbol)) continue;

            if (symbol.contains(".")) {
                String[] parts = symbol.split("\\.");
                defineSymbol(parts[0], Symbol.SymbolType.VARIABLE);

                StringBuilder current = new StringBuilder(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    current.append(".").append(parts[i]);
                    defineSymbol(current.toString(), Symbol.SymbolType.ATTRIBUTE);
                }
            } else {
                defineSymbol(symbol, Symbol.SymbolType.VARIABLE);
            }
        }
    }

    private boolean isFileLike(String value) {
        return value.matches(".(png|jpg|jpeg|gif|svg|css|js|ico|webp)$")
                || value.contains("/")
                || value.contains("-");
    }

    private boolean isReservedWord(String word) {
        String[] reservedWords = {
                "static", "filename", "uploads", "css", "style", "confirm",
                "return", "true", "false", "null", "none", "self", "for",
                "in", "if", "else", "elif", "endif", "endfor", "with", "as",
                "POST", "GET", "method", "enctype", "action", "onsubmit",
                "static", "filename"
        };

        for (String reserved : reservedWords) {
            if (word.equalsIgnoreCase(reserved)) {
                return true;
            }
        }
        return false;
    }
}