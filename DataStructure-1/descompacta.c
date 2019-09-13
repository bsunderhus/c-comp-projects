#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "TadArvore.h"
#include "bitmap.h"

char* extensaoefolha(FILE* entrada,char* vet){
	int i=0;
	char word;
	while(i<4){
		fread(&word,1,1,entrada);
		vet[i] = word;
		i++;
	}
	return vet;
}

int folha(FILE* entrada){
	char n;
	int f;
	fread(&n,1,1,entrada);
	f = (int)n;
	if(f <= 0)
	  f = 256 + f;
	return f;
}

char* nomeComp(char* nomeArq,char* saida,char* ext){
	char n = nomeArq[0];
	char nome[30];
	int i=0;
	while(n != '.'){
		nome[i] = n;
		n = nomeArq[i+1];
		i++;
	}
	saida = (char*)malloc((strlen(nome)+1)*sizeof(char));
	strcpy(saida,nome);
	strcat(saida,ext);
	return saida;
}

int main(int argc,char** argv){
	FILE* ent;
	FILE* saida;
	char extensao[4];
	char* outName;
	int folhas,quant=0,quFolhas=0;
	int vet[8];
	char lixo;
	int trashPath;
	Arv_Char* arv;	
	if(!(ent = fopen(argv[1],"r"))){
		printf("Arquivo n達o encontrado");
		exit(1);
	}
	fread(&lixo,1,1,ent);
	int nLixo = (int)lixo;
// 	printf("%d\n\n",nLixo);
	extensao[0] = *extensaoefolha(ent,extensao);
	outName = nomeComp(argv[1],outName,extensao);
	printf("%s\n\n",outName);
	saida = fopen("out.txt","w");
	folhas = folha(ent);
	arv = recriaArv(ent,folhas,&quFolhas,&quant,vet);
	bitmap bmp = bitmapInit(folhas*8);
	chaToBitmap(ent,&bmp,vet,&quant);;
	int i = 0;
	putChar(arv,&bmp,folhas,&i);
	i=0;
	char vetTexto[1024];
	int n=0;
	trashPath = caminhoLixo(arv);
	printf("%d\n\n",trashPath);
	umadirecao(arv,vet,ent,saida,vetTexto,&i,&quant);
	int menos = nLixo/trashPath;
	if(i>0){
	   fwrite(vetTexto,1,i-menos,saida);
	    }
	fclose(ent);
	fclose(saida);
	return 0;
}