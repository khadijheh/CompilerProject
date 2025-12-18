package ast.web.css;

import ast.base.BaseNode;
import ast.base.ASTNode;
import visitor.ASTVisitor;

public class CssStyleNode extends BaseNode {
    private final CssBodyNode body;

    public CssStyleNode(CssBodyNode body, int line, int column) {
        super(line, column);
        this.body = body;
    }

    public CssBodyNode getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
