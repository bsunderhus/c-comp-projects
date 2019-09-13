// Generated from Grammar.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#algoritmo}.
	 * @param ctx the parse tree
	 */
	void enterAlgoritmo(GrammarParser.AlgoritmoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#algoritmo}.
	 * @param ctx the parse tree
	 */
	void exitAlgoritmo(GrammarParser.AlgoritmoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaracao_algoritmo}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_algoritmo(GrammarParser.Declaracao_algoritmoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaracao_algoritmo}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_algoritmo(GrammarParser.Declaracao_algoritmoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#var_decl_block}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_block(GrammarParser.Var_decl_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#var_decl_block}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_block(GrammarParser.Var_decl_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(GrammarParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(GrammarParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tp_primitivo}.
	 * @param ctx the parse tree
	 */
	void enterTp_primitivo(GrammarParser.Tp_primitivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tp_primitivo}.
	 * @param ctx the parse tree
	 */
	void exitTp_primitivo(GrammarParser.Tp_primitivoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tp_matriz}.
	 * @param ctx the parse tree
	 */
	void enterTp_matriz(GrammarParser.Tp_matrizContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tp_matriz}.
	 * @param ctx the parse tree
	 */
	void exitTp_matriz(GrammarParser.Tp_matrizContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tp_prim_pl}.
	 * @param ctx the parse tree
	 */
	void enterTp_prim_pl(GrammarParser.Tp_prim_plContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tp_prim_pl}.
	 * @param ctx the parse tree
	 */
	void exitTp_prim_pl(GrammarParser.Tp_prim_plContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_block}.
	 * @param ctx the parse tree
	 */
	void enterStm_block(GrammarParser.Stm_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_block}.
	 * @param ctx the parse tree
	 */
	void exitStm_block(GrammarParser.Stm_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_list}.
	 * @param ctx the parse tree
	 */
	void enterStm_list(GrammarParser.Stm_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_list}.
	 * @param ctx the parse tree
	 */
	void exitStm_list(GrammarParser.Stm_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_ret}.
	 * @param ctx the parse tree
	 */
	void enterStm_ret(GrammarParser.Stm_retContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_ret}.
	 * @param ctx the parse tree
	 */
	void exitStm_ret(GrammarParser.Stm_retContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(GrammarParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(GrammarParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_attr}.
	 * @param ctx the parse tree
	 */
	void enterStm_attr(GrammarParser.Stm_attrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_attr}.
	 * @param ctx the parse tree
	 */
	void exitStm_attr(GrammarParser.Stm_attrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_se}.
	 * @param ctx the parse tree
	 */
	void enterStm_se(GrammarParser.Stm_seContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_se}.
	 * @param ctx the parse tree
	 */
	void exitStm_se(GrammarParser.Stm_seContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_enquanto}.
	 * @param ctx the parse tree
	 */
	void enterStm_enquanto(GrammarParser.Stm_enquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_enquanto}.
	 * @param ctx the parse tree
	 */
	void exitStm_enquanto(GrammarParser.Stm_enquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stm_para}.
	 * @param ctx the parse tree
	 */
	void enterStm_para(GrammarParser.Stm_paraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stm_para}.
	 * @param ctx the parse tree
	 */
	void exitStm_para(GrammarParser.Stm_paraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#passo}.
	 * @param ctx the parse tree
	 */
	void enterPasso(GrammarParser.PassoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#passo}.
	 * @param ctx the parse tree
	 */
	void exitPasso(GrammarParser.PassoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fcall}.
	 * @param ctx the parse tree
	 */
	void enterFcall(GrammarParser.FcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fcall}.
	 * @param ctx the parse tree
	 */
	void exitFcall(GrammarParser.FcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fargs}.
	 * @param ctx the parse tree
	 */
	void enterFargs(GrammarParser.FargsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fargs}.
	 * @param ctx the parse tree
	 */
	void exitFargs(GrammarParser.FargsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GrammarParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(GrammarParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(GrammarParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fvar_decl}.
	 * @param ctx the parse tree
	 */
	void enterFvar_decl(GrammarParser.Fvar_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fvar_decl}.
	 * @param ctx the parse tree
	 */
	void exitFvar_decl(GrammarParser.Fvar_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fparams}.
	 * @param ctx the parse tree
	 */
	void enterFparams(GrammarParser.FparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fparams}.
	 * @param ctx the parse tree
	 */
	void exitFparams(GrammarParser.FparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fparam}.
	 * @param ctx the parse tree
	 */
	void enterFparam(GrammarParser.FparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fparam}.
	 * @param ctx the parse tree
	 */
	void exitFparam(GrammarParser.FparamContext ctx);
}