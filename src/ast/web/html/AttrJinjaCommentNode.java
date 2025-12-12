package ast.web.html;

import ast.ASTVisitor;
import ast.web.jinja.JinjaCommentNode;

public abstract class AttrJinjaCommentNode extends AttrValueItemNode {
    private JinjaCommentNode comment;

    public AttrJinjaCommentNode(JinjaCommentNode comment, int line, int column) {
        super(line, column);
        this.comment = comment;
    }

    public JinjaCommentNode getComment() { return comment; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}