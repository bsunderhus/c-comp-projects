/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo TadArvore.c
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patri­cia Dockhorn Costa.
 *
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"TadLista.h"
#include"TadArvore.h"
#include"bitmap.h"


struct Arv_Char{
    int valor;//quantidade de vezes que o caracter se repete.
    char carac;// o caracter referente.
    struct Arv_Char* dir;
    struct Arv_Char* esq;
};

Arv_Char* criaArvore(int val, char carac){
    Arv_Char* sem = (Arv_Char*)malloc(sizeof(Arv_Char)); //Aloca espaco pra arvore.
    sem->valor = val; //Agrega o valor.
    sem->carac = carac; //Agrega o caracter.
    sem->dir = NULL;
    sem->esq = NULL;
    return sem; //Retorna a estrutura.
}

Arv_Char* ligaArv(int val,Arv_Char* esq, Arv_Char* dir){
	Arv_Char* sem = (Arv_Char*)malloc(sizeof(Arv_Char)); //Aloca espaco pra arvore.
	sem->valor = val; //Agrega um valor (no caso, será a soma das estruturas a direita e a esquerda.
	sem->dir = dir; //Agrega uma folha para a direita.
	sem->esq = esq; //Agrega uma folha para a esquerda.
	return sem; //Retorna a estrutura.
}

int valorArv(Arv_Char* a){
    return a->valor; //Retorna o valor (de repeticoes do caracter) da arvore.
}
void imprimeArv (Arv_Char* a){
  printf("%d | %c\n",a->valor, a->carac); //Imprime as informacoes da arvore a.
}

void imprime_formatoMenosArvMais (Arv_Char* a) // UTILIZADA PARA TESTE.
{
  printf("<%d | %c ", a->valor , a->carac);
  if((a->esq)== NULL)
    printf("< >");
  else
  {
    imprime_formatoMenosArvMais(a->esq);
    
  }
  if((a->dir)== NULL)
    printf("< >");
  else
  {
    imprime_formatoMenosArvMais(a->dir);
    
  }
  printf(">");
}

void HuffToBmp(bitmap* bm, Arv_Char* ar, FILE* out){
  int i = 0;
  if(ar->esq == NULL && ar->dir == NULL){//folha...caso de parada.
    bitmapAppendLeastSignificantBit(bm, 1);//se achar uma folha é posto o bit 1 no bitmap.
    if(bm->length == bm->max_size){//caso o bitmap esteja cheio...
      fwrite(bm->contents,sizeof(unsigned char),bm->length/8,out);//imprima o bitmap no arquivo de saida
      bm->length = 0;//zere o length.
      for(i=0;i<bm->max_size;i++){
	bm->contents[i] = 0;//e resete o bitmap.
      }
    }
    return;
  }if(ar->esq != NULL || ar->dir != NULL){//raiz...caso de parada.
    bitmapAppendLeastSignificantBit(bm, 0);//se achar uma raiz é posto o bit 0 no bitmap.
    if(bm->length == bm->max_size){//caso o bitmap esteja cheio...
     fwrite(bm->contents,sizeof(unsigned char),bm->length/8,out);//imprima o bitmap no arquivo de saida
      bm->length = 0;//zere o length.
      for(i=0;i<bm->max_size;i++){
	bm->contents[i] = 0;//e resete o bitmap.
      }
    }
  }
      HuffToBmp(bm, ar->esq,out);//chamada recursiva da função.
    HuffToBmp(bm, ar->dir,out);//chamada recursiva da função.
}

int contaFolhas(Arv_Char* arv){
  if(arv->esq == NULL && arv->dir == NULL){//se achar uma folha
    return 1;//retorne 1
  }else{//caso contrario...
    return contaFolhas(arv->esq) + contaFolhas(arv->dir) + 0;//faça a recursividade.
  }
}

void converteChar(Arv_Char* arv, bitmap* bm, FILE* out){
  int i,bin[8];
  char c;
  if(arv->esq == NULL && arv->dir == NULL){
    for(i=0;i<8;i++){
     bin[i]=((arv->carac>>i)&1); 
    }
    for(i=7; i>=0; i--){
	c = (char)bin[i];
	bitmapAppendLeastSignificantBit(bm,c);
	if(bm->length == bm->max_size){
	  fwrite(bm->contents,sizeof(unsigned char),bm->length/8,out);
	  bm->length = 0;
	    *bm = bitmapInit(1024);
	  }
    }
  }else{
    converteChar(arv->esq,bm,out);
    converteChar(arv->dir,bm,out);
  }
}

//Função auxiliar para funcao alturaArv, retorna o maior entre dois inteiros.
int arv_compara(int a, int b){
    if(a > b)
        return a;
    else
        return b;
}
 
 
 
