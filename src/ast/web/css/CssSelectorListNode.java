package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;

public class CssSelectorListNode extends BaseNode {
    private final List<CssSelectorNode> selectors;

    public CssSelectorListNode(List<CssSelectorNode> selectors, int line, int column) {
        super(line, column);
        this.selectors = selectors;
    }

    public List<CssSelectorNode> getSelectors() { return selectors; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
