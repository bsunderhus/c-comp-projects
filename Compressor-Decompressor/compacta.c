/*
 *  Trabalho 2 Estrutura de Dados
 *  Arquivo Compacta.c
 *  Alunos: Bernardo Sunderhus & Thiago Borges
 *  Profª: Patri­cia Dockhorn Costa.
 *
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"TadArvore.h"
#include"TadLista.h"
#include"bitmap.h"


#define TAM 1024

//FUNÇÕES DE USO EXCLUSIVO DA COMPACTA
//Função que conta os caracteres de um arquivo
int* contaCaracter(FILE* arq, int* v){
    int i=0; //inteiro que conta os caracteres
    char word; //caracter que pega do arquivo de entrada
    while(fread(&word,1,1,arq)){
            i = word; //converte a letra pra inteiro
            if( i < 0) //para caso onde temos inteiros negativos, precisamos converter para o complemento do vetor
	      i = 256 + i;
            v[i]++;//aquela parcela do vetor é incrementada
        }
    return v; //retorna o vetor
}
//Função que pega o nome do arquivo de entrada e coloca a extensão ".comp"
char* nomeComp(char* nomeArq,char* saida){
	char n = nomeArq[0];//n pega o primeiro caractere do arquivo de entrada
	char* nome = (char*)malloc(30*sizeof(char)); //alocação de espaço para o nome do arquivo (teve de ser dinâmico, pois estático gerava lixo)
	int i=0;//contador
	while(n != '.'){
		nome[i] = n;//o vetor nome na posição i recebe o valor de n até que n seja igual ao caractere ponto final
		n = nomeArq[i+1]; //n é igual ao próximo caractere do nome de entrada
		i++; //i é incrementado
	}
	saida = (char*)malloc((strlen(nome)+1)*sizeof(char));//saida é alocado adequadamente
	strcpy(saida,nome);//saida recebe uma cópia de nome
	free(nome);//nome é liberada
	strcat(saida,".comp");//saida é concatenada com a extensão de saída do arquivo
	return saida;//retorna o nome
}
//Função que gera a extensão do arquivo de entrada para poder descompactar com a mesma extensão
void extensao(char* nomeArq,FILE* out){
	char ext = nomeArq[0];//ext pega o primeiro caractere do arquivo de entrada
	int j,i = 1;
		while(ext !='.'){
			ext = nomeArq[i]; //enquanto ext não é igual a ponto final, i é incrementado
			i++;
		}
		fwrite(&ext,1,1,out);//então o ponto é escrito no arquivo de saída
		for(j=1;j<=3;j++){
		fwrite(&nomeArq[i],1,1,out);//e o resto da extensão também é escrito
		i++;
		}
}

int main(int argc, char** argv){
	//algumas das variáveis são previamente declaradas
	FILE* arq;//arquivo de entrada
	FILE* saida;//arquivo de saida
	char l;//caractere de leitura do arquivo de entrada
	char* outName;//nome de saída
	int folhas,i,alt,lixo; //variaveis inteiras: total de folhas da árvore, i é usado para contagem de recursões além da casa no vetor para alocação do bitmap,altura da árvore, total de bits de lixo
	int caracteres[256] = {0}; //vetor de caracteres
	Lista_Arv* lista = inicializaLista(); //inicialização da lista de arvores
	bitmap bmp = bitmapInit(TAM); //inicialização do tipo bitmap
	
	//abertura dos arquivos de saida e leitura do de entrada
	outName = nomeComp(argv[1],outName);
	saida = fopen(outName,"w"); //saida principal do programa
	if(!(arq = fopen(argv[1],"rb"))){
		printf("Arquivo não encontrado\n");
		exit(1);
	}
	
	fwrite("0",1,1,saida);//aloca espaço para o lixo que será computado no final do arquivo
	extensao(argv[1],saida); //Função que pega a extenção do arvquivo de entrada
	
	//contagem de caracteres e criação da arvore de Huffman 
	caracteres[0] = *contaCaracter(arq,caracteres); //Contamos todos os caracteres pertencentes ao arquivo
	lista = criaLista(caracteres,lista); //E criamos uma lista de arvores com cada elemento do vetor e sua quantidade
	lista = Huffman(lista); //Função que cria a arvore de Huffman
	
	//Impressão dos dados no arquivo de saída
	folhas = contaLista(lista); //contagem das folhas da árvore
	fwrite(&folhas,1,1,saida); //impressão da quantidade de folhas
	listaToHuff(&bmp,lista,saida); //criação da árvore em binário para o arquivo de saida
	convCharlista(lista,&bmp,saida); //Função que converte os caracteres em binário
	fclose(arq);// fechamos o arquivo
	arq = fopen(argv[1],"r"); //e reabrimos
	
	alt = tamanhoArv(lista); //medimos o tamanho da árvore
	int caminho[alt+1]; //criamos um vetor para sabermos os caminho a ser feito pela árvore
	int quant = 0,vezes=0; //a quantidade de casas do vetor que usamos (quant) e a quantidade de vezes que o while será usado
	int qCaracteres = pegaValor(lista); //quantos caracteres temos ao todo (peso da primeira raiz)
	
	//pegamos cada caracter do arquivo e percorremos a árvore procurando o caminho, fazendo com que o vetor preencha as casas com 0 para a esquerda e 1 para a direita
	while(vezes<qCaracteres){
		 fread(&l,1,1,arq);//lê os caracteres do arquivo, 1 a 1
		caminhoArvChar(lista,caminho, l, alt,&quant);//joga dentro da função de leitura do caminho o que é necessário para percorrer a árvore e ver os bits de caminho
		for(i=0;i<quant;i++){ //o vetor contendo o caminho é escrito dentro do bitmap, até a ultima casa escrita
 	  bitmapAppendLeastSignificantBit(&bmp,caminho[i]);//apende de bit a bit do caminho
 	  if(bmp.length == bmp.max_size){ //se o bitmap chegar no valor máximo então é impresso o bitmap no arquivo de saída
	      fwrite(bmp.contents,sizeof(unsigned char),bmp.length/8,saida);//impressão dos bytes dentro do bitmap para a saída
	  bmp = bitmapInit(TAM);//reinicialização do bitmap
 		}
	  }
	  	quant = 0;//quantidade usada no vetor caminho é reinicializada
		vezes++;//vezes é incrementado, continuando a recursão até o seu valor ser igual ao total de caracteres usados no arquivo
	}
	//verificamos qual caso teremos um resto para gerar lixo (que vem junto com o caractere final)
 	if((bmp.length)%8 == 0)
	  fwrite(bmp.contents,sizeof(unsigned char),bmp.length/8,saida); //caso de divisão inteira
 	else
	{
 	  fwrite(bmp.contents,sizeof(unsigned char),(bmp.length/8)+1,saida); //caso de divisão com resto, gerando lixo
	  lixo =8-((bmp.length)%8);
	}
	rewind(saida);//voltamos para o começo do arquivo de saída
	fwrite(&lixo,1,1,saida);//impresso o lixo no começo do arquivo, sobreescrevendo aquele caractere que alocamos inicialmente
	fclose(saida); //fechamos a saida
	return 0;

}