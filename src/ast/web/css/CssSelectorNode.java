package ast.web.css;

import ast.base.BaseNode;
import ast.base.ASTNode;
import visitor.ASTVisitor;

import java.util.List;

public class CssSelectorNode extends BaseNode {
    private final List<ASTNode> parts;

    public CssSelectorNode(List<ASTNode> parts, int line, int column) {
        super(line, column);
        this.parts = parts;
    }

    public List<ASTNode> getParts() { return parts; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
