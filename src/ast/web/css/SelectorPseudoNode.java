package ast.web.css;

import ast.ASTVisitor;

public abstract class SelectorPseudoNode extends SelectorNode {
    private String pseudoClass;
    private String pseudoElement;

    public SelectorPseudoNode(String pseudoClass, String pseudoElement, int line, int column) {
        super(line, column);
        this.pseudoClass = pseudoClass;
        this.pseudoElement = pseudoElement;
    }

    public String getPseudoClass() { return pseudoClass; }
    public String getPseudoElement() { return pseudoElement; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}