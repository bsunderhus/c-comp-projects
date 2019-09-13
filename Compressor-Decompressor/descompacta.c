/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo Compacta.c
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patricia Dockhorn Costa.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "TadArvore.h"
#include "bitmap.h"
//FUNÇÕES DE USO EXCLUSIVO DA DESCOMPACTA
//Função que pega extensao
char* extensaof(FILE* entrada,char* vet){
	int i=0;//conta as iterações e usado como casa no vetor
	char word;
	while(i<4){
		fread(&word,1,1,entrada);//lê cada caracter da extensão
		vet[i] = word;
		i++;
	}
	//i é incrementado e passa para o vetor da entrada os caracteres da extensão do arquivo
	return vet;
}
//Função que pega as folhas
int folha(FILE* entrada){
	char n; //este char pega o valor das folhas como caractere
	int f;//f será o valor de n convertido para inteiro
	fread(&n,1,1,entrada); //lido o número de folhas como caractere
	f = (int)n; //conversão de char para int
	if(f <= 0)
	  f = 256 + f;
	return f;
	//função que pega o valor das folhas, caso seja negativo ele converte para o complementar
}
//Função que pega o nome da entrada
char* nomeComp(char* nomeArq,char* saida,char* ext){
	char n = nomeArq[0]; //n será a primeira palavra do nome do arquivo de entrada
	char* nome = (char*)malloc(30*sizeof(char)); //alocação de espaço para o nome do arquivo (teve de ser dinâmico, pois estático gerava lixo);
	int i=0; //contador e casa do vetor
	while(n != '.'){
		nome[i] = n; //nome armazena o caractere na casa de i
		n = nomeArq[i+1]; //n pega o próximo caractere do nome do arquivo de entrada
		i++; //i é incrementado
	}
	saida = (char*)malloc((strlen(nome)+1)*sizeof(char)); //saida é devidamente alocado
	strcpy(saida,nome);//nome é copiado para a saída
	free(nome); //nome é liberada
	strcat(saida,ext);//o nome é concatenada com a extensão do arquivo de saída
	return saida; //o nome do arquivo de saída é retornado
}

int main(int argc,char** argv){
	//declaração das variáveis
	FILE* ent; //entrada do arquivo
	FILE* saida; //saída do arquivo
	char lixo; //variável que pega o lixo do arquivo de entrada
	char* extensao = (char*)malloc(5*sizeof(char)); //vetor contendo a extensao do arquivo
	char vetTexto[1024]; //vetTexto pega os caracteres do arquivo de saída antes de ser escrito no arquivo de saída
	char* outName; //nome do arquivo de saída
	int vet[8];//vetor que pega os bits dos caracteres da entrada
	int folhas,quant=0,quFolhas=0,trashPath,i=0,n=0,menos,nLixo;
	/*variáveis inteiras
	 quant é a quantidade que o vetor de bits anda
	 trashPath pega o caminho do elemento mais a esquerda para tratar o lixo
	 menos é o valor de bytes a ser subtraído no fwrite
	 nLixo é o valor dos bits de lixo, dessa vez como número*/
	Arv_Char* arv; //A árvore
	//abertura do arquivo de entrada
	if(!(ent = fopen(argv[1],"r"))){
		printf("Arquivo n達o encontrado");
		exit(1);
	}
	//leitura da quantidade de bits de lixo que teremos no arquivo
	fread(&lixo,1,1,ent);
	nLixo = (int)lixo;
	//extensão do arquivo de saída
	extensao[0] = *extensaof(ent,extensao);
	outName = nomeComp(argv[1],outName,extensao);
	saida = fopen(outName,"w");
	//quantidade de folhas
	folhas = folha(ent);
	//recriando a árvore de caracteres
	arv = recriaArv(ent,folhas,&quFolhas,&quant,vet);
	//O bmp pegará quais caracteres serão usados na árvore por ondem de peso
	bitmap bmp = bitmapInit(folhas*8);
	charToBitmap(ent,&bmp,vet,&quant);
	//os caracteres são colocados na árvore
	putChar(arv,&bmp,folhas,&i);
	//é descoberto a quantidade de bits do caminho do caracter mais a esquerda para tratar o lixo
	trashPath = caminhoLixo(arv);
	//i é reinicializada para reuso
	i=0;
	//umadirecao irá percorrer a árvore procurando os caracteres para serem impressos no arquivo de saida
	umadirecao(arv,vet,ent,saida,vetTexto,&i,&quant);
	//os caracteres lixo, são a divisão de bits de lixo pela quantidade de bits do caminho
	menos = nLixo/trashPath;
	//se i ainda for maior que 0, vetTexto que contém o texto a ser escrito será impresso no arquivo de saída
	//exceto pelos caracteres de lixo
	if(i>0){
	   fwrite(vetTexto,1,i-menos,saida);
	    }
	//fechamos entrada e saída
	fclose(ent);
	fclose(saida);
	return 0;
}