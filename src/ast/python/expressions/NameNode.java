package ast.python.expressions;

import ast.ASTVisitor;

public abstract class NameNode extends ExprNode {
    private String name;

    public NameNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}