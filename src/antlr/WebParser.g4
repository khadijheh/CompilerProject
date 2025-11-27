parser grammar WebParser;

options {
    tokenVocab = WebLexer;
}

// ===== DOCUMENT LEVEL =====
program:statement+ EOF;

statement:
    htmlContent
    | jinjaContent
    | cssContent
    | flaskContent
    | TEXT_CONTENT
    ;



// ===== HTML CONTENT =====
htmlContent:
    doctype |
    htmlElement |
    htmlText
    ;

doctype: DOCTYPE_OPEN DOCTYPE_CONTENT DOCTYPE_CLOSE;

htmlElement:
    // FORM ELEMENTS
    FORM_TAG htmlAttribute* HTML_TAG_CLOSE formContent HTML_TAG_END FORM_TAG HTML_TAG_CLOSE #formElementTag
    | INPUT_TAG htmlAttribute* (HTML_TAG_CLOSE | HTML_TAG_SELF_CLOSE) #inputElementTag
    | TEXTAREA_TAG htmlAttribute* HTML_TAG_CLOSE htmlText? HTML_TAG_END TEXTAREA_TAG HTML_TAG_CLOSE #textareaElementTag
    | BUTTON_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END BUTTON_TAG HTML_TAG_CLOSE #buttonElementTag
    | LABEL_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END LABEL_TAG HTML_TAG_CLOSE #labelElementTag
    | SELECT_TAG htmlAttribute* HTML_TAG_CLOSE optionContent HTML_TAG_END SELECT_TAG HTML_TAG_CLOSE #selectElementTag
    | OPTION_TAG htmlAttribute* (HTML_TAG_CLOSE htmlContent* HTML_TAG_END OPTION_TAG HTML_TAG_CLOSE | HTML_TAG_SELF_CLOSE) #optionElementTag

    // STRUCTURAL ELEMENTS
    | DIV_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END DIV_TAG HTML_TAG_CLOSE #divElementTag
    | TABLE_TAG htmlAttribute* HTML_TAG_CLOSE tableContent HTML_TAG_END TABLE_TAG HTML_TAG_CLOSE #tableElementTag
    | TR_TAG htmlAttribute* HTML_TAG_CLOSE trContent HTML_TAG_END TR_TAG HTML_TAG_CLOSE #trElementTag
    | TD_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END TD_TAG HTML_TAG_CLOSE #tdElementTag
    | TH_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END TH_TAG HTML_TAG_CLOSE #thElementTag
    | UL_TAG htmlAttribute* HTML_TAG_CLOSE ulContent HTML_TAG_END UL_TAG HTML_TAG_CLOSE #ulElementTag
    | LI_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END LI_TAG HTML_TAG_CLOSE #liElementTag
    | A_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END A_TAG HTML_TAG_CLOSE #aElementTag
    | IMG_TAG htmlAttribute* HTML_TAG_SELF_CLOSE #imgElementTag
    | SPAN_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END SPAN_TAG HTML_TAG_CLOSE #spanElementTag
    | P_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END P_TAG HTML_TAG_CLOSE #pElementTag

    // HEAD ELEMENTS
    | META_TAG htmlAttribute* HTML_TAG_SELF_CLOSE #metaElementTag
    | TITLE_TAG htmlAttribute* HTML_TAG_CLOSE htmlText HTML_TAG_END TITLE_TAG HTML_TAG_CLOSE #titleElementTag
    | LINK_TAG htmlAttribute* HTML_TAG_SELF_CLOSE #linkElementTag

    // TEXT ELEMENTS
    | H1_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END H1_TAG HTML_TAG_CLOSE #h1ElementTag
    | H2_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END H2_TAG HTML_TAG_CLOSE #h2ElementTag
    | H3_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END H3_TAG HTML_TAG_CLOSE #h3ElementTag

    // STYLE AND SCRIPT
    | STYLE_TAG htmlAttribute* HTML_TAG_CLOSE cssContent HTML_TAG_END STYLE_TAG HTML_TAG_CLOSE #styleElementTag
    | SCRIPT_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END SCRIPT_TAG HTML_TAG_CLOSE #scriptElementTag

    // ROOT ELEMENTS
    | HTML_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END HTML_TAG HTML_TAG_CLOSE #htmlRootElement
    | HEAD_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END HEAD_TAG HTML_TAG_CLOSE #headRootElement
    | BODY_TAG htmlAttribute* HTML_TAG_CLOSE htmlContent* HTML_TAG_END BODY_TAG HTML_TAG_CLOSE #bodyRootElement

    // GENERAL TAGS (fallback)
    | HTML_TAG_OPEN HTML_TAG_NAME htmlAttribute* (HTML_TAG_CLOSE htmlContent* HTML_TAG_END HTML_TAG_NAME HTML_TAG_CLOSE | HTML_TAG_SELF_CLOSE) #genericElementTag
    ;

