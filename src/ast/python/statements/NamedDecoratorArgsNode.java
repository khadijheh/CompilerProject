package ast.python.statements;

import ast.base.BaseNode;
import ast.python.expressions.ExprNode;
import visitor.ASTVisitor;
import java.util.List;

public  class NamedDecoratorArgsNode extends BaseNode {
    private List<String> names;
    private List<ExprNode> values;

    public NamedDecoratorArgsNode(List<String> names, List<ExprNode> values, int line, int column) {
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