
#include<stdio.h>
#include<stdlib.h>
#include "implementacao.h"

int main(int argc, char** argv){
  FILE* Entrada;
  FILE* Saida;
  
  if(!(Entrada = fopen(argv[1],"r"))){
		printf("Arquivo não encontrado\n");
		exit(1);
}
  if((Saida = fopen(argv[2],"w")) == NULL)
  {
    printf("Erro na abertura do arquivo\n");
    exit(1);
  }

int n, m;
int x,y,z;
int aux = 0;
int aux2 = 0;
while(fscanf(Entrada,"%d %d", &n, &m) == 2)
{
  if(n == 0 && m == 0)
    exit(1);
  int** mat = Matriz(n);
  while ( aux < m)
  {
    fscanf(Entrada, "%d %d %d", &x , &y , &z);
    mat[x-1][y-1] = z;
    mat[y-1][x-1] = z;
    aux++;
  }
  aux = 0;
  mat = algoritmo(mat,n);
  fprintf(Saida,"Teste %d\n",++aux2);
  imprime(Saida,mat,n);
  libera(mat,n);
}
fclose(Entrada);
fclose(Saida);
return 0;
}