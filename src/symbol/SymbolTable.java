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

    public void allocate() {
        scopeStack.clear();
        allScopes.clear();
        symbolReferences.clear();

        globalScope = new Scope("global", Scope.ScopeType.GLOBAL, null);
        currentScope = globalScope;

        scopeStack.push(globalScope);
        allScopes.add(globalScope);
    }
    public void free() {
        scopeStack.clear();
        allScopes.clear();
        symbolReferences.clear();
        currentScope = null;
        globalScope = null;
    }

    public boolean insert(String name,
                          Symbol.SymbolType type,
                          int line,
                          int column,
                          Object value) {
        return defineSymbol(name, type, line, column, value);
    }


    public Symbol lookup(String name) {
        if (currentScope == null) {
            return null;
        }
        return currentScope.resolveRecursively(name);
    }


    public boolean setAttribute(String symbolName, String key, Object value) {
        Symbol symbol = lookup(symbolName);
        if (symbol == null) {
            return false;
        }
        symbol.setAttribute(key, value);
        return true;
    }
    public Object getAttribute(String symbolName, String key) {
        Symbol symbol = lookup(symbolName);
        if (symbol == null) {
            return null;
        }
        return symbol.getAttribute(key);
    }


    public boolean exists(String name) {
        return lookup(name) != null;
    }


    public Symbol.SymbolType getSymbolType(String name) {
        Symbol symbol = lookup(name);
        return (symbol != null) ? symbol.getType() : null;
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


    public boolean defineSymbol(String name, Symbol.SymbolType type, int line, int column, Object value) {
        Symbol symbol = new Symbol(name, type, line, column, value);

        symbolReferences.computeIfAbsent(name, k -> new ArrayList<>()).add(symbol);

        return currentScope.define(symbol);
    }

    public Symbol resolveInCurrentScope(String name) {
        return currentScope.resolve(name);
    }

    public List<Symbol> findAllSymbols(String name) {
        return symbolReferences.getOrDefault(name, new ArrayList<>());
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




}