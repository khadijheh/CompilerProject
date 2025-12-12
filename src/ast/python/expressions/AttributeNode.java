package ast.python.expressions;

import ast.ASTVisitor;

public abstract class AttributeNode extends ExprNode {
    private ExprNode object;
    private String attribute;

    public AttributeNode(ExprNode object, String attribute, int line, int column) {
        super(line, column);
        this.object = object;
        this.attribute = attribute;
    }

    public ExprNode getObject() { return object; }
    public String getAttribute() { return attribute; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}