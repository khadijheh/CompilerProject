package ast.python.statements;

import ast.base.BaseNode;
import visitor.ASTVisitor;
import java.util.List;

public abstract class ImportStmtNode extends BaseNode {
    private String module;
    private List<String> imports;
    private boolean isFromImport;

    public ImportStmtNode(String module, List<String> imports, boolean isFromImport, int line, int column) {
        super(line, column);
        this.module = module;
        this.imports = imports;
        this.isFromImport = isFromImport;
    }

    public String getModule() { return module; }
    public List<String> getImports() { return imports; }
    public boolean isFromImport() { return isFromImport; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}