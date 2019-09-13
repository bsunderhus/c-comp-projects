/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo TadArvore.h
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patri­cia Dockhorn Costa.
 *
 */

#ifndef TADARVORE_H_
#define TADARVORE_H_

typedef struct Lista_Arv Lista_Arv; //PORQUE Q ISSO TA ANTES DO TADLISTA.H????????????????????????

#include"bitmap.h"
#include"TadLista.h"

//Estrutura de arvore.
typedef struct Arv_Char Arv_Char;

/* Funcao que alloca espaco na memoria para uma arvore.
* inputs: O caracter contido na raiz e o valor (utilizado para contar repeticoes do caracter).
* output: A estrutura da arvore criada, com a raiz tendo o caracter de input e as arvores filhas sendo NULL.
* pre-condicao:-----------------
* pos-condicao:-----------------
*/
Arv_Char* criaArvore(int val, char carac);

/* Retorna o valor utilizado para contar repeticoes do caracter.
* inputs: A arvore.
* output: O valor agregado a arvore.
* pre-condicao: A arvore tem que estar devidamente inicializada.
* pos-condicao:-----------------
*/
int valorArv(Arv_Char* a);

/* Cria uma nova arvore a partir de duas outras.
* inputs: valor inteiro que corresponde a soma dos valores das duas arvores e as duas arvores.
* output: A nova arvore.
* pre-condicao: As arvores tem que estar devidamente inicializada e o valor tem q corresponder a soma dos valores das duas arvores.
* pos-condicao: Nova arvore criada.
*/
Arv_Char* ligaArv(int val,Arv_Char* esq, Arv_Char* dir);

/* Imprime as informacoes da arvore.
* inputs: A arvore.
* output: NULL.
* pre-condicao: A arvore tem que estar devidamente inicializada.
* pos-condicao: Nada pode ser alterado.
*/
void imprimeArv (Arv_Char* a);

/* Imprime as informacoes da arvore no formato <a<esq><dir>>.
* inputs: A arvore.
* output: NULL.
* pre-condicao: A arvore tem que estar devidamente inicializada.
* pos-condicao: Nada pode ser alterado.
*/
void imprime_formatoMenosArvMais (Arv_Char* a);

/*Funcao que recebe a arvore de Huffman e a escreve no arquivo de saida atraves do bitmap.
* inputs:O bitmap, a arvore, o arquivo de saida.
* output:NULL.
* pre-condicao:Arvore e bitmap devidamente inicializadas, e arquivo de saida devidamente criado.
* pos-condicao:A arvore de Hffman deve ser escrita com sucesso no arquivo de saida.
*/
void HuffToBmp(bitmap* bm, Arv_Char* ar, FILE* out);

/*conta o numero de folhas da arvore.
* inputs:A arvore.
* output:O numero de folhas da arvore.
* pre-condicao:A arvore devidamente inicializada
* pos-condicao:Nada alterado.
*/
int contaFolhas(Arv_Char* arv);

/*Escreve os simbolos da tabela ASCII de acordo com o formato estabelecido pela Arvore no arquivo de saida usando o bitmap.
* inputs:A arvore, o bitmap e o arquivo de saida.
* output:NULL.
* pre-condicao:todos os arquivos de entrada devem estar devidamente inicializados.
* pos-condicao:Nada alterado e os simbolos da arvore devem ser escritos no arquivo de saida.
*/
void converteChar(Arv_Char* arv, bitmap* bm, FILE* out);

/*Calcula a altura da arvore.
* inputs:A arvore.
* output:O valor da altura da arvore.
* pre-condicao:Arvore devidamente inicializada.
* pos-condicao:Nada alterado.
*/
int alturaArv(Arv_Char* ar);

/*Compara dois inteiros e retorna o maior entre eles.
* inputs:Dois inteiros.
* output:O maior dos inteiros.
* pre-condicao:NULL.
* pos-condicao:Retornar o valor devido.
*/
int arv_compara(int a1, int a2);

/*Calcula o caminho necessario para chegar a um determinado simbolo na arvore.
* inputs:A arvore, dois vetores de inteiro e o simbolo.
* output:?????????????
* pre-condicao:Arvore devidamente inicializada.
* pos-condicao:???????
*/
int caminho(Arv_Char* ar, int* vet,int* quant, char c);

/*Função que refaz a árvore de Huffman na descompactação do arquivo.
* inputs:Número de folhas da árvore,tres vetores de inteiro (quantidade, quantidade até folha e o vetor que caminha no arquivo).
* output:A árvore montada.
* pre-condicao: ------.
* pos-condicao:Árvore montada.
*/
Arv_Char* recriaArv(FILE* ent, int folhas, int* quFolhas,int* quant, int* vet);

/*Recebe e le o proximo simbolo a ser posto no vetor.
* inputs:vetor de inteiro e arquivo de entrada.
* output:NULL.
* pre-condicao:Entrada devidamente inicializada.
* pos-condicao:Nada alterado.
*/
void proxChar(FILE* entrada, int* vet);

/* Função que realiza a inserção dos simbolos na nova arvore do descompactador.
* inputs:A árvore, o bitmap, o numero de folha e um vetor de inteiro.
* output:NULL.
* pre-condicao:A árvore devidamente criada, bitmap inicializado.
* pos-condicao:Nada alterado.
*/
void putChar(Arv_Char* ar,bitmap* bm, int folhas, int* i);
//char convertBinToChar(int* vet);

/*Escreve um simbolo dentro do bitmap conforme os parametros para ser passado para a função putChar.
* inputs:Arquivo de entrada, o bitmap, um vetor de inteiro e um ponteiro para inteiro.
* output:NULL.
* pre-condicao:NULL.
* pos-condicao:Nada alterado e bitmap preenchido.
*/
void charToBitmap(FILE* ent,bitmap* bm, int* vet, int* quant);

/*Função que faz o preenchimento de um vetor texto que será usado para escrever no arquivo de saida.
 * Essa função vai ler o caminho no arquivo de entrada e vai achar o simbolo correspondente na árvore e vai então escreve-lo na saida.
* inputs:A árvore, 3 ponteiros para inteiros, o arquivo de entrada e o de saida.
* output:NULL.
* pre-condicao:Entrada devidamente inicializada.
* pos-condicao:Nada alterado.
*/
void umadirecao(Arv_Char* arv, int* i,FILE* ent,FILE* saida,char* vetTexto,int* pos,int* auxp);

/*Função que retorna o valor necessario para chegar ao elemento mais a esquerda da árvore.
* inputs:a árvore.
* output:um inteiro representando o caminho para chegar ao elemento superior mais a esquerda da arvore.
* pre-condicao:Arvore devidamente inicializada.
* pos-condicao:Nada alterado.
*/
int caminhoLixo(Arv_Char* arv);
#endif /* TADARVORE_H_ */
