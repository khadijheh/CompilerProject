package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public abstract class WithStmtNode extends BaseNode {
    private BaseNode expression;
    private String alias;
    private List<BaseNode> body;

    public WithStmtNode(BaseNode expression, String alias, List<BaseNode> body, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.alias = alias;
        this.body = body;
    }

    public BaseNode getExpression() { return expression; }
    public String getAlias() { return alias; }
    public List<BaseNode> getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}