package ast.web.css;

import ast.base.ASTNode;
import ast.base.BaseNode;
import visitor.ASTVisitor;

public class CssDeclarationNode extends BaseNode {
    private final String property;
    private final ASTNode value;

    public CssDeclarationNode(String property, ASTNode value, int line, int column) {
        super(line, column);
        this.property = property;
        this.value = value;
    }

    public String getProperty() { return property; }
    public ASTNode getValue() { return value; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