int alturaArv(Arv_Char* ar){
   if((ar == NULL) || (ar->esq == NULL && ar->dir == NULL))
       return -1;//caso a árvore passada tenha somente um elemento, é passado -1 para caso especial.
   else
       return 1 + arv_compara(alturaArv(ar->esq), alturaArv(ar->dir));
}

int caminho(Arv_Char* ar, int* vet,int* quant, char c){
	int verify;
	if(ar->esq == NULL && ar->dir == NULL){
		if(c == ar->carac){
			return 0;
		}else{
			return 1;
		}
	}else{
		vet[*quant] = 0;
		(*quant)++;
		verify = caminho(ar->esq,vet,quant,c);
			if(verify == 0){
				return 0;
			}else{
				(*quant)--;
				vet[*quant] = 1;
				(*quant)++;
				verify = caminho(ar->dir,vet,quant,c);
					if(verify == 0){
						return 0;
					}else{
						(*quant)--;
						return 1;
					}
			}
	}
}

//funcao de descompactação, usada para refazer a árvore de Huffman na descompactação.
Arv_Char* recriaArv(FILE* ent, int folhas, int* quFolhas,int* quant, int* vet){
	int a;
	Arv_Char* r;
	if((*quFolhas) >= folhas){
		return r;
	}if((*quant) > 7){
		(*quant) = 0;
	}if((*quant) == 0){
		proxChar(ent, vet);
	}
		a = vet[*quant];
		(*quant)++;
	if(a == 1){
		r = criaArvore(1,'*');
		(*quFolhas)++;
		return r;
	}else{
		r = criaArvore(0,'*');
		r->esq = recriaArv(ent,folhas,quFolhas,quant,vet);
		r->dir = recriaArv(ent,folhas,quFolhas,quant,vet);
	}
	return r;
}

void proxChar(FILE* entrada, int* vet){
	char c;
	int i;
	fread(&c,1,1,entrada);
    for(i=0;i<8;i++){
		vet[7-i]=((c>>i)&1); 
	}

}
void putChar(Arv_Char* ar,bitmap* bm, int folhas, int* i){
 	if((*i) == folhas){
 	  return;
 	}
 	if(ar->esq == NULL && ar->dir == NULL){
 		ar->carac = bm->contents[*i];
 		(*i)++;
 		return;
 	}else{
 		putChar(ar->esq,bm,folhas,i);
 		putChar(ar->dir,bm,folhas,i);
 	}
 }

 
 //o bitmap será o usado na funcao putChar, então temos que passar o devido simbolo para o bitmap devidamente.
void charToBitmap(FILE* ent,bitmap* bm, int* vet, int* quant){
    char c;
    while(bm->length < bm->max_size){//enquanto nao chegar no final do bitmap...
    for(;*quant<8;(*quant)++){//adicione o quant até 8.
    if(bm->length >= bm->max_size){
      break;//mas, caso por algum incoveniente o bitmap passar de < diretamente para maior, pare!
    }
    c = vet[*quant] + '0';
    bitmapAppendLeastSignificantBit(bm,c);
      }
      if((*quant)>=8){
      proxChar(ent,vet);
       (*quant) = 0;
      }
    }
}

void umadirecao(Arv_Char* arv, int* i,FILE* ent,FILE* saida,char* vetTexto,int* pos,int* auxp){
	int aux = (*auxp);
	Arv_Char* a = arv;
	while(!feof(ent)){
	while(aux < 8)
	{
	if(i[aux] == 0){
		 a = a->esq;
		if(a->esq == NULL && a->dir == NULL)
		{
		 vetTexto[*pos] = a->carac;
		 if((*pos)==1023){
		 fwrite(vetTexto,1,1024,saida);
		 (*pos)=-1;
		 }
		 (*pos)++;
		 a = arv;
		}
	}
	if(i[aux] == 1){
		a = a->dir;
		if(a->esq == NULL && a->dir == NULL)
		{
		 vetTexto[*pos] = a->carac;
// 		 printf("Escreve %c\n\n",a->carac);
		 if((*pos)==1023){
		 fwrite(vetTexto,1,1024,saida);
		 (*pos)=-1;
		 }
		 (*pos)++;
		 a = arv; 
		}
	}
	aux++;
    }
      proxChar(ent,i);
      aux=0;
  }
}

//como se fosse uma funcao para percorrer na arvore, só que sem a recursividade, logo ela para na primeira instancia mais a esquerda.
int caminhoLixo(Arv_Char* arv){
  int i=0;
  while(arv->esq != NULL && arv->dir != NULL){
    arv = arv->esq;
    i++;
  }
  return i;
}