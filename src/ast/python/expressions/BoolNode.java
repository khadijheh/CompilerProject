package ast.python.expressions;

import ast.ASTVisitor;

public abstract class BoolNode extends ExprNode {
    private boolean value;

    public BoolNode(boolean value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public boolean getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}