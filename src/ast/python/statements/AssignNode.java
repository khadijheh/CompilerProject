package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class AssignNode extends BaseNode {
    private BaseNode left;   // المتغير أو target
    private BaseNode right;  // القيمة أو expression

    public AssignNode(BaseNode left, BaseNode right, int line, int column) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public BaseNode getLeft() { return left; }
    public BaseNode getRight() { return right; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
