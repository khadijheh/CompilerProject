package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import ast.python.other.ParameterListNode;
import java.util.List;

public abstract class FunctionDefNode extends BaseNode {
    private String name;
    private ParameterListNode params;
    private List<BaseNode> body;

    public FunctionDefNode(String name, ParameterListNode params, List<BaseNode> body, int line, int column) {
        super(line, column);
        this.name = name;
        this.params = params;
        this.body = body;
    }

    public String getName() { return name; }
    public ParameterListNode getParams() { return params; }
    public List<BaseNode> getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}