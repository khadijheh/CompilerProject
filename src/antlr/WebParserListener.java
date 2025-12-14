// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/WebParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WebParser}.
 */
public interface WebParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code TemplateNode}
	 * labeled alternative in {@link WebParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplateNode(WebParser.TemplateNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TemplateNode}
	 * labeled alternative in {@link WebParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplateNode(WebParser.TemplateNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContentHtmlElement}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void enterContentHtmlElement(WebParser.ContentHtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContentHtmlElement}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void exitContentHtmlElement(WebParser.ContentHtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContentHtmlText}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void enterContentHtmlText(WebParser.ContentHtmlTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContentHtmlText}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void exitContentHtmlText(WebParser.ContentHtmlTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContentJinjaExpression}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void enterContentJinjaExpression(WebParser.ContentJinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContentJinjaExpression}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void exitContentJinjaExpression(WebParser.ContentJinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContentJinjaBlock}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void enterContentJinjaBlock(WebParser.ContentJinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContentJinjaBlock}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void exitContentJinjaBlock(WebParser.ContentJinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContentJinjaComment}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void enterContentJinjaComment(WebParser.ContentJinjaCommentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContentJinjaComment}
	 * labeled alternative in {@link WebParser#contentItem}.
	 * @param ctx the parse tree
	 */
	void exitContentJinjaComment(WebParser.ContentJinjaCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlElementVoid}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementVoid(WebParser.HtmlElementVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlElementVoid}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementVoid(WebParser.HtmlElementVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlElementNormal}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementNormal(WebParser.HtmlElementNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlElementNormal}
	 * labeled alternative in {@link WebParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementNormal(WebParser.HtmlElementNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link WebParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElementNode(WebParser.VoidElementNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidElementNode}
	 * labeled alternative in {@link WebParser#htmlVoidElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElementNode(WebParser.VoidElementNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalElementNode}
	 * labeled alternative in {@link WebParser#htmlNormalElement}.
	 * @param ctx the parse tree
	 */
	void enterNormalElementNode(WebParser.NormalElementNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalElementNode}
	 * labeled alternative in {@link WebParser#htmlNormalElement}.
	 * @param ctx the parse tree
	 */
	void exitNormalElementNode(WebParser.NormalElementNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlAttributeAssignment}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeAssignment(WebParser.HtmlAttributeAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlAttributeAssignment}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeAssignment(WebParser.HtmlAttributeAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlAttributeBoolean}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttributeBoolean(WebParser.HtmlAttributeBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlAttributeBoolean}
	 * labeled alternative in {@link WebParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttributeBoolean(WebParser.HtmlAttributeBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrDoubleQuoted(WebParser.AttrDoubleQuotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrDoubleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrDoubleQuoted(WebParser.AttrDoubleQuotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrSingleQuoted(WebParser.AttrSingleQuotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrSingleQuoted}
	 * labeled alternative in {@link WebParser#htmlAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrSingleQuoted(WebParser.AttrSingleQuotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link WebParser#dqValue}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuotedValue(WebParser.DoubleQuotedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleQuotedValue}
	 * labeled alternative in {@link WebParser#dqValue}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuotedValue(WebParser.DoubleQuotedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link WebParser#sqValue}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuotedValue(WebParser.SingleQuotedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleQuotedValue}
	 * labeled alternative in {@link WebParser#sqValue}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuotedValue(WebParser.SingleQuotedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrTextNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void enterAttrTextNode(WebParser.AttrTextNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrTextNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void exitAttrTextNode(WebParser.AttrTextNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaExpressionNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaExpressionNode(WebParser.AttrJinjaExpressionNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaExpressionNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaExpressionNode(WebParser.AttrJinjaExpressionNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaBlockNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaBlockNode(WebParser.AttrJinjaBlockNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaBlockNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaBlockNode(WebParser.AttrJinjaBlockNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaCommentNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaCommentNode(WebParser.AttrJinjaCommentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaCommentNode}
	 * labeled alternative in {@link WebParser#htmlAttrValueItem}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaCommentNode(WebParser.AttrJinjaCommentNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlTextNode}
	 * labeled alternative in {@link WebParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTextNode(WebParser.HtmlTextNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlTextNode}
	 * labeled alternative in {@link WebParser#htmlText}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTextNode(WebParser.HtmlTextNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssStyleNode}
	 * labeled alternative in {@link WebParser#cssStyleBlock}.
	 * @param ctx the parse tree
	 */
	void enterCssStyleNode(WebParser.CssStyleNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssStyleNode}
	 * labeled alternative in {@link WebParser#cssStyleBlock}.
	 * @param ctx the parse tree
	 */
	void exitCssStyleNode(WebParser.CssStyleNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssBodyNode}
	 * labeled alternative in {@link WebParser#cssBody}.
	 * @param ctx the parse tree
	 */
	void enterCssBodyNode(WebParser.CssBodyNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssBodyNode}
	 * labeled alternative in {@link WebParser#cssBody}.
	 * @param ctx the parse tree
	 */
	void exitCssBodyNode(WebParser.CssBodyNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRuleNode}
	 * labeled alternative in {@link WebParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRuleNode(WebParser.CssRuleNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRuleNode}
	 * labeled alternative in {@link WebParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRuleNode(WebParser.CssRuleNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorSimpleNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorSimpleNode(WebParser.SelectorSimpleNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorSimpleNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorSimpleNode(WebParser.SelectorSimpleNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorClassNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorClassNode(WebParser.SelectorClassNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorClassNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorClassNode(WebParser.SelectorClassNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorIdNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorIdNode(WebParser.SelectorIdNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorIdNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorIdNode(WebParser.SelectorIdNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectorPseudoNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterSelectorPseudoNode(WebParser.SelectorPseudoNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectorPseudoNode}
	 * labeled alternative in {@link WebParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitSelectorPseudoNode(WebParser.SelectorPseudoNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDeclarationsNode}
	 * labeled alternative in {@link WebParser#cssDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclarationsNode(WebParser.CssDeclarationsNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDeclarationsNode}
	 * labeled alternative in {@link WebParser#cssDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclarationsNode(WebParser.CssDeclarationsNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDeclarationNode}
	 * labeled alternative in {@link WebParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclarationNode(WebParser.CssDeclarationNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDeclarationNode}
	 * labeled alternative in {@link WebParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclarationNode(WebParser.CssDeclarationNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaExpressionNode}
	 * labeled alternative in {@link WebParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpressionNode(WebParser.JinjaExpressionNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaExpressionNode}
	 * labeled alternative in {@link WebParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpressionNode(WebParser.JinjaExpressionNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaExprBodyNode}
	 * labeled alternative in {@link WebParser#jinjaExprBody}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExprBodyNode(WebParser.JinjaExprBodyNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaExprBodyNode}
	 * labeled alternative in {@link WebParser#jinjaExprBody}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExprBodyNode(WebParser.JinjaExprBodyNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link WebParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockNode(WebParser.JinjaBlockNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link WebParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockNode(WebParser.JinjaBlockNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockForStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockForStartNode(WebParser.BlockForStartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockForStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockForStartNode(WebParser.BlockForStartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockForEndNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockForEndNode(WebParser.BlockForEndNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockForEndNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockForEndNode(WebParser.BlockForEndNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockIfStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockIfStartNode(WebParser.BlockIfStartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockIfStartNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockIfStartNode(WebParser.BlockIfStartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockElifNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockElifNode(WebParser.BlockElifNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockElifNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockElifNode(WebParser.BlockElifNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockElseNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockElseNode(WebParser.BlockElseNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockElseNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockElseNode(WebParser.BlockElseNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockEndIfNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockEndIfNode(WebParser.BlockEndIfNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockEndIfNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockEndIfNode(WebParser.BlockEndIfNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSetNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockSetNode(WebParser.BlockSetNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSetNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockSetNode(WebParser.BlockSetNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSimpleNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockSimpleNode(WebParser.BlockSimpleNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSimpleNode}
	 * labeled alternative in {@link WebParser#jinjaBlockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockSimpleNode(WebParser.BlockSimpleNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStartNode}
	 * labeled alternative in {@link WebParser#forStart}.
	 * @param ctx the parse tree
	 */
	void enterForStartNode(WebParser.ForStartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStartNode}
	 * labeled alternative in {@link WebParser#forStart}.
	 * @param ctx the parse tree
	 */
	void exitForStartNode(WebParser.ForStartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForEndNode}
	 * labeled alternative in {@link WebParser#forEnd}.
	 * @param ctx the parse tree
	 */
	void enterForEndNode(WebParser.ForEndNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForEndNode}
	 * labeled alternative in {@link WebParser#forEnd}.
	 * @param ctx the parse tree
	 */
	void exitForEndNode(WebParser.ForEndNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStartNode}
	 * labeled alternative in {@link WebParser#ifStart}.
	 * @param ctx the parse tree
	 */
	void enterIfStartNode(WebParser.IfStartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStartNode}
	 * labeled alternative in {@link WebParser#ifStart}.
	 * @param ctx the parse tree
	 */
	void exitIfStartNode(WebParser.IfStartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElifPartNode}
	 * labeled alternative in {@link WebParser#elifPart}.
	 * @param ctx the parse tree
	 */
	void enterElifPartNode(WebParser.ElifPartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElifPartNode}
	 * labeled alternative in {@link WebParser#elifPart}.
	 * @param ctx the parse tree
	 */
	void exitElifPartNode(WebParser.ElifPartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElsePartNode}
	 * labeled alternative in {@link WebParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void enterElsePartNode(WebParser.ElsePartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElsePartNode}
	 * labeled alternative in {@link WebParser#elsePart}.
	 * @param ctx the parse tree
	 */
	void exitElsePartNode(WebParser.ElsePartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndIfPartNode}
	 * labeled alternative in {@link WebParser#endIfPart}.
	 * @param ctx the parse tree
	 */
	void enterEndIfPartNode(WebParser.EndIfPartNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndIfPartNode}
	 * labeled alternative in {@link WebParser#endIfPart}.
	 * @param ctx the parse tree
	 */
	void exitEndIfPartNode(WebParser.EndIfPartNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetStmtNode}
	 * labeled alternative in {@link WebParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmtNode(WebParser.SetStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetStmtNode}
	 * labeled alternative in {@link WebParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmtNode(WebParser.SetStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link WebParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmtNode(WebParser.SimpleStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link WebParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmtNode(WebParser.SimpleStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaBlockExprNode}
	 * labeled alternative in {@link WebParser#jinjaBlockExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockExprNode(WebParser.JinjaBlockExprNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaBlockExprNode}
	 * labeled alternative in {@link WebParser#jinjaBlockExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockExprNode(WebParser.JinjaBlockExprNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaCommentNode}
	 * labeled alternative in {@link WebParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void enterJinjaCommentNode(WebParser.JinjaCommentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaCommentNode}
	 * labeled alternative in {@link WebParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void exitJinjaCommentNode(WebParser.JinjaCommentNodeContext ctx);
}