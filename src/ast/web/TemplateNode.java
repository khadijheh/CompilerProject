package ast.web;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public class TemplateNode extends BaseNode {
    private List<ContentItemNode> content;

    public TemplateNode(List<ContentItemNode> content, int line, int column) {
        super(line, column);
        this.content = content;
    }

    public List<ContentItemNode> getContent() { return content; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}