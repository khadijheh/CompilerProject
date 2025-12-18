package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class AttributeSelectorNode extends BaseNode {
    private final String attribute;
    private final String value;

    public AttributeSelectorNode(String attribute, String value, int line, int column) {
        super(line, column);
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() { return attribute; }
    public String getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
