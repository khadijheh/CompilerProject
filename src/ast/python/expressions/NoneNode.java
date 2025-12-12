package ast.python.expressions;

import ast.ASTVisitor;

public abstract class NoneNode extends ExprNode {
    public NoneNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}