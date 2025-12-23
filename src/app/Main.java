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
import visitor.WebVisitor;

import ast.base.ASTNode;
import symbol.SymbolTable;
import symbol.Symbol;
import symbol.Scope;

import java.io.IOException;
import java.util.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
        try {

            // ======================= AST PRINTING =======================
            System.out.println("\n" + "=".repeat(70));
            System.out.println("AST GENERATION & PRINTING");
            System.out.println("=".repeat(70));

            buildAndPrintPython("FileOfTest/flask_app.txt");

            List<String> webFiles = List.of(
                    "FileOfTest/home.txt",
                    "FileOfTest/addProductHtml.txt",
                    "FileOfTest/product_details.txt"
            );

            for (String file : webFiles) {
                buildAndPrintWeb(file);
            }

            // ======================= SYMBOL TABLE ANALYSIS =======================
            System.out.println("\n" + "=".repeat(70));
            System.out.println("SYMBOL TABLE ANALYSIS SYSTEM");
            System.out.println("=".repeat(70));

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

    // ================= PYTHON AST =================
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

    // ================= WEB AST =================
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

    // ================= WEB TEMPLATE SYMBOL ANALYSIS =================
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

    // ================= PYTHON SYMBOL ANALYSIS =================
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

    // ================= SYMBOL TABLE PRINTING =================
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

        allSymbols.sort(Comparator.comparingInt(Symbol::getLine));

        System.out.printf("%-25s | %-15s | %-10s%n", "Symbol Name", "Type", "Line");
        System.out.println("-".repeat(60));

        for (Symbol sym : allSymbols) {
            int line = sym.getLine() < 0 ? 0 : sym.getLine();
            System.out.printf("%-25s | %-15s | %-10d%n",
                    sym.getName(), sym.getType(), line);
        }

        System.out.println("-".repeat(60));
    }
}
