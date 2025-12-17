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
		CSS_STYLE_CLOSE=22, CSS_WS=23, CSS_BRACE_OPEN=24, CSS_BLOCK_END=25, CSS_COLON=26, 
		CSS_SEMICOLON=27, CSS_IMPORTANT=28, CSS_CLASS=29, CSS_ID=30, CSS_PSEUDO=31, 
		CSS_SELECTOR=32, CSS_PROPERTY=33, CSS_VALUE=34, CSS_BLOCK_OTHER=35, JINJA_EXPR_OPEN_IN_ATTR=36, 
		JINJA_BLOCK_OPEN_IN_ATTR=37, JINJA_COMMENT_OPEN_IN_ATTR=38, HTML_ATTR_VALUE_CLOSE_DQ=39, 
		HTML_ATTR_VALUE_CLOSE_SQ=40, HTML_ATTR_VALUE_TEXT=41, HTML_ATTR_VALUE_WS=42, 
		JINJA_EXPR_CLOSE=43, JINJA_IDENT=44, JINJA_NUMBER=45, JINJA_STRING=46, 
		JINJA_OP=47, JINJA_DOT=48, JINJA_COMMA=49, JINJA_COLON=50, JINJA_LP=51, 
		JINJA_RP=52, JINJA_LB=53, JINJA_RB=54, JINJA_WS=55, JINJA_OTHER=56, JINJA_BLOCK_CLOSE=57, 
		JINJA_FOR=58, JINJA_IN=59, JINJA_ENDFOR=60, JINJA_IF=61, JINJA_ELIF=62, 
		JINJA_ELSE=63, JINJA_ENDIF=64, JINJA_SET=65, JINJA_BLOCK_IDENT=66, JINJA_BLOCK_NUMBER=67, 
		JINJA_BLOCK_STRING=68, JINJA_BLOCK_EQ=69, JINJA_BLOCK_DOT=70, JINJA_BLOCK_COMMA=71, 
		JINJA_BLOCK_COLON=72, JINJA_BLOCK_LP=73, JINJA_BLOCK_RP=74, JINJA_BLOCK_LB=75, 
		JINJA_BLOCK_RB=76, JINJA_BLOCK_WS=77, JINJA_BLOCK_OTHER=78, JINJA_COMMENT_CLOSE=79, 
		JINJA_COMMENT_TEXT=80, JINJA_COMMENT_WS=81;
	public static final int
		RULE_template = 0, RULE_contentItem = 1, RULE_htmlElement = 2, RULE_htmlVoidElement = 3, 
		RULE_htmlNormalElement = 4, RULE_htmlAttribute = 5, RULE_htmlAttributeValue = 6, 
		RULE_dqValue = 7, RULE_sqValue = 8, RULE_htmlAttrValueItem = 9, RULE_htmlText = 10, 
		RULE_cssStyleBlock = 11, RULE_cssBody = 12, RULE_cssRule = 13, RULE_cssSelector = 14, 
		RULE_cssDeclarations = 15, RULE_cssDeclaration = 16, RULE_jinjaExpression = 17, 
		RULE_jinjaExprBody = 18, RULE_jinjaBlock = 19, RULE_jinjaBlockInner = 20, 
		RULE_forStart = 21, RULE_forEnd = 22, RULE_ifStart = 23, RULE_elifPart = 24, 
		RULE_elsePart = 25, RULE_endIfPart = 26, RULE_setStmt = 27, RULE_simpleStmt = 28, 
		RULE_jinjaBlockExpr = 29, RULE_jinjaComment = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"template", "contentItem", "htmlElement", "htmlVoidElement", "htmlNormalElement", 
			"htmlAttribute", "htmlAttributeValue", "dqValue", "sqValue", "htmlAttrValueItem", 
			"htmlText", "cssStyleBlock", "cssBody", "cssRule", "cssSelector", "cssDeclarations", 
			"cssDeclaration", "jinjaExpression", "jinjaExprBody", "jinjaBlock", "jinjaBlockInner", 
			"forStart", "forEnd", "ifStart", "elifPart", "elsePart", "endIfPart", 
			"setStmt", "simpleStmt", "jinjaBlockExpr", "jinjaComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'<!--'", null, null, "'</'", "'<'", null, null, 
			null, null, null, null, null, "'/>'", "'>'", null, "'-->'", null, null, 
			null, null, "'{'", "'}'", null, "';'", "'!important'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'}}'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'%}'", "'for'", "'in'", "'endfor'", "'if'", "'elif'", "'else'", 
			"'endif'", "'set'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'#}'"
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
			"CSS_WS", "CSS_BRACE_OPEN", "CSS_BLOCK_END", "CSS_COLON", "CSS_SEMICOLON", 
			"CSS_IMPORTANT", "CSS_CLASS", "CSS_ID", "CSS_PSEUDO", "CSS_SELECTOR", 
			"CSS_PROPERTY", "CSS_VALUE", "CSS_BLOCK_OTHER", "JINJA_EXPR_OPEN_IN_ATTR", 
			"JINJA_BLOCK_OPEN_IN_ATTR", "JINJA_COMMENT_OPEN_IN_ATTR", "HTML_ATTR_VALUE_CLOSE_DQ", 
			"HTML_ATTR_VALUE_CLOSE_SQ", "HTML_ATTR_VALUE_TEXT", "HTML_ATTR_VALUE_WS", 
			"JINJA_EXPR_CLOSE", "JINJA_IDENT", "JINJA_NUMBER", "JINJA_STRING", "JINJA_OP", 
			"JINJA_DOT", "JINJA_COMMA", "JINJA_COLON", "JINJA_LP", "JINJA_RP", "JINJA_LB", 
			"JINJA_RB", "JINJA_WS", "JINJA_OTHER", "JINJA_BLOCK_CLOSE", "JINJA_FOR", 
			"JINJA_IN", "JINJA_ENDFOR", "JINJA_IF", "JINJA_ELIF", "JINJA_ELSE", "JINJA_ENDIF", 
			"JINJA_SET", "JINJA_BLOCK_IDENT", "JINJA_BLOCK_NUMBER", "JINJA_BLOCK_STRING", 
			"JINJA_BLOCK_EQ", "JINJA_BLOCK_DOT", "JINJA_BLOCK_COMMA", "JINJA_BLOCK_COLON", 
			"JINJA_BLOCK_LP", "JINJA_BLOCK_RP", "JINJA_BLOCK_LB", "JINJA_BLOCK_RB", 
			"JINJA_BLOCK_WS", "JINJA_BLOCK_OTHER", "JINJA_COMMENT_CLOSE", "JINJA_COMMENT_TEXT", 
			"JINJA_COMMENT_WS"
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846L) != 0)) {
				{
				{
				setState(62);
				contentItem();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_STYLE_TAG:
				_localctx = new ContentCssStyleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				cssStyleBlock();
				}
				break;
			case HTML_OPEN:
				_localctx = new ContentHtmlElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				htmlElement();
				}
				break;
			case TEXT:
				_localctx = new ContentHtmlTextContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				htmlText();
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new ContentJinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				jinjaExpression();
				}
				break;
			case JINJA_BLOCK_OPEN:
				_localctx = new ContentJinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				jinjaBlock();
				}
				break;
			case JINJA_COMMENT_OPEN:
				_localctx = new ContentJinjaCommentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
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
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new HtmlElementVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				htmlVoidElement();
				}
				break;
			case 2:
				_localctx = new HtmlElementNormalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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
			setState(82);
			match(HTML_OPEN);
			setState(83);
			match(HTML_IDENTIFIER);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HTML_IDENTIFIER) {
				{
				{
				setState(84);
				htmlAttribute();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
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
			setState(92);
			match(HTML_OPEN);
			setState(93);
			match(HTML_IDENTIFIER);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HTML_IDENTIFIER) {
				{
				{
				setState(94);
				htmlAttribute();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(HTML_TAG_CLOSE);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 846L) != 0)) {
				{
				{
				setState(101);
				contentItem();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(HTML_CLOSE_OPEN);
			setState(108);
			match(HTML_IDENTIFIER);
			setState(109);
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new HtmlAttributeAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(HTML_IDENTIFIER);
				setState(112);
				match(EQUALS);
				setState(113);
				htmlAttributeValue();
				}
				break;
			case 2:
				_localctx = new HtmlAttributeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
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
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_ATTR_VALUE_OPEN_DQ:
				_localctx = new AttrDoubleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				dqValue();
				}
				break;
			case HTML_ATTR_VALUE_OPEN_SQ:
				_localctx = new AttrSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
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
			setState(121);
			match(HTML_ATTR_VALUE_OPEN_DQ);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023255566L) != 0)) {
				{
				{
				setState(122);
				htmlAttrValueItem();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
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
			setState(130);
			match(HTML_ATTR_VALUE_OPEN_SQ);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023255566L) != 0)) {
				{
				{
				setState(131);
				htmlAttrValueItem();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
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
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_ATTR_VALUE_TEXT:
				_localctx = new AttrTextNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(HTML_ATTR_VALUE_TEXT);
				}
				break;
			case JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaExpressionNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				jinjaExpression();
				}
				break;
			case JINJA_BLOCK_OPEN:
				_localctx = new AttrJinjaBlockNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				jinjaBlock();
				}
				break;
			case JINJA_COMMENT_OPEN:
				_localctx = new AttrJinjaCommentNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
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
			setState(145);
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
		public CssBodyContext cssBody() {
			return getRuleContext(CssBodyContext.class,0);
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
			setState(147);
			match(CSS_STYLE_TAG);
			setState(148);
			cssBody();
			setState(149);
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
	public static class CssBodyContext extends ParserRuleContext {
		public CssBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssBody; }
	 
		public CssBodyContext() { }
		public void copyFrom(CssBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssBodyNodeContext extends CssBodyContext {
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public List<TerminalNode> CSS_BLOCK_OTHER() { return getTokens(WebParser.CSS_BLOCK_OTHER); }
		public TerminalNode CSS_BLOCK_OTHER(int i) {
			return getToken(WebParser.CSS_BLOCK_OTHER, i);
		}
		public CssBodyNodeContext(CssBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterCssBodyNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitCssBodyNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitCssBodyNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssBodyContext cssBody() throws RecognitionException {
		CssBodyContext _localctx = new CssBodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssBody);
		int _la;
		try {
			_localctx = new CssBodyNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 42412802048L) != 0)) {
				{
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CSS_CLASS:
				case CSS_ID:
				case CSS_PSEUDO:
				case CSS_SELECTOR:
					{
					setState(151);
					cssRule();
					}
					break;
				case CSS_BLOCK_OTHER:
					{
					setState(152);
					match(CSS_BLOCK_OTHER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(157);
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
		public CssSelectorContext cssSelector() {
			return getRuleContext(CssSelectorContext.class,0);
		}
		public TerminalNode CSS_BRACE_OPEN() { return getToken(WebParser.CSS_BRACE_OPEN, 0); }
		public CssDeclarationsContext cssDeclarations() {
			return getRuleContext(CssDeclarationsContext.class,0);
		}
		public TerminalNode CSS_BLOCK_END() { return getToken(WebParser.CSS_BLOCK_END, 0); }
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
			setState(158);
			cssSelector();
			setState(159);
			match(CSS_BRACE_OPEN);
			setState(160);
			cssDeclarations();
			setState(161);
			match(CSS_BLOCK_END);
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
	public static class SelectorSimpleNodeContext extends CssSelectorContext {
		public TerminalNode CSS_SELECTOR() { return getToken(WebParser.CSS_SELECTOR, 0); }
		public SelectorSimpleNodeContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSelectorSimpleNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSelectorSimpleNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSelectorSimpleNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorPseudoNodeContext extends CssSelectorContext {
		public TerminalNode CSS_PSEUDO() { return getToken(WebParser.CSS_PSEUDO, 0); }
		public SelectorPseudoNodeContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSelectorPseudoNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSelectorPseudoNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSelectorPseudoNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorIdNodeContext extends CssSelectorContext {
		public TerminalNode CSS_ID() { return getToken(WebParser.CSS_ID, 0); }
		public SelectorIdNodeContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSelectorIdNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSelectorIdNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSelectorIdNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectorClassNodeContext extends CssSelectorContext {
		public TerminalNode CSS_CLASS() { return getToken(WebParser.CSS_CLASS, 0); }
		public SelectorClassNodeContext(CssSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).enterSelectorClassNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WebParserListener ) ((WebParserListener)listener).exitSelectorClassNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WebParserVisitor ) return ((WebParserVisitor<? extends T>)visitor).visitSelectorClassNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cssSelector);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_SELECTOR:
				_localctx = new SelectorSimpleNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(CSS_SELECTOR);
				}
				break;
			case CSS_CLASS:
				_localctx = new SelectorClassNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(CSS_CLASS);
				}
				break;
			case CSS_ID:
				_localctx = new SelectorIdNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(CSS_ID);
				}
				break;
			case CSS_PSEUDO:
				_localctx = new SelectorPseudoNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(CSS_PSEUDO);
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
		enterRule(_localctx, 30, RULE_cssDeclarations);
		int _la;
		try {
			_localctx = new CssDeclarationsNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_PROPERTY) {
				{
				{
				setState(169);
				cssDeclaration();
				}
				}
				setState(174);
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
		public TerminalNode CSS_PROPERTY() { return getToken(WebParser.CSS_PROPERTY, 0); }
		public TerminalNode CSS_COLON() { return getToken(WebParser.CSS_COLON, 0); }
		public TerminalNode CSS_VALUE() { return getToken(WebParser.CSS_VALUE, 0); }
		public TerminalNode CSS_SEMICOLON() { return getToken(WebParser.CSS_SEMICOLON, 0); }
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
		enterRule(_localctx, 32, RULE_cssDeclaration);
		int _la;
		try {
			_localctx = new CssDeclarationNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(CSS_PROPERTY);
			setState(176);
			match(CSS_COLON);
			setState(177);
			match(CSS_VALUE);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_SEMICOLON) {
				{
				setState(178);
				match(CSS_SEMICOLON);
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
		enterRule(_localctx, 34, RULE_jinjaExpression);
		try {
			_localctx = new JinjaExpressionNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(JINJA_EXPR_OPEN);
			setState(182);
			jinjaExprBody();
			setState(183);
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
		enterRule(_localctx, 36, RULE_jinjaExprBody);
		int _la;
		try {
			_localctx = new JinjaExprBodyNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 108068798870847488L) != 0)) {
				{
				{
				setState(185);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 108068798870847488L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(190);
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
		enterRule(_localctx, 38, RULE_jinjaBlock);
		try {
			_localctx = new JinjaBlockNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(JINJA_BLOCK_OPEN);
			setState(192);
			jinjaBlockInner();
			setState(193);
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
		enterRule(_localctx, 40, RULE_jinjaBlockInner);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_FOR:
				_localctx = new BlockForStartNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				forStart();
				}
				break;
			case JINJA_ENDFOR:
				_localctx = new BlockForEndNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				forEnd();
				}
				break;
			case JINJA_IF:
				_localctx = new BlockIfStartNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				ifStart();
				}
				break;
			case JINJA_ELIF:
				_localctx = new BlockElifNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				elifPart();
				}
				break;
			case JINJA_ELSE:
				_localctx = new BlockElseNodeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				elsePart();
				}
				break;
			case JINJA_ENDIF:
				_localctx = new BlockEndIfNodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				endIfPart();
				}
				break;
			case JINJA_SET:
				_localctx = new BlockSetNodeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(201);
				setStmt();
				}
				break;
			case JINJA_BLOCK_IDENT:
				_localctx = new BlockSimpleNodeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(202);
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
		enterRule(_localctx, 42, RULE_forStart);
		int _la;
		try {
			_localctx = new ForStartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(JINJA_FOR);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(206);
				jinjaBlockExpr();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			match(JINJA_IN);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(213);
				jinjaBlockExpr();
				}
				}
				setState(218);
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
		enterRule(_localctx, 44, RULE_forEnd);
		try {
			_localctx = new ForEndNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
		enterRule(_localctx, 46, RULE_ifStart);
		int _la;
		try {
			_localctx = new IfStartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(JINJA_IF);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(222);
				jinjaBlockExpr();
				}
				}
				setState(227);
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
		enterRule(_localctx, 48, RULE_elifPart);
		int _la;
		try {
			_localctx = new ElifPartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(JINJA_ELIF);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(229);
				jinjaBlockExpr();
				}
				}
				setState(234);
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
		enterRule(_localctx, 50, RULE_elsePart);
		try {
			_localctx = new ElsePartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		enterRule(_localctx, 52, RULE_endIfPart);
		try {
			_localctx = new EndIfPartNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
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
		enterRule(_localctx, 54, RULE_setStmt);
		int _la;
		try {
			_localctx = new SetStmtNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(JINJA_SET);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(240);
				jinjaBlockExpr();
				}
				}
				setState(245);
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
		enterRule(_localctx, 56, RULE_simpleStmt);
		int _la;
		try {
			_localctx = new SimpleStmtNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(JINJA_BLOCK_IDENT);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) {
				{
				{
				setState(247);
				jinjaBlockExpr();
				}
				}
				setState(252);
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
		enterRule(_localctx, 58, RULE_jinjaBlockExpr);
		int _la;
		try {
			int _alt;
			_localctx = new JinjaBlockExprNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(254); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(253);
					_la = _input.LA(1);
					if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 3220701185L) != 0)) ) {
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
				setState(256); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 60, RULE_jinjaComment);
		int _la;
		try {
			_localctx = new JinjaCommentNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(JINJA_COMMENT_OPEN);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==JINJA_COMMENT_TEXT) {
				{
				setState(259);
				match(JINJA_COMMENT_TEXT);
				}
			}

			setState(262);
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
		"\u0004\u0001Q\u0109\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0005\u0000@\b\u0000\n\u0000\f\u0000C\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001M\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"Q\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003V\b\u0003\n\u0003"+
		"\f\u0003Y\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004`\b\u0004\n\u0004\f\u0004c\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004g\b\u0004\n\u0004\f\u0004j\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005t\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006x\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007|\b\u0007\n\u0007\f\u0007\u007f\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u0085\b\b\n\b\f"+
		"\b\u0088\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0090"+
		"\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0005\f\u009a\b\f\n\f\f\f\u009d\t\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00a8\b\u000e\u0001\u000f\u0005\u000f\u00ab\b\u000f\n\u000f\f\u000f"+
		"\u00ae\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00b4\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0005\u0012\u00bb\b\u0012\n\u0012\f\u0012\u00be\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00cc"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00d0\b\u0015\n\u0015\f\u0015"+
		"\u00d3\t\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00d7\b\u0015\n\u0015"+
		"\f\u0015\u00da\t\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u00e0\b\u0017\n\u0017\f\u0017\u00e3\t\u0017\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u00e7\b\u0018\n\u0018\f\u0018\u00ea\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u00f2\b\u001b\n\u001b\f\u001b\u00f5\t\u001b\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u00f9\b\u001c\n\u001c\f\u001c\u00fc\t\u001c\u0001\u001d\u0004\u001d"+
		"\u00ff\b\u001d\u000b\u001d\f\u001d\u0100\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0105\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0000\u0000\u001f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<\u0000\u0002\u0002\u0000,688\u0003\u0000/"+
		"/BLNN\u0111\u0000A\u0001\u0000\u0000\u0000\u0002L\u0001\u0000\u0000\u0000"+
		"\u0004P\u0001\u0000\u0000\u0000\u0006R\u0001\u0000\u0000\u0000\b\\\u0001"+
		"\u0000\u0000\u0000\ns\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000"+
		"\u000ey\u0001\u0000\u0000\u0000\u0010\u0082\u0001\u0000\u0000\u0000\u0012"+
		"\u008f\u0001\u0000\u0000\u0000\u0014\u0091\u0001\u0000\u0000\u0000\u0016"+
		"\u0093\u0001\u0000\u0000\u0000\u0018\u009b\u0001\u0000\u0000\u0000\u001a"+
		"\u009e\u0001\u0000\u0000\u0000\u001c\u00a7\u0001\u0000\u0000\u0000\u001e"+
		"\u00ac\u0001\u0000\u0000\u0000 \u00af\u0001\u0000\u0000\u0000\"\u00b5"+
		"\u0001\u0000\u0000\u0000$\u00bc\u0001\u0000\u0000\u0000&\u00bf\u0001\u0000"+
		"\u0000\u0000(\u00cb\u0001\u0000\u0000\u0000*\u00cd\u0001\u0000\u0000\u0000"+
		",\u00db\u0001\u0000\u0000\u0000.\u00dd\u0001\u0000\u0000\u00000\u00e4"+
		"\u0001\u0000\u0000\u00002\u00eb\u0001\u0000\u0000\u00004\u00ed\u0001\u0000"+
		"\u0000\u00006\u00ef\u0001\u0000\u0000\u00008\u00f6\u0001\u0000\u0000\u0000"+
		":\u00fe\u0001\u0000\u0000\u0000<\u0102\u0001\u0000\u0000\u0000>@\u0003"+
		"\u0002\u0001\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u0000\u0000\u0001E\u0001\u0001"+
		"\u0000\u0000\u0000FM\u0003\u0016\u000b\u0000GM\u0003\u0004\u0002\u0000"+
		"HM\u0003\u0014\n\u0000IM\u0003\"\u0011\u0000JM\u0003&\u0013\u0000KM\u0003"+
		"<\u001e\u0000LF\u0001\u0000\u0000\u0000LG\u0001\u0000\u0000\u0000LH\u0001"+
		"\u0000\u0000\u0000LI\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000M\u0003\u0001\u0000\u0000\u0000NQ\u0003\u0006"+
		"\u0003\u0000OQ\u0003\b\u0004\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000"+
		"\u0000\u0000Q\u0005\u0001\u0000\u0000\u0000RS\u0005\b\u0000\u0000SW\u0005"+
		"\u000b\u0000\u0000TV\u0003\n\u0005\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\u0010\u0000"+
		"\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0005\b\u0000\u0000]a\u0005\u000b"+
		"\u0000\u0000^`\u0003\n\u0005\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000dh\u0005\u0011\u0000\u0000"+
		"eg\u0003\u0002\u0001\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\u0007\u0000\u0000lm\u0005"+
		"\u000b\u0000\u0000mn\u0005\u0011\u0000\u0000n\t\u0001\u0000\u0000\u0000"+
		"op\u0005\u000b\u0000\u0000pq\u0005\f\u0000\u0000qt\u0003\f\u0006\u0000"+
		"rt\u0005\u000b\u0000\u0000so\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000t\u000b\u0001\u0000\u0000\u0000ux\u0003\u000e\u0007\u0000vx\u0003"+
		"\u0010\b\u0000wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\r"+
		"\u0001\u0000\u0000\u0000y}\u0005\u000e\u0000\u0000z|\u0003\u0012\t\u0000"+
		"{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\'\u0000\u0000\u0081"+
		"\u000f\u0001\u0000\u0000\u0000\u0082\u0086\u0005\u000f\u0000\u0000\u0083"+
		"\u0085\u0003\u0012\t\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005(\u0000\u0000\u008a\u0011\u0001"+
		"\u0000\u0000\u0000\u008b\u0090\u0005)\u0000\u0000\u008c\u0090\u0003\""+
		"\u0011\u0000\u008d\u0090\u0003&\u0013\u0000\u008e\u0090\u0003<\u001e\u0000"+
		"\u008f\u008b\u0001\u0000\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0013\u0001\u0000\u0000\u0000\u0091\u0092\u0005\t\u0000\u0000\u0092"+
		"\u0015\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0006\u0000\u0000\u0094"+
		"\u0095\u0003\u0018\f\u0000\u0095\u0096\u0005\u0016\u0000\u0000\u0096\u0017"+
		"\u0001\u0000\u0000\u0000\u0097\u009a\u0003\u001a\r\u0000\u0098\u009a\u0005"+
		"#\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0019\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f\u0003\u001c"+
		"\u000e\u0000\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0\u00a1\u0003\u001e"+
		"\u000f\u0000\u00a1\u00a2\u0005\u0019\u0000\u0000\u00a2\u001b\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a8\u0005 \u0000\u0000\u00a4\u00a8\u0005\u001d\u0000"+
		"\u0000\u00a5\u00a8\u0005\u001e\u0000\u0000\u00a6\u00a8\u0005\u001f\u0000"+
		"\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a7\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003 \u0010\u0000"+
		"\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ad\u001f\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0005!\u0000\u0000\u00b0\u00b1\u0005\u001a\u0000\u0000\u00b1"+
		"\u00b3\u0005\"\u0000\u0000\u00b2\u00b4\u0005\u001b\u0000\u0000\u00b3\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4!\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0005\u0001\u0000\u0000\u00b6\u00b7\u0003"+
		"$\u0012\u0000\u00b7\u00b8\u0005+\u0000\u0000\u00b8#\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0007\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd%\u0001\u0000\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0002\u0000\u0000"+
		"\u00c0\u00c1\u0003(\u0014\u0000\u00c1\u00c2\u00059\u0000\u0000\u00c2\'"+
		"\u0001\u0000\u0000\u0000\u00c3\u00cc\u0003*\u0015\u0000\u00c4\u00cc\u0003"+
		",\u0016\u0000\u00c5\u00cc\u0003.\u0017\u0000\u00c6\u00cc\u00030\u0018"+
		"\u0000\u00c7\u00cc\u00032\u0019\u0000\u00c8\u00cc\u00034\u001a\u0000\u00c9"+
		"\u00cc\u00036\u001b\u0000\u00ca\u00cc\u00038\u001c\u0000\u00cb\u00c3\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c4\u0001\u0000\u0000\u0000\u00cb\u00c5\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c6\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c8\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc)\u0001\u0000"+
		"\u0000\u0000\u00cd\u00d1\u0005:\u0000\u0000\u00ce\u00d0\u0003:\u001d\u0000"+
		"\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d8\u0005;\u0000\u0000\u00d5\u00d7\u0003:\u001d\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9+\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005"+
		"<\u0000\u0000\u00dc-\u0001\u0000\u0000\u0000\u00dd\u00e1\u0005=\u0000"+
		"\u0000\u00de\u00e0\u0003:\u001d\u0000\u00df\u00de\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2/\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e8\u0005>\u0000\u0000\u00e5\u00e7"+
		"\u0003:\u001d\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e91\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0005?\u0000\u0000\u00ec3\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\u0005@\u0000\u0000\u00ee5\u0001\u0000\u0000\u0000\u00ef\u00f3"+
		"\u0005A\u0000\u0000\u00f0\u00f2\u0003:\u001d\u0000\u00f1\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f47\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6\u00fa\u0005B\u0000\u0000"+
		"\u00f7\u00f9\u0003:\u001d\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb9\u0001\u0000\u0000\u0000\u00fc\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fd\u00ff\u0007\u0001\u0000\u0000\u00fe\u00fd"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u00fe"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101;\u0001"+
		"\u0000\u0000\u0000\u0102\u0104\u0005\u0003\u0000\u0000\u0103\u0105\u0005"+
		"P\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0005O\u0000"+
		"\u0000\u0107=\u0001\u0000\u0000\u0000\u001aALPWahsw}\u0086\u008f\u0099"+
		"\u009b\u00a7\u00ac\u00b3\u00bc\u00cb\u00d1\u00d8\u00e1\u00e8\u00f3\u00fa"+
		"\u0100\u0104";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}