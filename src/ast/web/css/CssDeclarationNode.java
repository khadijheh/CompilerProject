package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public abstract class CssDeclarationNode extends BaseNode {
    private String property;
    private String value;

    public CssDeclarationNode(String property, String value, int line, int column) {
        super(line, column);
        this.property = property;
        this.value = value;
    }

    public String getProperty() { return property; }
    public String getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}