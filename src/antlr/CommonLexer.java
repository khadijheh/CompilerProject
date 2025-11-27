// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/CommonLexer.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CommonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, STRING=2, NUMBER=3, IDENTIFIER=4, COMMA=5, COLON=6, SEMICOLON=7, 
		DOT=8, EQUALS=9, LPAREN=10, RPAREN=11, LBRACE=12, RBRACE=13, LBRACKET=14, 
		RBRACKET=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "STRING", "NUMBER", "IDENTIFIER", "COMMA", "COLON", "SEMICOLON", 
			"DOT", "EQUALS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", 
			"RBRACKET"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "','", "':'", "';'", "'.'", "'='", "'('", 
			"')'", "'{'", "'}'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "STRING", "NUMBER", "IDENTIFIER", "COMMA", "COLON", "SEMICOLON", 
			"DOT", "EQUALS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", 
			"RBRACKET"
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


	public CommonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CommonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000ff\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0004\u0000!\b\u0000\u000b\u0000\f\u0000\"\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001+\b\u0001"+
		"\n\u0001\f\u0001.\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00015\b\u0001\n\u0001\f\u00018\t\u0001\u0001\u0001"+
		"\u0003\u0001;\b\u0001\u0001\u0002\u0004\u0002>\b\u0002\u000b\u0002\f\u0002"+
		"?\u0001\u0002\u0001\u0002\u0004\u0002D\b\u0002\u000b\u0002\f\u0002E\u0003"+
		"\u0002H\b\u0002\u0001\u0003\u0001\u0003\u0005\u0003L\b\u0003\n\u0003\f"+
		"\u0003O\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0006"+
		"\u0003\u0000\t\n\r\r  \u0001\u0000\"\"\u0001\u0000\'\'\u0001\u000009\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__azo\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001 \u0001"+
		"\u0000\u0000\u0000\u0003:\u0001\u0000\u0000\u0000\u0005=\u0001\u0000\u0000"+
		"\u0000\u0007I\u0001\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000\u000b"+
		"R\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000\u0000\u000fV\u0001\u0000"+
		"\u0000\u0000\u0011X\u0001\u0000\u0000\u0000\u0013Z\u0001\u0000\u0000\u0000"+
		"\u0015\\\u0001\u0000\u0000\u0000\u0017^\u0001\u0000\u0000\u0000\u0019"+
		"`\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001dd\u0001"+
		"\u0000\u0000\u0000\u001f!\u0007\u0000\u0000\u0000 \u001f\u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0006\u0000\u0000\u0000"+
		"%\u0002\u0001\u0000\u0000\u0000&,\u0005\"\u0000\u0000\'+\b\u0001\u0000"+
		"\u0000()\u0005\\\u0000\u0000)+\u0005\"\u0000\u0000*\'\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000/;\u0005\"\u0000\u000006\u0005\'\u0000\u000015\b\u0002"+
		"\u0000\u000023\u0005\\\u0000\u000035\u0005\'\u0000\u000041\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u00009;\u0005\'\u0000\u0000:&\u0001\u0000\u0000\u0000"+
		":0\u0001\u0000\u0000\u0000;\u0004\u0001\u0000\u0000\u0000<>\u0007\u0003"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@G\u0001\u0000\u0000\u0000"+
		"AC\u0005.\u0000\u0000BD\u0007\u0003\u0000\u0000CB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000"+
		"\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000H\u0006\u0001\u0000\u0000\u0000IM\u0007\u0004\u0000\u0000"+
		"JL\u0007\u0005\u0000\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\b\u0001\u0000"+
		"\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005,\u0000\u0000Q\n\u0001\u0000"+
		"\u0000\u0000RS\u0005:\u0000\u0000S\f\u0001\u0000\u0000\u0000TU\u0005;"+
		"\u0000\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005.\u0000\u0000W\u0010"+
		"\u0001\u0000\u0000\u0000XY\u0005=\u0000\u0000Y\u0012\u0001\u0000\u0000"+
		"\u0000Z[\u0005(\u0000\u0000[\u0014\u0001\u0000\u0000\u0000\\]\u0005)\u0000"+
		"\u0000]\u0016\u0001\u0000\u0000\u0000^_\u0005{\u0000\u0000_\u0018\u0001"+
		"\u0000\u0000\u0000`a\u0005}\u0000\u0000a\u001a\u0001\u0000\u0000\u0000"+
		"bc\u0005[\u0000\u0000c\u001c\u0001\u0000\u0000\u0000de\u0005]\u0000\u0000"+
		"e\u001e\u0001\u0000\u0000\u0000\u000b\u0000\"*,46:?EGM\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}