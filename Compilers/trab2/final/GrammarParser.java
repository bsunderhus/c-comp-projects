// Generated from Grammar.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, WS=57, BlockComment=58, LineComment=59, 
		PALAVRA_RESERVADA=60, LITERAL=61, CARACTERE=62, ATRIBUICAO=63, IDENTIFICADOR=64, 
		SIMBOLO_ESPECIAL=65, REAL=66, INTEIRO=67, OPERADOR_RELACIONAL=68, OPERADOR_ARITIMETICA=69, 
		OPERADOR_LOGICO=70, LOGICO=71, OPERADOR_BIT_A_BIT=72, DESCONHECIDO=73;
	public static final int
		RULE_algoritmo = 0, RULE_declaracao_algoritmo = 1, RULE_var_decl_block = 2, 
		RULE_var_decl = 3, RULE_tp_primitivo = 4, RULE_tp_matriz = 5, RULE_tp_prim_pl = 6, 
		RULE_stm_block = 7, RULE_stm_list = 8, RULE_stm_ret = 9, RULE_lvalue = 10, 
		RULE_stm_attr = 11, RULE_stm_se = 12, RULE_stm_enquanto = 13, RULE_stm_para = 14, 
		RULE_passo = 15, RULE_expr = 16, RULE_termo = 17, RULE_fcall = 18, RULE_fargs = 19, 
		RULE_literal = 20, RULE_func_decl = 21, RULE_fvar_decl = 22, RULE_fparams = 23, 
		RULE_fparam = 24;
	public static final String[] ruleNames = {
		"algoritmo", "declaracao_algoritmo", "var_decl_block", "var_decl", "tp_primitivo", 
		"tp_matriz", "tp_prim_pl", "stm_block", "stm_list", "stm_ret", "lvalue", 
		"stm_attr", "stm_se", "stm_enquanto", "stm_para", "passo", "expr", "termo", 
		"fcall", "fargs", "literal", "func_decl", "fvar_decl", "fparams", "fparam"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'algoritmo'", "';'", "'variaveis'", "'fim_variaveis'", "','", "':'", 
		"'inteiro'", "'real'", "'caractere'", "'literal'", "'logico'", "'matriz'", 
		"'['", "']'", "'de'", "'inteiros'", "'reais'", "'caracteres'", "'literais'", 
		"'logicos'", "'inicio'", "'fim'", "'retorne'", "'se'", "'entao'", "'senao'", 
		"'fim_se'", "'enquanto'", "'faca'", "'fim_enquanto'", "'para'", "'ate'", 
		"'fim_para'", "'passo'", "'+'", "'-'", "'ou'", "'||'", "'e'", "'&&'", 
		"'|'", "'&'", "'^'", "'='", "'<>'", "'<'", "'<='", "'>'", "'>='", "'/'", 
		"'*'", "'%'", "'nao'", "'('", "')'", "'funcao'", null, null, null, null, 
		null, null, "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "WS", "BlockComment", 
		"LineComment", "PALAVRA_RESERVADA", "LITERAL", "CARACTERE", "ATRIBUICAO", 
		"IDENTIFICADOR", "SIMBOLO_ESPECIAL", "REAL", "INTEIRO", "OPERADOR_RELACIONAL", 
		"OPERADOR_ARITIMETICA", "OPERADOR_LOGICO", "LOGICO", "OPERADOR_BIT_A_BIT", 
		"DESCONHECIDO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AlgoritmoContext extends ParserRuleContext {
		public Declaracao_algoritmoContext declaracao_algoritmo() {
			return getRuleContext(Declaracao_algoritmoContext.class,0);
		}
		public Stm_blockContext stm_block() {
			return getRuleContext(Stm_blockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public Var_decl_blockContext var_decl_block() {
			return getRuleContext(Var_decl_blockContext.class,0);
		}
		public List<Func_declContext> func_decl() {
			return getRuleContexts(Func_declContext.class);
		}
		public Func_declContext func_decl(int i) {
			return getRuleContext(Func_declContext.class,i);
		}
		public AlgoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_algoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAlgoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAlgoritmo(this);
		}
	}

	public final AlgoritmoContext algoritmo() throws RecognitionException {
		AlgoritmoContext _localctx = new AlgoritmoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_algoritmo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			declaracao_algoritmo();
			setState(52);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(51);
				var_decl_block();
				}
			}

			setState(54);
			stm_block();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__55) {
				{
				{
				setState(55);
				func_decl();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_algoritmoContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(GrammarParser.IDENTIFICADOR, 0); }
		public Declaracao_algoritmoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_algoritmo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclaracao_algoritmo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclaracao_algoritmo(this);
		}
	}

	public final Declaracao_algoritmoContext declaracao_algoritmo() throws RecognitionException {
		Declaracao_algoritmoContext _localctx = new Declaracao_algoritmoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao_algoritmo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			match(IDENTIFICADOR);
			setState(65);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_decl_blockContext extends ParserRuleContext {
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public Var_decl_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVar_decl_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVar_decl_block(this);
		}
	}

	public final Var_decl_blockContext var_decl_block() throws RecognitionException {
		Var_decl_blockContext _localctx = new Var_decl_blockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__2);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				var_decl();
				setState(69);
				match(T__1);
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFICADOR );
			setState(75);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(GrammarParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(GrammarParser.IDENTIFICADOR, i);
		}
		public Tp_primitivoContext tp_primitivo() {
			return getRuleContext(Tp_primitivoContext.class,0);
		}
		public Tp_matrizContext tp_matriz() {
			return getRuleContext(Tp_matrizContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(IDENTIFICADOR);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(78);
				match(T__4);
				setState(79);
				match(IDENTIFICADOR);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(T__5);
			setState(88);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				{
				setState(86);
				tp_primitivo();
				}
				break;
			case T__11:
				{
				setState(87);
				tp_matriz();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tp_primitivoContext extends ParserRuleContext {
		public Tp_primitivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tp_primitivo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTp_primitivo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTp_primitivo(this);
		}
	}

	public final Tp_primitivoContext tp_primitivo() throws RecognitionException {
		Tp_primitivoContext _localctx = new Tp_primitivoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tp_primitivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tp_matrizContext extends ParserRuleContext {
		public Tp_prim_plContext tp_prim_pl() {
			return getRuleContext(Tp_prim_plContext.class,0);
		}
		public List<TerminalNode> INTEIRO() { return getTokens(GrammarParser.INTEIRO); }
		public TerminalNode INTEIRO(int i) {
			return getToken(GrammarParser.INTEIRO, i);
		}
		public Tp_matrizContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tp_matriz; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTp_matriz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTp_matriz(this);
		}
	}

	public final Tp_matrizContext tp_matriz() throws RecognitionException {
		Tp_matrizContext _localctx = new Tp_matrizContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tp_matriz);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__11);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				match(T__12);
				setState(94);
				match(INTEIRO);
				setState(95);
				match(T__13);
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(100);
			match(T__14);
			setState(101);
			tp_prim_pl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tp_prim_plContext extends ParserRuleContext {
		public Tp_prim_plContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tp_prim_pl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTp_prim_pl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTp_prim_pl(this);
		}
	}

	public final Tp_prim_plContext tp_prim_pl() throws RecognitionException {
		Tp_prim_plContext _localctx = new Tp_prim_plContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tp_prim_pl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_blockContext extends ParserRuleContext {
		public List<Stm_listContext> stm_list() {
			return getRuleContexts(Stm_listContext.class);
		}
		public Stm_listContext stm_list(int i) {
			return getRuleContext(Stm_listContext.class,i);
		}
		public Stm_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_block(this);
		}
	}

	public final Stm_blockContext stm_block() throws RecognitionException {
		Stm_blockContext _localctx = new Stm_blockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stm_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__20);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__23 - 23)) | (1L << (T__27 - 23)) | (1L << (T__30 - 23)) | (1L << (IDENTIFICADOR - 23)))) != 0)) {
				{
				{
				setState(106);
				stm_list();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_listContext extends ParserRuleContext {
		public Stm_attrContext stm_attr() {
			return getRuleContext(Stm_attrContext.class,0);
		}
		public FcallContext fcall() {
			return getRuleContext(FcallContext.class,0);
		}
		public Stm_retContext stm_ret() {
			return getRuleContext(Stm_retContext.class,0);
		}
		public Stm_seContext stm_se() {
			return getRuleContext(Stm_seContext.class,0);
		}
		public Stm_enquantoContext stm_enquanto() {
			return getRuleContext(Stm_enquantoContext.class,0);
		}
		public Stm_paraContext stm_para() {
			return getRuleContext(Stm_paraContext.class,0);
		}
		public Stm_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_list(this);
		}
	}

	public final Stm_listContext stm_list() throws RecognitionException {
		Stm_listContext _localctx = new Stm_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stm_list);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				stm_attr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				fcall();
				setState(116);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				stm_ret();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				stm_se();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				stm_enquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				stm_para();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_retContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stm_retContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_ret(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_ret(this);
		}
	}

	public final Stm_retContext stm_ret() throws RecognitionException {
		Stm_retContext _localctx = new Stm_retContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stm_ret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__22);
			setState(126);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (T__34 - 35)) | (1L << (T__35 - 35)) | (1L << (T__52 - 35)) | (1L << (T__53 - 35)) | (1L << (LITERAL - 35)) | (1L << (CARACTERE - 35)) | (1L << (IDENTIFICADOR - 35)) | (1L << (REAL - 35)) | (1L << (INTEIRO - 35)) | (1L << (LOGICO - 35)))) != 0)) {
				{
				setState(125);
				expr(0);
				}
			}

			setState(128);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(GrammarParser.IDENTIFICADOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLvalue(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lvalue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(IDENTIFICADOR);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(131);
					match(T__12);
					setState(132);
					expr(0);
					setState(133);
					match(T__13);
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_attrContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stm_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_attr(this);
		}
	}

	public final Stm_attrContext stm_attr() throws RecognitionException {
		Stm_attrContext _localctx = new Stm_attrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stm_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			lvalue();
			setState(141);
			match(ATRIBUICAO);
			setState(142);
			expr(0);
			setState(143);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_seContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Stm_listContext> stm_list() {
			return getRuleContexts(Stm_listContext.class);
		}
		public Stm_listContext stm_list(int i) {
			return getRuleContext(Stm_listContext.class,i);
		}
		public Stm_seContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_se; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_se(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_se(this);
		}
	}

	public final Stm_seContext stm_se() throws RecognitionException {
		Stm_seContext _localctx = new Stm_seContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stm_se);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__23);
			setState(146);
			expr(0);
			setState(147);
			match(T__24);
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				stm_list();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__23 - 23)) | (1L << (T__27 - 23)) | (1L << (T__30 - 23)) | (1L << (IDENTIFICADOR - 23)))) != 0) );
			setState(159);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(153);
				match(T__25);
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					stm_list();
					}
					}
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__23 - 23)) | (1L << (T__27 - 23)) | (1L << (T__30 - 23)) | (1L << (IDENTIFICADOR - 23)))) != 0) );
				}
			}

			setState(161);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_enquantoContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Stm_listContext> stm_list() {
			return getRuleContexts(Stm_listContext.class);
		}
		public Stm_listContext stm_list(int i) {
			return getRuleContext(Stm_listContext.class,i);
		}
		public Stm_enquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_enquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_enquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_enquanto(this);
		}
	}

	public final Stm_enquantoContext stm_enquanto() throws RecognitionException {
		Stm_enquantoContext _localctx = new Stm_enquantoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stm_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__27);
			setState(164);
			expr(0);
			setState(165);
			match(T__28);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				stm_list();
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__23 - 23)) | (1L << (T__27 - 23)) | (1L << (T__30 - 23)) | (1L << (IDENTIFICADOR - 23)))) != 0) );
			setState(171);
			match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stm_paraContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PassoContext passo() {
			return getRuleContext(PassoContext.class,0);
		}
		public List<Stm_listContext> stm_list() {
			return getRuleContexts(Stm_listContext.class);
		}
		public Stm_listContext stm_list(int i) {
			return getRuleContext(Stm_listContext.class,i);
		}
		public Stm_paraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStm_para(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStm_para(this);
		}
	}

	public final Stm_paraContext stm_para() throws RecognitionException {
		Stm_paraContext _localctx = new Stm_paraContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stm_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__30);
			setState(174);
			lvalue();
			setState(175);
			match(T__14);
			setState(176);
			expr(0);
			setState(177);
			match(T__31);
			setState(178);
			expr(0);
			setState(180);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(179);
				passo();
				}
			}

			setState(182);
			match(T__28);
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				stm_list();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__23 - 23)) | (1L << (T__27 - 23)) | (1L << (T__30 - 23)) | (1L << (IDENTIFICADOR - 23)))) != 0) );
			setState(188);
			match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PassoContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(GrammarParser.INTEIRO, 0); }
		public PassoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_passo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPasso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPasso(this);
		}
	}

	public final PassoContext passo() throws RecognitionException {
		PassoContext _localctx = new PassoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_passo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__33);
			setState(192);
			_la = _input.LA(1);
			if (_la==T__34 || _la==T__35) {
				{
				setState(191);
				_la = _input.LA(1);
				if ( !(_la==T__34 || _la==T__35) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(194);
			match(INTEIRO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(198);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__52))) != 0)) {
				{
				setState(197);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__52))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(200);
			termo();
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(203);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(204);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(206);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(207);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(209);
						match(T__40);
						setState(210);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(212);
						match(T__41);
						setState(213);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(215);
						match(T__42);
						setState(216);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(218);
						_la = _input.LA(1);
						if ( !(_la==T__43 || _la==T__44) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(219);
						expr(6);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(221);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(222);
						expr(5);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(224);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(225);
						expr(4);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(228);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FcallContext fcall() {
			return getRuleContext(FcallContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termo);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				fcall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				lvalue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				match(T__53);
				setState(238);
				expr(0);
				setState(239);
				match(T__54);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FcallContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(GrammarParser.IDENTIFICADOR, 0); }
		public FargsContext fargs() {
			return getRuleContext(FargsContext.class,0);
		}
		public FcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFcall(this);
		}
	}

	public final FcallContext fcall() throws RecognitionException {
		FcallContext _localctx = new FcallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(IDENTIFICADOR);
			setState(244);
			match(T__53);
			setState(246);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (T__34 - 35)) | (1L << (T__35 - 35)) | (1L << (T__52 - 35)) | (1L << (T__53 - 35)) | (1L << (LITERAL - 35)) | (1L << (CARACTERE - 35)) | (1L << (IDENTIFICADOR - 35)) | (1L << (REAL - 35)) | (1L << (INTEIRO - 35)) | (1L << (LOGICO - 35)))) != 0)) {
				{
				setState(245);
				fargs();
				}
			}

			setState(248);
			match(T__54);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FargsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFargs(this);
		}
	}

	public final FargsContext fargs() throws RecognitionException {
		FargsContext _localctx = new FargsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			expr(0);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(251);
				match(T__4);
				setState(252);
				expr(0);
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(GrammarParser.LITERAL, 0); }
		public TerminalNode INTEIRO() { return getToken(GrammarParser.INTEIRO, 0); }
		public TerminalNode REAL() { return getToken(GrammarParser.REAL, 0); }
		public TerminalNode CARACTERE() { return getToken(GrammarParser.CARACTERE, 0); }
		public TerminalNode LOGICO() { return getToken(GrammarParser.LOGICO, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (LITERAL - 61)) | (1L << (CARACTERE - 61)) | (1L << (REAL - 61)) | (1L << (INTEIRO - 61)) | (1L << (LOGICO - 61)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(GrammarParser.IDENTIFICADOR, 0); }
		public FparamsContext fparams() {
			return getRuleContext(FparamsContext.class,0);
		}
		public Fvar_declContext fvar_decl() {
			return getRuleContext(Fvar_declContext.class,0);
		}
		public Stm_blockContext stm_block() {
			return getRuleContext(Stm_blockContext.class,0);
		}
		public Tp_primitivoContext tp_primitivo() {
			return getRuleContext(Tp_primitivoContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFunc_decl(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__55);
			setState(261);
			match(IDENTIFICADOR);
			setState(262);
			match(T__53);
			setState(263);
			fparams();
			setState(264);
			match(T__54);
			setState(267);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(265);
				match(T__5);
				setState(266);
				tp_primitivo();
				}
			}

			setState(269);
			fvar_decl();
			setState(270);
			stm_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fvar_declContext extends ParserRuleContext {
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public Fvar_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fvar_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFvar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFvar_decl(this);
		}
	}

	public final Fvar_declContext fvar_decl() throws RecognitionException {
		Fvar_declContext _localctx = new Fvar_declContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fvar_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFICADOR) {
				{
				{
				setState(272);
				var_decl();
				setState(273);
				match(T__1);
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FparamsContext extends ParserRuleContext {
		public List<FparamContext> fparam() {
			return getRuleContexts(FparamContext.class);
		}
		public FparamContext fparam(int i) {
			return getRuleContext(FparamContext.class,i);
		}
		public FparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFparams(this);
		}
	}

	public final FparamsContext fparams() throws RecognitionException {
		FparamsContext _localctx = new FparamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			fparam();
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(281);
				match(T__4);
				setState(282);
				fparam();
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FparamContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(GrammarParser.IDENTIFICADOR, 0); }
		public Tp_primitivoContext tp_primitivo() {
			return getRuleContext(Tp_primitivoContext.class,0);
		}
		public Tp_matrizContext tp_matriz() {
			return getRuleContext(Tp_matrizContext.class,0);
		}
		public FparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFparam(this);
		}
	}

	public final FparamContext fparam() throws RecognitionException {
		FparamContext _localctx = new FparamContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(IDENTIFICADOR);
			setState(289);
			match(T__5);
			setState(292);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				{
				setState(290);
				tp_primitivo();
				}
				break;
			case T__11:
				{
				setState(291);
				tp_matriz();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3K\u0129\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\5\2\67\n\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\6\4J\n\4\r\4\16\4K\3\4\3\4\3\5\3\5\3"+
		"\5\7\5S\n\5\f\5\16\5V\13\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\6\7c\n\7\r\7\16\7d\3\7\3\7\3\7\3\b\3\b\3\t\3\t\7\tn\n\t\f\t\16\tq\13"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n}\n\n\3\13\3\13\5\13\u0081"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u008a\n\f\f\f\16\f\u008d\13\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\6\16\u0098\n\16\r\16\16\16\u0099"+
		"\3\16\3\16\6\16\u009e\n\16\r\16\16\16\u009f\5\16\u00a2\n\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\6\17\u00aa\n\17\r\17\16\17\u00ab\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b7\n\20\3\20\3\20\6\20\u00bb\n\20"+
		"\r\20\16\20\u00bc\3\20\3\20\3\21\3\21\5\21\u00c3\n\21\3\21\3\21\3\22\3"+
		"\22\5\22\u00c9\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00e8\n\22\f\22\16\22\u00eb\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f4\n\23\3\24\3\24\3\24\5\24\u00f9"+
		"\n\24\3\24\3\24\3\25\3\25\3\25\7\25\u0100\n\25\f\25\16\25\u0103\13\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u010e\n\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\7\30\u0116\n\30\f\30\16\30\u0119\13\30\3\31\3\31"+
		"\3\31\7\31\u011e\n\31\f\31\16\31\u0121\13\31\3\32\3\32\3\32\3\32\5\32"+
		"\u0127\n\32\3\32\2\3\"\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\2\f\3\2\t\r\3\2\22\26\3\2%&\4\2%&\67\67\3\2\'(\3\2)*\3\2./"+
		"\3\2\60\63\3\2\64\66\5\2?@DEII\u0137\2\64\3\2\2\2\4A\3\2\2\2\6E\3\2\2"+
		"\2\bO\3\2\2\2\n\\\3\2\2\2\f^\3\2\2\2\16i\3\2\2\2\20k\3\2\2\2\22|\3\2\2"+
		"\2\24~\3\2\2\2\26\u0084\3\2\2\2\30\u008e\3\2\2\2\32\u0093\3\2\2\2\34\u00a5"+
		"\3\2\2\2\36\u00af\3\2\2\2 \u00c0\3\2\2\2\"\u00c6\3\2\2\2$\u00f3\3\2\2"+
		"\2&\u00f5\3\2\2\2(\u00fc\3\2\2\2*\u0104\3\2\2\2,\u0106\3\2\2\2.\u0117"+
		"\3\2\2\2\60\u011a\3\2\2\2\62\u0122\3\2\2\2\64\66\5\4\3\2\65\67\5\6\4\2"+
		"\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28<\5\20\t\29;\5,\27\2:9\3\2\2"+
		"\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\2\2\3@\3\3\2"+
		"\2\2AB\7\3\2\2BC\7B\2\2CD\7\4\2\2D\5\3\2\2\2EI\7\5\2\2FG\5\b\5\2GH\7\4"+
		"\2\2HJ\3\2\2\2IF\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\6"+
		"\2\2N\7\3\2\2\2OT\7B\2\2PQ\7\7\2\2QS\7B\2\2RP\3\2\2\2SV\3\2\2\2TR\3\2"+
		"\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WZ\7\b\2\2X[\5\n\6\2Y[\5\f\7\2ZX\3\2"+
		"\2\2ZY\3\2\2\2[\t\3\2\2\2\\]\t\2\2\2]\13\3\2\2\2^b\7\16\2\2_`\7\17\2\2"+
		"`a\7E\2\2ac\7\20\2\2b_\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2"+
		"fg\7\21\2\2gh\5\16\b\2h\r\3\2\2\2ij\t\3\2\2j\17\3\2\2\2ko\7\27\2\2ln\5"+
		"\22\n\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs"+
		"\7\30\2\2s\21\3\2\2\2t}\5\30\r\2uv\5&\24\2vw\7\4\2\2w}\3\2\2\2x}\5\24"+
		"\13\2y}\5\32\16\2z}\5\34\17\2{}\5\36\20\2|t\3\2\2\2|u\3\2\2\2|x\3\2\2"+
		"\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\23\3\2\2\2~\u0080\7\31\2\2\177\u0081"+
		"\5\"\22\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\7\4\2\2\u0083\25\3\2\2\2\u0084\u008b\7B\2\2\u0085\u0086\7\17\2"+
		"\2\u0086\u0087\5\"\22\2\u0087\u0088\7\20\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u0085\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\27\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\5\26\f\2\u008f\u0090"+
		"\7A\2\2\u0090\u0091\5\"\22\2\u0091\u0092\7\4\2\2\u0092\31\3\2\2\2\u0093"+
		"\u0094\7\32\2\2\u0094\u0095\5\"\22\2\u0095\u0097\7\33\2\2\u0096\u0098"+
		"\5\22\n\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u00a1\3\2\2\2\u009b\u009d\7\34\2\2\u009c\u009e"+
		"\5\22\n\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\35\2\2\u00a4\33\3\2\2\2\u00a5"+
		"\u00a6\7\36\2\2\u00a6\u00a7\5\"\22\2\u00a7\u00a9\7\37\2\2\u00a8\u00aa"+
		"\5\22\n\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7 \2\2\u00ae\35\3"+
		"\2\2\2\u00af\u00b0\7!\2\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7\21\2\2\u00b2"+
		"\u00b3\5\"\22\2\u00b3\u00b4\7\"\2\2\u00b4\u00b6\5\"\22\2\u00b5\u00b7\5"+
		" \21\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\7\37\2\2\u00b9\u00bb\5\22\n\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\7#\2\2\u00bf\37\3\2\2\2\u00c0\u00c2\7$\2\2\u00c1\u00c3\t\4\2\2"+
		"\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\7E\2\2\u00c5!\3\2\2\2\u00c6\u00c8\b\22\1\2\u00c7\u00c9\t\5\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\5$"+
		"\23\2\u00cb\u00e9\3\2\2\2\u00cc\u00cd\f\f\2\2\u00cd\u00ce\t\6\2\2\u00ce"+
		"\u00e8\5\"\22\r\u00cf\u00d0\f\13\2\2\u00d0\u00d1\t\7\2\2\u00d1\u00e8\5"+
		"\"\22\f\u00d2\u00d3\f\n\2\2\u00d3\u00d4\7+\2\2\u00d4\u00e8\5\"\22\13\u00d5"+
		"\u00d6\f\t\2\2\u00d6\u00d7\7,\2\2\u00d7\u00e8\5\"\22\n\u00d8\u00d9\f\b"+
		"\2\2\u00d9\u00da\7-\2\2\u00da\u00e8\5\"\22\t\u00db\u00dc\f\7\2\2\u00dc"+
		"\u00dd\t\b\2\2\u00dd\u00e8\5\"\22\b\u00de\u00df\f\6\2\2\u00df\u00e0\t"+
		"\t\2\2\u00e0\u00e8\5\"\22\7\u00e1\u00e2\f\5\2\2\u00e2\u00e3\t\4\2\2\u00e3"+
		"\u00e8\5\"\22\6\u00e4\u00e5\f\4\2\2\u00e5\u00e6\t\n\2\2\u00e6\u00e8\5"+
		"\"\22\5\u00e7\u00cc\3\2\2\2\u00e7\u00cf\3\2\2\2\u00e7\u00d2\3\2\2\2\u00e7"+
		"\u00d5\3\2\2\2\u00e7\u00d8\3\2\2\2\u00e7\u00db\3\2\2\2\u00e7\u00de\3\2"+
		"\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea#\3\2\2\2\u00eb\u00e9\3\2\2\2"+
		"\u00ec\u00f4\5&\24\2\u00ed\u00f4\5\26\f\2\u00ee\u00f4\5*\26\2\u00ef\u00f0"+
		"\78\2\2\u00f0\u00f1\5\"\22\2\u00f1\u00f2\79\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00ec\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2"+
		"\2\2\u00f4%\3\2\2\2\u00f5\u00f6\7B\2\2\u00f6\u00f8\78\2\2\u00f7\u00f9"+
		"\5(\25\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\79\2\2\u00fb\'\3\2\2\2\u00fc\u0101\5\"\22\2\u00fd\u00fe\7\7\2\2"+
		"\u00fe\u0100\5\"\22\2\u00ff\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102)\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0105\t\13\2\2\u0105+\3\2\2\2\u0106\u0107\7:\2\2\u0107\u0108\7B\2\2\u0108"+
		"\u0109\78\2\2\u0109\u010a\5\60\31\2\u010a\u010d\79\2\2\u010b\u010c\7\b"+
		"\2\2\u010c\u010e\5\n\6\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\5.\30\2\u0110\u0111\5\20\t\2\u0111-\3\2\2\2"+
		"\u0112\u0113\5\b\5\2\u0113\u0114\7\4\2\2\u0114\u0116\3\2\2\2\u0115\u0112"+
		"\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"/\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011f\5\62\32\2\u011b\u011c\7\7\2"+
		"\2\u011c\u011e\5\62\32\2\u011d\u011b\3\2\2\2\u011e\u0121\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\61\3\2\2\2\u0121\u011f\3\2\2"+
		"\2\u0122\u0123\7B\2\2\u0123\u0126\7\b\2\2\u0124\u0127\5\n\6\2\u0125\u0127"+
		"\5\f\7\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127\63\3\2\2\2\35\66"+
		"<KTZdo|\u0080\u008b\u0099\u009f\u00a1\u00ab\u00b6\u00bc\u00c2\u00c8\u00e7"+
		"\u00e9\u00f3\u00f8\u0101\u010d\u0117\u011f\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}