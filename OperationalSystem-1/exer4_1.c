#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <limits.h>

int main(int argc, const char * argv[]){
    int fd[2];
    long n;
    pid_t pid;
    char line[_POSIX_PIPE_BUF];

    if (pipe(fd) < 0) {
        printf("pipe error\n");
        exit(1);}

    if ((pid=fork()) < 0) {
        printf("fork error\n");
        exit(1);}

    //process dad.
    if (pid > 0){
        close(fd[0]);
        write(fd[1], "Hello world\n", 12);
        write(fd[1], "Goodbye!\n",9);
    }else {// process son.
        close(fd[1]);
        n = read(fd[0], line, _POSIX_PIPE_BUF);
        write(STDOUT_FILENO, line, n);
    }
    return 0;
}
