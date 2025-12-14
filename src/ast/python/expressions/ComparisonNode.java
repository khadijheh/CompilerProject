package ast.python.expressions;

import visitor.ASTVisitor;
import java.util.List;
import java.util.ArrayList;

public  class ComparisonNode extends ExprNode {
    private ExprNode left;
    private List<ComparisonOp> comparisons;

    public static class ComparisonOp {
        private String operator;
        private ExprNode right;

        public ComparisonOp(String operator, ExprNode right) {
            this.operator = operator;
            this.right = right;
        }

        public String getOperator() { return operator; }
        public ExprNode getRight() { return right; }
    }

    public ComparisonNode(ExprNode left, List<ComparisonOp> comparisons, int line, int column) {
        super(line, column);
        this.left = left;
        this.comparisons = comparisons != null ? comparisons : new ArrayList<>();
    }

    public ExprNode getLeft() { return left; }
    public List<ComparisonOp> getComparisons() { return comparisons; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}