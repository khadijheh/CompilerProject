package ast.web.jinja;
import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public class JinjaBlockExprNode extends BaseNode {
    private List<String> parts;

    public JinjaBlockExprNode(List<String> parts, int line, int column) {
        super(line, column);
        this.parts = parts;
    }

    public List<String> getParts() { return parts; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
