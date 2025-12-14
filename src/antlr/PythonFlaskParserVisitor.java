// Generated from C:/Users/scc/IdeaProjects/CompilerProject/src/antlr/PythonFlaskParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonFlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonFlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code FileInputNode}
	 * labeled alternative in {@link PythonFlaskParser#file_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileInputNode(PythonFlaskParser.FileInputNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecoratorNode}
	 * labeled alternative in {@link PythonFlaskParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorNode(PythonFlaskParser.DecoratorNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#decoratorArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorArgs(PythonFlaskParser.DecoratorArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NamedDecoratorArgsNode}
	 * labeled alternative in {@link PythonFlaskParser#namedDecoratorArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedDecoratorArgsNode(PythonFlaskParser.NamedDecoratorArgsNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecoratedDefNode}
	 * labeled alternative in {@link PythonFlaskParser#decorated_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratedDefNode(PythonFlaskParser.DecoratedDefNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmtNode(PythonFlaskParser.SimpleStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmtNode(PythonFlaskParser.CompoundStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStmtLineNode}
	 * labeled alternative in {@link PythonFlaskParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmtLineNode(PythonFlaskParser.SimpleStmtLineNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#small_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmall_stmt(PythonFlaskParser.Small_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(PythonFlaskParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(PythonFlaskParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#pass_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass_stmt(PythonFlaskParser.Pass_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(PythonFlaskParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(PythonFlaskParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(PythonFlaskParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(PythonFlaskParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefNode}
	 * labeled alternative in {@link PythonFlaskParser#function_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefNode(PythonFlaskParser.FunctionDefNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterListNode}
	 * labeled alternative in {@link PythonFlaskParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListNode(PythonFlaskParser.ParameterListNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassDefNode}
	 * labeled alternative in {@link PythonFlaskParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefNode(PythonFlaskParser.ClassDefNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#with_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStmtNode(PythonFlaskParser.WithStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmtNode(PythonFlaskParser.IfStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmtNode(PythonFlaskParser.ForStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmtNode(PythonFlaskParser.WhileStmtNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(PythonFlaskParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#import_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_stmt(PythonFlaskParser.Import_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(PythonFlaskParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#importTargets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportTargets(PythonFlaskParser.ImportTargetsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PythonFlaskParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#or_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_test(PythonFlaskParser.Or_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#and_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_test(PythonFlaskParser.And_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#not_test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_test(PythonFlaskParser.Not_testContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(PythonFlaskParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(PythonFlaskParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(PythonFlaskParser.ArithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PythonFlaskParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(PythonFlaskParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(PythonFlaskParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PythonFlaskParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#atom_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_base(PythonFlaskParser.Atom_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailer(PythonFlaskParser.TrailerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(PythonFlaskParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(PythonFlaskParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#namedArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgList(PythonFlaskParser.NamedArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonFlaskParser#list_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_literal(PythonFlaskParser.List_literalContext ctx);
}