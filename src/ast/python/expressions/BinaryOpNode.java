package ast.python.expressions;

import ast.ASTVisitor;

public abstract class BinaryOpNode extends ExprNode {
    private String operator;
    private ExprNode left;
    private ExprNode right;

    public BinaryOpNode(String operator, ExprNode left, ExprNode right, int line, int column) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() { return operator; }
    public ExprNode getLeft() { return left; }
    public ExprNode getRight() { return right; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}