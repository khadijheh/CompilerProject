package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class PassNode extends BaseNode {

    public PassNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
