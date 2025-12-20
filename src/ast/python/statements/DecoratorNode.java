package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class DecoratorNode extends BaseNode {

    private final String name;
    private final DecoratorArgsNode args; // عقدة واحدة

    public DecoratorNode(String name,
                         DecoratorArgsNode args,
                         int line,
                         int column) {
        super(line, column);
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public DecoratorArgsNode getArgs() {
        return args;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
