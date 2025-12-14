package ast.web.css;

import visitor.ASTVisitor;

public abstract class SelectorClassNode extends SelectorNode {
    private String className;

    public SelectorClassNode(String className, int line, int column) {
        super(line, column);
        this.className = className;
    }

    public String getClassName() { return className; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}