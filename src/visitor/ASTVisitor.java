package visitor;

import ast.python.statements.*;
import ast.python.expressions.*;
import ast.python.other.*;
import ast.python.statements.SimpleStmtNode;
import ast.web.*;
import ast.web.html.*;
import ast.web.css.*;
import ast.web.jinja.*;

public interface ASTVisitor<T> {

    T visit(FileInputNode node);
    T visit(DecoratorNode node);
    T visit(NamedDecoratorArgsNode node);
    T visit(DecoratedDefNode node);
    T visit(SimpleStmtNode node);
    T visit(SimpleStmtLineNode node);
    T visit(CompoundStmtNode node);
    T visit(FunctionDefNode node);
    T visit(ParameterListNode node);
    T visit(ClassDefNode node);
    T visit(IfStmtNode node);
    T visit(ForStmtNode node);
    T visit(WhileStmtNode node);
    T visit(WithStmtNode node);
    T visit(ReturnStmtNode node);
    T visit(ImportStmtNode node);

    // Python Expressions
    T visit(BinaryOpNode node);
    T visit(UnaryOpNode node);
    T visit(ComparisonNode node);
    T visit(NameNode node);
    T visit(NumberNode node);
    T visit(StringNode node);
    T visit(BoolNode node);
    T visit(NoneNode node);
    T visit(ListLiteralNode node);
    T visit(CallNode node);
    T visit(AttributeNode node);
    T visit(IndexNode node);
    T visit(NamedArgListNode node);

    // Web General
    T visit(TemplateNode node);
    T visit(ContentHtmlElement node);
    T visit(ContentHtmlText node);
    T visit(ContentJinjaExpression node);
    T visit(ContentJinjaBlock node);
    T visit(ContentJinjaComment node);

    // HTML Elements
    T visit(VoidElementNode node);
    T visit(NormalElementNode node);
    T visit(HtmlAttributeAssignment node);
    T visit(HtmlAttributeBoolean node);
    T visit(DoubleQuotedValue node);
    T visit(SingleQuotedValue node);
    T visit(AttrTextNode node);
    T visit(AttrJinjaExpressionNode node);
    T visit(AttrJinjaBlockNode node);
    T visit(AttrJinjaCommentNode node);
    T visit(HtmlTextNode node);

    // CSS
    T visit(CssStyleNode node);
    T visit(CssBodyNode node);
    T visit(CssRuleNode node);
    T visit(CssSelectorListNode cssSelectorListNode);
    T visit(CssSelectorNode cssSelectorNode);
    T visit(SelectorPartNode selectorPartNode);
    T visit(TypeSelectorNode typeSelectorNode);
    T visit(AttributeSelectorNode attributeSelectorNode);
    T visit(CssDeclarationNode cssDeclarationNode);
    T visit(CssValueNode cssValueNode);
    T visit(ClassSelectorNode classSelectorNode);
    T visit(IdSelectorNode idSelectorNode);
    T visit(PseudoSelectorNode pseudoSelectorNode);
    T visit(CssValueAtomNode cssValueAtomNode);
    T visit(ContentCssStyle contentCssStyle);


    // Jinja
    T visit(JinjaExpressionNode node);
    T visit(JinjaExprBodyNode node);
    T visit(JinjaBlockNode node);
    T visit(ForStartNode node);
    T visit(ForEndNode node);
    T visit(IfStartNode node);
    T visit(ElifPartNode node);
    T visit(ElsePartNode node);
    T visit(EndIfPartNode node);
    T visit(SetStmtNode node);
    T visit(WebSimpleStmtNode node);
    T visit(JinjaBlockExprNode node);
    T visit(JinjaCommentNode node);
    T visit(ArgListNode argListNode);
    T visit(AssignNode assignNode);
    T visit(ContinueNode continueNode);
    T visit(BreakNode breakNode);
    T visit(PassNode passNode);

    //T visit(SimpleStmtNode simpleStmtNode);
}