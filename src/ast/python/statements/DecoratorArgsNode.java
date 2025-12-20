package ast.python.statements;

import ast.base.BaseNode;
import ast.python.expressions.ExprNode;
import visitor.ASTVisitor;

import java.util.List;

public class DecoratorArgsNode extends BaseNode {
    private List<ExprNode> positional;
    private NamedDecoratorArgsNode named;

    public DecoratorArgsNode(List<ExprNode> positional, NamedDecoratorArgsNode named, int line, int column) {
        super(line, column);
        this.positional = positional;
        this.named = named;
    }

    public List<ExprNode> getPositional() { return positional; }
    public NamedDecoratorArgsNode getNamed() { return named; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
