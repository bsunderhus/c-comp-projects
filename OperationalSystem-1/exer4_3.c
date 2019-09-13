//
//  exer4_3.c
//  
//
//  Created by Bernardo Sunderhus on 7/23/14.
//
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <limits.h>
#include<fcntl.h>

#define READ 0 
#define WRITE 1 
#define STDOUT 1

int main(int argc, const char * argv[]) {
    int fd[2];
    pid_t pid;
    
    if ( pipe(fd)< 0 ) { fprintf(stderr,"Erro no tubo\n");_exit(1); }
    if ( (pid=fork())< 0 ) { fprintf(stderr,"Erro no fork\n");_exit(1); }
    
    if (pid > 0)//process dead.
    {
        close(fd[READ]);
        dup2(fd[1], STDOUT_FILENO);
        execlp("cat", "cat", argv[1], NULL);
    }
    else//process son.
    {
        close(fd[WRITE]);
        dup2(fd[0], STDIN_FILENO);
        int file = open(argv[2],O_WRONLY);
        dup2(file,STDOUT_FILENO);
        execlp("grep","grep",argv[3],NULL);
    }
    return 0;
}