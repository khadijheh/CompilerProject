package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public abstract class JinjaBlockNode extends BaseNode {
    private BaseNode inner;

    public JinjaBlockNode(BaseNode inner, int line, int column) {
        super(line, column);
        this.inner = inner;
    }

    public BaseNode getInner() { return inner; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}