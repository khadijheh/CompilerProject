package ast.web;

import visitor.ASTVisitor;
import ast.web.jinja.JinjaExpressionNode;

public abstract class ContentJinjaExpression extends ContentItemNode {
    private JinjaExpressionNode expression;

    public ContentJinjaExpression(JinjaExpressionNode expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    public JinjaExpressionNode getExpression() { return expression; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}