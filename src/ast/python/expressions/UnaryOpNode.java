package ast.python.expressions;

import ast.ASTVisitor;

public abstract class UnaryOpNode extends ExprNode {
    private String operator;
    private ExprNode operand;

    public UnaryOpNode(String operator, ExprNode operand, int line, int column) {
        super(line, column);
        this.operator = operator;
        this.operand = operand;
    }

    public String getOperator() { return operator; }
    public ExprNode getOperand() { return operand; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}