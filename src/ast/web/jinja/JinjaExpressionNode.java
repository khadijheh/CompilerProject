package ast.web.jinja;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class JinjaExpressionNode extends BaseNode {
    private JinjaExprBodyNode body;

    public JinjaExpressionNode(JinjaExprBodyNode body, int line, int column) {
        super(line, column);
        this.body = body;
    }

    public JinjaExprBodyNode getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}