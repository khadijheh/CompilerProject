package visitor;

import ast.base.BaseNode;
import ast.python.expressions.*;
import ast.python.statements.*;
import ast.python.other.*;
import ast.web.*;
import ast.web.html.*;
import ast.web.css.*;
import ast.web.jinja.*;

import java.util.List;

public class PrinterVisitor implements ASTVisitor<Void> {


    private void printlnNode(String text, int line) {
        for (int i = 0; i < indent; i++) System.out.print("  ");
        if (line >= 0) System.out.println(text + " (line: " + line + ")");
        else System.out.println(text);
    }
    private int indent = 0;

    private void printIndent() {
        for (int i = 0; i < indent; i++) System.out.print("  ");
    }

    private void println(String text) {
        printIndent();
        System.out.println(text);
    }

    private void visitList(List<? extends BaseNode> nodes) {
        if (nodes != null) {
            for (BaseNode node : nodes) {
                if (node != null) node.accept(this);
            }
        }
    }

    // ==================== Python AST Nodes ====================
    @Override
    public Void visit(FileInputNode node) {
        if (node == null) return null;
        println("FileInputNode (line " + node.getLine() + ")");
        indent++;
        visitList(node.getStatements());
        indent--;
        return null;
    }

    @Override
    public Void visit(DecoratorNode node) {
        if (node == null) return null;
        println("DecoratorNode: " + node.getName() + " (line " + node.getLine() + ")");
        indent++;
        visitList(node.getArgs());
        visitList(node.getNamedArgs());
        indent--;
        return null;
    }

