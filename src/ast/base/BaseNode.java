package ast.base;

import visitor.ASTVisitor;

public abstract class BaseNode implements ASTNode {
    protected int line;
    protected int column;

    public BaseNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() { return line; }
    public int getColumn() { return column; }

    @Override
    public abstract <T> T accept(ASTVisitor<T> visitor);
}