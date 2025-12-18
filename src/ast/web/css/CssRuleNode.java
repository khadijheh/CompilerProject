package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class CssRuleNode extends BaseNode {
    private final CssSelectorListNode selectors;
    private final CssBodyNode declarations;

    public CssRuleNode(CssSelectorListNode selectors, CssBodyNode declarations, int line, int column) {
        super(line, column);
        this.selectors = selectors;
        this.declarations = declarations;
    }

    public CssSelectorListNode getSelectors() { return selectors; }
    public CssBodyNode getDeclarations() { return declarations; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
