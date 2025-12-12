// Generated from C:/Users/User/Desktop/comp/CompilerProject/src/antlr/PythonFlaskParser.g4 by ANTLR 4.13.2

package antlr.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonFlaskParser}.
 */
public interface PythonFlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code FileInputNode}
	 * labeled alternative in {@link PythonFlaskParser#file_input}.
	 * @param ctx the parse tree
	 */
	void enterFileInputNode(PythonFlaskParser.FileInputNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FileInputNode}
	 * labeled alternative in {@link PythonFlaskParser#file_input}.
	 * @param ctx the parse tree
	 */
	void exitFileInputNode(PythonFlaskParser.FileInputNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecoratorNode}
	 * labeled alternative in {@link PythonFlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorNode(PythonFlaskParser.DecoratorNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecoratorNode}
	 * labeled alternative in {@link PythonFlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorNode(PythonFlaskParser.DecoratorNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#decoratorArgs}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorArgs(PythonFlaskParser.DecoratorArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#decoratorArgs}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorArgs(PythonFlaskParser.DecoratorArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedDecoratorArgsNode}
	 * labeled alternative in {@link PythonFlaskParser#namedDecoratorArgs}.
	 * @param ctx the parse tree
	 */
	void enterNamedDecoratorArgsNode(PythonFlaskParser.NamedDecoratorArgsNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedDecoratorArgsNode}
	 * labeled alternative in {@link PythonFlaskParser#namedDecoratorArgs}.
	 * @param ctx the parse tree
	 */
	void exitNamedDecoratorArgsNode(PythonFlaskParser.NamedDecoratorArgsNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecoratedDefNode}
	 * labeled alternative in {@link PythonFlaskParser#decorated_def}.
	 * @param ctx the parse tree
	 */
	void enterDecoratedDefNode(PythonFlaskParser.DecoratedDefNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecoratedDefNode}
	 * labeled alternative in {@link PythonFlaskParser#decorated_def}.
	 * @param ctx the parse tree
	 */
	void exitDecoratedDefNode(PythonFlaskParser.DecoratedDefNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmtNode(PythonFlaskParser.SimpleStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmtNode(PythonFlaskParser.SimpleStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmtNode(PythonFlaskParser.CompoundStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmtNode(PythonFlaskParser.CompoundStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleStmtLineNode}
	 * labeled alternative in {@link PythonFlaskParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmtLineNode(PythonFlaskParser.SimpleStmtLineNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleStmtLineNode}
	 * labeled alternative in {@link PythonFlaskParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmtLineNode(PythonFlaskParser.SimpleStmtLineNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSmall_stmt(PythonFlaskParser.Small_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#small_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSmall_stmt(PythonFlaskParser.Small_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(PythonFlaskParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(PythonFlaskParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(PythonFlaskParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(PythonFlaskParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPass_stmt(PythonFlaskParser.Pass_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#pass_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPass_stmt(PythonFlaskParser.Pass_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(PythonFlaskParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(PythonFlaskParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(PythonFlaskParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(PythonFlaskParser.Continue_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(PythonFlaskParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(PythonFlaskParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(PythonFlaskParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(PythonFlaskParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefNode}
	 * labeled alternative in {@link PythonFlaskParser#function_def}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefNode(PythonFlaskParser.FunctionDefNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefNode}
	 * labeled alternative in {@link PythonFlaskParser#function_def}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefNode(PythonFlaskParser.FunctionDefNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterListNode}
	 * labeled alternative in {@link PythonFlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterListNode(PythonFlaskParser.ParameterListNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterListNode}
	 * labeled alternative in {@link PythonFlaskParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterListNode(PythonFlaskParser.ParameterListNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDefNode}
	 * labeled alternative in {@link PythonFlaskParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClassDefNode(PythonFlaskParser.ClassDefNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDefNode}
	 * labeled alternative in {@link PythonFlaskParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClassDefNode(PythonFlaskParser.ClassDefNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WithStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWithStmtNode(PythonFlaskParser.WithStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WithStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#with_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWithStmtNode(PythonFlaskParser.WithStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmtNode(PythonFlaskParser.IfStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmtNode(PythonFlaskParser.IfStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmtNode(PythonFlaskParser.ForStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmtNode(PythonFlaskParser.ForStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmtNode(PythonFlaskParser.WhileStmtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmtNode}
	 * labeled alternative in {@link PythonFlaskParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmtNode(PythonFlaskParser.WhileStmtNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(PythonFlaskParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(PythonFlaskParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(PythonFlaskParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(PythonFlaskParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(PythonFlaskParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(PythonFlaskParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#importTargets}.
	 * @param ctx the parse tree
	 */
	void enterImportTargets(PythonFlaskParser.ImportTargetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#importTargets}.
	 * @param ctx the parse tree
	 */
	void exitImportTargets(PythonFlaskParser.ImportTargetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonFlaskParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonFlaskParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(PythonFlaskParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(PythonFlaskParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(PythonFlaskParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(PythonFlaskParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(PythonFlaskParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(PythonFlaskParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonFlaskParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonFlaskParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(PythonFlaskParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(PythonFlaskParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(PythonFlaskParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(PythonFlaskParser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PythonFlaskParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PythonFlaskParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PythonFlaskParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PythonFlaskParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#power}.
	 * @param ctx the parse tree
	 */
	void enterPower(PythonFlaskParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#power}.
	 * @param ctx the parse tree
	 */
	void exitPower(PythonFlaskParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PythonFlaskParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PythonFlaskParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#atom_base}.
	 * @param ctx the parse tree
	 */
	void enterAtom_base(PythonFlaskParser.Atom_baseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#atom_base}.
	 * @param ctx the parse tree
	 */
	void exitAtom_base(PythonFlaskParser.Atom_baseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterTrailer(PythonFlaskParser.TrailerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitTrailer(PythonFlaskParser.TrailerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(PythonFlaskParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(PythonFlaskParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(PythonFlaskParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(PythonFlaskParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#namedArgList}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgList(PythonFlaskParser.NamedArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#namedArgList}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgList(PythonFlaskParser.NamedArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonFlaskParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void enterList_literal(PythonFlaskParser.List_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonFlaskParser#list_literal}.
	 * @param ctx the parse tree
	 */
	void exitList_literal(PythonFlaskParser.List_literalContext ctx);
}