package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class NamedDecoratorArgsNode extends BaseNode {
    private List<String> names;
    private List<BaseNode> values;

    public NamedDecoratorArgsNode(List<String> names, List<BaseNode> values, int line, int column) {
        super(line, column);
        this.names = names;
        this.values = values;
    }

    public List<String> getNames() { return names; }
    public List<BaseNode> getValues() { return values; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}