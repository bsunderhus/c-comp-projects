#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
  printf("Programa A, pid: %d \n\n", getpid());
  sleep(10);
  int pidFilho;
  //printf("%d\n\n",getpid());
  pidFilho = fork();
  if(pidFilho == 0)
  {
    printf("Programa B, pid: %d\n\n",getpid());
    sleep(10);
    pidFilho = fork();
    if(pidFilho == 0)
    {
      printf("Programa B.1, pid: %d\n\n", getpid());
      sleep(10);
      printf("Programa B.1 vai terminar\n\n");
    }
    if(pidFilho > 0)
    {
      pidFilho = fork();
      if(pidFilho == 0)
      {
	printf("Programa B.2, pid: %d\n\n", getpid());
	sleep(10);
	printf("Programa B.2 vai terminar\n\n");
      }
      else
      {
	printf("Programa B vai terminar\n\n");
      }
    }
  }
  else // pidFilho > 0
  {
    pidFilho = fork();
    if(pidFilho == 0)
    {
      printf("Programa C, pid: %d\n\n", getpid());
      sleep(10);
      printf("Programa C vai terminar\n\n");
    }
    else
    {
      printf("Programa A vai terminar\n\n");
    }
  }
  return 0;
}