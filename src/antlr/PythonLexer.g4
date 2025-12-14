lexer grammar PythonLexer;

tokens { INDENT, DEDENT, NEWLINE }

@header {
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;
}

@members {
    java.util.Stack<Integer> indents = new java.util.Stack<>();
    java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
    int opened = 0;

    // *****************************************************************
    // تم التعديل لحل مشكلة NullPointerException (يتم توفير مصدر الرمز)
    // *****************************************************************
    Token createToken(int type, String text) {
        // نستخدم Pair و this (_input) لربط الرمز بمصدره، وهو أمر ضروري لآلية معالجة الأخطاء
        CommonToken t = new CommonToken(
            new org.antlr.v4.runtime.misc.Pair<TokenSource, CharStream>(this, _input),
            type,
            0,
            -1, // startIndex
            -1  // stopIndex
        );
        t.setText(text);

        // تعيين السطر والموضع لتحسين تقارير الأخطاء
       t.setLine(getLine()); // <--- تم التعديل
       t.setCharPositionInLine(getCharPositionInLine()); // <--- تم التعديل
        return t;
    }
    // *****************************************************************

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
}

// ------------------ NEWLINE + INDENT/DEDENT ------------------
NEWLINE
    : ('\r'? '\n' | '\r')
      {
          if (opened > 0) { skip(); return; }

          int indent = 0, pos = 1;
          boolean isBlankOrComment = false;

          while (true) {
              int c = _input.LA(pos);
              if (c == ' ') indent++;
              else if (c == '\t') indent += 8 - (indent % 8);
              else if (c == '#' || c == '\r' || c == '\n' || c == IntStream.EOF) { isBlankOrComment = true; break; }
              else break;
              pos++;
          }

          if (isBlankOrComment) {
              for (int i = 1; i < pos; i++) _input.consume(); // تم التعديل إلى i=1
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

          for (int i = 1; i < pos; i++) _input.consume(); // تم التعديل إلى i=1

          skip();
      }
    ;
// ------------------ NEWLINE + INDENT/DEDENT ------------------
//NEWLINE
//    : ('\r'? '\n' | '\r')
//      {
//          if (opened > 0) { skip(); return; }
//
//          int indent = 0, pos = 1;
//          boolean isBlankOrComment = false;
//
//          while (true) {
//              int c = _input.LA(pos);
//              if (c == ' ') indent++;
//              else if (c == '\t') indent += 8 - (indent % 8);
//              else if (c == '#' || c == '\r' || c == '\n' || c == IntStream.EOF) { isBlankOrComment = true; break; }
//              else break;
//              pos++;
//          }
//
//          if (isBlankOrComment) {
//              for (int i = 1; i < pos; i++) _input.consume();
//              skip();
//              return;
//          }
//
//          tokens.add(createToken(NEWLINE, getText()));
//
//          int prevIndent = indents.isEmpty() ? 0 : indents.peek();
//
//          if (indent > prevIndent) {
//              indents.push(indent);
//              tokens.add(createToken(INDENT, ""));
//          } else if (indent < prevIndent) {
//              while (!indents.isEmpty() && indents.peek() > indent) {
//                  indents.pop();
//                  tokens.add(createToken(DEDENT, ""));
//              }
//          }
//
//          for (int i = 1; i < pos; i++) _input.consume();
//
//          // أهم سطر
//          skip();
//      }
//    ;



// ------------------ WHITESPACE & COMMENTS ------------------
WS      : [ \t]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;

// ------------------ KEYWORDS ------------------
DEF:'def';
CLASS:'class';
RETURN:'return';
IMPORT:'import';
FROM:'from';
IF:'if';
ELIF:'elif';
ELSE:'else';
FOR:'for';
WHILE:'while';
IN:'in';
PASS:'pass';
BREAK:'break';
CONTINUE:'continue';
TRUE:'True';
FALSE:'False';
NONE:'None';
NOT:'not';
AND:'and';
OR:'or';
WITH:'with';
AS:'as';
AT:'@';

// ------------------ SYMBOLS ------------------
LPAREN:'(' {opened++;};
RPAREN:')' {opened--;};
LBRACK:'[' {opened++;};
RBRACK:']' {opened--;};
LBRACE:'{' {opened++;};
RBRACE:'}' {opened--;};
COLON:':';
COMMA:',';
DOT:'.';
SEMICOLON:';';
ASSIGN:'=';
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

// ------------------ IDENTIFIERS & LITERALS ------------------
NAME : [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER : [0-9]+ ('.' [0-9]+)? ;

// STRING supports single/double and triple quotes (non-greedy for triples)
STRING
    : '"' (ESC | ~["\\\r\n])* '"'
    | '\'' (ESC | ~['\\\r\n])* '\''
    | '"""' .*? '"""'
    | '\'\'\'' .*? '\'\'\''
    ;

fragment ESC : '\\' . ;
