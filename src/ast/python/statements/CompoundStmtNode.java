package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class CompoundStmtNode extends BaseNode {
    private BaseNode stmt;

    public CompoundStmtNode(BaseNode stmt, int line, int column) {
        super(line, column);
        this.stmt = stmt;
    }

    public BaseNode getStmt() { return stmt; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}