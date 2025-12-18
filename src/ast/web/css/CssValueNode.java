package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;

public class CssValueNode extends BaseNode {

    private final List<BaseNode> atoms;

    public CssValueNode(List<BaseNode> atoms, int line, int column) {
        super(line, column);
        this.atoms = atoms;
    }

    public List<BaseNode> getAtoms() {
        return atoms;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
