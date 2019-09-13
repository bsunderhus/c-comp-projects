
#include <stdio.h>
#include <stdlib.h>
#include "implementacao.h"


int** Matriz(int n)
{
  int i;
  int** mat =(int**)malloc(n*sizeof(int*));
  for(i=0;i<n;i++)
    mat[i] = (int*)malloc(n*sizeof(int));
  
  int j,k;
  for(k=0;k<n;k++)
    for(j=0;j<n;j++)
      mat[j][k]= 0;
  return mat;
}

void libera(int** mat,int n)
{
  int i;
  for(i=0;i<n;i++)
    free(mat[i]);
  free(mat);
}

void imprime(FILE* s,int** mat,int n)
{
  int j,k;
  for(k=0;k<n;k++)
  {
    for(j=0;j<n;j++)
      if(j>k)
	if(mat[j][k] != 0)
	  fprintf(s,"%d %d\n",k+1,j+1);
  }
}

int infinito(int** mat, int n)
{
  int max=0;
  int j,k;
  for(k=0;k<n;k++)
    for(j=0;j<n;j++)
      max = max + mat[j][k];
  max = max/2 +1;
  return max;
}

int** algoritmo(int** mat, int n)
{
  
  int j,k;
  int min = infinito(mat,n);
  int hilfe = infinito(mat,n);
  
  for(k=0;k<n;k++)
    for(j=0;j<n;j++)
      if(mat[j][k] == 0)
	mat[j][k] = min;  
      
  int vis[n];
  for(k=0;k<n;k++)
    vis[k] = 0;
  
  int aux = 1;
  vis[0] = 1; 
  int a,u,b,v;
  
  int** saida = Matriz(n);
  
  while(aux<n)
  {
    for(k=0,min = hilfe;k<n;k++)
      for(j=0;j<n;j++)
      {
	if(mat[k][j] < min)
	  if(vis[k] != 0)
	  {
	    min=mat[k][j];
	    a=u=k;
	    b=v=j;
	    
	  }
      }
      if(vis[u]==0 || vis[v]==0)
	{
	    //printf("Edge %d:(%d %d) cost:%d\n\n",aux++,(a+1),(b	+1),min);
	    saida[a][b] = saida[b][a] = min;
	    vis[b] = 1;
	    aux++;
	}
	  mat[a][b] = mat[b][a] = hilfe;
  }
  return saida;
}