package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;

public  class CompoundStmtNode extends BaseNode {
    private BaseNode stmt;

    public CompoundStmtNode(BaseNode stmt, int line, int column) {
        super(line, column);
        this.stmt = stmt;
    }
    public List<BaseNode> getStatements() {
        return List.of(stmt);
    }
    public BaseNode getStmt() { return stmt; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}