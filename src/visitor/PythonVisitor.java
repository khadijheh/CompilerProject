package visitor;

import antlr.*;
import ast.base.*;
import ast.python.statements.*;
import ast.python.expressions.*;
import ast.python.other.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class PythonVisitor extends PythonFlaskParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitFileInputNode(PythonFlaskParser.FileInputNodeContext ctx) {
        List<BaseNode> elements = new ArrayList<>();
        for (var child : ctx.children) {
                ASTNode node = visit(child);
                if (node instanceof BaseNode bn) {
                    elements.add(bn);

            }
        }

        return new FileInputNode(
                elements,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitNamedArgList(PythonFlaskParser.NamedArgListContext ctx) {
        List<String> names = new ArrayList<>();
        List<ExprNode> values = new ArrayList<>();

        if (ctx == null || ctx.NAME() == null || ctx.NAME().isEmpty()) {
            return new NamedArgListNode(names, values,
                    ctx != null && ctx.start != null ? ctx.start.getLine() : -1,
                    ctx != null && ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
        }

        // safe access
        names.add(ctx.NAME(0).getText());
        values.add((ExprNode) visit(ctx.expr(0)));

        int extraCount = ctx.NAME().size() - 1;
        for (int i = 1; i <= extraCount; i++) {
            names.add(ctx.NAME(i).getText());
            values.add((ExprNode) visit(ctx.expr(i)));
        }

        return new NamedArgListNode(
                names,
                values,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }


    @Override
    public ASTNode visitList_literal(PythonFlaskParser.List_literalContext ctx) {
        List<ExprNode> elements = new ArrayList<>();
        if (ctx != null && ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (var exprCtx : ctx.expr()) {
                if (exprCtx == null) continue;
                ExprNode expr = (ExprNode) visit(exprCtx);
                if (expr != null) elements.add(expr);
            }
        }

        return new ListLiteralNode(
                elements,
                ctx != null && ctx.start != null ? ctx.start.getLine() : -1,
                ctx != null && ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }


    @Override
    public ASTNode visitArgList(PythonFlaskParser.ArgListContext ctx) {
        List<ExprNode> positional = new ArrayList<>();
        NamedArgListNode named = null;
        if (ctx == null) {
            return new ArgListNode(positional, named, -1, -1);
        }

        if (ctx.namedArgList() != null && (ctx.expr() == null || ctx.expr().isEmpty())) {
            named = (NamedArgListNode) visit(ctx.namedArgList());
        }

        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (var exprCtx : ctx.expr()) {
                if (exprCtx == null) continue;
                positional.add((ExprNode) visit(exprCtx));
            }

            if (ctx.namedArgList() != null) {
                named = (NamedArgListNode) visit(ctx.namedArgList());
            }
        }

        return new ArgListNode(
                positional,
                named,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }

    @Override
    public ASTNode visitIndex(PythonFlaskParser.IndexContext ctx) {
        ExprNode indexExpr = (ExprNode) visit(ctx.expr());
        return new IndexNode(
                null,
                indexExpr,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitAtom(PythonFlaskParser.AtomContext ctx) {
        ExprNode base = (ExprNode) visit(ctx.atom_base());
        for (PythonFlaskParser.TrailerContext trailerCtx : ctx.trailer()) {
            ASTNode trailer = visit(trailerCtx);
            if (trailer instanceof AttributeNode attr) {
                base = new AttributeNode(
                        base,
                        attr.getAttribute(),
                        attr.getLine(),
                        attr.getColumn()
                );
            } else if (trailer instanceof CallNode call) {
                base = new CallNode(
                        base,
                        call.getArgs(),
                        call.getNamedArgs(),
                        call.getLine(),
                        call.getColumn()
                );
            } else if (trailer instanceof IndexNode index) {
                base = new IndexNode(
                        base,
                        index.getIndex(),
                        index.getLine(),
                        index.getColumn()
                );
            }
        }

        return base;
    }


    @Override
    public ASTNode visitPower(PythonFlaskParser.PowerContext ctx) {
        if (ctx == null || ctx.atom() == null) return null;
        ExprNode left = (ExprNode) visit(ctx.atom());
        if (ctx.factor() != null) {
            ExprNode right = (ExprNode) visit(ctx.factor());
            return new BinaryOpNode("**", left, right, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return left;
    }

    @Override
    public ASTNode visitTerm(PythonFlaskParser.TermContext ctx) {
        if (ctx == null || ctx.factor() == null || ctx.factor().isEmpty()) return null;
        ExprNode left = (ExprNode) visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            ExprNode right = (ExprNode) visit(ctx.factor(i));
            String op = ctx.getChild(2 * i - 1).getText(); // * / // %
            left = new BinaryOpNode(op, left, right, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return left;
    }

    @Override
    public ASTNode visitArithExpr(PythonFlaskParser.ArithExprContext ctx) {
        if (ctx == null || ctx.term() == null || ctx.term().isEmpty()) return null;
        ExprNode left = (ExprNode) visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            ExprNode right = (ExprNode) visit(ctx.term(i));
            String op = ctx.getChild(2 * i - 1).getText(); // + -
            left = new BinaryOpNode(op, left, right, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return left;
    }


    @Override
    public ASTNode visitComparison(PythonFlaskParser.ComparisonContext ctx) {

        ExprNode left = (ExprNode) visit(ctx.arithExpr(0));

        if (ctx.compOp() == null || ctx.compOp().isEmpty()) {
            return left;
        }

        List<ComparisonNode.ComparisonOp> ops = new ArrayList<>();

        for (int i = 0; i < ctx.compOp().size(); i++) {
            String operator = ctx.compOp(i).getText();
            ExprNode right = (ExprNode) visit(ctx.arithExpr(i + 1));

            ops.add(new ComparisonNode.ComparisonOp(operator, right));
        }

        return new ComparisonNode(
                left,
                ops,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitExpr(PythonFlaskParser.ExprContext ctx) {
        return visit(ctx.or_test());
    }

    @Override
    public ASTNode visitNot_test(PythonFlaskParser.Not_testContext ctx) {
        if (ctx == null) return null;

        if (ctx.NOT() != null && ctx.not_test() != null) {
            ExprNode operand = (ExprNode) visit(ctx.not_test());
            return new UnaryOpNode("not", operand,
                    ctx.start != null ? ctx.start.getLine() : -1,
                    ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
        }

        if (ctx.comparison() != null) {
            return visit(ctx.comparison());
        }

        return null;
    }


    @Override
    public ASTNode visitFactor(PythonFlaskParser.FactorContext ctx) {
        if (ctx == null) return null;
        ExprNode base = (ExprNode) visit(ctx.power());
        if (base == null) return null;
        if (ctx.ADD() != null) {
            return new UnaryOpNode(ctx.ADD().getText(), base, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.SUB() != null) {
            return new UnaryOpNode(ctx.SUB().getText(), base, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else {
            return base;
        }
    }

    @Override
    public ASTNode visitAtom_base(PythonFlaskParser.Atom_baseContext ctx) {
        if (ctx == null) return null;
        if (ctx.NAME() != null) {
            return new NameNode(ctx.NAME().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.NUMBER() != null) {
            return new NumberNode(ctx.NUMBER().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.STRING() != null) {
            return new StringNode(ctx.STRING().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.list_literal() != null) {
            return visit(ctx.list_literal());
        } else if (ctx.LPAREN() != null && ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.TRUE() != null) {
            return new BoolNode(true, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.FALSE() != null) {
            return new BoolNode(false, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        } else if (ctx.NONE() != null) {
            return new NoneNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return null;
    }


    @Override
    public ASTNode visitImport_stmt(PythonFlaskParser.Import_stmtContext ctx) {
        if (ctx == null) return null;

        if (ctx.IMPORT() != null && ctx.FROM() == null) {
            List<String> imports = new ArrayList<>();
            if (ctx.dottedName() != null) {
                for (PythonFlaskParser.DottedNameContext dnCtx : ctx.dottedName()) {
                    if (dnCtx == null) continue;
                    imports.add(dnCtx.getText().trim());
                }
            }
            return new ImportStmtNode(null, imports, false,
                    ctx.start != null ? ctx.start.getLine() : -1,
                    ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
            };
        }

        if (ctx.FROM() != null) {
            String module = "";
            if (ctx.dottedName() != null && !ctx.dottedName().isEmpty()) {
                module = ctx.dottedName(0).getText();
            }

            List<String> imports = new ArrayList<>();
            if (ctx.importTargets() != null) {
                ImportStmtNode targetsNode = (ImportStmtNode) visit(ctx.importTargets());
                if (targetsNode != null) imports = targetsNode.getImports();
            }

            return new ImportStmtNode(module, imports, true,
                    ctx.start != null ? ctx.start.getLine() : -1,
                    ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
            };
        }

        return null;
    }


    @Override
    public ASTNode visitWhileStmtNode(PythonFlaskParser.WhileStmtNodeContext ctx) {
        if (ctx == null) return null;


        ExprNode condition = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        List<BaseNode> body = extractSuiteStatements(ctx.suite());
        return new WhileStmtNode(condition, body,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }


    @Override
    public ASTNode visitForStmtNode(PythonFlaskParser.ForStmtNodeContext ctx) {
        if (ctx == null) return null;
        BaseNode target = ctx.target() != null ? (BaseNode) visit(ctx.target()) : null;
        ExprNode iterable = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        List<BaseNode> body = extractSuiteStatements(ctx.suite());
        return new ForStmtNode(target, iterable, body,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }

    @Override
    public ASTNode visitIfStmtNode(PythonFlaskParser.IfStmtNodeContext ctx) {
        if (ctx == null) return null;

        // -------- condition --------
        ExprNode condition = (ExprNode) visit(ctx.expr(0));

        // -------- then body --------
        List<BaseNode> thenBody = extractSuiteStatements(ctx.suite(0));

        // -------- elif branches --------
        List<IfStmtNode.IfBranch> elifBranches = new ArrayList<>();

        int elifCount = ctx.ELIF().size();
        for (int i = 0; i < elifCount; i++) {
            ExprNode elifCond = (ExprNode) visit(ctx.expr(i + 1));
            List<BaseNode> elifBody = extractSuiteStatements(ctx.suite(i + 1));
            elifBranches.add(new IfStmtNode.IfBranch(elifCond, elifBody));
        }

        // -------- else body --------
        List<BaseNode> elseBody = new ArrayList<>();
        if (ctx.ELSE() != null) {
            // The last suite is the else body
            int elseIndex = ctx.suite().size() - 1;
            elseBody = extractSuiteStatements(ctx.suite(elseIndex));
        }

        return new IfStmtNode(
                condition,
                thenBody,
                elifBranches,
                elseBody,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }

    private List<BaseNode> extractSuiteStatements(PythonFlaskParser.SuiteContext suite) {
        List<BaseNode> result = new ArrayList<>();
        if (suite == null) return result;

        ASTNode node = visit(suite);

        if (node instanceof CompoundStmtNode) {
            result.addAll(((CompoundStmtNode) node).getStatements());
        } else if (node instanceof BaseNode) {
            result.add((BaseNode) node);
        }

        return result;
    }

    @Override
    public ASTNode visitSuite(PythonFlaskParser.SuiteContext ctx) {
        List<BaseNode> statements = new ArrayList<>();

        if (ctx.simple_stmt() != null) {
            ASTNode n = visit(ctx.simple_stmt());
            if (n instanceof BaseNode) {
                statements.add((BaseNode) n);
            }
        } else {
            for (PythonFlaskParser.StmtContext stmtCtx : ctx.stmt()) {
                ASTNode n = visit(stmtCtx);
                if (n instanceof BaseNode) {
                    statements.add((BaseNode) n);
                }
            }
        }

        return new CompoundStmtNodeList(
                statements,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }

    @Override
    public ASTNode visitWithStmtNode(PythonFlaskParser.WithStmtNodeContext ctx) {
        if (ctx == null) return null;
        ExprNode expression = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        String alias = ctx.NAME() != null ? ctx.NAME().getText() : null;

        List<BaseNode> body = extractSuiteStatements(ctx.suite());

        return new WithStmtNode(expression, alias, body,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }

    @Override
    public ASTNode visitParameterListNode(PythonFlaskParser.ParameterListNodeContext ctx) {
        List<String> parameters = new ArrayList<>();
        if (ctx == null || ctx.NAME() == null) return new ParameterListNode(parameters, -1, -1);
        for (var nameCtx : ctx.NAME()) {
            parameters.add(nameCtx.getText());
        }
        return new ParameterListNode(parameters,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
    }

    @Override
    public ASTNode visitCompound_stmt(PythonFlaskParser.Compound_stmtContext ctx) {
        if (ctx == null) return null;

        if (ctx.if_stmt() != null) return visit(ctx.if_stmt());
        if (ctx.for_stmt() != null) return visit(ctx.for_stmt());
        if (ctx.while_stmt() != null) return visit(ctx.while_stmt());
        if (ctx.with_stmt() != null) return visit(ctx.with_stmt());
        if (ctx.class_def() != null) return visit(ctx.class_def());
        return null;
    }


    @Override
    public ASTNode visitReturn_stmt(PythonFlaskParser.Return_stmtContext ctx) {
        if (ctx == null) return null;
        BaseNode value = ctx.expr() != null ? (BaseNode) visit(ctx.expr()) : null;
        return new ReturnStmtNode(
                value,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitSimpleStmtNode(PythonFlaskParser.SimpleStmtNodeContext ctx) {
        return visit(ctx.simple_stmt());
    }



    @Override
    public ASTNode visitSimpleStmtLineNode(PythonFlaskParser.SimpleStmtLineNodeContext ctx) {
        if (ctx == null || ctx.small_stmt() == null) return null;

        List<BaseNode> statements = new ArrayList<>();
        for (var smallStmtCtx : ctx.small_stmt()) {
            if (smallStmtCtx == null) continue;
            ASTNode n = visit(smallStmtCtx);
            if (n != null) statements.add((BaseNode) n);
        }

        if (statements.isEmpty()) return null;

        return new SimpleStmtLineNode(statements,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }

    @Override
    public ASTNode visitNamedDecoratorArgsNode(PythonFlaskParser.NamedDecoratorArgsNodeContext ctx) {
        List<String> names = new ArrayList<>();
        List<ExprNode> values = new ArrayList<>();
        if (ctx == null || ctx.NAME() == null) return new NamedDecoratorArgsNode(names, values, -1, -1) {
        };

        for (int i = 0; i < ctx.NAME().size(); i++) {
            names.add(ctx.NAME(i).getText());
            values.add((ExprNode) visit(ctx.expr(i)));
        }

        return new NamedDecoratorArgsNode(names, values,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }

    public ASTNode visitSmall_stmt(PythonFlaskParser.Small_stmtContext ctx) {
        if (ctx == null) return null;

        if (ctx.import_stmt() != null) {
            return visitImport_stmt(ctx.import_stmt());
        } else if (ctx.expr_stmt() != null) {
            return visit(ctx.expr_stmt());
        } else if (ctx.pass_stmt() != null) {
            return visit(ctx.pass_stmt());
        } else if (ctx.break_stmt() != null) {
            return visit(ctx.break_stmt());
        } else if (ctx.continue_stmt() != null) {
            return visit(ctx.continue_stmt());
        } else if (ctx.return_stmt() != null) {
            return visit(ctx.return_stmt());
        }

        return null;
    }

    @Override
    public ASTNode visitTarget(PythonFlaskParser.TargetContext ctx) {
        if (ctx.atom() != null)
            return visit(ctx.atom());
        if (ctx.NAME() != null) {
            return new NameNode(ctx.NAME().getText(), ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
        }
        return null;
    }

    @Override
    public ASTNode visitExpr_stmt(PythonFlaskParser.Expr_stmtContext ctx) {
        if (ctx == null) return null;

        BaseNode left = ctx.target() != null ? (BaseNode) visit(ctx.target()) : null;
        ExprNode right = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;

        // assignment
        if (left != null && right != null && ctx.ASSIGN() != null) {
            return new AssignNode(left, right, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    @Override
    public ASTNode visitContinue_stmt(PythonFlaskParser.Continue_stmtContext ctx) {
        if (ctx == null) return null;
        return new ContinueNode(ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
    }

    @Override
    public ASTNode visitBreak_stmt(PythonFlaskParser.Break_stmtContext ctx) {
        if (ctx == null) return null;
        return new BreakNode(ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
    }

    @Override
    public ASTNode visitPass_stmt(PythonFlaskParser.Pass_stmtContext ctx) {
        if (ctx == null) return null;
        return new PassNode(ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
    }

    @Override
    public ASTNode visitCompOp(PythonFlaskParser.CompOpContext ctx) {
        if (ctx == null) return null;
        return new StringNode(ctx.getText(), ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
    }

    @Override
    public ASTNode visitTrailer(PythonFlaskParser.TrailerContext ctx) {
        if (ctx == null) return null;

        // ===== attribute access: .name =====
        if (ctx.DOT() != null && ctx.NAME() != null) {
            return new AttributeNode(
                    null,
                    ctx.NAME().getText(),
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }

        // ===== function call: () =====
        if (ctx.LPAREN() != null) {
            ArgListNode args = ctx.argList() != null
                    ? (ArgListNode) visit(ctx.argList())
                    : new ArgListNode(new ArrayList<>(), null, ctx.start.getLine(), ctx.start.getCharPositionInLine());

            return new CallNode(null, args.getPositional(), args.getNamed(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        if (ctx.index() != null) {
            ExprNode indexExpr = (ExprNode) visit(ctx.index());
            return new IndexNode(null, indexExpr, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }

        return null;
    }

    @Override
    public ASTNode visitAnd_test(PythonFlaskParser.And_testContext ctx) {
        if (ctx == null || ctx.not_test() == null || ctx.not_test().isEmpty()) return null;
        ExprNode left = (ExprNode) visit(ctx.not_test(0));
        for (int i = 1; i < ctx.not_test().size(); i++) {
            ExprNode right = (ExprNode) visit(ctx.not_test(i));
            left = new BinaryOpNode("and", left, right, ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
        }
        return left;
    }

    @Override
    public ASTNode visitOr_test(PythonFlaskParser.Or_testContext ctx) {
        if (ctx == null || ctx.and_test() == null || ctx.and_test().isEmpty()) return null;
        ExprNode left = (ExprNode) visit(ctx.and_test(0));
        for (int i = 1; i < ctx.and_test().size(); i++) {
            ExprNode right = (ExprNode) visit(ctx.and_test(i));
            left = new BinaryOpNode("or", left, right, ctx.start != null ? ctx.start.getLine() : -1, ctx.start != null ? ctx.start.getCharPositionInLine() : -1);
        }
        return left;
    }

    @Override
    public ASTNode visitImportTargets(PythonFlaskParser.ImportTargetsContext ctx) {
        List<String> imports = new ArrayList<>();
        if (ctx != null && ctx.NAME() != null) {
            for (var token : ctx.NAME()) {
                imports.add(token.getText().trim());
            }
        }
        return new ImportStmtNode(null, imports, false,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1) {
        };
    }
    @Override
    public ASTNode visitDecoratedDefNode(PythonFlaskParser.DecoratedDefNodeContext ctx) {
        List<DecoratorNode> decorators = new ArrayList<>();

        for (var dctx : ctx.decorator()) {
            decorators.add((DecoratorNode) visit(dctx));
        }
        FunctionDefNode func = null;
        if (ctx.function_def() != null) {
            func = (FunctionDefNode) visit(ctx.function_def());
        } else {
            func = new FunctionDefNode("<missing NAME>", new ParameterListNode(new ArrayList<>(), ctx.start.getLine(), ctx.start.getCharPositionInLine()), new ArrayList<>(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return new DecoratedDefNode(
                decorators,
                func,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitFunctionDefNode(PythonFlaskParser.FunctionDefNodeContext ctx) {
        if (ctx == null) return null;

        String name = ctx.NAME() != null ? ctx.NAME().getText() : "<missing NAME>";

        ParameterListNode params = ctx.parameterList() != null
                ? (ParameterListNode) visit(ctx.parameterList())
                : new ParameterListNode(new ArrayList<>(), ctx.start.getLine(), ctx.start.getCharPositionInLine());

        List<BaseNode> body = extractSuiteStatements(ctx.suite());

        return new FunctionDefNode(
                name,
                params,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitClassDefNode(PythonFlaskParser.ClassDefNodeContext ctx) {
        if (ctx == null) return null;

        String name = ctx.NAME() != null ? ctx.NAME().getText() : "";

        List<BaseNode> baseClasses = new ArrayList<>();
        if (ctx.argList() != null && ctx.argList().expr() != null) {
            for (PythonFlaskParser.ExprContext exprCtx : ctx.argList().expr()) {
                ASTNode n = visit(exprCtx);
                if (n instanceof ExprNode) baseClasses.add((BaseNode) n);
            }
        }

        List<BaseNode> body = extractSuiteStatements(ctx.suite());

        return new ClassDefNode(
                name,
                baseClasses,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitDecoratorNode(PythonFlaskParser.DecoratorNodeContext ctx) {
        String decoratorName = ctx.dottedName().getText().trim();
        DecoratorArgsNode argsNode = null;

        if (ctx.decoratorArgs() != null) {
            ASTNode args = visit(ctx.decoratorArgs());
            if (args instanceof DecoratorArgsNode dan) {
                argsNode = dan;
            }
        }

        return new DecoratorNode(
                decoratorName,
                argsNode,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitDecoratorArgs(PythonFlaskParser.DecoratorArgsContext ctx) {
        List<ExprNode> positional = new ArrayList<>();
        NamedDecoratorArgsNode named = null;

        if (ctx.expr() != null) {
            for (var exprCtx : ctx.expr()) {
                ExprNode node = (ExprNode) visit(exprCtx);
                if (node != null) positional.add(node);
            }
        }

        if (ctx.namedDecoratorArgs() != null) {
            named = (NamedDecoratorArgsNode) visit(ctx.namedDecoratorArgs());
        }

        return new DecoratorArgsNode(
                positional,
                named,
                ctx.start != null ? ctx.start.getLine() : -1,
                ctx.start != null ? ctx.start.getCharPositionInLine() : -1
        );
    }

}