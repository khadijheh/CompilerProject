package symbol;

import java.util.*;

public class SymbolTable {
    private Scope currentScope;
    private Scope globalScope;
    private final Stack<Scope> scopeStack;
    private final List<Scope> allScopes;
    private final Map<String, List<Symbol>> symbolReferences;

    public SymbolTable() {
        this.globalScope = new Scope("global", Scope.ScopeType.GLOBAL, null);
        this.currentScope = globalScope;
        this.scopeStack = new Stack<>();
        this.scopeStack.push(globalScope);
        this.allScopes = new ArrayList<>();
        this.allScopes.add(globalScope);
        this.symbolReferences = new HashMap<>();
    }

    public void enterScope(String name, Scope.ScopeType type) {
        Scope newScope = new Scope(name, type, currentScope);
        currentScope = newScope;
        scopeStack.push(newScope);
        allScopes.add(newScope);
    }

    public void exitScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
            currentScope = scopeStack.peek();
        }
    }

    public boolean defineSymbol(String name, Symbol.SymbolType type, int line, int column) {
        return defineSymbol(name, type, line, column, null);
    }

    public boolean defineSymbol(String name, Symbol.SymbolType type, int line, int column, Object value) {
        Symbol symbol = new Symbol(name, type, line, column, value);

        symbolReferences.computeIfAbsent(name, k -> new ArrayList<>()).add(symbol);

        return currentScope.define(symbol);
    }

    public Symbol resolve(String name) {
        return currentScope.resolveRecursively(name);
    }

    public Symbol resolveFromGlobal(String name) {
        return globalScope.resolveRecursively(name);
    }

    public Symbol resolveInCurrentScope(String name) {
        return currentScope.resolve(name);
    }

    public List<Symbol> findAllSymbols(String name) {
        return symbolReferences.getOrDefault(name, new ArrayList<>());
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public Scope getGlobalScope() {
        return globalScope;
    }

    public List<Scope> getAllScopes() {
        return Collections.unmodifiableList(allScopes);
    }

    public int getTotalSymbols() {
        int total = 0;
        for (Scope scope : allScopes) {
            total += scope.getSymbols().size();
        }
        return total;
    }

    public int getTotalSymbolsRecursive() {
        return globalScope.getTotalSymbols();
    }

    public void reset() {
        this.globalScope = new Scope("global", Scope.ScopeType.GLOBAL, null);
        this.currentScope = globalScope;
        this.scopeStack.clear();
        this.scopeStack.push(globalScope);
        this.allScopes.clear();
        this.allScopes.add(globalScope);
        this.symbolReferences.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== SYMBOL TABLE ======\n");
        sb.append("Current Scope: ").append(currentScope.getName())
                .append(" [").append(currentScope.getType()).append("]\n");
        sb.append("Scope Stack Depth: ").append(scopeStack.size()).append("\n");
        sb.append("Total Scopes: ").append(allScopes.size()).append("\n");
        sb.append("Total Symbols: ").append(getTotalSymbols()).append("\n\n");

        sb.append(globalScope.toDetailedString());

        return sb.toString();
    }

    public String toHierarchicalString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== SYMBOL TABLE HIERARCHY ======\n");
        printScopeHierarchy(globalScope, 0, sb);
        return sb.toString();
    }

    private void printScopeHierarchy(Scope scope, int depth, StringBuilder sb) {
        sb.append(scope.toString(depth));

        for (Scope child : scope.getChildScopes()) {
            printScopeHierarchy(child, depth + 1, sb);
        }
    }

    public String toSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== SYMBOL TABLE SUMMARY ======\n");

        Map<Symbol.SymbolType, Integer> typeCount = new HashMap<>();
        for (Scope scope : allScopes) {
            for (Symbol symbol : scope.getSymbols().values()) {
                typeCount.merge(symbol.getType(), 1, Integer::sum);
            }
        }

        sb.append("Symbol Types:\n");
        typeCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));

        sb.append("\nScope Types:\n");
        Map<Scope.ScopeType, Integer> scopeTypeCount = new HashMap<>();
        for (Scope scope : allScopes) {
            scopeTypeCount.merge(scope.getType(), 1, Integer::sum);
        }

        scopeTypeCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));

        return sb.toString();
    }

    public String searchSymbol(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("Search Results for '").append(name).append("':\n");

        List<Symbol> allMatches = findAllSymbols(name);
        if (allMatches.isEmpty()) {
            sb.append("  No symbols found\n");
        } else {
            sb.append("  Found ").append(allMatches.size()).append(" occurrence(s):\n");
            for (int i = 0; i < allMatches.size(); i++) {
                Symbol sym = allMatches.get(i);
                sb.append("  ").append(i + 1).append(". ").append(sym).append("\n");
            }
        }

        return sb.toString();
    }
}