lexer grammar CssLexer;

import CommonLexer;

// CSS SPECIFIC TOKENS
CSS_STYLE_TAG: '<style>' -> pushMode(CSS_MODE);

// ===== CSS MODE =====
mode CSS_MODE;
    CSS_END: '</style>' -> popMode;

    // SELECTORS
    CSS_SELECTOR: [a-zA-Z][a-zA-Z0-9#.%_-]* | '*' | '::'? [a-zA-Z-]+;
    CSS_CLASS: '.' [a-zA-Z_][a-zA-Z0-9_-]*;
    CSS_ID: '#' [a-zA-Z_][a-zA-Z0-9_-]*;
    CSS_PSEUDO: ':' [a-zA-Z-]+;

    // BRACES
    CSS_BRACE_OPEN: '{' -> pushMode(CSS_BLOCK_MODE);
    CSS_BRACE_CLOSE: '}';

    CSS_WS: WS;

// ===== CSS BLOCK MODE =====
mode CSS_BLOCK_MODE;
    CSS_BLOCK_END: '}' -> popMode;

    // PROPERTIES
    CSS_PROPERTY: [a-zA-Z-]+;
    CSS_VALUE: ~[;{}!]+;
    CSS_IMPORTANT: '!important';

    // COMMON CSS PROPERTIES
    CSS_WIDTH: 'width';
    CSS_HEIGHT: 'height';
    CSS_COLOR: 'color';
    CSS_BACKGROUND: 'background';
    CSS_BACKGROUND_COLOR: 'background-color';
    CSS_MARGIN: 'margin';
    CSS_PADDING: 'padding';
    CSS_FONT_FAMILY: 'font-family';
    CSS_FONT_SIZE: 'font-size';
    CSS_FONT_WEIGHT: 'font-weight';
    CSS_BORDER: 'border';
    CSS_BORDER_RADIUS: 'border-radius';
    CSS_DISPLAY: 'display';
    CSS_POSITION: 'position';
    CSS_FLOAT: 'float';
    CSS_TEXT_ALIGN: 'text-align';
    CSS_TEXT_DECORATION: 'text-decoration';
    CSS_VERTICAL_ALIGN: 'vertical-align';
    CSS_BOX_SHADOW: 'box-shadow';
    CSS_OPACITY: 'opacity';
    CSS_Z_INDEX: 'z-index';
    CSS_OVERFLOW: 'overflow';
    CSS_CURSOR: 'cursor';
    CSS_TRANSITION: 'transition';
    CSS_TRANSFORM: 'transform';
    CSS_LINE_HEIGHT: 'line-height';
    CSS_MAX_WIDTH: 'max-width';
    CSS_MIN_WIDTH: 'min-width';
    CSS_MAX_HEIGHT: 'max-height';
    CSS_MIN_HEIGHT: 'min-height';
    CSS_LIST_STYLE: 'list-style';
    CSS_TABLE_LAYOUT: 'table-layout';
    CSS_BORDER_COLLAPSE: 'border-collapse';

    CSS_BLOCK_WS: WS;


