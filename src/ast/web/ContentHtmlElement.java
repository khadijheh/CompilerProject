package ast.web;

import visitor.ASTVisitor;
import ast.base.BaseNode;

public abstract class ContentHtmlElement extends ContentItemNode {
    private BaseNode element;

    public ContentHtmlElement(BaseNode element, int line, int column) {
        super(line, column);
        this.element = element;
    }

    public BaseNode getElement() { return element; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}