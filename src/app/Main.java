/*
// java
package app;

import antlr.PythonFlaskParser;
import antlr.PythonLexer;
import antlr.WebCombinedLexer;
import antlr.WebParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import visitor.PythonVisitor;
import visitor.PrinterVisitor;
import ast.base.ASTNode;
import visitor.WebVisitor;

import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) {
        try {
            buildAndPrintPython("FileOfTest/flask_app.txt");
            List<String> webFiles = List.of(
                    "FileOfTest/home.txt",
                    "FileOfTest/addProductHtml.txt",
                    "FileOfTest/product_details.txt"
            );

            for (String file : webFiles) {
                buildAndPrintWeb(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ================= PYTHON =================
    private static void buildAndPrintPython(String path) throws IOException {
        System.out.println("\n====== PYTHON AST ======\n");

        CharStream input = fromFileName(path);
        PythonLexer lexer = new PythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonFlaskParser parser = new PythonFlaskParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());

        ParseTree tree = parser.file_input();
        ASTNode ast = new PythonVisitor().visit(tree);

        ast.accept(new PrinterVisitor());
    }
    // ================= WEB =================
    private static void buildAndPrintWeb(String path) throws IOException {
        System.out.println("\n====== WEB AST : " + path + " ======\n");

        CharStream input = fromFileName(path);
        WebCombinedLexer lexer = new WebCombinedLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WebParser parser = new WebParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());
        ParseTree tree = parser.template();
        ASTNode ast = new WebVisitor().visit(tree);

        ast.accept(new PrinterVisitor());
    }
}

 */
package app;

import antlr.PythonFlaskParser;
import antlr.PythonLexer;
import antlr.WebCombinedLexer;
import antlr.WebParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import visitor.PythonVisitor;
import visitor.PrinterVisitor;
import visitor.SymbolTableVisitor;
import ast.base.ASTNode;
import visitor.WebVisitor;
import symbol.SymbolTable;
import symbol.Symbol;
import symbol.Scope;

import java.io.IOException;
import java.util.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n" + "=".repeat(70));
            System.out.println("SYMBOL TABLE ANALYSIS SYSTEM");
            System.out.println("=".repeat(70));

            List<String> webFiles = List.of(
                    "FileOfTest/home.txt",
                    "FileOfTest/addProductHtml.txt",
                    "FileOfTest/product_details.txt"
            );

            for (String file : webFiles) {
                analyzeWebTemplate(file);
                System.out.println("\n" + "-".repeat(70) + "\n");
            }

            analyzePythonFile("FileOfTest/flask_app.txt");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ================= WEB TEMPLATE ANALYSIS =================
    private static void analyzeWebTemplate(String path) throws IOException {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("ANALYZING WEB TEMPLATE: " + path);
        System.out.println("=".repeat(70));

        CharStream input = fromFileName(path);
        WebCombinedLexer lexer = new WebCombinedLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WebParser parser = new WebParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());
        ParseTree tree = parser.template();
        ASTNode ast = new WebVisitor().visit(tree);

        SymbolTableVisitor visitor = new SymbolTableVisitor();
        ast.accept(visitor);

        SymbolTable symbolTable = visitor.getSymbolTable();

        printSymbolTableWithScopesHierarchy(symbolTable, path);
    }

    // ================= PYTHON FILE ANALYSIS =================
    private static void analyzePythonFile(String path) throws IOException {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("ANALYZING PYTHON FILE: " + path);
        System.out.println("=".repeat(70));

        CharStream input = fromFileName(path);
        PythonLexer lexer = new PythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonFlaskParser parser = new PythonFlaskParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());

        ParseTree tree = parser.file_input();
        ASTNode ast = new PythonVisitor().visit(tree);

        SymbolTableVisitor visitor = new SymbolTableVisitor();
        ast.accept(visitor);

        SymbolTable symbolTable = visitor.getSymbolTable();

        printSymbolTableWithScopesHierarchy(symbolTable, path);
    }

    private static void printSymbolTableWithScopesHierarchy(SymbolTable symbolTable, String filename) {
        System.out.println("\nSYMBOL TABLE for " + filename + ":");
        System.out.println("-".repeat(70));

        System.out.println(symbolTable.toHierarchicalString());

        System.out.println("\nFLAT SYMBOL TABLE VIEW:");
        System.out.println("-".repeat(70));
        printFlatSymbolTable(symbolTable);
    }

    private static void printFlatSymbolTable(SymbolTable symbolTable) {
        List<Symbol> allSymbols = new ArrayList<>();
        for (Scope scope : symbolTable.getAllScopes()) {
            allSymbols.addAll(scope.getSymbols().values());
        }

        allSymbols.sort((a, b) -> Integer.compare(a.getLine(), b.getLine()));

        System.out.printf("%-25s | %-15s | %-10s%n", "Symbol Name", "Type", "Line");
        System.out.println("-".repeat(60));

        for (Symbol sym : allSymbols) {
            int line = sym.getLine();
            if (line < 0) line = 0;

            System.out.printf("%-25s | %-15s | %-10d%n", sym.getName(), sym.getType(), line);
        }

        System.out.println("-".repeat(60));
    }

    /*
    private static void demonstrateHelperMethods(SymbolTable symbolTable) {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("HELPER METHODS AVAILABLE (not used in main output):");
        System.out.println("=".repeat(70));

        System.out.println("1. Searching for 'product':");
        System.out.println(symbolTable.searchSymbol("product"));

        System.out.println("2. Summary:");
        System.out.println(symbolTable.toSummary());

        System.out.println("3. Full table view:");
        System.out.println(symbolTable.toString());
    }
    */

    private static void printDetailedScopeHierarchy(SymbolTable symbolTable) {
        System.out.println("\nDETAILED SCOPE HIERARCHY:");
        System.out.println("=".repeat(70));

        Scope globalScope = symbolTable.getGlobalScope();
        printScopeWithSymbols(globalScope, 0);
    }

    private static void printScopeWithSymbols(Scope scope, int indentLevel) {
        String indent = "  ".repeat(indentLevel);

        System.out.printf("%sScope: %s [%s] (Level: %d, Symbols: %d)%n",
                indent,
                scope.getName(),
                scope.getLevel(),
                scope.getSymbols().size());

        if (!scope.getSymbols().isEmpty()) {
            for (Symbol symbol : scope.getSymbols().values()) {
                System.out.printf("%s  - %s [%s] at line %d%n",
                        indent,
                        symbol.getName(),
                        symbol.getLine());
            }
        }

        for (Scope child : scope.getChildScopes()) {
            printScopeWithSymbols(child, indentLevel + 1);
        }
    }

}