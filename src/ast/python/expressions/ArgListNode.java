package ast.python.expressions;

import visitor.ASTVisitor;

import java.util.List;

public class ArgListNode extends ExprNode {

    private List<ExprNode> positional;
    private NamedArgListNode named;

    public ArgListNode(List<ExprNode> positional,
                       NamedArgListNode named,
                       int line, int column) {
        super(line, column);
        this.positional = positional;
        this.named = named;
    }

    public List<ExprNode> getPositional() {
        return positional;
    }

    public NamedArgListNode getNamed() {
        return named;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }


}
