parser grammar PythonFlaskParser;

options { tokenVocab=PythonLexer; }

// ---------------------------
// Root
// ---------------------------
file_input
    : (stmt | decorated_def | NEWLINE)* EOF      #file_inputNode
    ;

// ---------------------------
// Decorators
// ---------------------------
decorator
    : AT dottedName (LPAREN decoratorArgs? RPAREN)? NEWLINE   #decoratorNode
    ;

decoratorArgs
    : expr (COMMA expr)* (COMMA namedDecoratorArgs)?          #decoratorArgsNode
    | namedDecoratorArgs                                      #decoratorArgsNamedNode
    ;

namedDecoratorArgs
    : NAME ASSIGN expr (COMMA NAME ASSIGN expr)*              #namedDecoratorArgsNode
    ;

decorated_def
    : decorator+ (function_def | class_def)                   #decorated_defNode
    ;

// ---------------------------
// Statements
// ---------------------------
stmt
    : simple_stmt        #stmtSimpleNode
    | compound_stmt      #stmtCompoundNode
    ;

simple_stmt
    : small_stmt (SEMICOLON small_stmt)* NEWLINE              #simple_stmtNode
    ;

small_stmt
    : expr_stmt                  #small_stmtExprNode
    | return_stmt NEWLINE?       #small_stmtReturnNode
    | import_stmt                #small_stmtImportNode
    | pass_stmt NEWLINE?         #small_stmtPassNode
    | break_stmt NEWLINE?        #small_stmtBreakNode
    | continue_stmt NEWLINE?     #small_stmtContinueNode
    ;

expr_stmt
    : target ASSIGN expr         #expr_stmtAssignNode
    | expr                       #expr_stmtExprOnlyNode
    ;

target
    : NAME                       #targetNameNode
    | atom index                 #targetIndexNode
    ;

pass_stmt     : PASS NEWLINE?        #pass_stmtNode ;
break_stmt    : BREAK NEWLINE?       #break_stmtNode ;
continue_stmt : CONTINUE NEWLINE?    #continue_stmtNode ;
return_stmt   : RETURN expr? NEWLINE? #return_stmtNode ;

// ---------------------------
// Compound statements
// ---------------------------
compound_stmt
    : if_stmt        #compound_ifNode
    | while_stmt     #compound_whileNode
    | for_stmt       #compound_forNode
    | function_def   #compound_functionNode
    | class_def      #compound_classNode
    | with_stmt      #compound_withNode
    ;

function_def
    : DEF NAME LPAREN parameterList? RPAREN COLON suite    #function_defNode
    ;

parameterList
    : NAME (COMMA NAME)*                                   #parameterListNode
    ;

class_def
    : CLASS NAME (LPAREN argList? RPAREN)? COLON suite     #class_defNode
    ;

with_stmt
    : WITH expr (AS NAME)? COLON suite                     #with_stmtNode
    ;

if_stmt
    : IF expr COLON suite
      (ELIF expr COLON suite)*
      (ELSE COLON suite)?                                 #if_stmtNode
    ;

for_stmt
    : FOR target IN expr COLON suite                       #for_stmtNode
    ;

while_stmt
    : WHILE expr COLON suite                               #while_stmtNode
    ;

// ---------------------------
// Suite
// ---------------------------
suite
    : simple_stmt                               #suiteSimpleNode
    | NEWLINE (stmt | NEWLINE)+ NEWLINE         #suiteBlockNode
    ;

// ---------------------------
// Imports
// ---------------------------
import_stmt
    : IMPORT dottedName (COMMA dottedName)*         #import_stmtSimpleNode
    | FROM (DOT* | dottedName) IMPORT (MUL | importTargets)   #import_stmtFromNode
    ;

dottedName : NAME (DOT NAME)*                       #dottedNameNode ;
importTargets : NAME (AS NAME)? (COMMA NAME (AS NAME)? )*   #importTargetsNode ;

// ---------------------------
// Expressions
// ---------------------------
expr : or_test                       #exprNode ;

or_test
    : and_test (OR and_test)*        #or_testNode
    ;

and_test
    : not_test (AND not_test)*       #and_testNode
    ;

not_test
    : NOT not_test                   #not_testNode
    | comparison                     #not_testCmpNode
    ;

comparison
    : arithExpr (compOp arithExpr)*  #comparisonNode
    ;

compOp : EQ | NEQ | LT | GT | LE | GE   #compOpNode ;

arithExpr
    : term ( (ADD | SUB) term )*        #arithExprNode
    ;

term
    : factor ( (MUL | DIV | MOD) factor )*   #termNode
    ;

factor
    : (ADD | SUB | NOT)? power          #factorNode
    ;

power
    : atom (MUL MUL factor)?            #powerNode
    ;

atom
    : atom_base trailer*                #atomNode
    ;

atom_base
    : NAME                              #atomBaseNameNode
    | NUMBER                            #atomBaseNumberNode
    | STRING                            #atomBaseStringNode
    | list_literal                      #atomBaseListNode
    | LPAREN expr RPAREN                #atomBaseParNode
    | TRUE                              #atomBaseTrueNode
    | FALSE                             #atomBaseFalseNode
    | NONE                              #atomBaseNoneNode
    ;

trailer
    : DOT NAME                          #trailerAttrNode
    | LPAREN NEWLINE? argList? NEWLINE? RPAREN   #trailerCallNode
    | index                             #trailerIndexNode
    ;

index : LBRACK expr RBRACK              #indexNode ;

argList
    : expr (COMMA expr)* (COMMA namedArgList)?  #argListNode
    | namedArgList                              #argListNamedOnlyNode
    ;

namedArgList
    : NAME ASSIGN expr (COMMA NEWLINE? NAME ASSIGN expr)*   #namedArgListNode
    ;

list_literal
    : LBRACK (expr (COMMA expr)*)? RBRACK         #list_literalNode
    ;
