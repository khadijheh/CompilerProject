parser grammar WebParser;

options { tokenVocab=WebCombinedLexer; }

// ===========================
// ROOT
// ===========================
//cssFile
//    : (cssRule | CSS_WS | CSS_BLOCK_WS | CSS_BLOCK_OTHER)* EOF   #CssFileNode
//    ;

template
    : contentItem* EOF                           #TemplateNode
    ;

// ---------------------- CSS FILE ENTRY ----------------------

// ===========================
// CONTENT ITEMS
// ===========================
contentItem
    : cssStyleBlock                               #ContentCssStyle
    | htmlElement                                 #ContentHtmlElement
    | htmlText                                     #ContentHtmlText
    | jinjaExpression                              #ContentJinjaExpression
    | jinjaBlock                                   #ContentJinjaBlock
    | jinjaComment                                 #ContentJinjaComment
    ;

// =====================================================
//  HTML ELEMENTS
// =====================================================

htmlElement
    : htmlVoidElement                              #HtmlElementVoid
    | htmlNormalElement                            #HtmlElementNormal
    ;

htmlVoidElement
    : HTML_OPEN HTML_IDENTIFIER htmlAttribute* HTML_TAG_SELF_CLOSE   #VoidElementNode
    ;

htmlNormalElement
    : HTML_OPEN HTML_IDENTIFIER htmlAttribute* HTML_TAG_CLOSE
      contentItem*
      HTML_CLOSE_OPEN HTML_IDENTIFIER HTML_TAG_CLOSE                 #NormalElementNode
    ;

// =====================================================
//  HTML ATTRIBUTES
// =====================================================

htmlAttribute
    : HTML_IDENTIFIER EQUALS htmlAttributeValue    #HtmlAttributeAssignment
    | HTML_IDENTIFIER                              #HtmlAttributeBoolean
    ;

htmlAttributeValue
    : dqValue                                      #AttrDoubleQuoted
    | sqValue                                      #AttrSingleQuoted
    ;

dqValue
    : HTML_ATTR_VALUE_OPEN_DQ htmlAttrValueItem* HTML_ATTR_VALUE_CLOSE_DQ   #DoubleQuotedValue
    ;

sqValue
    : HTML_ATTR_VALUE_OPEN_SQ htmlAttrValueItem* HTML_ATTR_VALUE_CLOSE_SQ   #SingleQuotedValue
    ;

htmlAttrValueItem
    : HTML_ATTR_VALUE_TEXT                         #AttrTextNode
    | jinjaExpression                              #AttrJinjaExpressionNode
    | jinjaBlock                                   #AttrJinjaBlockNode
    | jinjaComment                                 #AttrJinjaCommentNode
    ;

// =====================================================
//  TEXT
// =====================================================

htmlText
    : TEXT                                         #HtmlTextNode
    ;

// ===========================
// CSS (<style> ... </style>)
// ===========================
cssStyleBlock
    : CSS_STYLE_TAG cssRules CSS_STYLE_CLOSE       #CssStyleNode
    ;

cssRules
    : cssRule*                                     #CssRulesNode
    ;

cssRule
    : cssSelectorList CSS_LBRACE cssDeclarations CSS_RBRACE   #CssRuleNode
    ;

cssSelectorList
    : cssSelector (CSS_COMMA cssSelector)*         #CssSelectorListNode
    ;
cssSelector
    : selectorPart (CSS_WS+ selectorPart)*         #CssSelectorNode
    ;selectorPart
         : simpleSelector+                       #SelectorPartNode
         ;

     simpleSelector
         : typeSelector                           #TypeSelectorNode
         | classSelector                          #ClassSelectorNode
         | idSelector                             #IdSelectorNode
         | pseudoSelector                          #PseudoSelectorNode
         | attributeSelector                       #AttributeSeNode
         ;

     typeSelector
         : CSS_IDENT                               #TypeSelectorIdNode
         ;

     classSelector
         : CSS_DOT CSS_IDENT                        #ClassSelectorIdNode
         ;

     idSelector
         : CSS_HASH CSS_IDENT                       #IdSelectorIdNode
         ;

     pseudoSelector
         : CSS_COLON CSS_IDENT                      #PseudoSelectorIdNode
         ;

     attributeSelector
         : CSS_LBRACK CSS_IDENT CSS_EQUAL (CSS_STRING | CSS_IDENT) CSS_RBRACK   #AttributeSelectorNode
         ;


