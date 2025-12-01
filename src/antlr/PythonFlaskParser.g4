parser grammar PythonFlaskParser;

options { tokenVocab=PythonLexer; }

// ---------------------------
// Root
// ---------------------------
file_input
    : (stmt | decorated_def | NEWLINE)* EOF
    ;

// ---------------------------
// Decorators & decorated defs
// ---------------------------
decorator
    : AT dottedName (LPAREN decoratorArgs? RPAREN)? NEWLINE
    ;
decoratorArgs
    : expr (COMMA expr)* (COMMA namedDecoratorArgs)?
    | namedDecoratorArgs
    ;

namedDecoratorArgs
    : NAME ASSIGN expr (COMMA NAME ASSIGN expr)*
    ;

decorated_def
    : decorator+ (function_def | class_def)
    ;

// ---------------------------
// Statements
// ---------------------------
stmt
    : simple_stmt
    | compound_stmt
    ;

simple_stmt
    : small_stmt (COMMA small_stmt)* NEWLINE
    ;

small_stmt
    : expr_stmt
    | return_stmt
    | import_stmt
    | pass_stmt
    | break_stmt
    | continue_stmt
    ;

expr_stmt
    : target ASSIGN expr               #AssignNode
    | expr                             #ExprStatementNode
    ;

target
    : NAME                             #TargetNameNode
    | atom index                       #TargetIndexNode
    ;

// control small stmts
pass_stmt   : PASS ;
break_stmt  : BREAK ;
continue_stmt : CONTINUE ;
return_stmt : RETURN expr? ;

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
    : DEF NAME LPAREN parameterList? RPAREN COLON NEWLINE INDENT suite DEDENT
    ;

parameterList
    : NAME (COMMA NAME)*
    ;

class_def
    : CLASS NAME (LPAREN argList? RPAREN)? COLON NEWLINE INDENT suite DEDENT
    ;

with_stmt
    : WITH expr (AS NAME)? COLON NEWLINE INDENT suite DEDENT
    ;

if_stmt
    : IF expr COLON NEWLINE INDENT suite DEDENT
      (ELIF expr COLON NEWLINE INDENT suite DEDENT)*
      (ELSE COLON NEWLINE INDENT suite DEDENT)?
    ;

for_stmt
    : FOR target IN expr COLON NEWLINE INDENT suite DEDENT
    ;

while_stmt
    : WHILE expr COLON NEWLINE INDENT suite DEDENT
    ;

// suite can be one or more stmts (simple or compound)
suite
    : stmt+
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
// Expressions (safe postfix handling)
// ---------------------------

// top-level expression
expr
    : or_test
    ;

or_test
    : and_test (OR and_test)*
    ;

and_test
    : not_test (AND not_test)*
    ;

not_test
    : NOT not_test
    | comparison
    ;

// comparisons
comparison
    : arithExpr (compOp arithExpr)*
    ;

compOp
    : EQ | NEQ | LT | GT | LE | GE
    ;

// arithmetic
arithExpr
    : term ( (ADD | SUB) term )*
    ;

term
    : factor ( (MUL | DIV | MOD) factor )*
    ;

factor
    : (ADD | SUB | NOT)? power
    ;

power
    : atom (MUL MUL factor)?
    ;

// atom + trailers (avoids left recursion explosion)
atom
    : atom_base trailer*
    ;

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

// trailer: attribute, call, indexing
trailer
    : DOT NAME
    | LPAREN argList? RPAREN
    | index
    ;

// indexing
index
    : LBRACK expr RBRACK
    ;

// arguments
argList
    : expr (COMMA expr)* (COMMA namedArgList)?
    | namedArgList
    ;

namedArgList
    : NAME ASSIGN expr (COMMA NAME ASSIGN expr)*
    ;

// list literal (used e.g. methods=['GET','POST'])
list_literal
    : LBRACK (expr (COMMA expr)*)? RBRACK
    ;

// helper to keep compatibility
primary : atom ;

// ---------------------------
// End of grammar
// ---------------------------
