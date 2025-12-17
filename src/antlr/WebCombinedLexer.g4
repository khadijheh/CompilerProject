lexer grammar WebCombinedLexer;

// -----------------------------------------------------
//  COMMON FRAGMENTS
// -----------------------------------------------------
fragment DIGIT  : [0-9] ;
fragment LETTER : [a-zA-Z_] ;
fragment STRING : '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'' ;

// =====================================================
//  ROOT MODE (DEFAULT)
// =====================================================

// --------- Jinja openings ---------
JINJA_EXPR_OPEN     : '{{' -> pushMode(JINJA_EXPR_MODE) ;
JINJA_BLOCK_OPEN    : '{%' -> pushMode(JINJA_BLOCK_MODE) ;
JINJA_COMMENT_OPEN  : '{#' -> pushMode(JINJA_COMMENT_MODE) ;

// --------- HTML comment ---------
HTML_COMMENT_OPEN : '<!--' -> pushMode(HTML_COMMENT_MODE) ;

// --------- HTML declarations (<!DOCTYPE...>) ---------
HTML_DECLARATION : '<!' ~[>]* '>' -> skip ;

// --------- CSS <style> ---------
CSS_STYLE_TAG : '<' [sS][tT][yY][lL][eE] [ \t\r\n]* '>' -> pushMode(CSS_MODE) ;
HTML_CLOSE_OPEN : '</' -> pushMode(HTML_MODE) ;
// --------- HTML tags ---------
HTML_OPEN : '<' -> pushMode(HTML_MODE) ;

TEXT
    : ( LETTER
      | DIGIT
      | '-'
      | '_'
      | '.'
      | '/'
      | ':'
      | ';'
      | ','
      | '!'
      | '?'
      | '+'
      | '*'
      | '='
      | '@'
      | '$'
      | '%'
      | '^'
      | '&'
      | '('
      | ')'
      | '['
      | ']'
      | '\\'
      | '|'
      | '"'
      | '\''
      )+
    ;
WS
    : [ \t\r\n]+ -> skip
    ;
// ============================
// HTML MODE
// ============================
mode HTML_MODE;

//HTML_CLOSE_START : '/' ;
HTML_IDENTIFIER : [a-zA-Z_:][a-zA-Z0-9_:\-.]* ;
EQUALS : '=' ;
HTML_WS          : [ \t\r\n]+  -> skip ;
HTML_ATTR_VALUE_OPEN_DQ : '"'  -> pushMode(HTML_ATTR_VALUE_MODE) ;
HTML_ATTR_VALUE_OPEN_SQ : '\'' -> pushMode(HTML_ATTR_VALUE_MODE) ;

HTML_TAG_SELF_CLOSE : '/>' -> popMode ;
HTML_TAG_CLOSE      : '>'  -> popMode ;

