package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class DecoratorNode extends BaseNode {
    private String name;
    private List<BaseNode> args;
    private List<NamedDecoratorArgsNode> namedArgs;

    public DecoratorNode(String name, List<BaseNode> args, List<NamedDecoratorArgsNode> namedArgs, int line, int column) {
        super(line, column);
        this.name = name;
        this.args = args;
        this.namedArgs = namedArgs;
    }

    public String getName() { return name; }
    public List<BaseNode> getArgs() { return args; }
    public List<NamedDecoratorArgsNode> getNamedArgs() { return namedArgs; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}