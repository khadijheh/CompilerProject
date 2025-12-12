package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class ForStmtNode extends BaseNode {
    private BaseNode target;
    private BaseNode iterable;
    private List<BaseNode> body;

    public ForStmtNode(BaseNode target, BaseNode iterable, List<BaseNode> body, int line, int column) {
        super(line, column);
        this.target = target;
        this.iterable = iterable;
        this.body = body;
    }

    public BaseNode getTarget() { return target; }
    public BaseNode getIterable() { return iterable; }
    public List<BaseNode> getBody() { return body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}