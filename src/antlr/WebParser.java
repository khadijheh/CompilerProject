// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/WebParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class WebParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		JINJA_EXPR_OPEN=1, JINJA_BLOCK_OPEN=2, JINJA_COMMENT_OPEN=3, HTML_COMMENT_OPEN=4, 
		HTML_DECLARATION=5, CSS_STYLE_TAG=6, HTML_CLOSE_OPEN=7, HTML_OPEN=8, TEXT=9, 
		WS=10, HTML_IDENTIFIER=11, EQUALS=12, HTML_WS=13, HTML_ATTR_VALUE_OPEN_DQ=14, 
		HTML_ATTR_VALUE_OPEN_SQ=15, HTML_TAG_SELF_CLOSE=16, HTML_TAG_CLOSE=17, 
		HTML_OTHER=18, HTML_COMMENT_CLOSE=19, HTML_COMMENT_TEXT=20, HTML_COMMENT_WS=21, 
		CSS_STYLE_CLOSE=22, CSS_WS=23, CSS_LBRACE=24, CSS_RBRACE=25, CSS_LBRACK=26, 
		CSS_RBRACK=27, CSS_COLON=28, CSS_SEMI=29, CSS_COMMA=30, CSS_EQUAL=31, 
		CSS_LP=32, CSS_RP=33, CSS_DOT=34, CSS_COLOR_HEX=35, CSS_HASH=36, CSS_IDENT=37, 
		CSS_NUMBER=38, CSS_UNIT=39, CSS_STRING=40, CSS_MINUS=41, CSS_OTHER=42, 
		JINJA_EXPR_OPEN_IN_ATTR=43, JINJA_BLOCK_OPEN_IN_ATTR=44, JINJA_COMMENT_OPEN_IN_ATTR=45, 
		HTML_ATTR_VALUE_CLOSE_DQ=46, HTML_ATTR_VALUE_CLOSE_SQ=47, HTML_ATTR_VALUE_TEXT=48, 
		HTML_ATTR_VALUE_WS=49, JINJA_EXPR_CLOSE=50, JINJA_IDENT=51, JINJA_NUMBER=52, 
		JINJA_STRING=53, JINJA_OP=54, JINJA_DOT=55, JINJA_COMMA=56, JINJA_COLON=57, 
		JINJA_LP=58, JINJA_RP=59, JINJA_LB=60, JINJA_RB=61, JINJA_WS=62, JINJA_OTHER=63, 
		JINJA_BLOCK_CLOSE=64, JINJA_FOR=65, JINJA_IN=66, JINJA_ENDFOR=67, JINJA_IF=68, 
		JINJA_ELIF=69, JINJA_ELSE=70, JINJA_ENDIF=71, JINJA_SET=72, JINJA_BLOCK_IDENT=73, 
		JINJA_BLOCK_NUMBER=74, JINJA_BLOCK_STRING=75, JINJA_BLOCK_EQ=76, JINJA_BLOCK_DOT=77, 
		JINJA_BLOCK_COMMA=78, JINJA_BLOCK_COLON=79, JINJA_BLOCK_LP=80, JINJA_BLOCK_RP=81, 
		JINJA_BLOCK_LB=82, JINJA_BLOCK_RB=83, JINJA_BLOCK_WS=84, JINJA_BLOCK_OTHER=85, 
		JINJA_COMMENT_CLOSE=86, JINJA_COMMENT_TEXT=87, JINJA_COMMENT_WS=88;
	public static final int
		RULE_template = 0, RULE_contentItem = 1, RULE_htmlElement = 2, RULE_htmlVoidElement = 3, 
		RULE_htmlNormalElement = 4, RULE_htmlAttribute = 5, RULE_htmlAttributeValue = 6, 
		RULE_dqValue = 7, RULE_sqValue = 8, RULE_htmlAttrValueItem = 9, RULE_htmlText = 10, 
		RULE_cssStyleBlock = 11, RULE_cssRules = 12, RULE_cssRule = 13, RULE_cssSelectorList = 14, 
		RULE_cssSelector = 15, RULE_selectorPart = 16, RULE_simpleSelector = 17, 
		RULE_typeSelector = 18, RULE_classSelector = 19, RULE_idSelector = 20, 
		RULE_pseudoSelector = 21, RULE_attributeSelector = 22, RULE_cssDeclarations = 23, 
		RULE_cssDeclaration = 24, RULE_cssValue = 25, RULE_cssValueAtom = 26, 
		RULE_jinjaExpression = 27, RULE_jinjaExprBody = 28, RULE_jinjaBlock = 29, 
		RULE_jinjaBlockInner = 30, RULE_forStart = 31, RULE_forEnd = 32, RULE_ifStart = 33, 
		RULE_elifPart = 34, RULE_elsePart = 35, RULE_endIfPart = 36, RULE_setStmt = 37, 
		RULE_simpleStmt = 38, RULE_jinjaBlockExpr = 39, RULE_jinjaComment = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "contentItem", "htmlElement", "htmlVoidElement", "htmlNormalElement", 
			"htmlAttribute", "htmlAttributeValue", "dqValue", "sqValue", "htmlAttrValueItem", 
			"htmlText", "cssStyleBlock", "cssRules", "cssRule", "cssSelectorList", 
			"cssSelector", "selectorPart", "simpleSelector", "typeSelector", "classSelector", 
			"idSelector", "pseudoSelector", "attributeSelector", "cssDeclarations", 
			"cssDeclaration", "cssValue", "cssValueAtom", "jinjaExpression", "jinjaExprBody", 
			"jinjaBlock", "jinjaBlockInner", "forStart", "forEnd", "ifStart", "elifPart", 
			"elsePart", "endIfPart", "setStmt", "simpleStmt", "jinjaBlockExpr", "jinjaComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'<!--'", null, null, "'</'", "'<'", null, null, 
			null, null, null, null, null, "'/>'", "'>'", null, "'-->'", null, null, 
			null, null, "'{'", "'}'", null, null, null, "';'", null, null, null, 
			null, null, null, "'#'", null, null, null, null, "'-'", null, null, null, 
			null, null, null, null, null, "'}}'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'%}'", "'for'", "'in'", "'endfor'", 
			"'if'", "'elif'", "'else'", "'endif'", "'set'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'#}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "JINJA_EXPR_OPEN", "JINJA_BLOCK_OPEN", "JINJA_COMMENT_OPEN", "HTML_COMMENT_OPEN", 
			"HTML_DECLARATION", "CSS_STYLE_TAG", "HTML_CLOSE_OPEN", "HTML_OPEN", 
			"TEXT", "WS", "HTML_IDENTIFIER", "EQUALS", "HTML_WS", "HTML_ATTR_VALUE_OPEN_DQ", 
			"HTML_ATTR_VALUE_OPEN_SQ", "HTML_TAG_SELF_CLOSE", "HTML_TAG_CLOSE", "HTML_OTHER", 
			"HTML_COMMENT_CLOSE", "HTML_COMMENT_TEXT", "HTML_COMMENT_WS", "CSS_STYLE_CLOSE", 
			"CSS_WS", "CSS_LBRACE", "CSS_RBRACE", "CSS_LBRACK", "CSS_RBRACK", "CSS_COLON", 
			"CSS_SEMI", "CSS_COMMA", "CSS_EQUAL", "CSS_LP", "CSS_RP", "CSS_DOT", 
			"CSS_COLOR_HEX", "CSS_HASH", "CSS_IDENT", "CSS_NUMBER", "CSS_UNIT", "CSS_STRING", 
			"CSS_MINUS", "CSS_OTHER", "JINJA_EXPR_OPEN_IN_ATTR", "JINJA_BLOCK_OPEN_IN_ATTR", 
			"JINJA_COMMENT_OPEN_IN_ATTR", "HTML_ATTR_VALUE_CLOSE_DQ", "HTML_ATTR_VALUE_CLOSE_SQ", 
			"HTML_ATTR_VALUE_TEXT", "HTML_ATTR_VALUE_WS", "JINJA_EXPR_CLOSE", "JINJA_IDENT", 
			"JINJA_NUMBER", "JINJA_STRING", "JINJA_OP", "JINJA_DOT", "JINJA_COMMA", 
			"JINJA_COLON", "JINJA_LP", "JINJA_RP", "JINJA_LB", "JINJA_RB", "JINJA_WS", 
			"JINJA_OTHER", "JINJA_BLOCK_CLOSE", "JINJA_FOR", "JINJA_IN", "JINJA_ENDFOR", 
			"JINJA_IF", "JINJA_ELIF", "JINJA_ELSE", "JINJA_ENDIF", "JINJA_SET", "JINJA_BLOCK_IDENT", 
			"JINJA_BLOCK_NUMBER", "JINJA_BLOCK_STRING", "JINJA_BLOCK_EQ", "JINJA_BLOCK_DOT", 
			"JINJA_BLOCK_COMMA", "JINJA_BLOCK_COLON", "JINJA_BLOCK_LP", "JINJA_BLOCK_RP", 
			"JINJA_BLOCK_LB", "JINJA_BLOCK_RB", "JINJA_BLOCK_WS", "JINJA_BLOCK_OTHER", 
			"JINJA_COMMENT_CLOSE", "JINJA_COMMENT_TEXT", "JINJA_COMMENT_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "WebParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WebParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateContext extends ParserRuleContext {
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
	 
		public TemplateContext() { }
		public void copyFrom(TemplateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TemplateNodeContext extends TemplateContext {
		public TerminalNode EOF() { return getToken(WebParser.EOF, 0); }
		public List<ContentItemContext> contentItem() {
			return getRuleContexts(ContentItemContext.class);
		}
		public ContentItemContext contentItem(int i) {
			return getRuleContext(ContentItemContext.class,i);
		}
		public TemplateNodeContext(TemplateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterTemplateNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitTemplateNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitTemplateNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_template);
		int _la;
		try {
			_localctx = new TemplateNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846L) != 0)) {
				{
				{
				setState(82);
				contentItem();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentItemContext extends ParserRuleContext {
		public ContentItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentItem; }
	 
		public ContentItemContext() { }
		public void copyFrom(ContentItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentJinjaCommentContext extends ContentItemContext {
		public JinjaCommentContext jinjaComment() {
			return getRuleContext(JinjaCommentContext.class,0);
		}
		public ContentJinjaCommentContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentJinjaComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentJinjaComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentJinjaComment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentCssStyleContext extends ContentItemContext {
		public CssStyleBlockContext cssStyleBlock() {
			return getRuleContext(CssStyleBlockContext.class,0);
		}
		public ContentCssStyleContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentCssStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentCssStyle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentCssStyle(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentHtmlElementContext extends ContentItemContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public ContentHtmlElementContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentJinjaExpressionContext extends ContentItemContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public ContentJinjaExpressionContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentHtmlTextContext extends ContentItemContext {
		public HtmlTextContext htmlText() {
			return getRuleContext(HtmlTextContext.class,0);
		}
		public ContentHtmlTextContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentHtmlText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentHtmlText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentHtmlText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContentJinjaBlockContext extends ContentItemContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public ContentJinjaBlockContext(ContentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterContentJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitContentJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitContentJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentItemContext contentItem() throws RecognitionException {
		ContentItemContext _localctx = new ContentItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_contentItem);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_STYLE_TAG:
				_localctx = new ContentCssStyleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				cssStyleBlock();
				}
				break;
			case HTML_OPEN:
				_localctx = new ContentHtmlElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				htmlElement();
				}
				break;
			case TEXT:
				_localctx = new ContentHtmlTextContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				htmlText();
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new ContentJinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				jinjaExpression();
				}
				break;
			case JINJA_BLOCK_OPEN:
				_localctx = new ContentJinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				jinjaBlock();
				}
				break;
			case JINJA_COMMENT_OPEN:
				_localctx = new ContentJinjaCommentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				jinjaComment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementVoidContext extends HtmlElementContext {
		public HtmlVoidElementContext htmlVoidElement() {
			return getRuleContext(HtmlVoidElementContext.class,0);
		}
		public HtmlElementVoidContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterHtmlElementVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitHtmlElementVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitHtmlElementVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementNormalContext extends HtmlElementContext {
		public HtmlNormalElementContext htmlNormalElement() {
			return getRuleContext(HtmlNormalElementContext.class,0);
		}
		public HtmlElementNormalContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterHtmlElementNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitHtmlElementNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitHtmlElementNormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlElementVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				htmlVoidElement();
				}
				break;
			case 2:
				_localctx = new HtmlElementNormalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				htmlNormalElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlVoidElementContext extends ParserRuleContext {
		public HtmlVoidElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlVoidElement; }
	 
		public HtmlVoidElementContext() { }
		public void copyFrom(HtmlVoidElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementNodeContext extends HtmlVoidElementContext {
		public TerminalNode HTML_OPEN() { return getToken(WebParser.HTML_OPEN, 0); }
		public TerminalNode HTML_IDENTIFIER() { return getToken(WebParser.HTML_IDENTIFIER, 0); }
		public TerminalNode HTML_TAG_SELF_CLOSE() { return getToken(WebParser.HTML_TAG_SELF_CLOSE, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public VoidElementNodeContext(HtmlVoidElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterVoidElementNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitVoidElementNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitVoidElementNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlVoidElementContext htmlVoidElement() throws RecognitionException {
		HtmlVoidElementContext _localctx = new HtmlVoidElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlVoidElement);
		int _la;
		try {
			_localctx = new VoidElementNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(HTML_OPEN);
			setState(103);
			match(HTML_IDENTIFIER);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HTML_IDENTIFIER) {
				{
				{
				setState(104);
				htmlAttribute();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			match(HTML_TAG_SELF_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlNormalElementContext extends ParserRuleContext {
		public HtmlNormalElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlNormalElement; }
	 
		public HtmlNormalElementContext() { }
		public void copyFrom(HtmlNormalElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalElementNodeContext extends HtmlNormalElementContext {
		public TerminalNode HTML_OPEN() { return getToken(WebParser.HTML_OPEN, 0); }
		public List<TerminalNode> HTML_IDENTIFIER() { return getTokens(WebParser.HTML_IDENTIFIER); }
		public TerminalNode HTML_IDENTIFIER(int i) {
			return getToken(WebParser.HTML_IDENTIFIER, i);
		}
		public List<TerminalNode> HTML_TAG_CLOSE() { return getTokens(WebParser.HTML_TAG_CLOSE); }
		public TerminalNode HTML_TAG_CLOSE(int i) {
			return getToken(WebParser.HTML_TAG_CLOSE, i);
		}
		public TerminalNode HTML_CLOSE_OPEN() { return getToken(WebParser.HTML_CLOSE_OPEN, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public List<ContentItemContext> contentItem() {
			return getRuleContexts(ContentItemContext.class);
		}
		public ContentItemContext contentItem(int i) {
			return getRuleContext(ContentItemContext.class,i);
		}
		public NormalElementNodeContext(HtmlNormalElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterNormalElementNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitNormalElementNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitNormalElementNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlNormalElementContext htmlNormalElement() throws RecognitionException {
		HtmlNormalElementContext _localctx = new HtmlNormalElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlNormalElement);
		int _la;
		try {
			_localctx = new NormalElementNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(HTML_OPEN);
			setState(113);
			match(HTML_IDENTIFIER);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HTML_IDENTIFIER) {
				{
				{
				setState(114);
				htmlAttribute();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(HTML_TAG_CLOSE);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846L) != 0)) {
				{
				{
				setState(121);
				contentItem();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(HTML_CLOSE_OPEN);
			setState(128);
			match(HTML_IDENTIFIER);
			setState(129);
			match(HTML_TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends ParserRuleContext {
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
	 
		public HtmlAttributeContext() { }
		public void copyFrom(HtmlAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeBooleanContext extends HtmlAttributeContext {
		public TerminalNode HTML_IDENTIFIER() { return getToken(WebParser.HTML_IDENTIFIER, 0); }
		public HtmlAttributeBooleanContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterHtmlAttributeBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitHtmlAttributeBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitHtmlAttributeBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeAssignmentContext extends HtmlAttributeContext {
		public TerminalNode HTML_IDENTIFIER() { return getToken(WebParser.HTML_IDENTIFIER, 0); }
		public TerminalNode EQUALS() { return getToken(WebParser.EQUALS, 0); }
		public HtmlAttributeValueContext htmlAttributeValue() {
			return getRuleContext(HtmlAttributeValueContext.class,0);
		}
		public HtmlAttributeAssignmentContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterHtmlAttributeAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitHtmlAttributeAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitHtmlAttributeAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_htmlAttribute);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new HtmlAttributeAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(HTML_IDENTIFIER);
				setState(132);
				match(EQUALS);
				setState(133);
				htmlAttributeValue();
				}
				break;
			case 2:
				_localctx = new HtmlAttributeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(HTML_IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeValueContext extends ParserRuleContext {
		public HtmlAttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttributeValue; }
	 
		public HtmlAttributeValueContext() { }
		public void copyFrom(HtmlAttributeValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrDoubleQuotedContext extends HtmlAttributeValueContext {
		public DqValueContext dqValue() {
			return getRuleContext(DqValueContext.class,0);
		}
		public AttrDoubleQuotedContext(HtmlAttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrDoubleQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrDoubleQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrDoubleQuoted(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrSingleQuotedContext extends HtmlAttributeValueContext {
		public SqValueContext sqValue() {
			return getRuleContext(SqValueContext.class,0);
		}
		public AttrSingleQuotedContext(HtmlAttributeValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrSingleQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrSingleQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrSingleQuoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeValueContext htmlAttributeValue() throws RecognitionException {
		HtmlAttributeValueContext _localctx = new HtmlAttributeValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlAttributeValue);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_ATTR_VALUE_OPEN_DQ:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				dqValue();
				}
				break;
			case HTML_ATTR_VALUE_OPEN_SQ:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				sqValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DqValueContext extends ParserRuleContext {
		public DqValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dqValue; }
	 
		public DqValueContext() { }
		public void copyFrom(DqValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleQuotedValueContext extends DqValueContext {
		public TerminalNode HTML_ATTR_VALUE_OPEN_DQ() { return getToken(WebParser.HTML_ATTR_VALUE_OPEN_DQ, 0); }
		public TerminalNode HTML_ATTR_VALUE_CLOSE_DQ() { return getToken(WebParser.HTML_ATTR_VALUE_CLOSE_DQ, 0); }
		public List<HtmlAttrValueItemContext> htmlAttrValueItem() {
			return getRuleContexts(HtmlAttrValueItemContext.class);
		}
		public HtmlAttrValueItemContext htmlAttrValueItem(int i) {
			return getRuleContext(HtmlAttrValueItemContext.class,i);
		}
		public DoubleQuotedValueContext(DqValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterDoubleQuotedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitDoubleQuotedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitDoubleQuotedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DqValueContext dqValue() throws RecognitionException {
		DqValueContext _localctx = new DqValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dqValue);
		int _la;
		try {
			_localctx = new DoubleQuotedValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(HTML_ATTR_VALUE_OPEN_DQ);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474976710670L) != 0)) {
				{
				{
				setState(142);
				htmlAttrValueItem();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(HTML_ATTR_VALUE_CLOSE_DQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqValueContext extends ParserRuleContext {
		public SqValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqValue; }
	 
		public SqValueContext() { }
		public void copyFrom(SqValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleQuotedValueContext extends SqValueContext {
		public TerminalNode HTML_ATTR_VALUE_OPEN_SQ() { return getToken(WebParser.HTML_ATTR_VALUE_OPEN_SQ, 0); }
		public TerminalNode HTML_ATTR_VALUE_CLOSE_SQ() { return getToken(WebParser.HTML_ATTR_VALUE_CLOSE_SQ, 0); }
		public List<HtmlAttrValueItemContext> htmlAttrValueItem() {
			return getRuleContexts(HtmlAttrValueItemContext.class);
		}
		public HtmlAttrValueItemContext htmlAttrValueItem(int i) {
			return getRuleContext(HtmlAttrValueItemContext.class,i);
		}
		public SingleQuotedValueContext(SqValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSingleQuotedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSingleQuotedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSingleQuotedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqValueContext sqValue() throws RecognitionException {
		SqValueContext _localctx = new SqValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sqValue);
		int _la;
		try {
			_localctx = new SingleQuotedValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(HTML_ATTR_VALUE_OPEN_SQ);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474976710670L) != 0)) {
				{
				{
				setState(151);
				htmlAttrValueItem();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(HTML_ATTR_VALUE_CLOSE_SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttrValueItemContext extends ParserRuleContext {
		public HtmlAttrValueItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttrValueItem; }
	 
		public HtmlAttrValueItemContext() { }
		public void copyFrom(HtmlAttrValueItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrTextNodeContext extends HtmlAttrValueItemContext {
		public TerminalNode HTML_ATTR_VALUE_TEXT() { return getToken(WebParser.HTML_ATTR_VALUE_TEXT, 0); }
		public AttrTextNodeContext(HtmlAttrValueItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrTextNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrTextNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrTextNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaExpressionNodeContext extends HtmlAttrValueItemContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public AttrJinjaExpressionNodeContext(HtmlAttrValueItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrJinjaExpressionNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrJinjaExpressionNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrJinjaExpressionNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaCommentNodeContext extends HtmlAttrValueItemContext {
		public JinjaCommentContext jinjaComment() {
			return getRuleContext(JinjaCommentContext.class,0);
		}
		public AttrJinjaCommentNodeContext(HtmlAttrValueItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrJinjaCommentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrJinjaCommentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrJinjaCommentNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaBlockNodeContext extends HtmlAttrValueItemContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public AttrJinjaBlockNodeContext(HtmlAttrValueItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttrJinjaBlockNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttrJinjaBlockNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttrJinjaBlockNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttrValueItemContext htmlAttrValueItem() throws RecognitionException {
		HtmlAttrValueItemContext _localctx = new HtmlAttrValueItemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_htmlAttrValueItem);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_ATTR_VALUE_TEXT:
				_localctx = new AttrTextNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(HTML_ATTR_VALUE_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaExpressionNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				jinjaExpression();
				}
				break;
			case JINJA_BLOCK_OPEN:
				_localctx = new AttrJinjaBlockNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				jinjaBlock();
				}
				break;
			case JINJA_COMMENT_OPEN:
				_localctx = new AttrJinjaCommentNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				jinjaComment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContext extends ParserRuleContext {
		public HtmlTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlText; }
	 
		public HtmlTextContext() { }
		public void copyFrom(HtmlTextContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextNodeContext extends HtmlTextContext {
		public TerminalNode TEXT() { return getToken(WebParser.TEXT, 0); }
		public HtmlTextNodeContext(HtmlTextContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterHtmlTextNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitHtmlTextNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitHtmlTextNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlTextContext htmlText() throws RecognitionException {
		HtmlTextContext _localctx = new HtmlTextContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_htmlText);
		try {
			_localctx = new HtmlTextNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssStyleBlockContext extends ParserRuleContext {
		public CssStyleBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssStyleBlock; }
	 
		public CssStyleBlockContext() { }
		public void copyFrom(CssStyleBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssStyleNodeContext extends CssStyleBlockContext {
		public TerminalNode CSS_STYLE_TAG() { return getToken(WebParser.CSS_STYLE_TAG, 0); }
		public CssRulesContext cssRules() {
			return getRuleContext(CssRulesContext.class,0);
		}
		public TerminalNode CSS_STYLE_CLOSE() { return getToken(WebParser.CSS_STYLE_CLOSE, 0); }
		public CssStyleNodeContext(CssStyleBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssStyleNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssStyleNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssStyleNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssStyleBlockContext cssStyleBlock() throws RecognitionException {
		CssStyleBlockContext _localctx = new CssStyleBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssStyleBlock);
		try {
			_localctx = new CssStyleNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(CSS_STYLE_TAG);
			setState(168);
			cssRules();
			setState(169);
			match(CSS_STYLE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRulesContext extends ParserRuleContext {
		public CssRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRules; }
	 
		public CssRulesContext() { }
		public void copyFrom(CssRulesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRulesNodeContext extends CssRulesContext {
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public CssRulesNodeContext(CssRulesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssRulesNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssRulesNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssRulesNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRulesContext cssRules() throws RecognitionException {
		CssRulesContext _localctx = new CssRulesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssRules);
		int _la;
		try {
			_localctx = new CssRulesNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 223673843712L) != 0)) {
				{
				{
				setState(171);
				cssRule();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
	 
		public CssRuleContext() { }
		public void copyFrom(CssRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleNodeContext extends CssRuleContext {
		public CssSelectorListContext cssSelectorList() {
			return getRuleContext(CssSelectorListContext.class,0);
		}
		public TerminalNode CSS_LBRACE() { return getToken(WebParser.CSS_LBRACE, 0); }
		public CssDeclarationsContext cssDeclarations() {
			return getRuleContext(CssDeclarationsContext.class,0);
		}
		public TerminalNode CSS_RBRACE() { return getToken(WebParser.CSS_RBRACE, 0); }
		public CssRuleNodeContext(CssRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssRuleNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssRuleNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssRuleNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cssRule);
		try {
			_localctx = new CssRuleNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			cssSelectorList();
			setState(178);
			match(CSS_LBRACE);
			setState(179);
			cssDeclarations();
			setState(180);
			match(CSS_RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListContext extends ParserRuleContext {
		public CssSelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelectorList; }
	 
		public CssSelectorListContext() { }
		public void copyFrom(CssSelectorListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListNodeContext extends CssSelectorListContext {
		public List<CssSelectorContext> cssSelector() {
			return getRuleContexts(CssSelectorContext.class);
		}
		public CssSelectorContext cssSelector(int i) {
			return getRuleContext(CssSelectorContext.class,i);
		}
		public List<TerminalNode> CSS_COMMA() { return getTokens(WebParser.CSS_COMMA); }
		public TerminalNode CSS_COMMA(int i) {
			return getToken(WebParser.CSS_COMMA, i);
		}
		public CssSelectorListNodeContext(CssSelectorListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssSelectorListNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssSelectorListNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssSelectorListNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorListContext cssSelectorList() throws RecognitionException {
		CssSelectorListContext _localctx = new CssSelectorListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cssSelectorList);
		int _la;
		try {
			_localctx = new CssSelectorListNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			cssSelector();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_COMMA) {
				{
				{
				setState(183);
				match(CSS_COMMA);
				setState(184);
				cssSelector();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
	 
		public CssSelectorContext() { }
		public void copyFrom(CssSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorNodeContext extends CssSelectorContext {
		public List<SelectorPartContext> selectorPart() {
			return getRuleContexts(SelectorPartContext.class);
		}
		public SelectorPartContext selectorPart(int i) {
			return getRuleContext(SelectorPartContext.class,i);
		}
		public List<TerminalNode> CSS_WS() { return getTokens(WebParser.CSS_WS); }
		public TerminalNode CSS_WS(int i) {
			return getToken(WebParser.CSS_WS, i);
		}
		public CssSelectorNodeContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cssSelector);
		int _la;
		try {
			_localctx = new CssSelectorNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			selectorPart();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_WS) {
				{
				{
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(191);
					match(CSS_WS);
					}
					}
					setState(194); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CSS_WS );
				setState(196);
				selectorPart();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorPartContext extends ParserRuleContext {
		public SelectorPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorPart; }
	 
		public SelectorPartContext() { }
		public void copyFrom(SelectorPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorPartNodeContext extends SelectorPartContext {
		public List<SimpleSelectorContext> simpleSelector() {
			return getRuleContexts(SimpleSelectorContext.class);
		}
		public SimpleSelectorContext simpleSelector(int i) {
			return getRuleContext(SimpleSelectorContext.class,i);
		}
		public SelectorPartNodeContext(SelectorPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSelectorPartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSelectorPartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSelectorPartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorPartContext selectorPart() throws RecognitionException {
		SelectorPartContext _localctx = new SelectorPartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selectorPart);
		int _la;
		try {
			_localctx = new SelectorPartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				simpleSelector();
				}
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 223673843712L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleSelectorContext extends ParserRuleContext {
		public SimpleSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSelector; }
	 
		public SimpleSelectorContext() { }
		public void copyFrom(SimpleSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorNodeContext extends SimpleSelectorContext {
		public ClassSelectorContext classSelector() {
			return getRuleContext(ClassSelectorContext.class,0);
		}
		public ClassSelectorNodeContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterClassSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitClassSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitClassSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorNodeContext extends SimpleSelectorContext {
		public IdSelectorContext idSelector() {
			return getRuleContext(IdSelectorContext.class,0);
		}
		public IdSelectorNodeContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterIdSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitIdSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitIdSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeSeNodeContext extends SimpleSelectorContext {
		public AttributeSelectorContext attributeSelector() {
			return getRuleContext(AttributeSelectorContext.class,0);
		}
		public AttributeSeNodeContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttributeSeNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttributeSeNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttributeSeNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PseudoSelectorNodeContext extends SimpleSelectorContext {
		public PseudoSelectorContext pseudoSelector() {
			return getRuleContext(PseudoSelectorContext.class,0);
		}
		public PseudoSelectorNodeContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterPseudoSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitPseudoSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitPseudoSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeSelectorNodeContext extends SimpleSelectorContext {
		public TypeSelectorContext typeSelector() {
			return getRuleContext(TypeSelectorContext.class,0);
		}
		public TypeSelectorNodeContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterTypeSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitTypeSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitTypeSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleSelectorContext simpleSelector() throws RecognitionException {
		SimpleSelectorContext _localctx = new SimpleSelectorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_simpleSelector);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_IDENT:
				_localctx = new TypeSelectorNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				typeSelector();
				}
				break;
			case CSS_DOT:
				_localctx = new ClassSelectorNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				classSelector();
				}
				break;
			case CSS_HASH:
				_localctx = new IdSelectorNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				idSelector();
				}
				break;
			case CSS_COLON:
				_localctx = new PseudoSelectorNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(210);
				pseudoSelector();
				}
				break;
			case CSS_LBRACK:
				_localctx = new AttributeSeNodeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(211);
				attributeSelector();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSelectorContext extends ParserRuleContext {
		public TypeSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSelector; }
	 
		public TypeSelectorContext() { }
		public void copyFrom(TypeSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeSelectorIdNodeContext extends TypeSelectorContext {
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public TypeSelectorIdNodeContext(TypeSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterTypeSelectorIdNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitTypeSelectorIdNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitTypeSelectorIdNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSelectorContext typeSelector() throws RecognitionException {
		TypeSelectorContext _localctx = new TypeSelectorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeSelector);
		try {
			_localctx = new TypeSelectorIdNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(CSS_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorContext extends ParserRuleContext {
		public ClassSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSelector; }
	 
		public ClassSelectorContext() { }
		public void copyFrom(ClassSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorIdNodeContext extends ClassSelectorContext {
		public TerminalNode CSS_DOT() { return getToken(WebParser.CSS_DOT, 0); }
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public ClassSelectorIdNodeContext(ClassSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterClassSelectorIdNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitClassSelectorIdNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitClassSelectorIdNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassSelectorContext classSelector() throws RecognitionException {
		ClassSelectorContext _localctx = new ClassSelectorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_classSelector);
		try {
			_localctx = new ClassSelectorIdNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(CSS_DOT);
			setState(217);
			match(CSS_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorContext extends ParserRuleContext {
		public IdSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idSelector; }
	 
		public IdSelectorContext() { }
		public void copyFrom(IdSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorIdNodeContext extends IdSelectorContext {
		public TerminalNode CSS_HASH() { return getToken(WebParser.CSS_HASH, 0); }
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public IdSelectorIdNodeContext(IdSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterIdSelectorIdNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitIdSelectorIdNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitIdSelectorIdNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdSelectorContext idSelector() throws RecognitionException {
		IdSelectorContext _localctx = new IdSelectorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_idSelector);
		try {
			_localctx = new IdSelectorIdNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(CSS_HASH);
			setState(220);
			match(CSS_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PseudoSelectorContext extends ParserRuleContext {
		public PseudoSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudoSelector; }
	 
		public PseudoSelectorContext() { }
		public void copyFrom(PseudoSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PseudoSelectorIdNodeContext extends PseudoSelectorContext {
		public TerminalNode CSS_COLON() { return getToken(WebParser.CSS_COLON, 0); }
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public PseudoSelectorIdNodeContext(PseudoSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterPseudoSelectorIdNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitPseudoSelectorIdNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitPseudoSelectorIdNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudoSelectorContext pseudoSelector() throws RecognitionException {
		PseudoSelectorContext _localctx = new PseudoSelectorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_pseudoSelector);
		try {
			_localctx = new PseudoSelectorIdNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(CSS_COLON);
			setState(223);
			match(CSS_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeSelectorContext extends ParserRuleContext {
		public AttributeSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSelector; }
	 
		public AttributeSelectorContext() { }
		public void copyFrom(AttributeSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeSelectorNodeContext extends AttributeSelectorContext {
		public TerminalNode CSS_LBRACK() { return getToken(WebParser.CSS_LBRACK, 0); }
		public List<TerminalNode> CSS_IDENT() { return getTokens(WebParser.CSS_IDENT); }
		public TerminalNode CSS_IDENT(int i) {
			return getToken(WebParser.CSS_IDENT, i);
		}
		public TerminalNode CSS_EQUAL() { return getToken(WebParser.CSS_EQUAL, 0); }
		public TerminalNode CSS_RBRACK() { return getToken(WebParser.CSS_RBRACK, 0); }
		public TerminalNode CSS_STRING() { return getToken(WebParser.CSS_STRING, 0); }
		public AttributeSelectorNodeContext(AttributeSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterAttributeSelectorNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitAttributeSelectorNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitAttributeSelectorNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeSelectorContext attributeSelector() throws RecognitionException {
		AttributeSelectorContext _localctx = new AttributeSelectorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attributeSelector);
		int _la;
		try {
			_localctx = new AttributeSelectorNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(CSS_LBRACK);
			setState(226);
			match(CSS_IDENT);
			setState(227);
			match(CSS_EQUAL);
			setState(228);
			_la = _input.LA(1);
			if ( !(_la==CSS_IDENT || _la==CSS_STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(229);
			match(CSS_RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationsContext extends ParserRuleContext {
		public CssDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclarations; }
	 
		public CssDeclarationsContext() { }
		public void copyFrom(CssDeclarationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationsNodeContext extends CssDeclarationsContext {
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssDeclarationsNodeContext(CssDeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssDeclarationsNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssDeclarationsNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssDeclarationsNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationsContext cssDeclarations() throws RecognitionException {
		CssDeclarationsContext _localctx = new CssDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cssDeclarations);
		int _la;
		try {
			_localctx = new CssDeclarationsNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_IDENT) {
				{
				{
				setState(231);
				cssDeclaration();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
	 
		public CssDeclarationContext() { }
		public void copyFrom(CssDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationNodeContext extends CssDeclarationContext {
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public TerminalNode CSS_COLON() { return getToken(WebParser.CSS_COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode CSS_SEMI() { return getToken(WebParser.CSS_SEMI, 0); }
		public CssDeclarationNodeContext(CssDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssDeclarationNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssDeclarationNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssDeclarationNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cssDeclaration);
		int _la;
		try {
			_localctx = new CssDeclarationNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(CSS_IDENT);
			setState(238);
			match(CSS_COLON);
			setState(239);
			cssValue();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_SEMI) {
				{
				setState(240);
				match(CSS_SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssValueNodeContext extends CssValueContext {
		public List<CssValueAtomContext> cssValueAtom() {
			return getRuleContexts(CssValueAtomContext.class);
		}
		public CssValueAtomContext cssValueAtom(int i) {
			return getRuleContext(CssValueAtomContext.class,i);
		}
		public CssValueNodeContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssValueNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssValueNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssValueNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cssValue);
		try {
			int _alt;
			_localctx = new CssValueNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(244); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(243);
					cssValueAtom();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(246); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueAtomContext extends ParserRuleContext {
		public TerminalNode CSS_COLOR_HEX() { return getToken(WebParser.CSS_COLOR_HEX, 0); }
		public TerminalNode CSS_NUMBER() { return getToken(WebParser.CSS_NUMBER, 0); }
		public TerminalNode CSS_UNIT() { return getToken(WebParser.CSS_UNIT, 0); }
		public TerminalNode CSS_STRING() { return getToken(WebParser.CSS_STRING, 0); }
		public TerminalNode CSS_IDENT() { return getToken(WebParser.CSS_IDENT, 0); }
		public TerminalNode CSS_COMMA() { return getToken(WebParser.CSS_COMMA, 0); }
		public TerminalNode CSS_LP() { return getToken(WebParser.CSS_LP, 0); }
		public TerminalNode CSS_RP() { return getToken(WebParser.CSS_RP, 0); }
		public TerminalNode CSS_MINUS() { return getToken(WebParser.CSS_MINUS, 0); }
		public CssValueAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssValueAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssValueAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssValueAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueAtomContext cssValueAtom() throws RecognitionException {
		CssValueAtomContext _localctx = new CssValueAtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cssValueAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4308925939712L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
	 
		public JinjaExpressionContext() { }
		public void copyFrom(JinjaExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionNodeContext extends JinjaExpressionContext {
		public TerminalNode JINJA_EXPR_OPEN() { return getToken(WebParser.JINJA_EXPR_OPEN, 0); }
		public JinjaExprBodyContext jinjaExprBody() {
			return getRuleContext(JinjaExprBodyContext.class,0);
		}
		public TerminalNode JINJA_EXPR_CLOSE() { return getToken(WebParser.JINJA_EXPR_CLOSE, 0); }
		public JinjaExpressionNodeContext(JinjaExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterJinjaExpressionNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitJinjaExpressionNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitJinjaExpressionNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_jinjaExpression);
		try {
			_localctx = new JinjaExpressionNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(JINJA_EXPR_OPEN);
			setState(251);
			jinjaExprBody();
			setState(252);
			match(JINJA_EXPR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprBodyContext extends ParserRuleContext {
		public JinjaExprBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExprBody; }
	 
		public JinjaExprBodyContext() { }
		public void copyFrom(JinjaExprBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprBodyNodeContext extends JinjaExprBodyContext {
		public List<TerminalNode> JINJA_IDENT() { return getTokens(WebParser.JINJA_IDENT); }
		public TerminalNode JINJA_IDENT(int i) {
			return getToken(WebParser.JINJA_IDENT, i);
		}
		public List<TerminalNode> JINJA_NUMBER() { return getTokens(WebParser.JINJA_NUMBER); }
		public TerminalNode JINJA_NUMBER(int i) {
			return getToken(WebParser.JINJA_NUMBER, i);
		}
		public List<TerminalNode> JINJA_STRING() { return getTokens(WebParser.JINJA_STRING); }
		public TerminalNode JINJA_STRING(int i) {
			return getToken(WebParser.JINJA_STRING, i);
		}
		public List<TerminalNode> JINJA_OP() { return getTokens(WebParser.JINJA_OP); }
		public TerminalNode JINJA_OP(int i) {
			return getToken(WebParser.JINJA_OP, i);
		}
		public List<TerminalNode> JINJA_LP() { return getTokens(WebParser.JINJA_LP); }
		public TerminalNode JINJA_LP(int i) {
			return getToken(WebParser.JINJA_LP, i);
		}
		public List<TerminalNode> JINJA_RP() { return getTokens(WebParser.JINJA_RP); }
		public TerminalNode JINJA_RP(int i) {
			return getToken(WebParser.JINJA_RP, i);
		}
		public List<TerminalNode> JINJA_LB() { return getTokens(WebParser.JINJA_LB); }
		public TerminalNode JINJA_LB(int i) {
			return getToken(WebParser.JINJA_LB, i);
		}
		public List<TerminalNode> JINJA_RB() { return getTokens(WebParser.JINJA_RB); }
		public TerminalNode JINJA_RB(int i) {
			return getToken(WebParser.JINJA_RB, i);
		}
		public List<TerminalNode> JINJA_COMMA() { return getTokens(WebParser.JINJA_COMMA); }
		public TerminalNode JINJA_COMMA(int i) {
			return getToken(WebParser.JINJA_COMMA, i);
		}
		public List<TerminalNode> JINJA_COLON() { return getTokens(WebParser.JINJA_COLON); }
		public TerminalNode JINJA_COLON(int i) {
			return getToken(WebParser.JINJA_COLON, i);
		}
		public List<TerminalNode> JINJA_DOT() { return getTokens(WebParser.JINJA_DOT); }
		public TerminalNode JINJA_DOT(int i) {
			return getToken(WebParser.JINJA_DOT, i);
		}
		public List<TerminalNode> JINJA_OTHER() { return getTokens(WebParser.JINJA_OTHER); }
		public TerminalNode JINJA_OTHER(int i) {
			return getToken(WebParser.JINJA_OTHER, i);
		}
		public JinjaExprBodyNodeContext(JinjaExprBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterJinjaExprBodyNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitJinjaExprBodyNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitJinjaExprBodyNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprBodyContext jinjaExprBody() throws RecognitionException {
		JinjaExprBodyContext _localctx = new JinjaExprBodyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_jinjaExprBody);
		int _la;
		try {
			_localctx = new JinjaExprBodyNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4613937818241073152L) != 0)) {
				{
				{
				setState(254);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -4613937818241073152L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ParserRuleContext {
		public JinjaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlock; }
	 
		public JinjaBlockContext() { }
		public void copyFrom(JinjaBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockNodeContext extends JinjaBlockContext {
		public TerminalNode JINJA_BLOCK_OPEN() { return getToken(WebParser.JINJA_BLOCK_OPEN, 0); }
		public JinjaBlockInnerContext jinjaBlockInner() {
			return getRuleContext(JinjaBlockInnerContext.class,0);
		}
		public TerminalNode JINJA_BLOCK_CLOSE() { return getToken(WebParser.JINJA_BLOCK_CLOSE, 0); }
		public JinjaBlockNodeContext(JinjaBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterJinjaBlockNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitJinjaBlockNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitJinjaBlockNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContext jinjaBlock() throws RecognitionException {
		JinjaBlockContext _localctx = new JinjaBlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_jinjaBlock);
		try {
			_localctx = new JinjaBlockNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(JINJA_BLOCK_OPEN);
			setState(261);
			jinjaBlockInner();
			setState(262);
			match(JINJA_BLOCK_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockInnerContext extends ParserRuleContext {
		public JinjaBlockInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlockInner; }
	 
		public JinjaBlockInnerContext() { }
		public void copyFrom(JinjaBlockInnerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockElifNodeContext extends JinjaBlockInnerContext {
		public ElifPartContext elifPart() {
			return getRuleContext(ElifPartContext.class,0);
		}
		public BlockElifNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockElifNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockElifNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockElifNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSimpleNodeContext extends JinjaBlockInnerContext {
		public SimpleStmtContext simpleStmt() {
			return getRuleContext(SimpleStmtContext.class,0);
		}
		public BlockSimpleNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockSimpleNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockSimpleNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockSimpleNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockEndIfNodeContext extends JinjaBlockInnerContext {
		public EndIfPartContext endIfPart() {
			return getRuleContext(EndIfPartContext.class,0);
		}
		public BlockEndIfNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockEndIfNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockEndIfNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockEndIfNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockIfStartNodeContext extends JinjaBlockInnerContext {
		public IfStartContext ifStart() {
			return getRuleContext(IfStartContext.class,0);
		}
		public BlockIfStartNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockIfStartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockIfStartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockIfStartNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSetNodeContext extends JinjaBlockInnerContext {
		public SetStmtContext setStmt() {
			return getRuleContext(SetStmtContext.class,0);
		}
		public BlockSetNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockSetNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockSetNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockSetNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockForEndNodeContext extends JinjaBlockInnerContext {
		public ForEndContext forEnd() {
			return getRuleContext(ForEndContext.class,0);
		}
		public BlockForEndNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockForEndNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockForEndNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockForEndNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockForStartNodeContext extends JinjaBlockInnerContext {
		public ForStartContext forStart() {
			return getRuleContext(ForStartContext.class,0);
		}
		public BlockForStartNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockForStartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockForStartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockForStartNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockElseNodeContext extends JinjaBlockInnerContext {
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public BlockElseNodeContext(JinjaBlockInnerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterBlockElseNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitBlockElseNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitBlockElseNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockInnerContext jinjaBlockInner() throws RecognitionException {
		JinjaBlockInnerContext _localctx = new JinjaBlockInnerContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_jinjaBlockInner);
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_FOR:
				_localctx = new BlockForStartNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				forStart();
				}
				break;
			case JINJA_ENDFOR:
				_localctx = new BlockForEndNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				forEnd();
				}
				break;
			case JINJA_IF:
				_localctx = new BlockIfStartNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				ifStart();
				}
				break;
			case JINJA_ELIF:
				_localctx = new BlockElifNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				elifPart();
				}
				break;
			case JINJA_ELSE:
				_localctx = new BlockElseNodeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				elsePart();
				}
				break;
			case JINJA_ENDIF:
				_localctx = new BlockEndIfNodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(269);
				endIfPart();
				}
				break;
			case JINJA_SET:
				_localctx = new BlockSetNodeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				setStmt();
				}
				break;
			case JINJA_BLOCK_IDENT:
				_localctx = new BlockSimpleNodeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(271);
				simpleStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStartContext extends ParserRuleContext {
		public ForStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStart; }
	 
		public ForStartContext() { }
		public void copyFrom(ForStartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStartNodeContext extends ForStartContext {
		public TerminalNode JINJA_FOR() { return getToken(WebParser.JINJA_FOR, 0); }
		public TerminalNode JINJA_IN() { return getToken(WebParser.JINJA_IN, 0); }
		public List<JinjaBlockExprContext> jinjaBlockExpr() {
			return getRuleContexts(JinjaBlockExprContext.class);
		}
		public JinjaBlockExprContext jinjaBlockExpr(int i) {
			return getRuleContext(JinjaBlockExprContext.class,i);
		}
		public ForStartNodeContext(ForStartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterForStartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitForStartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitForStartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStartContext forStart() throws RecognitionException {
		ForStartContext _localctx = new ForStartContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_forStart);
		int _la;
		try {
			_localctx = new ForStartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(JINJA_FOR);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(275);
				jinjaBlockExpr();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
			match(JINJA_IN);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(282);
				jinjaBlockExpr();
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForEndContext extends ParserRuleContext {
		public ForEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forEnd; }
	 
		public ForEndContext() { }
		public void copyFrom(ForEndContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForEndNodeContext extends ForEndContext {
		public TerminalNode JINJA_ENDFOR() { return getToken(WebParser.JINJA_ENDFOR, 0); }
		public ForEndNodeContext(ForEndContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterForEndNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitForEndNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitForEndNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForEndContext forEnd() throws RecognitionException {
		ForEndContext _localctx = new ForEndContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_forEnd);
		try {
			_localctx = new ForEndNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(JINJA_ENDFOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStartContext extends ParserRuleContext {
		public IfStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStart; }
	 
		public IfStartContext() { }
		public void copyFrom(IfStartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStartNodeContext extends IfStartContext {
		public TerminalNode JINJA_IF() { return getToken(WebParser.JINJA_IF, 0); }
		public List<JinjaBlockExprContext> jinjaBlockExpr() {
			return getRuleContexts(JinjaBlockExprContext.class);
		}
		public JinjaBlockExprContext jinjaBlockExpr(int i) {
			return getRuleContext(JinjaBlockExprContext.class,i);
		}
		public IfStartNodeContext(IfStartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterIfStartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitIfStartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitIfStartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStartContext ifStart() throws RecognitionException {
		IfStartContext _localctx = new IfStartContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ifStart);
		int _la;
		try {
			_localctx = new IfStartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(JINJA_IF);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(291);
				jinjaBlockExpr();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElifPartContext extends ParserRuleContext {
		public ElifPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifPart; }
	 
		public ElifPartContext() { }
		public void copyFrom(ElifPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElifPartNodeContext extends ElifPartContext {
		public TerminalNode JINJA_ELIF() { return getToken(WebParser.JINJA_ELIF, 0); }
		public List<JinjaBlockExprContext> jinjaBlockExpr() {
			return getRuleContexts(JinjaBlockExprContext.class);
		}
		public JinjaBlockExprContext jinjaBlockExpr(int i) {
			return getRuleContext(JinjaBlockExprContext.class,i);
		}
		public ElifPartNodeContext(ElifPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterElifPartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitElifPartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitElifPartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifPartContext elifPart() throws RecognitionException {
		ElifPartContext _localctx = new ElifPartContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_elifPart);
		int _la;
		try {
			_localctx = new ElifPartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(JINJA_ELIF);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(298);
				jinjaBlockExpr();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsePartContext extends ParserRuleContext {
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
	 
		public ElsePartContext() { }
		public void copyFrom(ElsePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElsePartNodeContext extends ElsePartContext {
		public TerminalNode JINJA_ELSE() { return getToken(WebParser.JINJA_ELSE, 0); }
		public ElsePartNodeContext(ElsePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterElsePartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitElsePartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitElsePartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_elsePart);
		try {
			_localctx = new ElsePartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(JINJA_ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndIfPartContext extends ParserRuleContext {
		public EndIfPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endIfPart; }
	 
		public EndIfPartContext() { }
		public void copyFrom(EndIfPartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndIfPartNodeContext extends EndIfPartContext {
		public TerminalNode JINJA_ENDIF() { return getToken(WebParser.JINJA_ENDIF, 0); }
		public EndIfPartNodeContext(EndIfPartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterEndIfPartNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitEndIfPartNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitEndIfPartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndIfPartContext endIfPart() throws RecognitionException {
		EndIfPartContext _localctx = new EndIfPartContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_endIfPart);
		try {
			_localctx = new EndIfPartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(JINJA_ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetStmtContext extends ParserRuleContext {
		public SetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStmt; }
	 
		public SetStmtContext() { }
		public void copyFrom(SetStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetStmtNodeContext extends SetStmtContext {
		public TerminalNode JINJA_SET() { return getToken(WebParser.JINJA_SET, 0); }
		public List<JinjaBlockExprContext> jinjaBlockExpr() {
			return getRuleContexts(JinjaBlockExprContext.class);
		}
		public JinjaBlockExprContext jinjaBlockExpr(int i) {
			return getRuleContext(JinjaBlockExprContext.class,i);
		}
		public SetStmtNodeContext(SetStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSetStmtNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSetStmtNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSetStmtNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetStmtContext setStmt() throws RecognitionException {
		SetStmtContext _localctx = new SetStmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_setStmt);
		int _la;
		try {
			_localctx = new SetStmtNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(JINJA_SET);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(309);
				jinjaBlockExpr();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStmtContext extends ParserRuleContext {
		public SimpleStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStmt; }
	 
		public SimpleStmtContext() { }
		public void copyFrom(SimpleStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStmtNodeContext extends SimpleStmtContext {
		public TerminalNode JINJA_BLOCK_IDENT() { return getToken(WebParser.JINJA_BLOCK_IDENT, 0); }
		public List<JinjaBlockExprContext> jinjaBlockExpr() {
			return getRuleContexts(JinjaBlockExprContext.class);
		}
		public JinjaBlockExprContext jinjaBlockExpr(int i) {
			return getRuleContext(JinjaBlockExprContext.class,i);
		}
		public SimpleStmtNodeContext(SimpleStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSimpleStmtNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSimpleStmtNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSimpleStmtNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStmtContext simpleStmt() throws RecognitionException {
		SimpleStmtContext _localctx = new SimpleStmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_simpleStmt);
		int _la;
		try {
			_localctx = new SimpleStmtNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(JINJA_BLOCK_IDENT);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) {
				{
				{
				setState(316);
				jinjaBlockExpr();
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockExprContext extends ParserRuleContext {
		public JinjaBlockExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlockExpr; }
	 
		public JinjaBlockExprContext() { }
		public void copyFrom(JinjaBlockExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockExprNodeContext extends JinjaBlockExprContext {
		public List<TerminalNode> JINJA_BLOCK_IDENT() { return getTokens(WebParser.JINJA_BLOCK_IDENT); }
		public TerminalNode JINJA_BLOCK_IDENT(int i) {
			return getToken(WebParser.JINJA_BLOCK_IDENT, i);
		}
		public List<TerminalNode> JINJA_BLOCK_NUMBER() { return getTokens(WebParser.JINJA_BLOCK_NUMBER); }
		public TerminalNode JINJA_BLOCK_NUMBER(int i) {
			return getToken(WebParser.JINJA_BLOCK_NUMBER, i);
		}
		public List<TerminalNode> JINJA_BLOCK_STRING() { return getTokens(WebParser.JINJA_BLOCK_STRING); }
		public TerminalNode JINJA_BLOCK_STRING(int i) {
			return getToken(WebParser.JINJA_BLOCK_STRING, i);
		}
		public List<TerminalNode> JINJA_BLOCK_EQ() { return getTokens(WebParser.JINJA_BLOCK_EQ); }
		public TerminalNode JINJA_BLOCK_EQ(int i) {
			return getToken(WebParser.JINJA_BLOCK_EQ, i);
		}
		public List<TerminalNode> JINJA_BLOCK_DOT() { return getTokens(WebParser.JINJA_BLOCK_DOT); }
		public TerminalNode JINJA_BLOCK_DOT(int i) {
			return getToken(WebParser.JINJA_BLOCK_DOT, i);
		}
		public List<TerminalNode> JINJA_BLOCK_COMMA() { return getTokens(WebParser.JINJA_BLOCK_COMMA); }
		public TerminalNode JINJA_BLOCK_COMMA(int i) {
			return getToken(WebParser.JINJA_BLOCK_COMMA, i);
		}
		public List<TerminalNode> JINJA_BLOCK_COLON() { return getTokens(WebParser.JINJA_BLOCK_COLON); }
		public TerminalNode JINJA_BLOCK_COLON(int i) {
			return getToken(WebParser.JINJA_BLOCK_COLON, i);
		}
		public List<TerminalNode> JINJA_BLOCK_LP() { return getTokens(WebParser.JINJA_BLOCK_LP); }
		public TerminalNode JINJA_BLOCK_LP(int i) {
			return getToken(WebParser.JINJA_BLOCK_LP, i);
		}
		public List<TerminalNode> JINJA_BLOCK_RP() { return getTokens(WebParser.JINJA_BLOCK_RP); }
		public TerminalNode JINJA_BLOCK_RP(int i) {
			return getToken(WebParser.JINJA_BLOCK_RP, i);
		}
		public List<TerminalNode> JINJA_BLOCK_LB() { return getTokens(WebParser.JINJA_BLOCK_LB); }
		public TerminalNode JINJA_BLOCK_LB(int i) {
			return getToken(WebParser.JINJA_BLOCK_LB, i);
		}
		public List<TerminalNode> JINJA_BLOCK_RB() { return getTokens(WebParser.JINJA_BLOCK_RB); }
		public TerminalNode JINJA_BLOCK_RB(int i) {
			return getToken(WebParser.JINJA_BLOCK_RB, i);
		}
		public List<TerminalNode> JINJA_BLOCK_OTHER() { return getTokens(WebParser.JINJA_BLOCK_OTHER); }
		public TerminalNode JINJA_BLOCK_OTHER(int i) {
			return getToken(WebParser.JINJA_BLOCK_OTHER, i);
		}
		public List<TerminalNode> JINJA_OP() { return getTokens(WebParser.JINJA_OP); }
		public TerminalNode JINJA_OP(int i) {
			return getToken(WebParser.JINJA_OP, i);
		}
		public JinjaBlockExprNodeContext(JinjaBlockExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterJinjaBlockExprNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitJinjaBlockExprNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitJinjaBlockExprNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockExprContext jinjaBlockExpr() throws RecognitionException {
		JinjaBlockExprContext _localctx = new JinjaBlockExprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jinjaBlockExpr);
		int _la;
		try {
			int _alt;
			_localctx = new JinjaBlockExprNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(323); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(322);
					_la = _input.LA(1);
					if ( !(((((_la - 54)) & ~0x3f) == 0 && ((1L << (_la - 54)) & 3220701185L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(325); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentContext extends ParserRuleContext {
		public JinjaCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaComment; }
	 
		public JinjaCommentContext() { }
		public void copyFrom(JinjaCommentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentNodeContext extends JinjaCommentContext {
		public TerminalNode JINJA_COMMENT_OPEN() { return getToken(WebParser.JINJA_COMMENT_OPEN, 0); }
		public TerminalNode JINJA_COMMENT_CLOSE() { return getToken(WebParser.JINJA_COMMENT_CLOSE, 0); }
		public TerminalNode JINJA_COMMENT_TEXT() { return getToken(WebParser.JINJA_COMMENT_TEXT, 0); }
		public JinjaCommentNodeContext(JinjaCommentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterJinjaCommentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitJinjaCommentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitJinjaCommentNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaCommentContext jinjaComment() throws RecognitionException {
		JinjaCommentContext _localctx = new JinjaCommentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_jinjaComment);
		int _la;
		try {
			_localctx = new JinjaCommentNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(JINJA_COMMENT_OPEN);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==JINJA_COMMENT_TEXT) {
				{
				setState(328);
				match(JINJA_COMMENT_TEXT);
				}
			}

			setState(331);
			match(JINJA_COMMENT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001X\u014e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0001\u0000\u0005\u0000T\b\u0000\n\u0000\f\u0000W\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001a\b\u0001\u0001\u0002\u0001\u0002\u0003"+
		"\u0002e\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003j\b\u0003"+
		"\n\u0003\f\u0003m\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004t\b\u0004\n\u0004\f\u0004w\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004{\b\u0004\n\u0004\f\u0004~\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0088\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u008c\b\u0006\u0001\u0007\u0001\u0007\u0005\u0007\u0090\b\u0007\n\u0007"+
		"\f\u0007\u0093\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b"+
		"\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00a4\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0005\f\u00ad\b\f\n\f\f\f\u00b0\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00ba\b\u000e\n\u000e\f\u000e\u00bd\t\u000e\u0001\u000f\u0001\u000f\u0004"+
		"\u000f\u00c1\b\u000f\u000b\u000f\f\u000f\u00c2\u0001\u000f\u0005\u000f"+
		"\u00c6\b\u000f\n\u000f\f\u000f\u00c9\t\u000f\u0001\u0010\u0004\u0010\u00cc"+
		"\b\u0010\u000b\u0010\f\u0010\u00cd\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00d5\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0005\u0017\u00e9\b\u0017"+
		"\n\u0017\f\u0017\u00ec\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u00f2\b\u0018\u0001\u0019\u0004\u0019\u00f5\b\u0019"+
		"\u000b\u0019\f\u0019\u00f6\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0005\u001c\u0100\b\u001c\n\u001c"+
		"\f\u001c\u0103\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0111\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0005\u001f\u0115\b\u001f\n\u001f\f\u001f\u0118\t\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u011c\b\u001f\n\u001f\f\u001f\u011f\t\u001f\u0001 "+
		"\u0001 \u0001!\u0001!\u0005!\u0125\b!\n!\f!\u0128\t!\u0001\"\u0001\"\u0005"+
		"\"\u012c\b\"\n\"\f\"\u012f\t\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0005%\u0137\b%\n%\f%\u013a\t%\u0001&\u0001&\u0005&\u013e\b&\n&\f&\u0141"+
		"\t&\u0001\'\u0004\'\u0144\b\'\u000b\'\f\'\u0145\u0001(\u0001(\u0003(\u014a"+
		"\b(\u0001(\u0001(\u0001(\u0000\u0000)\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNP\u0000\u0004\u0002\u0000%%((\u0004\u0000\u001e\u001e !##%)\u0002"+
		"\u00003=??\u0003\u000066ISUU\u0151\u0000U\u0001\u0000\u0000\u0000\u0002"+
		"`\u0001\u0000\u0000\u0000\u0004d\u0001\u0000\u0000\u0000\u0006f\u0001"+
		"\u0000\u0000\u0000\bp\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000\u0000"+
		"\u0000\f\u008b\u0001\u0000\u0000\u0000\u000e\u008d\u0001\u0000\u0000\u0000"+
		"\u0010\u0096\u0001\u0000\u0000\u0000\u0012\u00a3\u0001\u0000\u0000\u0000"+
		"\u0014\u00a5\u0001\u0000\u0000\u0000\u0016\u00a7\u0001\u0000\u0000\u0000"+
		"\u0018\u00ae\u0001\u0000\u0000\u0000\u001a\u00b1\u0001\u0000\u0000\u0000"+
		"\u001c\u00b6\u0001\u0000\u0000\u0000\u001e\u00be\u0001\u0000\u0000\u0000"+
		" \u00cb\u0001\u0000\u0000\u0000\"\u00d4\u0001\u0000\u0000\u0000$\u00d6"+
		"\u0001\u0000\u0000\u0000&\u00d8\u0001\u0000\u0000\u0000(\u00db\u0001\u0000"+
		"\u0000\u0000*\u00de\u0001\u0000\u0000\u0000,\u00e1\u0001\u0000\u0000\u0000"+
		".\u00ea\u0001\u0000\u0000\u00000\u00ed\u0001\u0000\u0000\u00002\u00f4"+
		"\u0001\u0000\u0000\u00004\u00f8\u0001\u0000\u0000\u00006\u00fa\u0001\u0000"+
		"\u0000\u00008\u0101\u0001\u0000\u0000\u0000:\u0104\u0001\u0000\u0000\u0000"+
		"<\u0110\u0001\u0000\u0000\u0000>\u0112\u0001\u0000\u0000\u0000@\u0120"+
		"\u0001\u0000\u0000\u0000B\u0122\u0001\u0000\u0000\u0000D\u0129\u0001\u0000"+
		"\u0000\u0000F\u0130\u0001\u0000\u0000\u0000H\u0132\u0001\u0000\u0000\u0000"+
		"J\u0134\u0001\u0000\u0000\u0000L\u013b\u0001\u0000\u0000\u0000N\u0143"+
		"\u0001\u0000\u0000\u0000P\u0147\u0001\u0000\u0000\u0000RT\u0003\u0002"+
		"\u0001\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000XY\u0005\u0000\u0000\u0001Y\u0001\u0001\u0000"+
		"\u0000\u0000Za\u0003\u0016\u000b\u0000[a\u0003\u0004\u0002\u0000\\a\u0003"+
		"\u0014\n\u0000]a\u00036\u001b\u0000^a\u0003:\u001d\u0000_a\u0003P(\u0000"+
		"`Z\u0001\u0000\u0000\u0000`[\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000"+
		"\u0000`]\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000"+
		"\u0000\u0000a\u0003\u0001\u0000\u0000\u0000be\u0003\u0006\u0003\u0000"+
		"ce\u0003\b\u0004\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"e\u0005\u0001\u0000\u0000\u0000fg\u0005\b\u0000\u0000gk\u0005\u000b\u0000"+
		"\u0000hj\u0003\n\u0005\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005\u0010\u0000\u0000o\u0007"+
		"\u0001\u0000\u0000\u0000pq\u0005\b\u0000\u0000qu\u0005\u000b\u0000\u0000"+
		"rt\u0003\n\u0005\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000x|\u0005\u0011\u0000\u0000y{\u0003\u0002"+
		"\u0001\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0007\u0000\u0000\u0080"+
		"\u0081\u0005\u000b\u0000\u0000\u0081\u0082\u0005\u0011\u0000\u0000\u0082"+
		"\t\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u000b\u0000\u0000\u0084\u0085"+
		"\u0005\f\u0000\u0000\u0085\u0088\u0003\f\u0006\u0000\u0086\u0088\u0005"+
		"\u000b\u0000\u0000\u0087\u0083\u0001\u0000\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u000b\u0001\u0000\u0000\u0000\u0089\u008c\u0003"+
		"\u000e\u0007\u0000\u008a\u008c\u0003\u0010\b\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\r\u0001\u0000\u0000"+
		"\u0000\u008d\u0091\u0005\u000e\u0000\u0000\u008e\u0090\u0003\u0012\t\u0000"+
		"\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0005.\u0000\u0000\u0095\u000f\u0001\u0000\u0000\u0000\u0096"+
		"\u009a\u0005\u000f\u0000\u0000\u0097\u0099\u0003\u0012\t\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005/\u0000\u0000\u009e\u0011\u0001\u0000\u0000\u0000\u009f\u00a4\u0005"+
		"0\u0000\u0000\u00a0\u00a4\u00036\u001b\u0000\u00a1\u00a4\u0003:\u001d"+
		"\u0000\u00a2\u00a4\u0003P(\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a4\u0013\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005\t\u0000\u0000\u00a6\u0015\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0006\u0000\u0000\u00a8\u00a9\u0003\u0018\f\u0000\u00a9\u00aa\u0005"+
		"\u0016\u0000\u0000\u00aa\u0017\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003"+
		"\u001a\r\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u0019\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0003\u001c\u000e\u0000\u00b2\u00b3\u0005\u0018"+
		"\u0000\u0000\u00b3\u00b4\u0003.\u0017\u0000\u00b4\u00b5\u0005\u0019\u0000"+
		"\u0000\u00b5\u001b\u0001\u0000\u0000\u0000\u00b6\u00bb\u0003\u001e\u000f"+
		"\u0000\u00b7\u00b8\u0005\u001e\u0000\u0000\u00b8\u00ba\u0003\u001e\u000f"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u001d\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000"+
		"\u0000\u00be\u00c7\u0003 \u0010\u0000\u00bf\u00c1\u0005\u0017\u0000\u0000"+
		"\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6\u0003 \u0010\u0000\u00c5"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"\u001f\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cc\u0003\"\u0011\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce!\u0001\u0000\u0000\u0000\u00cf\u00d5\u0003"+
		"$\u0012\u0000\u00d0\u00d5\u0003&\u0013\u0000\u00d1\u00d5\u0003(\u0014"+
		"\u0000\u00d2\u00d5\u0003*\u0015\u0000\u00d3\u00d5\u0003,\u0016\u0000\u00d4"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5#\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0005%\u0000\u0000\u00d7%\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\""+
		"\u0000\u0000\u00d9\u00da\u0005%\u0000\u0000\u00da\'\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0005$\u0000\u0000\u00dc\u00dd\u0005%\u0000\u0000\u00dd"+
		")\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u001c\u0000\u0000\u00df\u00e0"+
		"\u0005%\u0000\u0000\u00e0+\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u001a"+
		"\u0000\u0000\u00e2\u00e3\u0005%\u0000\u0000\u00e3\u00e4\u0005\u001f\u0000"+
		"\u0000\u00e4\u00e5\u0007\u0000\u0000\u0000\u00e5\u00e6\u0005\u001b\u0000"+
		"\u0000\u00e6-\u0001\u0000\u0000\u0000\u00e7\u00e9\u00030\u0018\u0000\u00e8"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb"+
		"/\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0005%\u0000\u0000\u00ee\u00ef\u0005\u001c\u0000\u0000\u00ef\u00f1\u0003"+
		"2\u0019\u0000\u00f0\u00f2\u0005\u001d\u0000\u0000\u00f1\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f21\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f5\u00034\u001a\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f73\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0007\u0001\u0000\u0000\u00f95\u0001\u0000\u0000\u0000\u00fa\u00fb"+
		"\u0005\u0001\u0000\u0000\u00fb\u00fc\u00038\u001c\u0000\u00fc\u00fd\u0005"+
		"2\u0000\u0000\u00fd7\u0001\u0000\u0000\u0000\u00fe\u0100\u0007\u0002\u0000"+
		"\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u01029\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005\u0002\u0000\u0000\u0105\u0106\u0003<\u001e\u0000\u0106"+
		"\u0107\u0005@\u0000\u0000\u0107;\u0001\u0000\u0000\u0000\u0108\u0111\u0003"+
		">\u001f\u0000\u0109\u0111\u0003@ \u0000\u010a\u0111\u0003B!\u0000\u010b"+
		"\u0111\u0003D\"\u0000\u010c\u0111\u0003F#\u0000\u010d\u0111\u0003H$\u0000"+
		"\u010e\u0111\u0003J%\u0000\u010f\u0111\u0003L&\u0000\u0110\u0108\u0001"+
		"\u0000\u0000\u0000\u0110\u0109\u0001\u0000\u0000\u0000\u0110\u010a\u0001"+
		"\u0000\u0000\u0000\u0110\u010b\u0001\u0000\u0000\u0000\u0110\u010c\u0001"+
		"\u0000\u0000\u0000\u0110\u010d\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111=\u0001\u0000"+
		"\u0000\u0000\u0112\u0116\u0005A\u0000\u0000\u0113\u0115\u0003N\'\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000"+
		"\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0119\u011d\u0005B\u0000\u0000\u011a\u011c\u0003N\'\u0000\u011b\u011a"+
		"\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b"+
		"\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e?\u0001"+
		"\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0005"+
		"C\u0000\u0000\u0121A\u0001\u0000\u0000\u0000\u0122\u0126\u0005D\u0000"+
		"\u0000\u0123\u0125\u0003N\'\u0000\u0124\u0123\u0001\u0000\u0000\u0000"+
		"\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u0126\u0127\u0001\u0000\u0000\u0000\u0127C\u0001\u0000\u0000\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0129\u012d\u0005E\u0000\u0000\u012a\u012c"+
		"\u0003N\'\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012eE\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0005F\u0000\u0000\u0131G\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0005G\u0000\u0000\u0133I\u0001\u0000\u0000\u0000\u0134\u0138"+
		"\u0005H\u0000\u0000\u0135\u0137\u0003N\'\u0000\u0136\u0135\u0001\u0000"+
		"\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139K\u0001\u0000\u0000"+
		"\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013f\u0005I\u0000\u0000"+
		"\u013c\u013e\u0003N\'\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e"+
		"\u0141\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f"+
		"\u0140\u0001\u0000\u0000\u0000\u0140M\u0001\u0000\u0000\u0000\u0141\u013f"+
		"\u0001\u0000\u0000\u0000\u0142\u0144\u0007\u0003\u0000\u0000\u0143\u0142"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0143"+
		"\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146O\u0001"+
		"\u0000\u0000\u0000\u0147\u0149\u0005\u0003\u0000\u0000\u0148\u014a\u0005"+
		"W\u0000\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000"+
		"\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0005V\u0000"+
		"\u0000\u014cQ\u0001\u0000\u0000\u0000\u001eU`dku|\u0087\u008b\u0091\u009a"+
		"\u00a3\u00ae\u00bb\u00c2\u00c7\u00cd\u00d4\u00ea\u00f1\u00f6\u0101\u0110"+
		"\u0116\u011d\u0126\u012d\u0138\u013f\u0145\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}