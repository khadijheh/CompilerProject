package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public abstract class SetStmtNode extends BaseNode {
    private String assignment;

    public SetStmtNode(String assignment, int line, int column) {
        super(line, column);
        this.assignment = assignment;
    }

    public String getAssignment() { return assignment; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}