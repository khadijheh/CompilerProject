package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class IdSelectorNode extends BaseNode {
    private final String idName;

    public IdSelectorNode(String idName, int line, int column) {
        super(line, column);
        this.idName = idName;
    }

    public String getIdName() {
        return idName;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
