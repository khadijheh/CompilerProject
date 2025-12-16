package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public  class ForStartNode extends BaseNode {
    private String variables;
    private String iterable;

    public ForStartNode(String variables, String iterable, int line, int column) {
        super(line, column);
        this.variables = variables;
        this.iterable = iterable;
    }

    public String getVariables() { return variables; }
    public String getIterable() { return iterable; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}