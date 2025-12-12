package ast.web.html;

import ast.ASTVisitor;
import ast.web.jinja.JinjaExpressionNode;

public abstract class AttrJinjaExpressionNode extends AttrValueItemNode {
    private JinjaExpressionNode expression;

    public AttrJinjaExpressionNode(JinjaExpressionNode expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    public JinjaExpressionNode getExpression() { return expression; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}