htmlAttribute:
    HTML_ATTR_NAME (EQUALS HTML_ATTR_VALUE)? #genericAttribute
    | HTML_ATTR_ACTION (EQUALS HTML_ATTR_VALUE)? #actionAttribute
    | HTML_ATTR_METHOD (EQUALS HTML_ATTR_VALUE)? #methodAttribute
    | HTML_ATTR_NAME_ATTR (EQUALS HTML_ATTR_VALUE)? #nameAttribute
    | HTML_ATTR_TYPE (EQUALS HTML_ATTR_VALUE)? #typeAttribute
    | HTML_ATTR_REQUIRED #requiredAttribute
    | HTML_ATTR_ENCTYPE (EQUALS HTML_ATTR_VALUE)? #enctypeAttribute
    | HTML_ATTR_SRC (EQUALS HTML_ATTR_VALUE)? #srcAttribute
    | HTML_ATTR_HREF (EQUALS HTML_ATTR_VALUE)? #hrefAttribute
    | HTML_ATTR_CLASS (EQUALS HTML_ATTR_VALUE)? #classAttribute
    | HTML_ATTR_ID (EQUALS HTML_ATTR_VALUE)? #idAttribute
    | HTML_ATTR_STYLE (EQUALS HTML_ATTR_VALUE)? #styleAttribute
    | HTML_ATTR_FOR (EQUALS HTML_ATTR_VALUE)? #forAttribute
    | HTML_ATTR_PLACEHOLDER (EQUALS HTML_ATTR_VALUE)? #placeholderAttribute
    | HTML_ATTR_VALUE_ATTR (EQUALS HTML_ATTR_VALUE)? #valueAttribute
    | HTML_ATTR_ROWS (EQUALS HTML_ATTR_VALUE)? #rowsAttribute
    | HTML_ATTR_COLS (EQUALS HTML_ATTR_VALUE)? #colsAttribute
    | HTML_ATTR_SELECTED #selectedAttribute
    | HTML_ATTR_DISABLED #disabledAttribute
    | HTML_ATTR_READONLY #readonlyAttribute
    | HTML_ATTR_CHARSET (EQUALS HTML_ATTR_VALUE)? #charsetAttribute
    | HTML_ATTR_CONTENT (EQUALS HTML_ATTR_VALUE)? #contentAttribute
    | HTML_ATTR_REL (EQUALS HTML_ATTR_VALUE)? #relAttribute
    | HTML_ATTR_ALT (EQUALS HTML_ATTR_VALUE)? #altAttribute
    | HTML_ATTR_TARGET (EQUALS HTML_ATTR_VALUE)? #targetAttribute
    | HTML_ATTR_STEP (EQUALS HTML_ATTR_VALUE)? #stepAttribute
    | HTML_ATTR_ACCEPT (EQUALS HTML_ATTR_VALUE)? #acceptAttribute
    | HTML_ATTR_LANG (EQUALS HTML_ATTR_VALUE)? #langAttribute
    | HTML_ATTR_WIDTH (EQUALS HTML_ATTR_VALUE)? #widthAttribute
    | HTML_ATTR_HEIGHT (EQUALS HTML_ATTR_VALUE)? #heightAttribute
    ;

// ==== FIXED CONTENT RULES ====
formContent: (htmlElement | jinjaContent | TEXT_CONTENT | WS)*;
tableContent: (htmlElement | TEXT_CONTENT | WS)*;
trContent: (htmlElement | TEXT_CONTENT | WS)*;
ulContent: (htmlElement | TEXT_CONTENT | WS)*;
optionContent: (htmlElement | TEXT_CONTENT | WS)*;
htmlText: (TEXT_CONTENT | WS)+;

