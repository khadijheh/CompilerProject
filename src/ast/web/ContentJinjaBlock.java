package ast.web;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import ast.web.jinja.JinjaBlockNode;

public  class ContentJinjaBlock extends ContentItemNode {
    private BaseNode block;

    public ContentJinjaBlock(BaseNode block, int line, int column) {
        super(line, column);
        this.block = block;
    }

    public BaseNode getBlock() { return block; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}