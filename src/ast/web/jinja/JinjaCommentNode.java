package ast.web.jinja;

import ast.base.BaseNode;
import ast.ASTVisitor;

public abstract class JinjaCommentNode extends BaseNode {
    private String comment;

    public JinjaCommentNode(String comment, int line, int column) {
        super(line, column);
        this.comment = comment;
    }

    public String getComment() { return comment; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}