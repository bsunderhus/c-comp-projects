lexer grammar Scan;

WS : [ \r\t\n]+ -> skip;
BlockComment : '/*' .*? '*/' -> skip;
LineComment : '//' ~[\r\n]* -> skip;

PALAVRA_RESERVADA
    : 'algoritmo'
    | 'fim_variaveis'
    | 'variaveis'
    | 'inteiro'
    | 'real'
    | 'caractere'
    | 'literal'
    | 'logico'
    | 'inicio'
    | 'fim'
    | 'se'
    | 'senao'
    | 'entao'
    | 'fim_se'
    | 'enquanto'
    | 'faca'
    | 'fim_enquanto'
    | 'para' 
    | 'de'
    | 'ate'
    | 'fim_para'
    | 'matriz'
    | 'inteiros'
    | 'reais'
    | 'caracteres'
    | 'literais'
    | 'logicos'
    | 'funcao'
    | 'retorne'
    | 'passo';

LITERAL : '"' ('\\'.|~('\"'))* '"';
CARACTERE : '\'' ('\\'.|~('\"'))? '\''; 

ATRIBUICAO: ':=';

IDENTIFICADOR : [a-zA-Z_] [0-9a-zA-Z_]*;

SIMBOLO_ESPECIAL : '('|')'|'['|']'|','|';'|':';

fragment DECIMAL : [0-9]+;
fragment OCTAL : '0'[cC] [0-7]+;
fragment HEX : '0'[xX] [0-9a-fA-F]+;
fragment BINARY : '0'[bB] [01]+;

REAL: DECIMAL '.' DECIMAL;
INTEIRO: DECIMAL | OCTAL | BINARY | HEX;

OPERADOR_RELACIONAL : '>' | '>=' | '<' | '<=' | '=' | '<>';

OPERADOR_ARITIMETICA : '+'|'-'|'*'|'/'|'%'|'++'|'--';

OPERADOR_LOGICO : 'e'|'ou'|'nao';

LOGICO : 'verdadeiro'|'falso';

OPERADOR_BIT_A_BIT : '|'|'^'|'&';

DESCONHECIDO : .;