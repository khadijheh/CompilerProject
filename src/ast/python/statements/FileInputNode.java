package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public  class FileInputNode extends BaseNode {
    private List<BaseNode> statements;

    public FileInputNode(List<BaseNode> statements, int line, int column) {
        super(line, column);
        this.statements = statements;
    }

    public List<BaseNode> getStatements() { return statements; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}