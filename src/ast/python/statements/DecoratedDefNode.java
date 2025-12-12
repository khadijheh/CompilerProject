package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class DecoratedDefNode extends BaseNode {
    private List<DecoratorNode> decorators;
    private BaseNode definition;

    public DecoratedDefNode(List<DecoratorNode> decorators, BaseNode definition, int line, int column) {
        super(line, column);
        this.decorators = decorators;
        this.definition = definition;
    }

    public List<DecoratorNode> getDecorators() { return decorators; }
    public BaseNode getDefinition() { return definition; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}