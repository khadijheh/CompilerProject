package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class JinjaBlockExprNode extends BaseNode {
    private String expression;

    public JinjaBlockExprNode(String expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    public String getExpression() { return expression; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}