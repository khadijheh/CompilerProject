package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public abstract class ForEndNode extends BaseNode {
    public ForEndNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}