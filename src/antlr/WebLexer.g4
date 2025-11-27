lexer grammar WebLexer;

import HtmlLexer, CssLexer, Jinja2Lexer, FlaskLexer;

// MAIN LEXER RULES - ORDER IS CRITICAL
// 1. JINJA2 FIRST
JINJA_EXPR_OPEN: '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA_BLOCK_OPEN: '{%' -> pushMode(JINJA_BLOCK_MODE);
JINJA_COMMENT_OPEN: '{#' -> pushMode(JINJA_COMMENT_MODE);

// 2. HTML
DOCTYPE_OPEN: '<!DOCTYPE' -> pushMode(DOCTYPE_MODE);
HTML_COMMENT: '<!--' .*? '-->' -> skip;

// 3. SPECIFIC HTML TAGS
META_TAG: '<meta' -> pushMode(HTML_TAG_MODE);
TITLE_TAG: '<title' -> pushMode(HTML_TAG_MODE);
LINK_TAG: '<link' -> pushMode(HTML_TAG_MODE);
DIV_TAG: '<div' -> pushMode(HTML_TAG_MODE);
H1_TAG: '<h1' -> pushMode(HTML_TAG_MODE);
H2_TAG: '<h2' -> pushMode(HTML_TAG_MODE);
FORM_TAG: '<form' -> pushMode(HTML_TAG_MODE);
INPUT_TAG: '<input' -> pushMode(HTML_TAG_MODE);
TEXTAREA_TAG: '<textarea' -> pushMode(HTML_TAG_MODE);
BUTTON_TAG: '<button' -> pushMode(HTML_TAG_MODE);
LABEL_TAG: '<label' -> pushMode(HTML_TAG_MODE);
SELECT_TAG: '<select' -> pushMode(HTML_TAG_MODE);
OPTION_TAG: '<option' -> pushMode(HTML_TAG_MODE);
IMG_TAG: '<img' -> pushMode(HTML_TAG_MODE);
A_TAG: '<a' -> pushMode(HTML_TAG_MODE);
UL_TAG: '<ul' -> pushMode(HTML_TAG_MODE);
LI_TAG: '<li' -> pushMode(HTML_TAG_MODE);
TABLE_TAG: '<table' -> pushMode(HTML_TAG_MODE);
TR_TAG: '<tr' -> pushMode(HTML_TAG_MODE);
TD_TAG: '<td' -> pushMode(HTML_TAG_MODE);
// 4. GENERAL HTML
HTML_TAG_OPEN: '<' -> pushMode(HTML_TAG_MODE);
HTML_TAG_END: '</' -> pushMode(HTML_TAG_MODE);

// 5. CSS
CSS_STYLE_TAG: '<style>' -> pushMode(CSS_MODE);

// 6. PYTHON/FLASK
PYTHON_FLASK_IMPORT: 'from flask import' -> pushMode(PYTHON_MODE);
PYTHON_OS_IMPORT: 'import os' -> pushMode(PYTHON_MODE);
PYTHON_SQLALCHEMY_IMPORT: 'from flask_sqlalchemy import SQLAlchemy' -> pushMode(PYTHON_MODE);
PYTHON_FLASK_APP: '@app.route' -> pushMode(PYTHON_ROUTE_MODE);
PYTHON_CLASS_DEF: 'class' IDENTIFIER -> pushMode(PYTHON_CLASS_MODE);
PYTHON_DEF: 'def' IDENTIFIER -> pushMode(PYTHON_DEF_MODE);

// 7. TEXT CONTENT
TEXT_CONTENT: ~[<{@]+;

// 8. WHITESPACE
WS: [ \t\r\n]+ -> skip;