package ast.web.html;

import visitor.ASTVisitor;
import ast.base.BaseNode;

import java.util.List;

public  class DoubleQuotedValue extends AttributeValueNode {
    private List<BaseNode> content;

    public DoubleQuotedValue(List<BaseNode> content, int line, int column) {
        super(line, column);
        this.content = content;
    }
    public String asText() {
        StringBuilder sb = new StringBuilder();

        for (BaseNode node : content) {

            if (node instanceof AttrTextNode t) {
                sb.append(t.getText());
            }
            else if (node instanceof AttrJinjaExpressionNode j) {
                sb.append(j.getExpression().getBody().getExpression());
            }
        }
        return sb.toString();
    }

    public List<BaseNode> getContent() { return content; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}