
#include <stdio.h>
#include <stdlib.h>

#ifndef IMPLEMENTACAO_H_
#define IMPLEMENTACAO_H_

int** Matriz(int n);
void libera(int** mat,int n);
void imprime(FILE* s,int** mat,int n);
int infinito(int** mat,int n);
int** algoritmo(int** mat, int n);

#endif /* IMPLEMENTACAO_H_ */