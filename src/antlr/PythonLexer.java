// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/PythonLexer.g4 by ANTLR 4.13.2
package antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, NEWLINE=3, WS=4, COMMENT=5, DEF=6, CLASS=7, RETURN=8, 
		IMPORT=9, FROM=10, IF=11, ELIF=12, ELSE=13, FOR=14, WHILE=15, IN=16, PASS=17, 
		BREAK=18, CONTINUE=19, TRUE=20, FALSE=21, NONE=22, NOT=23, AND=24, OR=25, 
		WITH=26, AS=27, AT=28, LPAREN=29, RPAREN=30, LBRACK=31, RBRACK=32, LBRACE=33, 
		RBRACE=34, COLON=35, COMMA=36, DOT=37, SEMICOLON=38, ASSIGN=39, ADD=40, 
		SUB=41, MUL=42, DIV=43, MOD=44, EQ=45, NEQ=46, LT=47, GT=48, LE=49, GE=50, 
		NAME=51, NUMBER=52, STRING=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "WS", "COMMENT", "DEF", "CLASS", "RETURN", "IMPORT", "FROM", 
			"IF", "ELIF", "ELSE", "FOR", "WHILE", "IN", "PASS", "BREAK", "CONTINUE", 
			"TRUE", "FALSE", "NONE", "NOT", "AND", "OR", "WITH", "AS", "AT", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COLON", "COMMA", "DOT", 
			"SEMICOLON", "ASSIGN", "ADD", "SUB", "MUL", "DIV", "MOD", "EQ", "NEQ", 
			"LT", "GT", "LE", "GE", "NAME", "NUMBER", "STRING", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'def'", "'class'", "'return'", "'import'", 
			"'from'", "'if'", "'elif'", "'else'", "'for'", "'while'", "'in'", "'pass'", 
			"'break'", "'continue'", "'True'", "'False'", "'None'", "'not'", "'and'", 
			"'or'", "'with'", "'as'", "'@'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"':'", "','", "'.'", "';'", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "NEWLINE", "WS", "COMMENT", "DEF", "CLASS", 
			"RETURN", "IMPORT", "FROM", "IF", "ELIF", "ELSE", "FOR", "WHILE", "IN", 
			"PASS", "BREAK", "CONTINUE", "TRUE", "FALSE", "NONE", "NOT", "AND", "OR", 
			"WITH", "AS", "AT", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "COLON", "COMMA", "DOT", "SEMICOLON", "ASSIGN", "ADD", "SUB", 
			"MUL", "DIV", "MOD", "EQ", "NEQ", "LT", "GT", "LE", "GE", "NAME", "NUMBER", 
			"STRING"
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


	    java.util.Stack<Integer> indents = new java.util.Stack<>();
	    java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	    int opened = 0;


	    Token createToken(int type, String text) {

	        CommonToken t = new CommonToken(
	            new org.antlr.v4.runtime.misc.Pair<TokenSource, CharStream>(this, _input),
	            type,
	            0,
	            -1, // startIndex
	            -1  // stopIndex
	        );
	        t.setText(text);


	       t.setLine(getLine());
	       t.setCharPositionInLine(getCharPositionInLine());
	        return t;
	    }


	    @Override
	    public Token nextToken() {
	        // if we have queued tokens (INDENT/DEDENT/NEWLINE), return them first
	        if (!tokens.isEmpty()) {
	            return tokens.removeFirst();
	        }

	        Token next = super.nextToken();

	        // When reaching EOF, unwind remaining indentations
	        if (next.getType() == EOF) {
	            while (!indents.isEmpty()) {
	                indents.pop();
	                tokens.add(createToken(DEDENT, ""));
	            }
	            tokens.add(next);
	            return tokens.removeFirst();
	        }

	        return next;
	    }

	    int getIndentationCount(String spaces) {
	        int count = 0;
	        for (char ch : spaces.toCharArray()) {
	            if (ch == '\t') count += 8 - (count % 8);
	            else count++;
	        }
	        return count;
	    }

	    @Override
	    public void recover(LexerNoViableAltException e) {
	        // simple recovery: skip offending char
	        _input.seek(_input.index() + 1);
	        _input.consume();
	    }


	public PythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			LBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			RBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			LBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 31:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			          if (opened > 0) { skip(); return; }

			          int pos = 1;
			          int indent = 0;
			          boolean isBlankOrComment = false;

			          while (true) {
			              int c = _input.LA(pos);
			              if (c == ' ') indent++;
			              else if (c == '\t') indent += 8 - (indent % 8);
			              else if (c == '#' || c == '\r' || c == '\n' || c == IntStream.EOF) {
			                  isBlankOrComment = true;
			                  break;
			              } else break;
			              pos++;
			          }

			          if (isBlankOrComment) {
			              for (int i = 1; i < pos; i++) _input.consume();
			              skip();
			              return;
			          }


			          tokens.add(createToken(NEWLINE, getText()));

			          int prevIndent = indents.isEmpty() ? 0 : indents.peek();
			          if (indent > prevIndent) {
			              indents.push(indent);
			              tokens.add(createToken(INDENT, ""));
			          } else if (indent < prevIndent) {
			              while (!indents.isEmpty() && indents.peek() > indent) {
			                  indents.pop();
			                  tokens.add(createToken(DEDENT, ""));
			              }
			          }

			          for (int i = 1; i < pos; i++) _input.consume();


			      
			break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened++;
			break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened--;
			break;
		}
	}
	private void LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			opened++;
			break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened--;
			break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			opened++;
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			opened--;
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u00005\u016d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u0001\u0000\u0003\u0000k\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000o\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0004\u0001t\b\u0001\u000b\u0001\f\u0001u\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002|\b\u0002\n\u0002\f\u0002"+
		"\u007f\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001,\u0001,\u0001-\u0001"+
		"-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00050\u012b"+
		"\b0\n0\f0\u012e\t0\u00011\u00041\u0131\b1\u000b1\f1\u0132\u00011\u0001"+
		"1\u00041\u0137\b1\u000b1\f1\u0138\u00031\u013b\b1\u00012\u00012\u0001"+
		"2\u00052\u0140\b2\n2\f2\u0143\t2\u00012\u00012\u00012\u00012\u00052\u0149"+
		"\b2\n2\f2\u014c\t2\u00012\u00012\u00012\u00012\u00012\u00012\u00052\u0154"+
		"\b2\n2\f2\u0157\t2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00052\u0161\b2\n2\f2\u0164\t2\u00012\u00012\u00012\u00032\u0169\b2"+
		"\u00013\u00013\u00013\u0002\u0155\u0162\u00004\u0001\u0003\u0003\u0004"+
		"\u0005\u0005\u0007\u0006\t\u0007\u000b\b\r\t\u000f\n\u0011\u000b\u0013"+
		"\f\u0015\r\u0017\u000e\u0019\u000f\u001b\u0010\u001d\u0011\u001f\u0012"+
		"!\u0013#\u0014%\u0015\'\u0016)\u0017+\u0018-\u0019/\u001a1\u001b3\u001c"+
		"5\u001d7\u001e9\u001f; =!?\"A#C$E%G&I\'K(M)O*Q+S,U-W.Y/[0]1_2a3c4e5g\u0000"+
		"\u0001\u0000\u0007\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u0003\u0000A"+
		"Z__az\u0004\u000009AZ__az\u0001\u000009\u0004\u0000\n\n\r\r\"\"\\\\\u0004"+
		"\u0000\n\n\r\r\'\'\\\\\u017c\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000"+
		"\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I"+
		"\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000"+
		"\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000"+
		"\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W"+
		"\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000"+
		"\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000"+
		"\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e"+
		"\u0001\u0000\u0000\u0000\u0001n\u0001\u0000\u0000\u0000\u0003s\u0001\u0000"+
		"\u0000\u0000\u0005y\u0001\u0000\u0000\u0000\u0007\u0082\u0001\u0000\u0000"+
		"\u0000\t\u0086\u0001\u0000\u0000\u0000\u000b\u008c\u0001\u0000\u0000\u0000"+
		"\r\u0093\u0001\u0000\u0000\u0000\u000f\u009a\u0001\u0000\u0000\u0000\u0011"+
		"\u009f\u0001\u0000\u0000\u0000\u0013\u00a2\u0001\u0000\u0000\u0000\u0015"+
		"\u00a7\u0001\u0000\u0000\u0000\u0017\u00ac\u0001\u0000\u0000\u0000\u0019"+
		"\u00b0\u0001\u0000\u0000\u0000\u001b\u00b6\u0001\u0000\u0000\u0000\u001d"+
		"\u00b9\u0001\u0000\u0000\u0000\u001f\u00be\u0001\u0000\u0000\u0000!\u00c4"+
		"\u0001\u0000\u0000\u0000#\u00cd\u0001\u0000\u0000\u0000%\u00d2\u0001\u0000"+
		"\u0000\u0000\'\u00d8\u0001\u0000\u0000\u0000)\u00dd\u0001\u0000\u0000"+
		"\u0000+\u00e1\u0001\u0000\u0000\u0000-\u00e5\u0001\u0000\u0000\u0000/"+
		"\u00e8\u0001\u0000\u0000\u00001\u00ed\u0001\u0000\u0000\u00003\u00f0\u0001"+
		"\u0000\u0000\u00005\u00f2\u0001\u0000\u0000\u00007\u00f5\u0001\u0000\u0000"+
		"\u00009\u00f8\u0001\u0000\u0000\u0000;\u00fb\u0001\u0000\u0000\u0000="+
		"\u00fe\u0001\u0000\u0000\u0000?\u0101\u0001\u0000\u0000\u0000A\u0104\u0001"+
		"\u0000\u0000\u0000C\u0106\u0001\u0000\u0000\u0000E\u0108\u0001\u0000\u0000"+
		"\u0000G\u010a\u0001\u0000\u0000\u0000I\u010c\u0001\u0000\u0000\u0000K"+
		"\u010e\u0001\u0000\u0000\u0000M\u0110\u0001\u0000\u0000\u0000O\u0112\u0001"+
		"\u0000\u0000\u0000Q\u0114\u0001\u0000\u0000\u0000S\u0116\u0001\u0000\u0000"+
		"\u0000U\u0118\u0001\u0000\u0000\u0000W\u011b\u0001\u0000\u0000\u0000Y"+
		"\u011e\u0001\u0000\u0000\u0000[\u0120\u0001\u0000\u0000\u0000]\u0122\u0001"+
		"\u0000\u0000\u0000_\u0125\u0001\u0000\u0000\u0000a\u0128\u0001\u0000\u0000"+
		"\u0000c\u0130\u0001\u0000\u0000\u0000e\u0168\u0001\u0000\u0000\u0000g"+
		"\u016a\u0001\u0000\u0000\u0000ik\u0005\r\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lo\u0005\n\u0000"+
		"\u0000mo\u0005\r\u0000\u0000nj\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pq\u0006\u0000\u0000\u0000q\u0002\u0001"+
		"\u0000\u0000\u0000rt\u0007\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0006\u0001\u0001\u0000x\u0004\u0001"+
		"\u0000\u0000\u0000y}\u0005#\u0000\u0000z|\b\u0001\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0002\u0001\u0000\u0081\u0006"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005d\u0000\u0000\u0083\u0084\u0005"+
		"e\u0000\u0000\u0084\u0085\u0005f\u0000\u0000\u0085\b\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005c\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088"+
		"\u0089\u0005a\u0000\u0000\u0089\u008a\u0005s\u0000\u0000\u008a\u008b\u0005"+
		"s\u0000\u0000\u008b\n\u0001\u0000\u0000\u0000\u008c\u008d\u0005r\u0000"+
		"\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f"+
		"\u0090\u0005u\u0000\u0000\u0090\u0091\u0005r\u0000\u0000\u0091\u0092\u0005"+
		"n\u0000\u0000\u0092\f\u0001\u0000\u0000\u0000\u0093\u0094\u0005i\u0000"+
		"\u0000\u0094\u0095\u0005m\u0000\u0000\u0095\u0096\u0005p\u0000\u0000\u0096"+
		"\u0097\u0005o\u0000\u0000\u0097\u0098\u0005r\u0000\u0000\u0098\u0099\u0005"+
		"t\u0000\u0000\u0099\u000e\u0001\u0000\u0000\u0000\u009a\u009b\u0005f\u0000"+
		"\u0000\u009b\u009c\u0005r\u0000\u0000\u009c\u009d\u0005o\u0000\u0000\u009d"+
		"\u009e\u0005m\u0000\u0000\u009e\u0010\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0005i\u0000\u0000\u00a0\u00a1\u0005f\u0000\u0000\u00a1\u0012\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3\u00a4\u0005l\u0000\u0000"+
		"\u00a4\u00a5\u0005i\u0000\u0000\u00a5\u00a6\u0005f\u0000\u0000\u00a6\u0014"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005e\u0000\u0000\u00a8\u00a9\u0005"+
		"l\u0000\u0000\u00a9\u00aa\u0005s\u0000\u0000\u00aa\u00ab\u0005e\u0000"+
		"\u0000\u00ab\u0016\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005f\u0000\u0000"+
		"\u00ad\u00ae\u0005o\u0000\u0000\u00ae\u00af\u0005r\u0000\u0000\u00af\u0018"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005w\u0000\u0000\u00b1\u00b2\u0005"+
		"h\u0000\u0000\u00b2\u00b3\u0005i\u0000\u0000\u00b3\u00b4\u0005l\u0000"+
		"\u0000\u00b4\u00b5\u0005e\u0000\u0000\u00b5\u001a\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0005i\u0000\u0000\u00b7\u00b8\u0005n\u0000\u0000\u00b8\u001c"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005p\u0000\u0000\u00ba\u00bb\u0005"+
		"a\u0000\u0000\u00bb\u00bc\u0005s\u0000\u0000\u00bc\u00bd\u0005s\u0000"+
		"\u0000\u00bd\u001e\u0001\u0000\u0000\u0000\u00be\u00bf\u0005b\u0000\u0000"+
		"\u00bf\u00c0\u0005r\u0000\u0000\u00c0\u00c1\u0005e\u0000\u0000\u00c1\u00c2"+
		"\u0005a\u0000\u0000\u00c2\u00c3\u0005k\u0000\u0000\u00c3 \u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005c\u0000\u0000\u00c5\u00c6\u0005o\u0000\u0000"+
		"\u00c6\u00c7\u0005n\u0000\u0000\u00c7\u00c8\u0005t\u0000\u0000\u00c8\u00c9"+
		"\u0005i\u0000\u0000\u00c9\u00ca\u0005n\u0000\u0000\u00ca\u00cb\u0005u"+
		"\u0000\u0000\u00cb\u00cc\u0005e\u0000\u0000\u00cc\"\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0005T\u0000\u0000\u00ce\u00cf\u0005r\u0000\u0000\u00cf"+
		"\u00d0\u0005u\u0000\u0000\u00d0\u00d1\u0005e\u0000\u0000\u00d1$\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0005F\u0000\u0000\u00d3\u00d4\u0005a\u0000"+
		"\u0000\u00d4\u00d5\u0005l\u0000\u0000\u00d5\u00d6\u0005s\u0000\u0000\u00d6"+
		"\u00d7\u0005e\u0000\u0000\u00d7&\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005"+
		"N\u0000\u0000\u00d9\u00da\u0005o\u0000\u0000\u00da\u00db\u0005n\u0000"+
		"\u0000\u00db\u00dc\u0005e\u0000\u0000\u00dc(\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0005n\u0000\u0000\u00de\u00df\u0005o\u0000\u0000\u00df\u00e0\u0005"+
		"t\u0000\u0000\u00e0*\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005a\u0000"+
		"\u0000\u00e2\u00e3\u0005n\u0000\u0000\u00e3\u00e4\u0005d\u0000\u0000\u00e4"+
		",\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005o\u0000\u0000\u00e6\u00e7\u0005"+
		"r\u0000\u0000\u00e7.\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005w\u0000"+
		"\u0000\u00e9\u00ea\u0005i\u0000\u0000\u00ea\u00eb\u0005t\u0000\u0000\u00eb"+
		"\u00ec\u0005h\u0000\u0000\u00ec0\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005"+
		"a\u0000\u0000\u00ee\u00ef\u0005s\u0000\u0000\u00ef2\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0005@\u0000\u0000\u00f14\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0005(\u0000\u0000\u00f3\u00f4\u0006\u001a\u0002\u0000\u00f46\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0005)\u0000\u0000\u00f6\u00f7\u0006\u001b"+
		"\u0003\u0000\u00f78\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005[\u0000\u0000"+
		"\u00f9\u00fa\u0006\u001c\u0004\u0000\u00fa:\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0005]\u0000\u0000\u00fc\u00fd\u0006\u001d\u0005\u0000\u00fd<\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0005{\u0000\u0000\u00ff\u0100\u0006\u001e"+
		"\u0006\u0000\u0100>\u0001\u0000\u0000\u0000\u0101\u0102\u0005}\u0000\u0000"+
		"\u0102\u0103\u0006\u001f\u0007\u0000\u0103@\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0005:\u0000\u0000\u0105B\u0001\u0000\u0000\u0000\u0106\u0107\u0005"+
		",\u0000\u0000\u0107D\u0001\u0000\u0000\u0000\u0108\u0109\u0005.\u0000"+
		"\u0000\u0109F\u0001\u0000\u0000\u0000\u010a\u010b\u0005;\u0000\u0000\u010b"+
		"H\u0001\u0000\u0000\u0000\u010c\u010d\u0005=\u0000\u0000\u010dJ\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0005+\u0000\u0000\u010fL\u0001\u0000\u0000"+
		"\u0000\u0110\u0111\u0005-\u0000\u0000\u0111N\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u0005*\u0000\u0000\u0113P\u0001\u0000\u0000\u0000\u0114\u0115\u0005"+
		"/\u0000\u0000\u0115R\u0001\u0000\u0000\u0000\u0116\u0117\u0005%\u0000"+
		"\u0000\u0117T\u0001\u0000\u0000\u0000\u0118\u0119\u0005=\u0000\u0000\u0119"+
		"\u011a\u0005=\u0000\u0000\u011aV\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"!\u0000\u0000\u011c\u011d\u0005=\u0000\u0000\u011dX\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005<\u0000\u0000\u011fZ\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0005>\u0000\u0000\u0121\\\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0005<\u0000\u0000\u0123\u0124\u0005=\u0000\u0000\u0124^\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0005>\u0000\u0000\u0126\u0127\u0005=\u0000\u0000"+
		"\u0127`\u0001\u0000\u0000\u0000\u0128\u012c\u0007\u0002\u0000\u0000\u0129"+
		"\u012b\u0007\u0003\u0000\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012b"+
		"\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c"+
		"\u012d\u0001\u0000\u0000\u0000\u012db\u0001\u0000\u0000\u0000\u012e\u012c"+
		"\u0001\u0000\u0000\u0000\u012f\u0131\u0007\u0004\u0000\u0000\u0130\u012f"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0130"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u013a"+
		"\u0001\u0000\u0000\u0000\u0134\u0136\u0005.\u0000\u0000\u0135\u0137\u0007"+
		"\u0004\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001"+
		"\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001"+
		"\u0000\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0134\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013bd\u0001\u0000"+
		"\u0000\u0000\u013c\u0141\u0005\"\u0000\u0000\u013d\u0140\u0003g3\u0000"+
		"\u013e\u0140\b\u0005\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f"+
		"\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000\u0141"+
		"\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142"+
		"\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144"+
		"\u0169\u0005\"\u0000\u0000\u0145\u014a\u0005\'\u0000\u0000\u0146\u0149"+
		"\u0003g3\u0000\u0147\u0149\b\u0006\u0000\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014c\u0001\u0000"+
		"\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000"+
		"\u0000\u0000\u014d\u0169\u0005\'\u0000\u0000\u014e\u014f\u0005\"\u0000"+
		"\u0000\u014f\u0150\u0005\"\u0000\u0000\u0150\u0151\u0005\"\u0000\u0000"+
		"\u0151\u0155\u0001\u0000\u0000\u0000\u0152\u0154\t\u0000\u0000\u0000\u0153"+
		"\u0152\u0001\u0000\u0000\u0000\u0154\u0157\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156"+
		"\u0158\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0158"+
		"\u0159\u0005\"\u0000\u0000\u0159\u015a\u0005\"\u0000\u0000\u015a\u0169"+
		"\u0005\"\u0000\u0000\u015b\u015c\u0005\'\u0000\u0000\u015c\u015d\u0005"+
		"\'\u0000\u0000\u015d\u015e\u0005\'\u0000\u0000\u015e\u0162\u0001\u0000"+
		"\u0000\u0000\u015f\u0161\t\u0000\u0000\u0000\u0160\u015f\u0001\u0000\u0000"+
		"\u0000\u0161\u0164\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000"+
		"\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163\u0165\u0001\u0000\u0000"+
		"\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0165\u0166\u0005\'\u0000\u0000"+
		"\u0166\u0167\u0005\'\u0000\u0000\u0167\u0169\u0005\'\u0000\u0000\u0168"+
		"\u013c\u0001\u0000\u0000\u0000\u0168\u0145\u0001\u0000\u0000\u0000\u0168"+
		"\u014e\u0001\u0000\u0000\u0000\u0168\u015b\u0001\u0000\u0000\u0000\u0169"+
		"f\u0001\u0000\u0000\u0000\u016a\u016b\u0005\\\u0000\u0000\u016b\u016c"+
		"\t\u0000\u0000\u0000\u016ch\u0001\u0000\u0000\u0000\u0010\u0000jnu}\u012c"+
		"\u0132\u0138\u013a\u013f\u0141\u0148\u014a\u0155\u0162\u0168\b\u0001\u0000"+
		"\u0000\u0006\u0000\u0000\u0001\u001a\u0001\u0001\u001b\u0002\u0001\u001c"+
		"\u0003\u0001\u001d\u0004\u0001\u001e\u0005\u0001\u001f\u0006";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}