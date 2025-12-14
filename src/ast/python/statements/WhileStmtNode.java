package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public abstract class WhileStmtNode extends BaseNode {
    private BaseNode condition;
    private List<BaseNode> body;

    public WhileStmtNode(BaseNode condition, List<BaseNode> body, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.body = body;
    }

    public BaseNode getCondition() { return condition; }
    public List<BaseNode> getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}