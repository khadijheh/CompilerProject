package ast.web.html;

import ast.base.BaseNode;
import visitor.ASTVisitor;

public class HtmlTextNode extends BaseNode {
    private String text;

    public HtmlTextNode(String text, int line, int column) {
        super(line, column);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}