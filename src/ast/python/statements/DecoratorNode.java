package ast.python.statements;

import ast.base.BaseNode;
import ast.python.expressions.ExprNode;
import visitor.ASTVisitor;
import java.util.List;

public  class DecoratorNode extends BaseNode {
    private String name;
    private List<ExprNode> args;
    private List<NamedDecoratorArgsNode> namedArgs;

    public DecoratorNode(String name, List<ExprNode> args, List<NamedDecoratorArgsNode> namedArgs, int line, int column) {
        super(line, column);
        this.name = name;
        this.args = args;
        this.namedArgs = namedArgs;
    }

    public String getName() { return name; }
    public List<ExprNode> getArgs() { return args; }
    public List<NamedDecoratorArgsNode> getNamedArgs() { return namedArgs; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}