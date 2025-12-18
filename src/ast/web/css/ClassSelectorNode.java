package ast.web.css;

import ast.base.BaseNode;
import ast.base.ASTNode;
import visitor.ASTVisitor;

public class ClassSelectorNode extends BaseNode {
    private final String className;

    public ClassSelectorNode(String className, int line, int column) {
        super(line, column);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
