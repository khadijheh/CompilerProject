package ast.web.html;

import visitor.ASTVisitor;
import ast.web.jinja.JinjaBlockNode;

public abstract class AttrJinjaBlockNode extends AttrValueItemNode {
    private JinjaBlockNode block;

    public AttrJinjaBlockNode(JinjaBlockNode block, int line, int column) {
        super(line, column);
        this.block = block;
    }

    public JinjaBlockNode getBlock() { return block; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}