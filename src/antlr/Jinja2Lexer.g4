lexer grammar Jinja2Lexer;

import CommonLexer;

// JINJA2 SPECIFIC TOKENS
JINJA_EXPR_OPEN: '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA_BLOCK_OPEN: '{%' -> pushMode(JINJA_BLOCK_MODE);
JINJA_COMMENT_OPEN: '{#' -> pushMode(JINJA_COMMENT_MODE);

// ===== JINJA EXPRESSION MODE =====
mode JINJA_EXPR_MODE;
    JINJA_EXPR_CLOSE: '}}' -> popMode;

    // FLASK SPECIFIC FUNCTIONS
    JINJA_URL_FOR: 'url_for' -> pushMode(JINJA_FUNC_MODE);
    JINJA_GET_FLASHED: 'get_flashed_messages' -> pushMode(JINJA_FUNC_MODE);

    // VARIABLES AND FILTERS (محدث)
    JINJA_VARIABLE: IDENTIFIER;
    JINJA_FILTER: '|' IDENTIFIER;
    JINJA_LENGTH_FILTER: '|length';
    JINJA_ESCAPE_FILTER: '|escape';
    JINJA_SAFE_FILTER: '|safe';
    JINJA_ROUND_FILTER: '|round';
    JINJA_INT_FILTER: '|int';
    JINJA_FLOAT_FILTER: '|float';

    // PRODUCT SPECIFIC
    JINJA_PRODUCT_ACCESS: 'product\\.' IDENTIFIER;

    // VALUES
    JINJA_STRING: STRING;
    JINJA_NUMBER: NUMBER;

    // OPERATORS
    JINJA_OPERATOR: [+\-*/%] | '==' | '!=' | '>' | '<' | '>=' | '<=' | '\\|';
    JINJA_PIPE: '|';

    JINJA_EXPR_WS: WS;

// ===== JINJA FUNCTION MODE =====
mode JINJA_FUNC_MODE;
    JINJA_FUNC_CLOSE: ')' -> popMode;
    JINJA_FUNC_ARG:
        JINJA_STRING |
        JINJA_VARIABLE |
        (JINJA_VARIABLE '=' (JINJA_STRING | JINJA_VARIABLE));
    JINJA_FUNC_WS: WS;

// ===== JINJA BLOCK MODE =====
mode JINJA_BLOCK_MODE;
    JINJA_BLOCK_CLOSE: '%}' -> popMode;

    // CONTROL STRUCTURES (محدث)
    JINJA_FOR: 'for';
    JINJA_IN: 'in';
    JINJA_IF: 'if';
    JINJA_ELIF: 'elif';
    JINJA_ELSE: 'else';
    JINJA_ENDIF: 'endif';
    JINJA_ENDFOR: 'endfor';

    // TEMPLATE INHERITANCE
    JINJA_BLOCK: 'block';
    JINJA_ENDBLOCK: 'endblock';
    JINJA_ENDMACRO: 'endmacro';
    JINJA_EXTENDS: 'extends';
    JINJA_INCLUDE: 'include';

    // VARIABLES AND MACROS
    JINJA_SET: 'set';
    JINJA_MACRO: 'macro';
    JINJA_IMPORT: 'import';
    JINJA_FROM: 'from';

    // FLASK SPECIFIC
    JINJA_WITH: 'with';
    JINJA_ENDWITH: 'endwith';

    // CONTENT BLOCKS
    JINJA_CONTENT: 'content';
    JINJA_ENDCONTENT: 'endcontent';

    // IDENTIFIERS
    JINJA_BLOCK_VAR: IDENTIFIER;
    JINJA_BLOCK_STRING: STRING;

    JINJA_BLOCK_WS: WS;

// ===== JINJA COMMENT MODE =====
mode JINJA_COMMENT_MODE;
    JINJA_COMMENT_CLOSE: '#}' -> popMode;
 fragment   JINJA_COMMENT_CONTENT: ~[#}]*;