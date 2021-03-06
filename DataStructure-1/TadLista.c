/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo TadLista.c
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patrícia Dockhorn Costa.
 *
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"TadLista.h"
#include"TadArvore.h"
#include"bitmap.h"

//estrutura da lista de arvores.
struct Lista_Arv{
    Arv_Char* arv;
    struct Lista_Arv* prox;
};

//Iniciacao da lista.
Lista_Arv* inicializaLista(){
    Lista_Arv* l = NULL;
    return l;
}

Lista_Arv* incrementaLista(Lista_Arv* lista, Arv_Char* sem){
    Lista_Arv* novaSem = (Lista_Arv*)malloc(sizeof(Lista_Arv*)); //aloca memoria para a estrutura da lista
    novaSem->arv =sem; //agrega a arvore ao seu ponteiro
    novaSem->prox = lista; //aponta para o resto da lista
    return novaSem;
}

//Precisamos de uma função que organize a lista inicialmente
Lista_Arv* criaLista(int* vet, Lista_Arv* lista){
    int i=0;
    char x;
    while(i<256){ //i varre o vetor
        if(vet[i]!=0){ //se for diferente de 0, ou seja caso tenha alguma chamada desse caracter, será então criada uma celula na lista
    x = (char)i; //conversao de int para char
    Arv_Char* novaSem = criaArvore(vet[i],x); //criacao da nova "arvore"
    lista = incrementaLista(lista,novaSem); //incrementacao na lista
        }
        i++;
    }
    return lista;
}

Lista_Arv* concatenaNaLista (Lista_Arv* lista){
    Lista_Arv* aux1 = lista;  //primeiro termo da lista
    Lista_Arv* aux2 = lista->prox; //segundo termo da lista
    Lista_Arv* aux3 = aux2->prox; //terceiro termo da lista (LEMBRETE: TRATAR CASO SEJA NULL!)
    int i = 0;
    i = valorArv(aux1->arv) + valorArv(aux2->arv); //a soma do primeiro com o segundo
    Arv_Char* nArv = ligaArv(i,aux1->arv,aux2->arv); //uma nova arvore e criada com os dois primeiros termos como folhas
    return incrementaLista(aux3, nArv); //retorna a lista já com os dois primeiros dela em uma lista
}

Lista_Arv* arrumaLista (Lista_Arv* lista){
  if(lista== NULL){//Caso de parada de recursao.
    return lista;
  }
   Lista_Arv* aux1 = lista;// Navegacao na lista.
   Lista_Arv* aux2 = NULL; //Armazena o menor valor
   Lista_Arv* ant = NULL; //armazena o anterior
   int menorValor = valorArv(aux1->arv); //armazena o menor valor
   while(aux1 != NULL){//Navega na lista.
    if(valorArv(aux1->arv) < menorValor){
      menorValor = valorArv(aux1->arv);//Acha o menor valor na lista.
    }
     aux1 = aux1->prox;
  }
   aux1 = lista;//Reseta aux1.
    if(menorValor == valorArv(aux1->arv)){//chamada recursiva, caso primeiro elemento da lista seja o menor valor.
      aux1->prox = arrumaLista (aux1->prox);     
      return aux1;
    }
    else
    {
      while(aux1->prox != NULL && valorArv(aux1->prox->arv) != menorValor){ //Anda na lista enquanto o proximo valor nao for o menor valor.
     aux1 = aux1->prox;
  }
     ant = aux1;
     aux2 = aux1->prox;
     ant->prox = aux2->prox;
     aux2->prox = arrumaLista (lista);//segundo caso da chamada recursiva.
    }
  return aux2;//retorna o novo primeiro da lista , ja que e uma lista sem sentinela.
}

int tamanhoLista(Lista_Arv* lista){
	Lista_Arv* aux = lista;//Navegacao na lista.
	int i=0;//contador.
	while(aux!=NULL){
	  aux = aux->prox;//ISSO NAO DEVIA ESTAR DEPOIS DO I++???????????????????
	  i++;//incrementa o contador a cada passagem.
	}
	return i;
}

//IMPRIME TODA A LISTA.
void imprimeLista (Lista_Arv* lista){
  Lista_Arv* aux = lista;//Navegacao na lista.
  while(aux != NULL){
    imprimeArv (aux->arv);//Chamada da funcao do TadArvore.h que imprime a arvore.
    aux = aux->prox;    
  }
  printf("\n");
}

Lista_Arv* Huffman(Lista_Arv* lista){
  int i = tamanhoLista(lista);//Inteiro com o tamanho da lista.
  while(i > 1){
    lista = arrumaLista(lista);//Chamada da funcao arrumaLista para ordenar a lista de forma decrescente.
    lista = concatenaNaLista(lista);//Chamada da funcao concatenaNaLista para concatenar os dois primeiros elementos da lista.
    i--;//Decrementa o tamanho da lista ate chegar na condicao de parada (i<=1).
  }
  return lista;
}

//IMPRIME SOMENTE O PRIMEIRO DA LISTA.
void Imprime_Lista(Lista_Arv* lista){
      imprime_formatoMenosArvMais (lista->arv);
      printf("\n");
}

void listaToHuff(bitmap* bm, Lista_Arv* lista, FILE* out,FILE* bi){
  HuffToBmp(bm,lista->arv,out,bi);
}

int contaLista(Lista_Arv* lista){
  return contaFolhas(lista->arv);
}

void convCharlista(Lista_Arv* lista,bitmap* bm, FILE* out,FILE* bi){
  converteChar(lista->arv,bm,out,bi);
}

int tamanhoArv(Lista_Arv* lista){
  return alturaArv(lista->arv);
}

void caminhoArvChar(Lista_Arv* lista,int* cam, char c, int altura, int* quant){
	caminho(lista->arv,cam,quant,c);
}

int pegaValor(Lista_Arv* lista){
    return valorArv(lista->arv);
}