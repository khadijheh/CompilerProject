package ast.web.css;

import ast.base.BaseNode;
import ast.base.ASTNode;
import ast.web.ContentItemNode;
import visitor.ASTVisitor;

public class ContentCssStyle extends ContentItemNode {
    private final CssStyleNode cssStyle;

    public ContentCssStyle(CssStyleNode cssStyle, int line, int column) {
        super(line, column);
        this.cssStyle = cssStyle;
    }

    public CssStyleNode getCssStyle() {
        return cssStyle;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
