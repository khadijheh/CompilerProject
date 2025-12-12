package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class ClassDefNode extends BaseNode {
    private String name;
    private List<BaseNode> baseClasses;
    private List<BaseNode> body;

    public ClassDefNode(String name, List<BaseNode> baseClasses, List<BaseNode> body, int line, int column) {
        super(line, column);
        this.name = name;
        this.baseClasses = baseClasses;
        this.body = body;
    }

    public String getName() { return name; }
    public List<BaseNode> getBaseClasses() { return baseClasses; }
    public List<BaseNode> getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}