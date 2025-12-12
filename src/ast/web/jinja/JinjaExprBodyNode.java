package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class JinjaExprBodyNode extends BaseNode {
    private String expression;

    public JinjaExprBodyNode(String expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    public String getExpression() { return expression; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}