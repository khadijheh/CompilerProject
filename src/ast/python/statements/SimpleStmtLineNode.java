package ast.python.statements;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class SimpleStmtLineNode extends BaseNode {
    private List<BaseNode> statements;

    public SimpleStmtLineNode(List<BaseNode> statements, int line, int column) {
        super(line, column);
        this.statements = statements;
    }

    public List<BaseNode> getStatements() { return statements; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}