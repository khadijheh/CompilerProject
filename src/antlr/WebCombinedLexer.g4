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
// ===========================
// CSS MODE
// ===========================
mode CSS_MODE;

/* ---------- STYLE CLOSE ---------- */

CSS_STYLE_CLOSE
    : '</' [sS][tT][yY][lL][eE] '>' -> popMode
    ;

/* ---------- WHITESPACE ---------- */

CSS_WS
    : [ \t\r\n]+ -> skip
    ;

/* ---------- BRACES & SYMBOLS ---------- */

CSS_LBRACE : '{' ;
CSS_RBRACE : '}' ;
CSS_LBRACK : '[' ;
CSS_RBRACK : ']' ;
CSS_COLON  : ':' ;
CSS_SEMI   : ';' ;
CSS_COMMA  : ',' ;
CSS_EQUAL  : '=' ;
CSS_LP : '(' ;
CSS_RP : ')' ;
/* ---------- SELECTORS ---------- */

CSS_DOT    : '.' ;

/* ⚠️ مهم: اللون قبل # */
CSS_COLOR_HEX
    : '#' [0-9a-fA-F]+
    ;



CSS_HASH   : '#' ;

/* ---------- IDENTIFIER ---------- */

CSS_IDENT
    : [a-zA-Z_][a-zA-Z0-9_-]*
    ;

/* ---------- VALUES ---------- */

CSS_NUMBER
    : DIGIT+ ('.' DIGIT+)?
    ;

CSS_UNIT
    : 'px' | 'em' | 'rem' | '%' | 'vh' | 'vw'
    ;

CSS_STRING
    : STRING
    ;


/* ---------- FALLBACK ---------- */
CSS_MINUS
    : '-'
    ;

CSS_OTHER
    : .
    ;

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
