package ast.web.css;

import ast.ASTVisitor;

public abstract class SelectorIdNode extends SelectorNode {
    private String id;

    public SelectorIdNode(String id, int line, int column) {
        super(line, column);
        this.id = id;
    }

    public String getId() { return id; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}