package ast.web.css;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class TypeSelectorNode extends BaseNode {
    private final String name;
    public TypeSelectorNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }
    public String getName() { return name; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

// نفس الشكل للكلاسات ClassSelectorNode, IdSelectorNode, PseudoSelectorNode
