parser grammar PythonFlaskParser;

options { tokenVocab=PythonLexer; }

// ---------------------------
// Root
// ---------------------------
file_input
    : (stmt | decorated_def | NEWLINE)* EOF      #FileInputNode
    ;

// ---------------------------
// Decorators
// ---------------------------
decorator
    : AT dottedName (LPAREN decoratorArgs? RPAREN)? NEWLINE   #DecoratorNode
    ;

decoratorArgs
    : expr (COMMA expr)* (COMMA namedDecoratorArgs)?
    | namedDecoratorArgs
    ;

namedDecoratorArgs
    : NAME ASSIGN expr (COMMA NAME ASSIGN expr)*              #NamedDecoratorArgsNode
    ;

decorated_def
    : decorator+ (function_def | class_def)                   #DecoratedDefNode
    ;

// ---------------------------
// Statements
// ---------------------------
stmt
    : simple_stmt        #SimpleStmtNode
    | compound_stmt      #CompoundStmtNode
    ;

simple_stmt
    : small_stmt (SEMICOLON small_stmt)* NEWLINE              #SimpleStmtLineNode
    ;

small_stmt
    : expr_stmt
    | return_stmt
    | import_stmt
    | pass_stmt
    | break_stmt
    | continue_stmt
    ;

// ---------------------------
// Expression Statements
// ---------------------------
expr_stmt
    : target ASSIGN expr
    | expr
    ;

// ---------------------------
// Targets
// ---------------------------
target
    : NAME
    | atom index
    ;

// ---------------------------
// Simple keywords
// ---------------------------
pass_stmt     : PASS NEWLINE? ;
break_stmt    : BREAK NEWLINE? ;
continue_stmt : CONTINUE NEWLINE? ;
return_stmt   : RETURN expr? NEWLINE? ;

// ---------------------------
// Compound statements
// ---------------------------
compound_stmt
    : if_stmt
    | while_stmt
    | for_stmt
    | function_def
    | class_def
    | with_stmt
    ;

function_def
    : DEF NAME LPAREN parameterList? RPAREN COLON suite    #FunctionDefNode
    ;

parameterList
    : NAME (COMMA NAME)*                                   #ParameterListNode
    ;

class_def
    : CLASS NAME (LPAREN argList? RPAREN)? COLON suite     #ClassDefNode
    ;

with_stmt
    : WITH expr (AS NAME)? COLON suite                     #WithStmtNode
    ;

if_stmt
    : IF expr COLON suite
      (ELIF expr COLON suite)*
      (ELSE COLON suite)?                                 #IfStmtNode
    ;

for_stmt
    : FOR target IN expr COLON suite                       #ForStmtNode
    ;

while_stmt
    : WHILE expr COLON suite                               #WhileStmtNode
    ;

// ---------------------------
// Suite
// ---------------------------
suite
    : simple_stmt
    | NEWLINE (stmt | NEWLINE)+ NEWLINE
    ;

// ---------------------------
// Imports
// ---------------------------
import_stmt
    : IMPORT dottedName (COMMA dottedName)*
    | FROM (DOT* | dottedName) IMPORT (MUL | importTargets)
    ;

dottedName : NAME (DOT NAME)* ;
importTargets : NAME (AS NAME)? (COMMA NAME (AS NAME)? )* ;

// ---------------------------
// Expressions
// ---------------------------
expr : or_test ;

or_test : and_test (OR and_test)* ;
and_test : not_test (AND not_test)* ;
not_test : NOT not_test | comparison ;
comparison : arithExpr (compOp arithExpr)* ;
compOp : EQ | NEQ | LT | GT | LE | GE ;

arithExpr : term ( (ADD | SUB) term )* ;
term : factor ( (MUL | DIV | MOD) factor )* ;
factor : (ADD | SUB | NOT)? power ;
power : atom (MUL MUL factor)? ;

atom : atom_base trailer* ;
atom_base
    : NAME
    | NUMBER
    | STRING
    | list_literal
    | LPAREN expr RPAREN
    | TRUE
    | FALSE
    | NONE
    ;

trailer
    : DOT NAME
    | LPAREN NEWLINE? argList? NEWLINE? RPAREN
    | index
    ;

index : LBRACK expr RBRACK ;

argList
    : expr (COMMA expr)* (COMMA namedArgList)?
    | namedArgList
    ;

namedArgList
    : NAME ASSIGN expr (COMMA NEWLINE NAME ASSIGN expr)*
    ;

list_literal
    : LBRACK (expr (COMMA expr)*)? RBRACK ;
