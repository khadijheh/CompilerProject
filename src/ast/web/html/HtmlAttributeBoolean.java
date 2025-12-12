package ast.web.html;

import ast.ASTVisitor;

public abstract class HtmlAttributeBoolean extends HtmlAttributeNode {
    private String name;

    public HtmlAttributeBoolean(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}