HTML_OTHER : [^a-zA-Z0-9_:/>"'= ] ;

// =====================================================
//  HTML COMMENT MODE
// =====================================================
mode HTML_COMMENT_MODE;

HTML_COMMENT_CLOSE : '-->' -> popMode ;
HTML_COMMENT_TEXT  : ( ~'-' | '-' ~'>' )+ ;
HTML_COMMENT_WS    : [ \t\r\n]+ -> skip ;

// =====================================================
//  CSS MODE  (Refined + NON-BLOCKING)
// =====================================================
mode CSS_MODE;

// يغلق الـ <style>
CSS_STYLE_CLOSE : '</' [sS][tT][yY][lL][eE] '>' -> popMode ;

// تجاهل المسافات
CSS_WS : [ \t\r\n]+ -> skip ;

// فتح وغلق الأقواس
CSS_BRACE_OPEN : '{' ;
CSS_BLOCK_END  : '}' ;

// : و ; في القواعد
CSS_COLON     : ':' ;
CSS_SEMICOLON : ';' ;

// !important
CSS_IMPORTANT : '!important' ;

// selectors حسب الترتيب: class, id, pseudo, general
CSS_CLASS    : '.' [a-zA-Z_][a-zA-Z0-9_-]* ;
CSS_ID       : '#' [a-zA-Z_][a-zA-Z0-9_-]* ;
CSS_PSEUDO   : ':' [a-zA-Z_-]+ ( '(' (~')')* ')' )? ;

// selector عام مع السماح بالمسافات بين الكلمات (combinators)
CSS_SELECTOR
    : [a-zA-Z0-9_-]+ ( [ \t\r\n]+ [a-zA-Z0-9_-]+ )* ;

// property name
CSS_PROPERTY : [a-zA-Z-]+ ;

// قيمة بعد :
CSS_VALUE
    : (~(';' | '\r' | '\n' | '}'))+ ;

// fallback أي شيء آخر
CSS_BLOCK_OTHER : . ;

// =====================================================
//  HTML ATTRIBUTE VALUE MODE
// =====================================================
mode HTML_ATTR_VALUE_MODE;

JINJA_EXPR_OPEN_IN_ATTR    : '{{' -> pushMode(JINJA_EXPR_MODE) ;
JINJA_BLOCK_OPEN_IN_ATTR   : '{%' -> pushMode(JINJA_BLOCK_MODE) ;
JINJA_COMMENT_OPEN_IN_ATTR : '{#' -> pushMode(JINJA_COMMENT_MODE) ;
HTML_ATTR_VALUE_CLOSE_DQ : '"'  -> popMode ;
HTML_ATTR_VALUE_CLOSE_SQ : '\'' -> popMode ;
HTML_ATTR_VALUE_TEXT
    : ( '{' ~[#%]
      | ~["\r\n]
      )+
    ;

HTML_ATTR_VALUE_WS : [ \t\r\n]+ -> skip ;

// =====================================================
//  JINJA EXPRESSION MODE  {{ ... }}
// =====================================================
mode JINJA_EXPR_MODE;

JINJA_EXPR_CLOSE : '}}' -> popMode ;

JINJA_IDENT  : LETTER (LETTER | DIGIT)* ;
JINJA_NUMBER : DIGIT+ ;
JINJA_STRING : STRING ;

JINJA_OP     : [+\-*/><=]+ ;
JINJA_DOT    : '.' ;
JINJA_COMMA  : ',' ;
JINJA_COLON  : ':' ;
JINJA_LP     : '(' ;
JINJA_RP     : ')' ;
JINJA_LB     : '[' ;
JINJA_RB     : ']' ;

JINJA_WS    : [ \t\r\n]+ -> skip ;
JINJA_OTHER : . ;

// =====================================================
//  JINJA BLOCK MODE  {% ... %}
// =====================================================
mode JINJA_BLOCK_MODE;

JINJA_BLOCK_CLOSE : '%}' -> popMode ;



JINJA_FOR    : 'for' ;
JINJA_IN     : 'in' ;
JINJA_ENDFOR : 'endfor' ;

JINJA_IF     : 'if' ;
JINJA_ELIF   : 'elif' ;
JINJA_ELSE   : 'else' ;
JINJA_ENDIF  : 'endif' ;

JINJA_SET    : 'set' ;
JINJA_BLOCK_IDENT  : LETTER (LETTER | DIGIT)* ;
JINJA_BLOCK_NUMBER : DIGIT+ ;
JINJA_BLOCK_STRING : STRING ;
JINJA_BLOCK_EQ    : '=' ;
JINJA_BLOCK_DOT   : '.' ;
JINJA_BLOCK_COMMA : ',' ;
JINJA_BLOCK_COLON : ':' ;
JINJA_BLOCK_LP    : '(' ;
JINJA_BLOCK_RP    : ')' ;
JINJA_BLOCK_LB    : '[' ;
JINJA_BLOCK_RB    : ']' ;

JINJA_BLOCK_WS    : [ \t\r\n]+ -> skip ;
JINJA_BLOCK_OTHER : . ;

// =====================================================
//  JINJA COMMENT MODE  {# ... #}
// =====================================================
mode JINJA_COMMENT_MODE;

JINJA_COMMENT_CLOSE : '#}' -> popMode ;
JINJA_COMMENT_TEXT  : ~[#]+ ;
JINJA_COMMENT_WS    : [ \t\r\n]+ -> skip ;
