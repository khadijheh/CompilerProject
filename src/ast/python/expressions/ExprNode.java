package ast.python.expressions;

import ast.base.BaseNode;

public abstract class ExprNode extends BaseNode {
    public ExprNode(int line, int column) {
        super(line, column);
    }
}