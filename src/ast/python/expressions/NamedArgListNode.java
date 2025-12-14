package ast.python.expressions;

import visitor.ASTVisitor;
import java.util.List;

public class NamedArgListNode extends ExprNode {
    private List<String> names;
    private List<ExprNode> values;

    public NamedArgListNode(List<String> names, List<ExprNode> values, int line, int column) {
        super(line, column);
        this.names = names;
        this.values = values;
    }

    public List<String> getNames() { return names; }
    public List<ExprNode> getValues() { return values; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}