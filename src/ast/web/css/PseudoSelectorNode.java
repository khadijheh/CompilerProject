package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class PseudoSelectorNode extends BaseNode {
    private final String pseudo;

    public PseudoSelectorNode(String pseudo, int line, int column) {
        super(line, column);
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
