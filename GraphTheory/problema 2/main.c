#include<stdio.h>
#include<stdlib.h>

FILE* Entrada;
FILE* Saida;

int fluxo(int** grafo, int v0, int vf, int vs);

int main(int argc, char** argv){
  if(!(Entrada = fopen(argv[1],"r+"))){
		printf("Arquivo não encontrado\n");
		exit(1);
  }
  
  if((Saida = fopen(argv[2],"w+")) == NULL)
  {
    printf("Erro na abertura do arquivo\n");
    exit(1);
  }
  
  int n;
  while(1){
    fscanf(Entrada, "%d", &n);    
    
    if(n==0) {      
      break;
    }
    
    int** grafo;
    grafo = (int**)malloc(sizeof(int*)*n);
    
    int i;
    for(i=0;i<n;i++){
      grafo[i] = (int*)malloc(sizeof(int)*n);
    }

    int v0,vf,as; //Vértice de Origem, Vértice de chegada, Número de Arestas

    fscanf(Entrada, "%d %d %d",&v0,&vf,&as);
    for(i=0;i<as;i++){
      int v1,v2,valor;
      fscanf(Entrada, "%d %d %d", &v1,&v2,&valor);
      grafo[v1-1][v2-1] = valor;    
      grafo[v2-1][v1-1] = valor;
    }
      
    int fluxoMax = fluxo(grafo,v0-1,vf-1,n);
  
    fprintf(Saida,"A largura de banda é %d\n",fluxoMax);
  }
}

int fluxo(int** grafo, int v0, int vf, int n){
  
    int* valor = (int*) malloc(sizeof(int)*n);
    int* anterior = (int*) malloc(sizeof(int)*n);
    int i;    
    
   for(i=0;i<n;i++){
      valor[i] = -1;
      anterior[i] = -1;
    }
    valor[v0] = 0;
  
  for(i=0;i<n;i++){
    int j;
    for(j=0;j<n;j++){
      if(valor[j]==i){
	//VERIFICAR AS ADJACENCIAS
	int k;
	for(k=0;k<n;k++){
	  if(grafo[j][k]!=0){
	    if(valor[k]==-1){
	      valor[k] = i+1;
	      anterior[k] = j;
	    }
	    if(k == vf){
	      int ref, min = 1000000;
	      ref = k;
	      while(ref != v0){
		int ref2 = anterior[ref];
		min = (min < grafo[ref][ref2]) ? min : grafo[ref][ref2];
		ref = ref2;
	      }
	      ref = k;
	      while(ref!= v0){
		int ref2 = anterior[ref];
		grafo[ref][ref2] -= min; 
		grafo[ref2][ref] -= min;
		ref = ref2;
	      }
	      return (min + fluxo(grafo,v0,vf,n));
	    }
	  }
	}
      }
    }
  }
  return 0;
}
