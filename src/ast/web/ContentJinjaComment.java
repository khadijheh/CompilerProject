package ast.web;

import visitor.ASTVisitor;
import ast.web.jinja.JinjaCommentNode;

public abstract class ContentJinjaComment extends ContentItemNode {
    private JinjaCommentNode comment;

    public ContentJinjaComment(JinjaCommentNode comment, int line, int column) {
        super(line, column);
        this.comment = comment;
    }

    public JinjaCommentNode getComment() { return comment; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}