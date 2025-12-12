package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class IfStartNode extends BaseNode {
    private String condition;

    public IfStartNode(String condition, int line, int column) {
        super(line, column);
        this.condition = condition;
    }

    public String getCondition() { return condition; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}