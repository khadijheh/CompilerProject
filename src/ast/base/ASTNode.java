package ast.base;

import ast.ASTVisitor;

public interface ASTNode {
    <T> T accept(ASTVisitor<T> visitor);
}