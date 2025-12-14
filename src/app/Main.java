// java
package app;

import antlr.PythonFlaskParser;
import antlr.PythonLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import visitor.PythonVisitor;
import visitor.PrinterVisitor;
import ast.base.ASTNode;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "FileOfTest/flask_app.txt";
            CharStream input = fromFileName(path);
            PythonLexer lexer = new PythonLexer(input);
            CommonTokenStream token = new CommonTokenStream(lexer);
            PythonFlaskParser parser = new PythonFlaskParser(token);

            parser.removeErrorListeners();
            parser.addErrorListener(new DiagnosticErrorListener());

            ParseTree tree = parser.file_input();
            PythonVisitor pythonVisitor = new PythonVisitor();
            ASTNode ast = pythonVisitor.visit(tree);
            PrinterVisitor printer = new PrinterVisitor();
            ast.accept(printer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
