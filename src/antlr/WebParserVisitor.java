// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/WebParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WebParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WebParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code TemplateNode}
	 * labeled alternative in {@link WebParser#template}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateNode(WebParser.TemplateNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContentHtmlElement}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentHtmlElement(WebParser.ContentHtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContentHtmlText}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentHtmlText(WebParser.ContentHtmlTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContentJinjaExpression}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentJinjaExpression(WebParser.ContentJinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContentJinjaBlock}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentJinjaBlock(WebParser.ContentJinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContentJinjaComment}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentJinjaComment(WebParser.ContentJinjaCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlElementVoid}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementVoid(WebParser.HtmlElementVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlElementNormal}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementNormal(WebParser.HtmlElementNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link WebParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElementNode(WebParser.VoidElementNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalElementNode}
	 * labeled alternative in {@link WebParser#htmlNormalElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalElementNode(WebParser.NormalElementNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlAttributeAssignment}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeAssignment(WebParser.HtmlAttributeAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlAttributeBoolean}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttributeBoolean(WebParser.HtmlAttributeBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrDoubleQuoted(WebParser.AttrDoubleQuotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrSingleQuoted(WebParser.AttrSingleQuotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link WebParser#dqValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuotedValue(WebParser.DoubleQuotedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link WebParser#sqValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuotedValue(WebParser.SingleQuotedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrTextNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrTextNode(WebParser.AttrTextNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaExpressionNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaExpressionNode(WebParser.AttrJinjaExpressionNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaBlockNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaBlockNode(WebParser.AttrJinjaBlockNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaCommentNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaCommentNode(WebParser.AttrJinjaCommentNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlTextNode}
	 * labeled alternative in {@link WebParser#htmlText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTextNode(WebParser.HtmlTextNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssStyleNode}
	 * labeled alternative in {@link WebParser#cssStyleBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssStyleNode(WebParser.CssStyleNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssBodyNode}
	 * labeled alternative in {@link WebParser#cssBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssBodyNode(WebParser.CssBodyNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRuleNode}
	 * labeled alternative in {@link WebParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRuleNode(WebParser.CssRuleNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorSimpleNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorSimpleNode(WebParser.SelectorSimpleNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorClassNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorClassNode(WebParser.SelectorClassNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorIdNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorIdNode(WebParser.SelectorIdNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectorPseudoNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorPseudoNode(WebParser.SelectorPseudoNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDeclarationsNode}
	 * labeled alternative in {@link WebParser#cssDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclarationsNode(WebParser.CssDeclarationsNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDeclarationNode}
	 * labeled alternative in {@link WebParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclarationNode(WebParser.CssDeclarationNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExpressionNode}
	 * labeled alternative in {@link WebParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpressionNode(WebParser.JinjaExpressionNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaExprBodyNode}
	 * labeled alternative in {@link WebParser#jinjaExprBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprBodyNode(WebParser.JinjaExprBodyNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link WebParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockNode(WebParser.JinjaBlockNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockForStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockForStartNode(WebParser.BlockForStartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockForEndNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockForEndNode(WebParser.BlockForEndNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockIfStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIfStartNode(WebParser.BlockIfStartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockElifNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockElifNode(WebParser.BlockElifNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockElseNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockElseNode(WebParser.BlockElseNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockEndIfNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockEndIfNode(WebParser.BlockEndIfNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSetNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSetNode(WebParser.BlockSetNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSimpleNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSimpleNode(WebParser.BlockSimpleNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStartNode}
	 * labeled alternative in {@link WebParser#forStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStartNode(WebParser.ForStartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForEndNode}
	 * labeled alternative in {@link WebParser#forEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEndNode(WebParser.ForEndNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStartNode}
	 * labeled alternative in {@link WebParser#ifStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStartNode(WebParser.IfStartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElifPartNode}
	 * labeled alternative in {@link WebParser#elifPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifPartNode(WebParser.ElifPartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElsePartNode}
	 * labeled alternative in {@link WebParser#elsePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsePartNode(WebParser.ElsePartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndIfPartNode}
	 * labeled alternative in {@link WebParser#endIfPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndIfPartNode(WebParser.EndIfPartNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetStmtNode}
	 * labeled alternative in {@link WebParser#setStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStmtNode(WebParser.SetStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link WebParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmtNode(WebParser.SimpleStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaBlockExprNode}
	 * labeled alternative in {@link WebParser#jinjaBlockExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockExprNode(WebParser.JinjaBlockExprNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaCommentNode}
	 * labeled alternative in {@link WebParser#jinjaComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaCommentNode(WebParser.JinjaCommentNodeContext ctx);
}