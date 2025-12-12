package ast.python.other;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public class ParameterListNode extends BaseNode {
    private List<String> parameters;

    public ParameterListNode(List<String> parameters, int line, int column) {
        super(line, column);
        this.parameters = parameters;
    }

    public List<String> getParameters() { return parameters; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}