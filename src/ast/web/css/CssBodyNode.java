package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;
public class CssBodyNode extends BaseNode {

    private final List<? extends BaseNode> children;

    public CssBodyNode(List<? extends BaseNode> children, int line, int column) {
        super(line, column);
        this.children = children;
    }

    public List<? extends BaseNode> getChildren() {
        return children;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
