package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

import java.util.List;

public class SelectorPartNode extends BaseNode {

    private final List<BaseNode> simpleSelectors;

    public SelectorPartNode(List<BaseNode> simpleSelectors, int line, int column) {
        super(line, column);
        this.simpleSelectors = simpleSelectors;
    }

    public List<BaseNode> getSimpleSelectors() {
        return simpleSelectors;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
