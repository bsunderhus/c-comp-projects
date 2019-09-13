/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo TadLista.h
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patrícia Dockhorn Costa.
 *
 */
#ifndef TADLISTA_H_
#define TADLISTA_H_

typedef struct Arv_Char Arv_Char;

#include"TadArvore.h"
#include"bitmap.h"

//Estrutura Lista de Arvores.
typedef struct Lista_Arv Lista_Arv;

/* Inicializa uma lista.
* inputs: NULL.
* output: Uma lista com os padroes de estrutura do tipo Lista_Arv.
* pre-condicao: NULL.
* pos-condicao: Lista devidamnete criada e memória previa devidamente alocada para a lista.
*/
Lista_Arv* inicializaLista();

/*Incrementa uma nova arvore a lista de arvores.
* inputs: A lista de arvores e a arvore nova.
* output: A lista de arvores.
* pre-condicao: A arvore tem que estar devidamente inicializada e tambem a lista de arvores.
* pos-condicao:-----------------
*/
Lista_Arv* incrementaLista(Lista_Arv* lista, Arv_Char* sem);

/*Cria a lista de Arvores a partir de um vetor de inteiros que conta a passagem de caracteres de entrada.
* inputs: O vetor de inteiros e a lista de arvores.
* output: A lista de arvores.
* pre-condicao: A lista de arvores deve estar devidamente inicializada.
* pos-condicao: A lista de arvores deve estar com suas posicoes ocupadas por raizes contendo os caracteres de entrada e a frequencia de cada caracter.
*/
Lista_Arv* criaLista(int* vet, Lista_Arv* lista);

/*Concatena as duas primeiras raizes da lista de arvores.
* inputs: A lista de arvores.
* output: A lista de arvores.
* pre-condicao: A lista de arvores tem que estar devidamente inicializada.
* pos-condicao:A lsita de arvores deve conter um novo elemento que corresponde em frequencia com a soma dos dois elementos concatenados.
*/
Lista_Arv* concatenaNaLista(Lista_Arv* lista);

/*Organiza a lista por frequencia em ordem decrescente.
* inputs: A lista de arvores.
* output: A lista de arvores.
* pre-condicao: A lista de arvores tem que estar devidamente inicializada.
* pos-condicao:A lista Organizada por frequencia em ordem decrescente.
*/
Lista_Arv* arrumaLista (Lista_Arv* lista);

/*Retorna um inteiro que representa o tamanho total da lista.
* inputs: A lista de arvores.
* output: Inteiro.
* pre-condicao: A lista de Arvores deve estar devidamente inicializada.
* pos-condicao: A lista nao pode ser alterada.
*/
int tamanhoLista(Lista_Arv* lista);

/*Imprime todo o conteudo da lista de arvores.
* inputs: A lista de arvores.
* output: NULL.
* pre-condicao: A lista de Arvores deve estar devidamente inicializada.
* pos-condicao: A lista nao pode ser alterada.
*/
void imprimeLista (Lista_Arv* lista);

/*Monta a arvore de Huffman, basicamente a funcao arruma a lista e concatena todos os elementos ate so restar um.
* inputs: A lista de arvores.
* output: A lista de de arvores.
* pre-condicao: A lista de Arvores deve estar devidamente inicializada.
* pos-condicao: A lista e reduzida a arvore de Huffman.
*/
Lista_Arv* Huffman(Lista_Arv* lista);

/*Imprime o conteudo do primeiro elemento da lista.
* inputs: A lista de arvores.
* output: NULL.
* pre-condicao: A lista de Arvores deve estar devidamente inicializada.
* pos-condicao: A lista nao pode ser alterada.
*/
void Imprime_Lista(Lista_Arv* lista);

/*Função que faz chamada da função HuffToBmp contida no TadArvore.
* inputs:O bitmap, a lista de árvores, arquivo de saida.
* output: NULL.
* pre-condicao:Bitmap e lista inicializadas.
* pos-condicao:Nada alterado.
*/
void listaToHuff(bitmap* bm, Lista_Arv* lista, FILE* out);

/*Função que faz chamada da funcao contaFolhas contida no TadArvore.
* inputs: A lista de arvores.
* output: Inteiro representado pelo número de folhas da árvore.
* pre-condicao: lista inicializada.
* pos-condicao: nada alterado.
*/
int contaLista(Lista_Arv* lista);

/*Função que faz chamada da funcao converteChar contida no TadArvore.
* inputs: A lista de arvores, o bitmap e o arquivo de saida.
* output:NULL.
* pre-condicao: lista e bitmap inicializados.
* pos-condicao: nada alterado.
*/
void convCharlista(Lista_Arv* lista,bitmap* bm, FILE* out);

/*Função que faz chamada da funcao alturaArv contida no TadArvore.
* inputs: A lista de arvores.
* output: inteiro representando o tamanho da árvore.
* pre-condicao: lista inicializada.
* pos-condicao: nada alterado.
*/
int tamanhoArv(Lista_Arv* lista);

/*Função que faz chamada da funcao caminho contida no TadArvore.
* inputs: A lista de arvores, dois ponteiros para(quantidade e o caminho) inteiro e um inteiro.
* output:NULL.
* pre-condicao: lista e inicializada.
* pos-condicao: nada alterado.
*/
void caminhoArvChar(Lista_Arv* lista,int* cam, char c, int altura, int* quant);

/*Função que faz chamada da funcao valorArv contida no TadArvore.
* inputs: A lista de arvores.
* output:Inteiro.
* pre-condicao:Lista e inicializada.
* pos-condicao:Nada alterado.
*/
int pegaValor(Lista_Arv* lista);

#endif /* TADLISTA_H_ */
