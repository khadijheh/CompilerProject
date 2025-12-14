package ast.web.html;

import visitor.ASTVisitor;
import ast.base.BaseNode;
import ast.web.ContentItemNode;
import java.util.List;

public abstract class NormalElementNode extends HtmlElementNode {
    private String tagName;
    private List<BaseNode> attributes;
    private List<ContentItemNode> content;

    public NormalElementNode(String tagName, List<BaseNode> attributes, List<ContentItemNode> content, int line, int column) {
        super(line, column);
        this.tagName = tagName;
        this.attributes = attributes;
        this.content = content;
    }

    public String getTagName() { return tagName; }
    public List<BaseNode> getAttributes() { return attributes; }
    public List<ContentItemNode> getContent() { return content; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}