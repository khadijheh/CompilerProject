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
//            buildAndPrintPython("FileOfTest/flask_app.txt");
            List<String> webFiles = List.of(
                    "FileOfTest/home.txt"
//                    "FileOfTest/addProductHtml.txt",
//                    "FileOfTest/product_details.txt"
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
