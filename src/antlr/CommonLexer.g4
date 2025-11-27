lexer grammar CommonLexer;

// القواعد المشتركة بين جميع اللغات
WS: [ \t\r\n]+ -> skip;
STRING: ('"' (~["] | '\\"')* '"') | ('\'' (~['] | '\\\'')* '\'');
NUMBER: [0-9]+ ('.' [0-9]+)?;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
COMMA: ',';
COLON: ':';
SEMICOLON: ';';
DOT: '.';
EQUALS: '=';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';