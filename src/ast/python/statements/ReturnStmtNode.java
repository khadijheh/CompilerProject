package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public  class ReturnStmtNode extends BaseNode {
    private BaseNode value;

    public ReturnStmtNode(BaseNode value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public BaseNode getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}