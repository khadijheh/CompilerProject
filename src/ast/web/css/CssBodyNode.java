package ast.web.css;

import ast.base.BaseNode;
import ast.ASTVisitor;
import java.util.List;

public abstract class CssBodyNode extends BaseNode {
    private List<BaseNode> rules;

    public CssBodyNode(List<BaseNode> rules, int line, int column) {
        super(line, column);
        this.rules = rules;
    }

    public List<BaseNode> getRules() { return rules; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}