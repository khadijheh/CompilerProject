package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class WebSimpleStmtNode extends BaseNode {
    private String statement;

    public WebSimpleStmtNode(String statement, int line, int column) {
        super(line, column);
        this.statement = statement;
    }

    public String getStatement() { return statement; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}