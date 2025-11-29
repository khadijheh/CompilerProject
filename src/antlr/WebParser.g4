parser grammar WebParser;

options { tokenVocab=WebCombinedLexer; }

// ===========================
// ROOT
// ===========================
template
    : (contentItem)* EOF
    ;
// ---------------------- CSS FILE ENTRY ----------------------
cssFile
    : (cssRule | CSS_WS | CSS_BLOCK_WS  | CSS_BLOCK_OTHER)* EOF
    ;
//cssFilePreview
//    : ( CSS_SELECTOR
//      | CSS_CLASS
//      | CSS_ID
//      | CSS_PSEUDO
//      | CSS_PROPERTY
//      | CSS_VALUE
//      | CSS_IMPORTANT
//      | CSS_BRACE_OPEN
//      | CSS_BLOCK_END
//      | CSS_SEMICOLON
//      | CSS_WS
//      | CSS_BLOCK_WS
//      | CSS_TEXT
//      | CSS_BLOCK_OTHER
//      )* EOF
//    ;

// ===========================
// CONTENT ITEMS
// ===========================
contentItem
    : htmlElement
    | htmlText
    | jinjaExpression
    | jinjaBlock
    | jinjaComment
    ;

// =====================================================
//  HTML ELEMENTS
// =====================================================

htmlElement
    : htmlVoidElement
    | htmlNormalElement
    ;

htmlVoidElement
    : HTML_OPEN HTML_IDENTIFIER (htmlAttribute)* HTML_TAG_SELF_CLOSE
    ;

htmlNormalElement
    : HTML_OPEN HTML_IDENTIFIER (htmlAttribute)* HTML_TAG_CLOSE
      contentItem*
      HTML_CLOSE_OPEN HTML_IDENTIFIER HTML_TAG_CLOSE
    ;

// =====================================================
//  HTML ATTRIBUTES
// =====================================================

htmlAttribute
    : HTML_IDENTIFIER EQUALS htmlAttributeValue |HTML_IDENTIFIER
    ;

htmlAttributeValue
    : dqValue
    | sqValue
    ;

dqValue
    : HTML_ATTR_VALUE_OPEN_DQ (htmlAttrValueItem)* HTML_ATTR_VALUE_CLOSE_DQ
    ;

sqValue
    : HTML_ATTR_VALUE_OPEN_SQ (htmlAttrValueItem)* HTML_ATTR_VALUE_CLOSE_SQ
    ;

htmlAttrValueItem
    : HTML_ATTR_VALUE_TEXT
    | jinjaExpression
    | jinjaBlock
    | jinjaComment
    ;

// =====================================================
//  TEXT
// =====================================================

htmlText
    : TEXT
    ;

// ===========================
// CSS (<style> ... </style>)
// ===========================
cssStyleBlock
    : CSS_STYLE_TAG cssBody CSS_STYLE_CLOSE               #CssStyle
    ;

cssBody
    : ( cssRule | CSS_BLOCK_WS | CSS_BLOCK_OTHER )*
    ;

cssRule
    : cssSelector CSS_BRACE_OPEN cssDeclarations CSS_BLOCK_END  #Css_Rule
    ;

cssSelector
    : CSS_SELECTOR
    | CSS_CLASS
    | CSS_ID
    | CSS_PSEUDO
    ;

cssDeclarations
    : ( cssDeclaration | CSS_BLOCK_WS )*
    ;

cssDeclaration
    : CSS_PROPERTY CSS_COLON CSS_VALUE CSS_SEMICOLON?  #Css_Declaration
    ;

// ===========================
// JINJA EXPRESSION {{ ... }}
// ===========================
jinjaExpression
    : JINJA_EXPR_OPEN jinjaExprBody JINJA_EXPR_CLOSE    #Jinja_Expression
    ;

jinjaExprBody
    : ( JINJA_IDENT
      | JINJA_NUMBER
      | JINJA_STRING
      | JINJA_OP        // some lexers provide JINJA_OP in expr mode
      | JINJA_LP
      | JINJA_RP
      | JINJA_LB
      | JINJA_RB
      | JINJA_COMMA
      | JINJA_COLON
      | JINJA_DOT
      | JINJA_OTHER
      )*
    ;

// ===========================
// JINJA BLOCK {# ... #} wrapper
// We parse a single jinja block token (an opening or closing directive).
// Control flow is represented by sequences: a start jinjaBlock (e.g. {% if ... %})
// then contentItems... then a separate jinjaBlock for the corresponding end (e.g. {% endif %}).
// ===========================
jinjaBlock
    : JINJA_BLOCK_OPEN jinjaBlockInner JINJA_BLOCK_CLOSE    #Jinja_Block
    ;

// inner alternatives: start / end / elif / else / set / simple identifiers
jinjaBlockInner
    : forStart                                              #For_Start
    | forEnd                                                #For_End
    | ifStart                                               #If_Start
    | elifPart                                              #Elif_Part
    | elsePart                                              #Else_Part
    | endIfPart                                             #EndIf_Part
    | setStmt                                               #Set_Stmt
    | simpleStmt                                            #Simple_Stmt
    ;

// ---------------------------
// FOR block tokens (start / end)
// ---------------------------
forStart
    : JINJA_FOR jinjaBlockExpr* JINJA_IN jinjaBlockExpr*                                // e.g. "for item in items" tokens captured in jinjaBlockExpr*
    ;

forEnd
    : JINJA_ENDFOR
    ;

// ---------------------------
// IF / ELIF / ELSE / ENDIF tokens
// ---------------------------
ifStart
    : JINJA_IF jinjaBlockExpr*
    ;

elifPart
    : JINJA_ELIF jinjaBlockExpr*
    ;

elsePart
    : JINJA_ELSE
    ;

endIfPart
    : JINJA_ENDIF
    ;

// ---------------------------
// SET (assignment) inside block
// {% set name = expr %}
// ---------------------------
setStmt
    : JINJA_SET jinjaBlockExpr*
    ;

// ---------------------------
// Simple block (custom tags, raw, etc.)
// ---------------------------
simpleStmt
    : JINJA_BLOCK_IDENT jinjaBlockExpr*
    ;

// ---------------------------
// jinjaBlockExpr
// Accept many block tokens (identifiers, numbers, strings, punctuation, operators, other)
// This is intentionally permissive so conditions like "price > 5" parse even if lexer maps '>' to OTHER.
// ---------------------------
jinjaBlockExpr
    : ( JINJA_BLOCK_IDENT
      | JINJA_BLOCK_NUMBER
      | JINJA_BLOCK_STRING
      | JINJA_BLOCK_EQ
      | JINJA_BLOCK_DOT
      | JINJA_BLOCK_COMMA
      | JINJA_BLOCK_COLON
      | JINJA_BLOCK_LP
      | JINJA_BLOCK_RP
      | JINJA_BLOCK_LB
      | JINJA_BLOCK_RB
      | JINJA_BLOCK_OTHER
      | JINJA_OP        // include if lexer defines it in block mode
      )+
    ;

// ===========================
// JINJA COMMENT {# ... #}
// ===========================
jinjaComment
    : JINJA_COMMENT_OPEN (JINJA_COMMENT_TEXT)? JINJA_COMMENT_CLOSE    #Jinja_Comment
    ;

// ===========================
// FOOTER: forward TEXT and OTHER tokens (lexer)
 // (these two forwardings let parser refer to lexer tokens named TEXT/OTHER)
// ===========================
//text: TEXT ;

