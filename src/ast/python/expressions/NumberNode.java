package ast.python.expressions;

import ast.ASTVisitor;

public abstract class NumberNode extends ExprNode {
    private String value;

    public NumberNode(String value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}