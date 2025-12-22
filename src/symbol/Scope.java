package symbol;

import java.util.*;

public class Scope {
    private final Scope parent;
    private final Map<String, Symbol> symbols;
    private final String name;
    private final ScopeType type;
    private final int level;
    private final List<Scope> childScopes;

    public enum ScopeType {
        GLOBAL,
        FUNCTION,
        CLASS,
        MODULE,
        BLOCK,
        LOOP,
        CONDITIONAL,
        CSS_RULE,
        HTML_ELEMENT,
        JINJA_BLOCK,
        TEMPLATE,
        WITH_BLOCK,

    }

    public Scope(String name, ScopeType type, Scope parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.symbols = new LinkedHashMap<>();
        this.level = (parent == null) ? 0 : parent.getLevel() + 1;
        this.childScopes = new ArrayList<>();

        if (parent != null) {
            parent.addChildScope(this);
        }
    }

    private void addChildScope(Scope child) {
        childScopes.add(child);
    }

    public boolean define(Symbol symbol) {
        String name = symbol.getName();
        if (symbols.containsKey(name)) {
            return false;
        }
        symbols.put(name, symbol);
        return true;
    }

    public Symbol resolve(String name) {
        return symbols.get(name);
    }

    public Symbol resolveRecursively(String name) {
        Symbol symbol = resolve(name);
        if (symbol != null) {
            return symbol;
        }
        if (parent != null) {
            return parent.resolveRecursively(name);
        }
        return null;
    }

    public Scope getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public ScopeType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Map<String, Symbol> getSymbols() {
        return Collections.unmodifiableMap(symbols);
    }

    public List<Scope> getChildScopes() {
        return Collections.unmodifiableList(childScopes);
    }

    public int getTotalSymbols() {
        int total = symbols.size();
        for (Scope child : childScopes) {
            total += child.getTotalSymbols();
        }
        return total;
    }

    public boolean containsSymbol(String name) {
        return symbols.containsKey(name);
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        String indentStr = "  ".repeat(indent);

        sb.append(indentStr).append("Scope: ").append(name)
                .append(" [").append(type).append("]")
                .append(" (level ").append(level).append(")")
                .append(" - Symbols: ").append(symbols.size())
                .append("\n");

        if (symbols.isEmpty()) {
            sb.append(indentStr).append("  No symbols\n");
        } else {
            for (Symbol symbol : symbols.values()) {
                sb.append(indentStr).append("  - ").append(symbol).append("\n");
            }
        }

        return sb.toString();
    }

    public String toDetailedString() {
        return toDetailedString(0);
    }

    private String toDetailedString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(indent));

        for (Scope child : childScopes) {
            sb.append(child.toDetailedString(indent + 1));
        }

        return sb.toString();
    }
}