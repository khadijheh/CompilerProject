package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;
import java.util.ArrayList;

public  class IfStmtNode extends BaseNode {
    private BaseNode condition;
    private List<BaseNode> thenBody;
    private List<IfBranch> elifBranches;
    private List<BaseNode> elseBody;

    public static class IfBranch {
        private BaseNode condition;
        private List<BaseNode> body;

        public IfBranch(BaseNode condition, List<BaseNode> body) {
            this.condition = condition;
            this.body = body;
        }

        public BaseNode getCondition() { return condition; }
        public List<BaseNode> getBody() { return body; }
    }

    public IfStmtNode(BaseNode condition, List<BaseNode> thenBody, List<IfBranch> elifBranches, List<BaseNode> elseBody, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.thenBody = thenBody;
        this.elifBranches = elifBranches != null ? elifBranches : new ArrayList<>();
        this.elseBody = elseBody != null ? elseBody : new ArrayList<>();
    }

    public BaseNode getCondition() { return condition; }
    public List<BaseNode> getThenBody() { return thenBody; }
    public List<IfBranch> getElifBranches() { return elifBranches; }
    public List<BaseNode> getElseBody() { return elseBody; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}