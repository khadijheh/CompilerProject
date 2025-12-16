package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import visitor.WebVisitor;

import java.util.List;

public class BaseNodeList extends BaseNode {
    private final List<BaseNode> children;

    public BaseNodeList(List<BaseNode> children, int line, int column) {
        super(line, column);
        this.children = children;
    }

    public List<BaseNode> getChildren() {
        return children;
    }



    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}
