package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class EndIfPartNode extends BaseNode {
    public EndIfPartNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}