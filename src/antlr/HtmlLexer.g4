lexer grammar HtmlLexer;

import CommonLexer;

// HTML SPECIFIC TOKENS
// ⭐ MUST COME FIRST: General rules before specific ones ⭐
HTML_TAG_OPEN: '<' -> pushMode(HTML_TAG_MODE);
HTML_TAG_END: '</' -> pushMode(HTML_TAG_MODE);

// SPECIFIC HTML TAGS (محدث)
HTML_TAG: '<html' -> pushMode(HTML_TAG_MODE);
HEAD_TAG: '<head' -> pushMode(HTML_TAG_MODE);
BODY_TAG: '<body' -> pushMode(HTML_TAG_MODE);
META_TAG: '<meta' -> pushMode(HTML_TAG_MODE);
TITLE_TAG: '<title' -> pushMode(HTML_TAG_MODE);
LINK_TAG: '<link' -> pushMode(HTML_TAG_MODE);
DIV_TAG: '<div' -> pushMode(HTML_TAG_MODE);
H1_TAG: '<h1' -> pushMode(HTML_TAG_MODE);
H2_TAG: '<h2' -> pushMode(HTML_TAG_MODE);
H3_TAG: '<h3' -> pushMode(HTML_TAG_MODE);
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
TH_TAG: '<th' -> pushMode(HTML_TAG_MODE);
SPAN_TAG: '<span' -> pushMode(HTML_TAG_MODE);
P_TAG: '<p' -> pushMode(HTML_TAG_MODE);
B_TAG: '<b' -> pushMode(HTML_TAG_MODE);
STRONG_TAG: '<strong' -> pushMode(HTML_TAG_MODE);
BR_TAG: '<br' -> pushMode(HTML_TAG_MODE);
HR_TAG: '<hr' -> pushMode(HTML_TAG_MODE);
STYLE_TAG: '<style' -> pushMode(HTML_TAG_MODE);
SCRIPT_TAG: '<script' -> pushMode(HTML_TAG_MODE);

DOCTYPE_OPEN: '<!DOCTYPE' -> pushMode(DOCTYPE_MODE);
HTML_COMMENT: '<!--' .*? '-->' -> skip;

HTML_TEXT: ~[<{]+;

// ===== HTML TAG MODE =====
mode HTML_TAG_MODE;
    HTML_TAG_SELF_CLOSE: '/>' -> popMode;
    HTML_TAG_CLOSE: '>' -> popMode;

    HTML_TAG_NAME: [a-zA-Z][a-zA-Z0-9]*;

    // ATTRIBUTES
    HTML_ATTR_NAME: [a-zA-Z_][a-zA-Z0-9_\-]*;
    HTML_ATTR_VALUE: STRING | [a-zA-Z0-9_\-.:/]+;

    // SPECIFIC ATTRIBUTES (محدث)
    HTML_ATTR_ACTION: 'action';
    HTML_ATTR_METHOD: 'method';
    HTML_ATTR_NAME_ATTR: 'name';
    HTML_ATTR_TYPE: 'type';
    HTML_ATTR_REQUIRED: 'required';
    HTML_ATTR_ENCTYPE: 'enctype';
    HTML_ATTR_SRC: 'src';
    HTML_ATTR_HREF: 'href';
    HTML_ATTR_CLASS: 'class';
    HTML_ATTR_ID: 'id';
    HTML_ATTR_STYLE: 'style';
    HTML_ATTR_FOR: 'for';
    HTML_ATTR_PLACEHOLDER: 'placeholder';
    HTML_ATTR_VALUE_ATTR: 'value';
    HTML_ATTR_ROWS: 'rows';
    HTML_ATTR_COLS: 'cols';
    HTML_ATTR_SELECTED: 'selected';
    HTML_ATTR_DISABLED: 'disabled';
    HTML_ATTR_READONLY: 'readonly';
    HTML_ATTR_CHARSET: 'charset';
    HTML_ATTR_CONTENT: 'content';
    HTML_ATTR_REL: 'rel';
    HTML_ATTR_ALT: 'alt';
    HTML_ATTR_TARGET: 'target';
    HTML_ATTR_STEP: 'step';
    HTML_ATTR_ACCEPT: 'accept';
    HTML_ATTR_LANG: 'lang';
    HTML_ATTR_WIDTH: 'width';
    HTML_ATTR_HEIGHT: 'height';
    HTML_ATTR_BORDER: 'border';
    HTML_ATTR_CELLPADDING: 'cellpadding';
    HTML_ATTR_CELLSPACING: 'cellspacing';
    HTML_ATTR_ONCLICK: 'onclick';
    HTML_ATTR_DATA_TOGGLE: 'data-toggle';
    HTML_ATTR_DATA_TARGET: 'data-target';
    HTML_ATTR_ARIA_LABEL: 'aria-label';
    HTML_ATTR_ARIA_HIDDEN: 'aria-hidden';

    HTML_TAG_WS: WS;

// ===== DOCTYPE MODE =====
mode DOCTYPE_MODE;
    DOCTYPE_CLOSE: '>' -> popMode;
    DOCTYPE_CONTENT: ~[>]+;