package ast.visitors;

import ast.ASTVisitor;
import ast.base.BaseNode;
import ast.python.statements.*;
import ast.python.expressions.*;
import ast.python.other.*;
import ast.web.*;
import ast.web.html.*;
import ast.web.css.*;
import ast.web.jinja.*;

public class PrinterVisitor implements ASTVisitor<Void> {
    private int indent = 0;

    private void printIndent() {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public Void visit(FileInputNode node) {
        printIndent();
        System.out.println("FileInputNode (line: " + node.getLine() + ")");
        indent++;
        for (BaseNode stmt : node.getStatements()) {
            stmt.accept(this);
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(FunctionDefNode node) {
        printIndent();
        System.out.println("FunctionDef: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ClassDefNode node) {
        printIndent();
        System.out.println("ClassDef: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(IfStmtNode node) {
        printIndent();
        System.out.println("IfStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ForStmtNode node) {
        printIndent();
        System.out.println("ForStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(WhileStmtNode node) {
        printIndent();
        System.out.println("WhileStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(WithStmtNode node) {
        printIndent();
        System.out.println("WithStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ReturnStmtNode node) {
        printIndent();
        System.out.println("ReturnStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ImportStmtNode node) {
        printIndent();
        System.out.println("ImportStmt: " + node.getModule() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(DecoratorNode node) {
        printIndent();
        System.out.println("Decorator: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NamedDecoratorArgsNode node) {
        printIndent();
        System.out.println("NamedDecoratorArgs (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(DecoratedDefNode node) {
        printIndent();
        System.out.println("DecoratedDef (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SimpleStmtNode node) {
        printIndent();
        System.out.println("SimpleStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SimpleStmtLineNode node) {
        printIndent();
        System.out.println("SimpleStmtLine (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CompoundStmtNode node) {
        printIndent();
        System.out.println("CompoundStmt (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ParameterListNode node) {
        printIndent();
        System.out.println("ParameterList (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(BinaryOpNode node) {
        printIndent();
        System.out.println("BinaryOp: " + node.getOperator() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(UnaryOpNode node) {
        printIndent();
        System.out.println("UnaryOp: " + node.getOperator() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {
        printIndent();
        System.out.println("Comparison (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NameNode node) {
        printIndent();
        System.out.println("Name: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NumberNode node) {
        printIndent();
        System.out.println("Number: " + node.getValue() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        printIndent();
        System.out.println("String: " + node.getValue() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(BoolNode node) {
        printIndent();
        System.out.println("Bool: " + node.getValue() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NoneNode node) {
        printIndent();
        System.out.println("None (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ListLiteralNode node) {
        printIndent();
        System.out.println("ListLiteral (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CallNode node) {
        printIndent();
        System.out.println("Call (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(AttributeNode node) {
        printIndent();
        System.out.println("Attribute: " + node.getAttribute() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(IndexNode node) {
        printIndent();
        System.out.println("Index (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NamedArgListNode node) {
        printIndent();
        System.out.println("NamedArgList (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(TemplateNode node) {
        printIndent();
        System.out.println("TemplateNode (line: " + node.getLine() + ")");
        indent++;
        for (ContentItemNode item : node.getContent()) {
            item.accept(this);
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(ContentHtmlElement node) {
        printIndent();
        System.out.println("ContentHtmlElement (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ContentHtmlText node) {
        printIndent();
        System.out.println("ContentHtmlText: \"" + node.getText() + "\" (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ContentJinjaExpression node) {
        printIndent();
        System.out.println("ContentJinjaExpression (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ContentJinjaBlock node) {
        printIndent();
        System.out.println("ContentJinjaBlock (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ContentJinjaComment node) {
        printIndent();
        System.out.println("ContentJinjaComment (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(VoidElementNode node) {
        printIndent();
        System.out.println("VoidElement: <" + node.getTagName() + "/> (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(NormalElementNode node) {
        printIndent();
        System.out.println("NormalElement: <" + node.getTagName() + "> (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(HtmlAttributeAssignment node) {
        printIndent();
        System.out.println("HtmlAttributeAssignment: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(HtmlAttributeBoolean node) {
        printIndent();
        System.out.println("HtmlAttributeBoolean: " + node.getName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(DoubleQuotedValue node) {
        printIndent();
        System.out.println("DoubleQuotedValue (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SingleQuotedValue node) {
        printIndent();
        System.out.println("SingleQuotedValue (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(AttrTextNode node) {
        printIndent();
        System.out.println("AttrText: \"" + node.getText() + "\" (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(AttrJinjaExpressionNode node) {
        printIndent();
        System.out.println("AttrJinjaExpression (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(AttrJinjaBlockNode node) {
        printIndent();
        System.out.println("AttrJinjaBlock (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(AttrJinjaCommentNode node) {
        printIndent();
        System.out.println("AttrJinjaComment (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(HtmlTextNode node) {
        printIndent();
        System.out.println("HtmlText: \"" + node.getText() + "\" (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CssStyleNode node) {
        printIndent();
        System.out.println("CssStyle (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CssBodyNode node) {
        printIndent();
        System.out.println("CssBody (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CssRuleNode node) {
        printIndent();
        System.out.println("CssRule (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SelectorSimpleNode node) {
        printIndent();
        System.out.println("SelectorSimple: " + node.getSelector() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SelectorClassNode node) {
        printIndent();
        System.out.println("SelectorClass: ." + node.getClassName() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SelectorIdNode node) {
        printIndent();
        System.out.println("SelectorId: #" + node.getId() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SelectorPseudoNode node) {
        printIndent();
        System.out.println("SelectorPseudo: " + node.getPseudoClass() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(CssDeclarationNode node) {
        printIndent();
        System.out.println("CssDeclaration: " + node.getProperty() + ": " + node.getValue() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {
        printIndent();
        System.out.println("JinjaExpression (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(JinjaExprBodyNode node) {
        printIndent();
        System.out.println("JinjaExprBody: " + node.getExpression() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(JinjaBlockNode node) {
        printIndent();
        System.out.println("JinjaBlock (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ForStartNode node) {
        printIndent();
        System.out.println("ForStart (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ForEndNode node) {
        printIndent();
        System.out.println("ForEnd (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(IfStartNode node) {
        printIndent();
        System.out.println("IfStart: " + node.getCondition() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ElifPartNode node) {
        printIndent();
        System.out.println("Elif: " + node.getCondition() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(ElsePartNode node) {
        printIndent();
        System.out.println("Else (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(EndIfPartNode node) {
        printIndent();
        System.out.println("EndIf (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(SetStmtNode node) {
        printIndent();
        System.out.println("Set: " + node.getAssignment() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(WebSimpleStmtNode node) {
        printIndent();
        System.out.println("WebSimpleStmt: " + node.getStatement() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(JinjaBlockExprNode node) {
        printIndent();
        System.out.println("JinjaBlockExpr: " + node.getExpression() + " (line: " + node.getLine() + ")");
        return null;
    }

    @Override
    public Void visit(JinjaCommentNode node) {
        printIndent();
        System.out.println("JinjaComment: " + node.getComment() + " (line: " + node.getLine() + ")");
        return null;
    }
}