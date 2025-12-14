package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public abstract class CssRuleNode extends BaseNode {
    private BaseNode selector;
    private List<CssDeclarationNode> declarations;

    public CssRuleNode(BaseNode selector, List<CssDeclarationNode> declarations, int line, int column) {
        super(line, column);
        this.selector = selector;
        this.declarations = declarations;
    }

    public BaseNode getSelector() { return selector; }
    public List<CssDeclarationNode> getDeclarations() { return declarations; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}