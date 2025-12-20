package visitor;

import ast.base.ASTNode;
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

        println("DecoratorNode: " + node.getName() +
                " (line " + node.getLine() + ")");

        indent++;

        // زيارة عقدة DecoratorArgsNode (إن وجدت)
        if (node.getArgs() != null) {
            node.getArgs().accept(this);
        }

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
    public Void visit(DecoratorArgsNode node) {
        if (node == null) return null;

        println("DecoratorArgs:");
        indent++;

        if (node.getPositional() != null && !node.getPositional().isEmpty()) {
            println("Positional Args:");
            indent++;
            for (ExprNode expr : node.getPositional()) {
                if (expr != null) expr.accept(this);
            }
            indent--;
        }

        if (node.getNamed() != null) {
            println("Named Args:");
            indent++;
            node.getNamed().accept(this);
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
            return null;
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
            } else {
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
        printlnNode("Text: " + node.getText(), node.getLine());
        return null;
    }

    @Override
    public Void visit(HtmlTextNode node) {
        if (node == null) return null;
        printlnNode("TextNode: \"" + node.getText() + "\"", node.getLine());
        return null;
    }

    @Override
    public Void visit(CssStyleNode node) {
        if (node == null) return null;

        printlnNode("CSS Style", node.getLine());
        indent++;
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        indent--;
        return null;
    }


    private String collectAttrValue(List<BaseNode> nodes) {
        StringBuilder sb = new StringBuilder();

        for (BaseNode n : nodes) {
            if (n instanceof AttrTextNode t) {
                sb.append(t.getText());
            } else if (n instanceof AttrJinjaExpressionNode j) {
                sb.append(j.getExpression().getBody().getExpression());
            } else if (n instanceof AttrJinjaBlockNode b) {
                sb.append("[JINJA_BLOCK]");
            }
        }
        return sb.toString();
    }

    @Override
    public Void visit(DoubleQuotedValue node) {
        return null;
    }

    @Override
    public Void visit(SingleQuotedValue node) {
        return null;
    }

    @Override
    public Void visit(AttrTextNode node) {
        return null;
    }

    @Override
    public Void visit(AttrJinjaExpressionNode node) {
        printlnNode(
                "AttrJinjaExpr: {{ " + node.getExpression().getBody().getExpression() + " }}",
                node.getLine()
        );
        return null;
    }

    @Override
    public Void visit(AttrJinjaBlockNode node) {
        return null;
    }

    @Override
    public Void visit(HtmlAttributeAssignment node) {
        if (node == null) return null;

        String value = "";

        if (node.getValue() instanceof DoubleQuotedValue dq) {
            value = collectAttrValue(dq.getContent());
            printlnNode("Attr: " + node.getName() + " = " + value, node.getLine());
        } else if (node.getValue() instanceof SingleQuotedValue sq) {
            value = collectAttrValue(sq.getContent());
            printlnNode("Attr: " + node.getName() + " = '" + value + "'", node.getLine());
        } else {
            printlnNode("Attr: " + node.getName(), node.getLine());
        }

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
    public Void visit(ContentCssStyle node) {
        if (node == null) return null;

        printlnNode("ContentCssStyle", node.getLine());
        indent++;
        node.getCssStyle().accept(this);
        indent--;

        return null;
    }

    @Override
    public Void visit(CssBodyNode node) {
        if (node == null) return null;

        printlnNode("CssBody", node.getLine());
        indent++;

        if (node.getChildren() != null) {
            for (BaseNode child : node.getChildren()) {
                if (child != null) {
                    child.accept(this);
                }
            }
        }

        indent--;
        return null;
    }


    @Override
    public Void visit(CssRuleNode node) {
        if (node == null) return null;

        printlnNode("CssRule", node.getLine());
        indent++;

        // selectors
        if (node.getSelectors() != null) {
            println("Selectors:");
            indent++;
            node.getSelectors().accept(this);
            indent--;
        }

        // declarations (body)
        if (node.getDeclarations() != null) {
            println("Declarations:");
            indent++;
            node.getDeclarations().accept(this);
            indent--;
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(CssSelectorListNode node) {
        if (node == null) return null;

        printlnNode("SelectorList", node.getLine());
        indent++;
        visitList(node.getSelectors());
        indent--;

        return null;
    }

    @Override
    public Void visit(CssSelectorNode node) {
        if (node == null) return null;

        printlnNode("CssSelector", node.getLine());
        indent++;

        if (node.getParts() != null && !node.getParts().isEmpty()) {
            for (ASTNode part : node.getParts()) {
                if (part != null) {
                    part.accept(this);
                }
            }
        }

        indent--;
        return null;
    }

    @Override
    public Void visit(SelectorPartNode node) {
        if (node == null) return null;

        printlnNode("SelectorPart", node.getLine());
        indent++;

        if (node.getSimpleSelectors() != null && !node.getSimpleSelectors().isEmpty()) {
            visitList(node.getSimpleSelectors());
        }

        indent--;
        return null;
    }


// -------- Simple Selectors --------

    @Override
    public Void visit(TypeSelectorNode node) {
        printlnNode("TypeSelector: " + node.getName(), node.getLine());
        return null;
    }

    @Override
    public Void visit(ClassSelectorNode node) {
        printlnNode("ClassSelector: ." + node.getClassName(), node.getLine());
        return null;
    }

    @Override
    public Void visit(IdSelectorNode node) {
        printlnNode("IdSelector: #" + node.getIdName(), node.getLine());
        return null;
    }

    @Override
    public Void visit(PseudoSelectorNode node) {
        printlnNode("PseudoSelector: :" + node.getPseudo(), node.getLine());
        return null;
    }

    @Override
    public Void visit(AttributeSelectorNode node) {
        if (node.getValue() != null) {
            printlnNode(
                    "AttributeSelector: [" +
                            node.getAttribute() + "=" +
                            node.getValue() + "]",
                    node.getLine()
            );
        } else {
            printlnNode(
                    "AttributeSelector: [" + node.getAttribute() + "]",
                    node.getLine()
            );
        }
        return null;
    }

// -------- Declarations & Values --------

    @Override
    public Void visit(CssValueNode node) {
        StringBuilder value = new StringBuilder();
        BaseNode prevAtom = null;

        for (BaseNode atom : node.getAtoms()) {
            if (atom instanceof CssValueAtomNode atomNode) {
                String text = atomNode.getValue();

                if (prevAtom != null) {
                    String prevText = prevAtom instanceof CssValueAtomNode pa ? pa.getValue() : "";
                    if (!prevText.equals("(") && !prevText.equals(",") && !text.equals(")") && !text.equals(",")) {
                        value.append(" ");
                    }
                }

                value.append(text);
                prevAtom = atom;
            }
        }

        printlnNode("CssValue: " + value.toString(), node.getLine());
        return null;
    }

    @Override
    public Void visit(CssDeclarationNode node) {
        printlnNode("CssDecl: " + node.getProperty() + " = ", node.getLine());
        indent++;
        if (node.getValue() != null) node.getValue().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(CssValueAtomNode node) {
        printlnNode("ValueAtom: " + node.getValue(), node.getLine());
        return null;
    }
}