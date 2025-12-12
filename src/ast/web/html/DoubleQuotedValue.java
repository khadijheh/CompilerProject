package ast.web.html;

import ast.ASTVisitor;
import ast.base.BaseNode;

import java.util.List;

public abstract class DoubleQuotedValue extends AttributeValueNode {
    private List<BaseNode> content;

    public DoubleQuotedValue(List<BaseNode> content, int line, int column) {
        super(line, column);
        this.content = content;
    }

    public List<BaseNode> getContent() { return content; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}