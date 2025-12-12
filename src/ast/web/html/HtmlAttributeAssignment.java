package ast.web.html;

import ast.ASTVisitor;
import ast.base.BaseNode;

public abstract class HtmlAttributeAssignment extends HtmlAttributeNode {
    private String name;
    private BaseNode value;

    public HtmlAttributeAssignment(String name, BaseNode value, int line, int column) {
        super(line, column);
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public BaseNode getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}