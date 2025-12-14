package ast.python.expressions;

import visitor.ASTVisitor;
import java.util.List;

public class CallNode extends ExprNode {
    private ExprNode function;
    private List<ExprNode> args;
    private NamedArgListNode namedArgs;

    public CallNode(ExprNode function, List<ExprNode> args, NamedArgListNode namedArgs, int line, int column) {
        super(line, column);
        this.function = function;
        this.args = args;
        this.namedArgs = namedArgs;
    }

    public ExprNode getFunction() { return function; }
    public List<ExprNode> getArgs() { return args; }
    public NamedArgListNode getNamedArgs() { return namedArgs; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}