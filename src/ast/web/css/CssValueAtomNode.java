package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class CssValueAtomNode extends BaseNode {
    private final String value;

    public CssValueAtomNode(String value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public String getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
