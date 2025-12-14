package ast.python.expressions;

import visitor.ASTVisitor;
import java.util.List;

public  class ListLiteralNode extends ExprNode {
    private List<ExprNode> elements;

    public ListLiteralNode(List<ExprNode> elements, int line, int column) {
        super(line, column);
        this.elements = elements;
    }

    public List<ExprNode> getElements() { return elements; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
