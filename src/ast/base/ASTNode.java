package ast.base;

import visitor.ASTVisitor;

public interface ASTNode {
    <T> T accept(ASTVisitor<T> visitor);
}