// ===== JINJA2 CONTENT =====
jinjaContent:
    jinjaExpression |
    jinjaBlock
    ;

jinjaExpression:
    JINJA_EXPR_OPEN jinjaExprContent JINJA_EXPR_CLOSE #jinjaExpressionNode
    ;

jinjaExprContent:
    JINJA_URL_FOR jinjaFunctionArgs #urlForExpression
    | JINJA_GET_FLASHED jinjaFunctionArgs #getFlashedExpression
    | JINJA_PRODUCT_ACCESS #productAccessExpression
    | JINJA_VARIABLE (DOT JINJA_VARIABLE)* (JINJA_FILTER)* #variableExpression
    | JINJA_STRING #stringExpression
    | JINJA_NUMBER #numberExpression
    | jinjaExprContent JINJA_OPERATOR jinjaExprContent #binaryExpression
    | JINJA_VARIABLE #simpleVariableExpression
    ;

jinjaFunctionArgs: (jinjaFuncArg (COMMA jinjaFuncArg)*)? JINJA_FUNC_CLOSE #functionArguments;
jinjaFuncArg:
    JINJA_STRING #stringArgument
    | JINJA_VARIABLE #variableArgument
    | JINJA_VARIABLE EQUALS (JINJA_STRING | JINJA_VARIABLE) #keywordArgument
    ;

jinjaBlock:
    JINJA_BLOCK_OPEN jinjaBlockContent JINJA_BLOCK_CLOSE #jinjaBlockNode
    ;

jinjaBlockContent:
    JINJA_FOR JINJA_BLOCK_VAR JINJA_IN jinjaExprContent #forBlock
    | JINJA_IF jinjaExprContent #ifBlock
    | JINJA_ELIF jinjaExprContent #elifBlock
    | JINJA_ELSE #elseBlock
    | JINJA_ENDIF #endifBlock
    | JINJA_ENDFOR #endforBlock
    | JINJA_BLOCK JINJA_BLOCK_STRING #blockBlock
    | JINJA_ENDBLOCK #endblockBlock
    | JINJA_EXTENDS JINJA_BLOCK_STRING #extendsBlock
    | JINJA_INCLUDE JINJA_BLOCK_STRING #includeBlock
    | JINJA_SET JINJA_BLOCK_VAR EQUALS jinjaExprContent #setBlock
    | JINJA_WITH contextBlock #withBlock
    | JINJA_ENDWITH #endwithBlock
    | JINJA_MACRO JINJA_BLOCK_VAR LPAREN macroParams? RPAREN #macroBlock
    | JINJA_ENDMACRO #endmacroBlock
    | JINJA_FROM JINJA_BLOCK_STRING JINJA_IMPORT JINJA_BLOCK_VAR #importBlock
    ;

contextBlock: JINJA_BLOCK_VAR EQUALS jinjaExprContent #contextAssignment;
macroParams: JINJA_BLOCK_VAR (COMMA JINJA_BLOCK_VAR)* #macroParameters;

// ===== CSS CONTENT =====
cssContent: cssRule*;

cssRule:
    CSS_SELECTOR cssBlock #selectorRule
    | CSS_CLASS cssBlock #classRule
    | CSS_ID cssBlock #idRule
    | CSS_SELECTOR CSS_PSEUDO cssBlock #pseudoRule
    ;

cssBlock: CSS_BRACE_OPEN cssDeclaration* CSS_BLOCK_END #cssBlockNode;

