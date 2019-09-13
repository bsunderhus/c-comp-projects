grammar Grammar;

import Lexicon;

algoritmo
    : declaracao_algoritmo (var_decl_block)? stm_block (func_decl)* EOF
    ;

declaracao_algoritmo
    : 'algoritmo' IDENTIFICADOR ';'
    ;

var_decl_block
    : 'variaveis' (var_decl ';')+ 'fim_variaveis'
    ;

var_decl
    : IDENTIFICADOR (',' IDENTIFICADOR)* ':' (tp_primitivo|tp_matriz)
    ;

tp_primitivo
    : 'inteiro'
    | 'real'
    | 'caractere'
    | 'literal'
    | 'logico'
    ;
    
tp_matriz
    : 'matriz' ('[' INTEIRO ']') + 'de' tp_prim_pl
    ;

tp_prim_pl
    : 'inteiros'
    | 'reais'
    | 'caracteres'
    | 'literais'
    | 'logicos'
    ;

stm_block
    : 'inicio' (stm_list)* 'fim'
    ;

stm_list
    : stm_attr
    | fcall ';'
    | stm_ret
    | stm_se
    | stm_enquanto
    | stm_para
    ;

stm_ret
    : 'retorne' expr? ';'
    ;

lvalue
    : IDENTIFICADOR ('[' expr ']')*
    ;

stm_attr
    : lvalue ':=' expr ';'
    ;

stm_se
    : 'se' expr 'entao'  (stm_list)+ ('senao' (stm_list)+)? 'fim_se'
    ;

stm_enquanto
    : 'enquanto' expr 'faca' (stm_list)+ 'fim_enquanto'
    ;

stm_para
    : 'para' lvalue 'de' expr 'ate' expr passo? 'faca' (stm_list)+ 'fim_para'
    ;

passo
    : 'passo' ('+'|'-')? INTEIRO
    ;

expr
    : expr ('ou'|'||') expr
    | expr ('e'|'&&') expr
    | expr '|' expr
    | expr '&' expr
    | expr '^' expr
    | expr ('='|'<>') expr
    | expr ('<'|'<='|'>'|'>=') expr
    | expr ('+'|'-') expr
    | expr ('/'|'*'|'%') expr
    | ('+'|'-'|'nao')? termo
    ;

termo
    : fcall
    | lvalue
    | literal
    | '(' expr ')'
    ;

fcall
    : IDENTIFICADOR '(' fargs? ')'
    ;

fargs
    : expr (',' expr)*
    ;

literal
    : LITERAL
    | INTEIRO
    | REAL
    | CARACTERE
    | LOGICO
    ;

func_decl
    : 'funcao' IDENTIFICADOR '(' fparams ')' (':' tp_primitivo)? fvar_decl stm_block
    ;

fvar_decl
    : (var_decl';')*
    ;

fparams
    : fparam (',' fparam)*
    ;

fparam
    : IDENTIFICADOR ':' (tp_primitivo|tp_matriz)
    ;