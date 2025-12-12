package ast.web;

import ast.ASTVisitor;
import ast.web.jinja.JinjaBlockNode;

public abstract class ContentJinjaBlock extends ContentItemNode {
    private JinjaBlockNode block;

    public ContentJinjaBlock(JinjaBlockNode block, int line, int column) {
        super(line, column);
        this.block = block;
    }

    public JinjaBlockNode getBlock() { return block; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}