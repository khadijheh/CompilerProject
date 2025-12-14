package ast.python.expressions;

import visitor.ASTVisitor;

public class IndexNode extends ExprNode {
    private ExprNode object;
    private ExprNode index;

    public IndexNode(ExprNode object, ExprNode index, int line, int column) {
        super(line, column);
        this.object = object;
        this.index = index;
    }

    public ExprNode getObject() { return object; }
    public ExprNode getIndex() { return index; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}