/* ---------- DECLARATIONS ---------- */

cssDeclarations
    : cssDeclaration*
      #CssDeclarationsNode
    ;
cssDeclaration
    : CSS_IDENT CSS_COLON cssValue CSS_SEMI?
      #CssDeclarationNode
    ;
cssValue
    : cssValueAtom+
      #CssValueNode
    ;

cssValueAtom
    : CSS_COLOR_HEX
    | CSS_NUMBER
    | CSS_UNIT
    | CSS_STRING
    | CSS_IDENT
    | CSS_COMMA
    | CSS_LP
    | CSS_RP
    |CSS_MINUS
    ;



// ===========================
// JINJA EXPRESSION {{ ... }}
// ===========================
jinjaExpression
    : JINJA_EXPR_OPEN jinjaExprBody JINJA_EXPR_CLOSE    #JinjaExpressionNode
    ;

jinjaExprBody
    : (
        JINJA_IDENT
      | JINJA_NUMBER
      | JINJA_STRING
      | JINJA_OP
      | JINJA_LP
      | JINJA_RP
      | JINJA_LB
      | JINJA_RB
      | JINJA_COMMA
      | JINJA_COLON
      | JINJA_DOT
      | JINJA_OTHER
      )*                                            #JinjaExprBodyNode
    ;

// ===========================
// JINJA BLOCK {% ... %}
// ===========================
jinjaBlock
    : JINJA_BLOCK_OPEN jinjaBlockInner JINJA_BLOCK_CLOSE    #JinjaBlockNode
    ;

jinjaBlockInner
    : forStart               #BlockForStartNode
    | forEnd                 #BlockForEndNode
    | ifStart                #BlockIfStartNode
    | elifPart               #BlockElifNode
    | elsePart               #BlockElseNode
    | endIfPart              #BlockEndIfNode
    | setStmt                #BlockSetNode
    | simpleStmt             #BlockSimpleNode
    ;

// ---------------------------
// FOR BLOCK
// ---------------------------
forStart
    : JINJA_FOR jinjaBlockExpr* JINJA_IN jinjaBlockExpr*     #ForStartNode
    ;

forEnd
    : JINJA_ENDFOR                                            #ForEndNode
    ;

// ---------------------------
// IF / ELSEIF / ELSE / ENDIF
// ---------------------------
ifStart
    : JINJA_IF jinjaBlockExpr*                                #IfStartNode
    ;

elifPart
    : JINJA_ELIF jinjaBlockExpr*                              #ElifPartNode
    ;

elsePart
    : JINJA_ELSE                                              #ElsePartNode
    ;

endIfPart
    : JINJA_ENDIF                                             #EndIfPartNode
    ;

// ---------------------------
// SET STATEMENT
// ---------------------------
setStmt
    : JINJA_SET jinjaBlockExpr*                               #SetStmtNode
    ;

// ---------------------------
// SIMPLE CUSTOM BLOCK
// ---------------------------
simpleStmt
    : JINJA_BLOCK_IDENT jinjaBlockExpr*                       #SimpleStmtNode
    ;

// ---------------------------
// BLOCK EXPR
// ---------------------------
jinjaBlockExpr
    : (
        JINJA_BLOCK_IDENT
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
      | JINJA_OP
      )+                                                   #JinjaBlockExprNode
    ;

// ===========================
// JINJA COMMENT
// ===========================
jinjaComment
    : JINJA_COMMENT_OPEN JINJA_COMMENT_TEXT? JINJA_COMMENT_CLOSE    #JinjaCommentNode
    ;
