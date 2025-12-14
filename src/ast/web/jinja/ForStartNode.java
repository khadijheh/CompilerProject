package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public abstract class ForStartNode extends BaseNode {
    private List<String> variables;
    private List<String> iterable;

    public ForStartNode(List<String> variables, List<String> iterable, int line, int column) {
        super(line, column);
        this.variables = variables;
        this.iterable = iterable;
    }

    public List<String> getVariables() { return variables; }
    public List<String> getIterable() { return iterable; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}