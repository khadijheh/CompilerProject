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

        // 1️⃣ زيارة الـ decorators أولاً
        visitList(node.getDecorators());

        // 2️⃣ زيارة التعريف مع التحقق من النوع
        BaseNode def = node.getDefinition();
        if (def != null) {
            def.accept(this);
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
    @Override public Void visit(ContinueNode node) { println("ContinueNode (line " + node.getLine() + ")"); return null; }
    @Override public Void visit(BreakNode node) { println("BreakNode (line " + node.getLine() + ")"); return null; }
    @Override public Void visit(PassNode node) { println("PassNode (line " + node.getLine() + ")"); return null; }

    // ==================== Web / HTML / CSS / Jinja Nodes ====================
    @Override public Void visit(TemplateNode node) { if (node != null) println("TemplateNode (line "+node.getLine()+")"); return null; }
    @Override public Void visit(ContentHtmlElement node) { if (node!=null) println("ContentHtmlElement"); return null; }
    @Override public Void visit(ContentHtmlText node) { if (node!=null) println("ContentHtmlText"); return null; }
    @Override public Void visit(ContentJinjaExpression node) { if (node!=null) println("ContentJinjaExpression"); return null; }
    @Override public Void visit(ContentJinjaBlock node) { if (node!=null) println("ContentJinjaBlock"); return null; }
    @Override public Void visit(ContentJinjaComment node) { if (node!=null) println("ContentJinjaComment"); return null; }
    @Override public Void visit(VoidElementNode node) { if (node!=null) println("VoidElementNode"); return null; }
    @Override public Void visit(NormalElementNode node) { if (node!=null) println("NormalElementNode"); return null; }
    @Override public Void visit(HtmlAttributeAssignment node) { if (node!=null) println("HtmlAttributeAssignment"); return null; }
    @Override public Void visit(HtmlAttributeBoolean node) { if (node!=null) println("HtmlAttributeBoolean"); return null; }
    @Override public Void visit(DoubleQuotedValue node) { if (node!=null) println("DoubleQuotedValue"); return null; }
    @Override public Void visit(SingleQuotedValue node) { if (node!=null) println("SingleQuotedValue"); return null; }
    @Override public Void visit(AttrTextNode node) { if (node!=null) println("AttrTextNode"); return null; }
    @Override public Void visit(AttrJinjaExpressionNode node) { if (node!=null) println("AttrJinjaExpressionNode"); return null; }
    @Override public Void visit(AttrJinjaBlockNode node) { if (node!=null) println("AttrJinjaBlockNode"); return null; }
    @Override public Void visit(AttrJinjaCommentNode node) { if (node!=null) println("AttrJinjaCommentNode"); return null; }
    @Override public Void visit(HtmlTextNode node) { if (node!=null) println("HtmlTextNode"); return null; }
    @Override public Void visit(CssStyleNode node) { if (node!=null) println("CssStyleNode"); return null; }
    @Override public Void visit(CssBodyNode node) { if (node!=null) println("CssBodyNode"); return null; }
    @Override public Void visit(CssRuleNode node) { if (node!=null) println("CssRuleNode"); return null; }
    @Override public Void visit(SelectorSimpleNode node) { if (node!=null) println("SelectorSimpleNode"); return null; }
    @Override public Void visit(SelectorClassNode node) { if (node!=null) println("SelectorClassNode"); return null; }
    @Override public Void visit(SelectorIdNode node) { if (node!=null) println("SelectorIdNode"); return null; }
    @Override public Void visit(SelectorPseudoNode node) { if (node!=null) println("SelectorPseudoNode"); return null; }
    @Override public Void visit(CssDeclarationNode node) { if (node!=null) println("CssDeclarationNode"); return null; }
    @Override public Void visit(JinjaExpressionNode node) { if (node!=null) println("JinjaExpressionNode"); return null; }
    @Override public Void visit(JinjaExprBodyNode node) { if (node!=null) println("JinjaExprBodyNode"); return null; }
    @Override public Void visit(JinjaBlockNode node) { if (node!=null) println("JinjaBlockNode"); return null; }
    @Override public Void visit(ForStartNode node) { if (node!=null) println("ForStartNode"); return null; }
    @Override public Void visit(ForEndNode node) { if (node!=null) println("ForEndNode"); return null; }
    @Override public Void visit(IfStartNode node) { if (node!=null) println("IfStartNode"); return null; }
    @Override public Void visit(ElifPartNode node) { if (node!=null) println("ElifPartNode"); return null; }
    @Override public Void visit(ElsePartNode node) { if (node!=null) println("ElsePartNode"); return null; }
    @Override public Void visit(EndIfPartNode node) { if (node!=null) println("EndIfPartNode"); return null; }
    @Override public Void visit(SetStmtNode node) { if (node!=null) println("SetStmtNode"); return null; }
    @Override public Void visit(WebSimpleStmtNode node) { if (node!=null) println("WebSimpleStmtNode"); return null; }

    @Override
    public Void visit(JinjaBlockExprNode node) {
        if (node!=null) println("JinjaBlockExprNode"); return null;
    }

    @Override
    public Void visit(JinjaCommentNode node) {
        if (node!=null) println("JinjaCommentNode"); return null;

    }
}
