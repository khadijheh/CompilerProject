lexer grammar PythonLexer;
tokens { INDENT, DEDENT }

@header {
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
}

@members {

    java.util.Stack<Integer> indents = new java.util.Stack<>();
    java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
    int opened = 0;

    Token createToken(int type, String text) {
        CommonToken t = new CommonToken(type, text);
        t.setStartIndex(-1);
        t.setStopIndex(-1);
        return t;
    }

    @Override
    public Token nextToken() {

        if (!tokens.isEmpty()) {
            return tokens.removeFirst();
        }

        Token next = super.nextToken();

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
        for (int i = 0; i < spaces.length(); i++) {
            if (spaces.charAt(i) == '\t')
                count += 8 - (count % 8);
            else
                count++;
        }
        return count;
    }
}

// ---------------------------------------------------------
// NEWLINE + Handling Indentation
// ---------------------------------------------------------
NEWLINE
    : ('\r'? '\n' | '\r')
      {
          String nl = getText();
          int next = _input.LA(1);

          // تجاهل الأسطر الفارغة أو الأسطر داخل الأقواس
          if (opened > 0 || next == '\n' || next == '\r') {
              skip();
          } else {

              // اجمع المسافات بعد الـ NEWLINE
              StringBuilder buf = new StringBuilder();
              while (next == ' ' || next == '\t') {
                  buf.append((char) next);
                  _input.consume();
                  next = _input.LA(1);
              }

              int indent = getIndentationCount(buf.toString());
              int prev = indents.isEmpty() ? 0 : indents.peek();

              // إصدار NEWLINE
              emit(createToken(NEWLINE, nl));

              // مقارنة مستوى المسافة البادئة
              if (indent > prev) {
                  indents.push(indent);
                  tokens.add(createToken(INDENT, ""));
              } else {
                  while (!indents.isEmpty() && indents.peek() > indent) {
                      indents.pop();
                      tokens.add(createToken(DEDENT, ""));
                  }
              }
          }
      }
    ;


// ---------------------------------------------------------
// Whitespace & Comments
// ---------------------------------------------------------

WS      : [ \t]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;

// ---------------------------------------------------------
// Keywords
// ---------------------------------------------------------

DEF:'def';
CLASS:'class';
RETURN:'return';
IMPORT:'import';
FROM:'from';
WITH:'with';
AS:'as';
IF:'if';
ELIF:'elif';
ELSE:'else';
FOR:'for';
IN:'in';
WHILE:'while';
PASS:'pass';
BREAK:'break';
CONTINUE:'continue';
TRUE:'True';
FALSE:'False';
NONE:'None';
NOT:'not';

AND:'and';
OR:'or';

// ---------------------------------------------------------
// Symbols
// ---------------------------------------------------------

AT:'@';
COLON:':';
DOT:'.';
COMMA:',';
ASSIGN:'=';

LPAREN:'(' {opened++;};
RPAREN:')' {opened--;};

LBRACK:'[' {opened++;};
RBRACK:']' {opened--;};

ADD:'+';
SUB:'-';
MUL:'*';
DIV:'/';
MOD:'%';

EQ:'==';
NEQ:'!=';
LT:'<';
GT:'>';
LE:'<=';
GE:'>=';


// ---------------------------------------------------------
// Identifiers / Literals
// ---------------------------------------------------------

NAME : [a-zA-Z_][a-zA-Z0-9_]* ;

NUMBER : [0-9]+ ('.' [0-9]+)? ;

STRING
    : '"' (ESC | ~["\r\n\\])* '"'
    | '\'' (ESC | ~['\r\n\\])* '\''
    ;

fragment ESC : '\\' . ;
