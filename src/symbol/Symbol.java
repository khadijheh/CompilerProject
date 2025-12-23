package symbol;

import java.util.HashMap;
import java.util.Map;

public class Symbol {
    private final String name;
    private final SymbolType type;
    private final int line;
    private final int column;
    private final Object value;
    private final Map<String, Object> attributes;

    public enum SymbolType {
        VARIABLE,
        FUNCTION,
        CLASS,
        MODULE,
        ATTRIBUTE,
        PARAMETER,
        CSS_SELECTOR,
        CSS_PROPERTY,
        HTML_ELEMENT,
        HTML_ATTRIBUTE,
        JINJA_BLOCK,
        TEMPLATE,
        LIST,
        DICT,
        TUPLE,
        SET,
        BUILTIN_FUNCTION,
        DECORATOR,
         DECORATOR_KEYWORD,
        IMPORT,
        URL_PATTERN,
        TEMPLATE_REF,
        JINJA_EXPRESSION,
        FORM_FIELD,
        UNKNOWN
    }

    public Symbol(String name, SymbolType type, int line, int column) {
        this(name, type, line, column, null);
    }

    public Symbol(String name, SymbolType type, int line, int column, Object value) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.column = column;
        this.value = value;
        this.attributes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public SymbolType getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public boolean hasAttribute(String key) {
        return attributes.containsKey(key);
    }

    public Map<String, Object> getAttributes() {
        return new HashMap<>(attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" [").append(type).append("]");
        sb.append(" at (").append(line).append(":").append(column).append(")");

        if (value != null) {
            sb.append(" value=").append(value);
        }

        if (!attributes.isEmpty()) {
            sb.append(" attributes=").append(attributes);
        }

        return sb.toString();
    }
}