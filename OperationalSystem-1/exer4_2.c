//
//  main.c
//  trabalho-exercicio-4
//
//  Created by Bernardo Sunderhus on 7/19/14.
//  Copyright (c) 2014 Bernardo Sunderhus. All rights reserved.
//
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <limits.h>
#include <strings.h>



int main(int argc, const char * argv[]){
    int n,fd[2];
    int val = 0;
    pid_t pid;
    char line[_POSIX_PIPE_BUF];

    if ( pipe(fd)< 0 ) { fprintf(stderr,"Erro no tubo\n");_exit(1); }
    if ( (pid=fork())< 0 ) { fprintf(stderr,"Erro no fork\n");_exit(1); }

    if (pid > 0)
    {
        close(fd[0]);
        // send the value on the write-descriptor.
        for (val=1; val!=10; val++) {
            write(fd[1],"Linha ",(strlen("Linha ")+1));
            write(fd[1],&val,sizeof(val));
            printf("oi\n");
            //write(fd[1], &val, sizeof(val));
        }
        close(fd[1]);
        wait(&pid);
    }
    else
    {
        close(fd[1]);
        dup2(STDOUT_FILENO,fd[1]);
        /*while (read(fd[0], line,(strlen("Linha ")+1))&& read(fd[0], &val, sizeof(val))) {
            printf("%s",line);
            printf("%d ",val);
        }*/
        execlp("more", "more",STDOUT_FILENO,NULL);
    }
    return 0;
}
