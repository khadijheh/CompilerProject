package ast.web.css;

import visitor.ASTVisitor;

public abstract class SelectorSimpleNode extends SelectorNode {
    private String selector;

    public SelectorSimpleNode(String selector, int line, int column) {
        super(line, column);
        this.selector = selector;
    }

    public String getSelector() { return selector; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}