cssDeclaration:
    CSS_PROPERTY COLON CSS_VALUE (CSS_IMPORTANT)? SEMICOLON #genericDeclaration
    | CSS_WIDTH COLON CSS_VALUE SEMICOLON #widthDeclaration
    | CSS_HEIGHT COLON CSS_VALUE SEMICOLON #heightDeclaration
    | CSS_COLOR COLON CSS_VALUE SEMICOLON #colorDeclaration
    | CSS_BACKGROUND COLON CSS_VALUE SEMICOLON #backgroundDeclaration
    | CSS_BACKGROUND_COLOR COLON CSS_VALUE SEMICOLON #backgroundColorDeclaration
    | CSS_MARGIN COLON CSS_VALUE SEMICOLON #marginDeclaration
    | CSS_PADDING COLON CSS_VALUE SEMICOLON #paddingDeclaration
    | CSS_FONT_FAMILY COLON CSS_VALUE SEMICOLON #fontFamilyDeclaration
    | CSS_FONT_SIZE COLON CSS_VALUE SEMICOLON #fontSizeDeclaration
    | CSS_FONT_WEIGHT COLON CSS_VALUE SEMICOLON #fontWeightDeclaration
    | CSS_BORDER COLON CSS_VALUE SEMICOLON #borderDeclaration
    | CSS_BORDER_RADIUS COLON CSS_VALUE SEMICOLON #borderRadiusDeclaration
    | CSS_DISPLAY COLON CSS_VALUE SEMICOLON #displayDeclaration
    | CSS_POSITION COLON CSS_VALUE SEMICOLON #positionDeclaration
    | CSS_TEXT_ALIGN COLON CSS_VALUE SEMICOLON #textAlignDeclaration
    | CSS_TEXT_DECORATION COLON CSS_VALUE SEMICOLON #textDecorationDeclaration
    | CSS_BOX_SHADOW COLON CSS_VALUE SEMICOLON #boxShadowDeclaration
    | CSS_OPACITY COLON CSS_VALUE SEMICOLON #opacityDeclaration
    | CSS_CURSOR COLON CSS_VALUE SEMICOLON #cursorDeclaration
    | CSS_TRANSITION COLON CSS_VALUE SEMICOLON #transitionDeclaration
    | CSS_LINE_HEIGHT COLON CSS_VALUE SEMICOLON #lineHeightDeclaration
    | CSS_MAX_WIDTH COLON CSS_VALUE SEMICOLON #maxWidthDeclaration
    | CSS_MIN_WIDTH COLON CSS_VALUE SEMICOLON #minWidthDeclaration
    | CSS_MAX_HEIGHT COLON CSS_VALUE SEMICOLON #maxHeightDeclaration
    | CSS_MIN_HEIGHT COLON CSS_VALUE SEMICOLON #minHeightDeclaration
    | CSS_FLOAT COLON CSS_VALUE SEMICOLON #floatDeclaration
    | CSS_OVERFLOW COLON CSS_VALUE SEMICOLON #overflowDeclaration
    | CSS_Z_INDEX COLON CSS_VALUE SEMICOLON #zIndexDeclaration
    | CSS_LIST_STYLE COLON CSS_VALUE SEMICOLON #listStyleDeclaration
    | CSS_TABLE_LAYOUT COLON CSS_VALUE SEMICOLON #tableLayoutDeclaration
    | CSS_BORDER_COLLAPSE COLON CSS_VALUE SEMICOLON #borderCollapseDeclaration
    ;

// ===== FLASK CONTENT =====
flaskContent:
    PYTHON_FLASK_IMPORT flaskImport #flaskImportNode
    | PYTHON_OS_IMPORT #osImportNode
    | PYTHON_SQLALCHEMY_IMPORT #sqlAlchemyImportNode
    | PYTHON_FLASK_APP flaskRoute #flaskRouteNode
    | PYTHON_CLASS_DEF flaskClass #flaskClassNode
    | PYTHON_DEF flaskFunction #flaskFunctionNode
    ;

flaskImport:
    PYTHON_FLASK (COMMA importItem)* #flaskImportList
    ;

importItem:
    PYTHON_RENDER_TEMPLATE #renderTemplateImport
    | PYTHON_REQUEST #requestImport
    | PYTHON_REDIRECT #redirectImport
    | PYTHON_URL_FOR #urlForImport
    | PYTHON_SESSION #sessionImport
    | PYTHON_FLASH #flashImport
    ;

flaskRoute:
    LPAREN routePath (COMMA routeMethods)? RPAREN #routeDefinition
    ;

routePath: PYTHON_ROUTE_PATH #routePathNode;
routeMethods: PYTHON_METHODS EQUALS LBRACKET httpMethods RBRACKET #routeMethodsNode;
httpMethods: httpMethod (COMMA httpMethod)* #httpMethodsList;
httpMethod:
    PYTHON_GET #getMethod
    | PYTHON_POST #postMethod
    | PYTHON_DELETE #deleteMethod
    ;

flaskClass:
    PYTHON_CLASS_NAME (PYTHON_INHERITS)? #classDefinition
    ;

flaskFunction:
    PYTHON_FUNC_NAME PYTHON_PARAMS #functionDefinition
    ;