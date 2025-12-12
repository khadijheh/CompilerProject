package ast.web;

import ast.ASTVisitor;

public abstract class ContentHtmlText extends ContentItemNode {
    private final String text;

    public ContentHtmlText(String text, int line, int column) {
        super(line, column);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}