    @Override
    public Void visit(DecoratedDefNode node) {
        if (node == null) return null;
        println("DecoratedDefNode (line " + node.getLine() + ")");
        indent++;
        if (node.getDecorators() != null && !node.getDecorators().isEmpty()) {
            println("Decorators:");
            indent++;
            visitList(node.getDecorators());
            indent--;
        }
        BaseNode def = node.getDefinition();
        if (def != null) {
            println("Definition:");
            indent++;
            def.accept(this);
            indent--;
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(NamedDecoratorArgsNode node) {
        if (node == null) return null;
        println("NamedDecoratorArgsNode (line " + node.getLine() + ")");
        indent++;
        for (int i = 0; i < node.getNames().size(); i++) {
            println(node.getNames().get(i) + " =");
            indent++;
            BaseNode value = node.getValues().get(i);
            if (value != null) value.accept(this);
            indent--;
        }
        indent--;
        return null;
    }


    @Override
    public Void visit(SimpleStmtNode node) {
        if (node.getStmt() != null) node.getStmt().accept(this);
        return null;
    }

    @Override
    public Void visit(SimpleStmtLineNode node) {
        if (node == null || node.getStatements() == null || node.getStatements().isEmpty()) {
            return null; //  تجاهل العقدة الفارغة
        }
        visitList(node.getStatements());
        return null;
    }

    @Override
    public Void visit(CompoundStmtNode node) {
        if (node == null) return null;
        println("CompoundStmtNode (line " + node.getLine() + ")");
        indent++;
        if (node.getStmt() != null) node.getStmt().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(FunctionDefNode node) {
        if (node == null) return null;

        println("FunctionDefNode: " + node.getName()
                + " (line " + node.getLine() + ")");

        indent++;

        if (node.getParams() != null) {
            println("Parameters:");
            indent++;
            node.getParams().accept(this);
            indent--;
        }

        println("Body:");
        indent++;
        visitList(node.getBody());
        indent--;

        indent--;
        return null;
    }

    @Override
    public Void visit(ParameterListNode node) {
        if (node == null) return null;
        println("ParameterListNode (line " + node.getLine() + "): " + String.join(", ", node.getParameters()));
        return null;
    }

    @Override
    public Void visit(ClassDefNode node) {
        println("ClassDefNode: " + node.getName() + " (line " + node.getLine() + ")");
        indent++;

        if (node.getBaseClasses() != null && !node.getBaseClasses().isEmpty()) {
            println("BaseClasses:");
            indent++;
            for (BaseNode base : node.getBaseClasses()) {
                base.accept(this);
            }
            indent--;
        }

        if (node.getBody() != null && !node.getBody().isEmpty()) {
            println("Body:");
            indent++;
            for (BaseNode stmt : node.getBody()) {
                stmt.accept(this);
            }
            indent--;
        }

        indent--;
        return null;
    }


    @Override
    public Void visit(IfStmtNode node) {
        if (node == null) return null;
        println("IfStmtNode (line " + node.getLine() + ")");
        indent++;
        if (node.getCondition() != null) {
            println("Condition:");
            indent++;
            node.getCondition().accept(this);
            indent--;
        }
        println("Then Body:");
        indent++;
        for (BaseNode stmt : node.getThenBody()) {
            if (!(stmt instanceof CompoundStmtNode))
                stmt.accept(this);
        }

        indent--;
        if (node.getElifBranches() != null) {
            for (IfStmtNode.IfBranch elif : node.getElifBranches()) {
                println("Elif Condition:");
                indent++;
                if (elif.getCondition() != null) elif.getCondition().accept(this);
                indent--;
                println("Elif Body:");
                indent++;
                visitList(elif.getBody());
                indent--;
            }
        }
        if (node.getElseBody() != null && !node.getElseBody().isEmpty()) {
            println("Else Body:");
            indent++;
            visitList(node.getElseBody());
            indent--;
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(ForStmtNode node) {
        if (node == null) return null;
        println("ForStmtNode (line " + node.getLine() + ")");
        indent++;
        println("Target:");
        indent++;
        if (node.getTarget() != null) node.getTarget().accept(this);
        indent--;
        println("Iterable:");
        indent++;
        if (node.getIterable() != null) node.getIterable().accept(this);
        indent--;
        println("Body:");
        indent++;
        visitList(node.getBody());
        indent--;
        indent--;
        return null;
    }

    @Override
    public Void visit(WhileStmtNode node) {
        if (node == null) return null;
        println("WhileStmtNode (line " + node.getLine() + ")");
        indent++;
        println("Condition:");
        indent++;
        if (node.getCondition() != null) node.getCondition().accept(this);
        indent--;
        println("Body:");
        indent++;
        visitList(node.getBody());
        indent--;
        indent--;
        return null;
    }

    @Override
    public Void visit(WithStmtNode node) {
        if (node == null) return null;
        println("WithStmtNode (line " + node.getLine() + ")");
        indent++;
        println("Expression:");
        indent++;
        if (node.getExpression() != null) node.getExpression().accept(this);
        indent--;
        if (node.getAlias() != null) println("Alias: " + node.getAlias());
        println("Body:");
        indent++;
        visitList(node.getBody());
        indent--;
        indent--;
        return null;
    }

    @Override
    public Void visit(ReturnStmtNode node) {
        if (node == null) return null;

        println("ReturnStmtNode (line " + node.getLine() + ")");
        if (node.getValue() != null) {
            indent++;
            println("Value:");
            indent++;
            node.getValue().accept(this);
            indent -= 2;
        }
        return null;
    }


    @Override
    public Void visit(ImportStmtNode node) {
        if (node == null) return null;
        println("ImportStmtNode (line " + node.getLine() + ")");
        indent++;
        if (node.getModule() != null) println("Module: " + node.getModule());
        if (node.getImports() != null && !node.getImports().isEmpty()) {
            println("Imports: " + String.join(", ", node.getImports()));
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(AssignNode node) {
        if (node == null) return null;
        println("AssignNode (line " + node.getLine() + ")");
        indent++;
        if (node.getLeft() != null) {
            println("Left:");
            indent++;
            node.getLeft().accept(this);
            indent--;
        }
        if (node.getRight() != null) {
            println("Right:");
            indent++;
            node.getRight().accept(this);
            indent--;
        }
        indent--;
        return null;
    }

    public Void visit(BinaryOpNode node) {
        if (node == null) return null;
        println("BinaryOpNode: " + node.getOperator() + " (line " + node.getLine() + ")");
        indent++;
        println("Left:");
        indent++;
        if (node.getLeft() != null) node.getLeft().accept(this);
        indent--;
        println("Right:");
        indent++;
        if (node.getRight() != null) node.getRight().accept(this);
        indent--;
        indent--;
        return null;
    }

    @Override
    public Void visit(UnaryOpNode node) {
        if (node == null) return null;
        println("UnaryOpNode: " + node.getOperator() + " (line " + node.getLine() + ")");
        indent++;
        if (node.getOperand() != null) node.getOperand().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {
        if (node == null) return null;

        println("ComparisonNode (line " + node.getLine() + ")");
        indent++;

        if (node.getLeft() != null) {
            println("Left:");
            indent++;
            node.getLeft().accept(this);
            indent--;
        }

        if (node.getComparisons() != null) {
            for (ComparisonNode.ComparisonOp op : node.getComparisons()) {
                println("Operator: " + op.getOperator());
                indent++;
                if (op.getRight() != null) op.getRight().accept(this);
                indent--;
            }
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(NameNode node) {
        if (node == null) return null;
        println("NameNode: " + node.getName() + " (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NumberNode node) {
        if (node == null) return null;
        println("NumberNode: " + node.getValue() + " (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        if (node == null) return null;
        println("StringNode: " + node.getValue() + " (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(BoolNode node) {
        if (node == null) return null;
        println("BoolNode: " + node.getValue() + " (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NoneNode node) {
        if (node == null) return null;
        println("NoneNode (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ListLiteralNode node) {
        if (node == null) return null;
        println("ListLiteralNode (line " + node.getLine() + ")");
        indent++;
        visitList(node.getElements());
        indent--;
        return null;
    }

    @Override
    public Void visit(CallNode node) {
        if (node == null) return null;
        println("CallNode (line " + node.getLine() + ")");
        indent++;
        if (node.getFunction() != null) {
            println("Function:");
            indent++;
            node.getFunction().accept(this);
            indent--;
        }
        if (node.getArgs() != null) {
            println("Args:");
            indent++;
            visitList(node.getArgs());
            indent--;
        }
        if (node.getNamedArgs() != null) {
            println("Named Args:");
            indent++;
            node.getNamedArgs().accept(this);
            indent--;
        }
        indent--;
        return null;
    }

    public Void visit(AttributeNode node) {
        if (node == null) return null;
        println("AttributeNode: " + node.getAttribute() + " (line " + node.getLine() + ")");
        indent++;
        if (node.getObject() != null) {
            println("Object:");
            indent++;
            node.getObject().accept(this);
            indent--;
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(IndexNode node) {
        if (node == null) return null;
        println("IndexNode (line " + node.getLine() + ")");
        indent++;

        // object
        if (node.getObject() != null) {
            println("Object:");
            indent++;
            node.getObject().accept(this);
            indent--;
        }

        // index
        if (node.getIndex() != null) {
            println("Index:");
            indent++;
            node.getIndex().accept(this);
            indent--;
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(NamedArgListNode node) {
        if (node == null) return null;

        println("NamedArgListNode (line " + node.getLine() + ")");
        indent++;

        for (int i = 0; i < node.getNames().size(); i++) {
            String name = node.getNames().get(i);
            BaseNode value = node.getValues().get(i);

            // إذا كانت القيمة null، نتجاهلها تمامًا
            if (value == null) continue;

            // إذا كانت القيمة بسيطة (NameNode, StringNode, BoolNode, NumberNode, NoneNode)
            if (value instanceof NameNode) {
                println(name + " = " + ((NameNode) value).getName());
            } else if (value instanceof StringNode) {
                println(name + " = '" + ((StringNode) value).getValue() + "'");
            } else if (value instanceof BoolNode) {
                println(name + " = " + ((BoolNode) value).getValue());
            } else if (value instanceof NumberNode) {
                println(name + " = " + ((NumberNode) value).getValue());
            } else if (value instanceof NoneNode) {
                println(name + " = None");
            } else {
                // إذا كانت العقدة مركبة، نطبع الاسم أولاً ثم العقدة داخلها
                println(name + " =");
                indent++;
                value.accept(this);
                indent--;
            }
        }

        indent--;
        return null;
    }


    @Override
    public Void visit(ArgListNode node) {
        if (node == null) return null;
        println("ArgListNode (line " + node.getLine() + ")");
        indent++;
        visitList(node.getPositional());
        if (node.getNamed() != null) node.getNamed().accept(this);
        indent--;
        return null;
    }

    // ==================== Simple Statements ====================
    @Override
    public Void visit(ContinueNode node) {
        println("ContinueNode (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        println("BreakNode (line " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(PassNode node) {
        println("PassNode (line " + node.getLine() + ")");
        return null;
    }
    // ==================== Template ====================
    @Override
    public Void visit(TemplateNode node) {
        if (node == null) return null;
        printlnNode("TemplateNode:", node.getLine());
        indent++;
        visitList(node.getContent());
        indent--;
        return null;
    }

    // ==================== HTML ====================
    @Override
    public Void visit(ContentHtmlElement node) {
        if (node == null) return null;
        printlnNode("ContentHtmlElement:", node.getLine());
        indent++;
        if (node.getElement() != null) node.getElement().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(NormalElementNode node) {
        if (node == null) return null;

        printlnNode("NormalElement <" + node.getTagName() + ">", node.getLine());
        indent++;

        for (BaseNode attr : node.getAttributes())
            attr.accept(this);

        StringBuilder textBuffer = new StringBuilder();

        for (ContentItemNode c : node.getContent()) {

            // إذا كان نص HTML
            if (c instanceof ContentHtmlText textNode) {
                if (!textBuffer.isEmpty()) {
                    textBuffer.append(" ");
                }
                textBuffer.append(textNode.getText());
            }
            else {
                // اطبع النص المتجمع قبل أي عنصر آخر
                if (!textBuffer.isEmpty()) {
                    printlnNode("Text: " + textBuffer.toString(), c.getLine());
                    textBuffer.setLength(0);
                }
                c.accept(this);
            }
        }

        // طباعة أي نص متبقٍ
        if (!textBuffer.isEmpty()) {
            printlnNode("Text: " + textBuffer.toString(), node.getLine());
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(VoidElementNode node) {
        if (node == null) return null;
        printlnNode("VoidElement <" + node.getTagName() + ">", node.getLine());
        indent++;
        for (BaseNode attr : node.getAttributes()) attr.accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ContentHtmlText node) {
        if (node == null) return null;
        printlnNode("Text: " + node.getText() , node.getLine());
        return null;
    }

    @Override
    public Void visit(HtmlTextNode node) {
        if (node == null) return null;
        printlnNode("TextNode: \"" + node.getText() + "\"", node.getLine());
        return null;
    }
    private String collectAttrValue(List<BaseNode> nodes) {
        StringBuilder sb = new StringBuilder();

        for (BaseNode n : nodes) {
            if (n instanceof AttrTextNode t) {
                sb.append(t.getText());
            }
            else if (n instanceof AttrJinjaExpressionNode j) {
                sb.append(j.getExpression().getBody().getExpression());
            }
            else if (n instanceof AttrJinjaBlockNode b) {
                sb.append("[JINJA_BLOCK]");
            }
        }
        return sb.toString();
    }
    @Override public Void visit(DoubleQuotedValue node) { return null; }
    @Override public Void visit(SingleQuotedValue node) { return null; }
    @Override public Void visit(AttrTextNode node) { return null; }
    @Override
    public Void visit(AttrJinjaExpressionNode node) {
        printlnNode(
                "AttrJinjaExpr: {{ " + node.getExpression().getBody().getExpression() + " }}",
                node.getLine()
        );
        return null;
    }
    @Override public Void visit(AttrJinjaBlockNode node) { return null; }

    @Override
    public Void visit(HtmlAttributeAssignment node) {
        if (node == null) return null;

        String value = "";

        if (node.getValue() instanceof DoubleQuotedValue dq) {
            value = collectAttrValue(dq.getContent());
            printlnNode("Attr: " + node.getName() + " = " + value , node.getLine());
        } else if (node.getValue() instanceof SingleQuotedValue sq) {
            value = collectAttrValue(sq.getContent());
            printlnNode("Attr: " + node.getName() + " = '" + value + "'", node.getLine());
        } else {
            printlnNode("Attr: " + node.getName(), node.getLine());
        }

        return null;
    }


    @Override
    public Void visit(CssDeclarationNode node) {
        String value = node.getValue() != null ? node.getValue().toString() : "";
        printlnNode("CssDecl: " + node.getProperty() + " = " + value, node.getLine());
        return null;
    }

    @Override
    public Void visit(WebSimpleStmtNode node) {
        printlnNode("SimpleStmt: " + node.getStatement(), node.getLine());
        return null;
    }


    @Override
    public Void visit(HtmlAttributeBoolean node) {
        if (node == null) return null;
        printlnNode("Attr: " + node.getName(), node.getLine());
        return null;
    }


    @Override
    public Void visit(AttrJinjaCommentNode node) {
        printlnNode("AttrJinjaComment", node.getLine());
        return null;
    }

    // ==================== Jinja ====================
    @Override
    public Void visit(ContentJinjaExpression node) {
        printlnNode("ContentJinjaExpr:", node.getLine());
        indent++;
        node.getExpression().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ContentJinjaBlock node) {
        printlnNode("ContentJinjaBlock:", node.getLine());
        indent++;
        node.getBlock().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ContentJinjaComment node) {
        printlnNode("ContentJinjaComment", node.getLine());
        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {
        if (node == null) return null;
        printlnNode("JinjaExpr: " + node.getBody().getExpression(), node.getLine());
        return null;
    }
    @Override
    public Void visit(JinjaBlockNode node) {
        if (node == null) return null;

        printlnNode("JinjaBlock:", node.getLine());
        indent++;

        BaseNode inner = node.getInner();

        if (inner != null) {
            inner.accept(this);
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(JinjaExprBodyNode node) {
        printlnNode("ExprBody: " + node.getExpression(), node.getLine());
        return null;
    }

    @Override
    public Void visit(SetStmtNode node) {
        printlnNode("SetStmt: " + node.getAssignment(), node.getLine());
        return null;
    }

    @Override
    public Void visit(JinjaBlockExprNode node) {
        printlnNode(
                "BlockExpr: " + String.join(" ", node.getParts()),
                node.getLine()
        );
        return null;
    }


    @Override
    public Void visit(JinjaCommentNode node) {
        printlnNode("JinjaComment: " + node.getComment(), node.getLine());
        return null;
    }

    // في PrinterVisitor.java
    @Override
    public Void visit(ForStartNode node) {
        printlnNode("ForStart: " + node.getVariables() + " in " + node.getIterable(), node.getLine());
        return null;
    }


    @Override
    public Void visit(ForEndNode node) {
        printlnNode("ForEnd", node.getLine());
        return null;
    }

    @Override
    public Void visit(IfStartNode node) {
        printlnNode("IfStart: " + node.getCondition(), node.getLine());
        return null;
    }

    @Override
    public Void visit(ElifPartNode node) {
        printlnNode("Elif: " + node.getCondition(), node.getLine());
        return null;
    }

    @Override
    public Void visit(ElsePartNode node) {
        printlnNode("Else", node.getLine());
        return null;
    }

    @Override
    public Void visit(EndIfPartNode node) {
        printlnNode("EndIf", node.getLine());
        return null;
    }

    // ==================== CSS ====================
    @Override
    public Void visit(CssStyleNode node) {
        printlnNode("CssStyle:", node.getLine());
        indent++;
        node.getBody().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(CssBodyNode node) {
        printlnNode("CssBody:", node.getLine());
        indent++;
        for (BaseNode rule : node.getRules()) rule.accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(CssRuleNode node) {
        printlnNode("CssRule:", node.getLine());
        indent++;
        node.getSelector().accept(this);
        for (CssDeclarationNode decl : node.getDeclarations()) decl.accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(SelectorSimpleNode node) {
        printlnNode("Selector: " + node.getSelector(), node.getLine());
        return null;
    }

    @Override
    public Void visit(SelectorClassNode node) {
        printlnNode("SelectorClass: " + node.getClassName(), node.getLine());
        return null;
    }

    @Override
    public Void visit(SelectorIdNode node) {
        printlnNode("SelectorId: " + node.getId(), node.getLine());
        return null;
    }

    @Override
    public Void visit(SelectorPseudoNode node) {
        if (node.getPseudoElement() != null)
            printlnNode("SelectorPseudo: " + node.getPseudoClass() + "::" + node.getPseudoElement(), node.getLine());
        else
            printlnNode("SelectorPseudo: " + node.getPseudoClass(), node.getLine());
        return null;
    }

}