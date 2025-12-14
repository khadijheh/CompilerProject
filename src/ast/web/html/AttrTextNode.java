package ast.web.html;

import visitor.ASTVisitor;

public abstract class AttrTextNode extends AttrValueItemNode {
    private String text;

    public AttrTextNode(String text, int line, int column) {
        super(line, column);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}