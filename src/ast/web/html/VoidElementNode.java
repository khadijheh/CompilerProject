package ast.web.html;

import ast.ASTVisitor;
import ast.base.BaseNode;

import java.util.List;

public abstract class VoidElementNode extends HtmlElementNode {
    private String tagName;
    private List<BaseNode> attributes;

    public VoidElementNode(String tagName, List<BaseNode> attributes, int line, int column) {
        super(line, column);
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String getTagName() { return tagName; }
    public List<BaseNode> getAttributes() { return attributes; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}