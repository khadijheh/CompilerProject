package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;

public  class CompoundStmtNodeList extends CompoundStmtNode {
    private List<BaseNode> statements;

    public CompoundStmtNodeList(List<BaseNode> statements, int line, int column) {
        super(statements.isEmpty() ? null : statements.get(0), line, column); // parent abstract
        this.statements = statements;
    }

    public List<BaseNode> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}