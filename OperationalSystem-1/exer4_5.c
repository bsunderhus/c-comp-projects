
#include <stdio.h>
#include <signal.h>
#include <sys/wait.h>

static volatile sig_atomic_t sigflag;
static sigset_t newmask, oldmask, zeromask;
 
static void
sig_usr(int signo)
{
    sigflag = 1;
}
 
void
TELL_WAIT(void)
{
    if (signal(SIGUSR1, sig_usr) == SIG_ERR)
        perror("signal(SIGUSR1) error");
    if (signal(SIGUSR2, sig_usr) == SIG_ERR)
        perror("signal(SIGUSR2) error");
    sigemptyset(&zeromask);
    sigemptyset(&newmask);
    sigaddset(&newmask, SIGUSR1);
    sigaddset(&newmask, SIGUSR2);
 
    if (sigprocmask(SIG_BLOCK, &newmask, &oldmask) < 0)
        perror("SIG_BLOCK error");
}
 
void
TELL_PARENT(pid_t pid)
{
    kill(pid, SIGUSR2);
}
 
void
WAIT_PARENT(void)
{
    while (sigflag == 0)
        sigsuspend(&zeromask);
    sigflag = 0;
 

    if (sigprocmask(SIG_SETMASK, &oldmask, NULL) < 0)
        perror("SIG_SETMASK error");
}
 
void
TELL_CHILD(pid_t pid)
{
    kill(pid, SIGUSR1);
}
 
void
WAIT_CHILD(void)
{
    while (sigflag == 0)
        sigsuspend(&zeromask);
    sigflag = 0;
 
    if (sigprocmask(SIG_SETMASK, &oldmask, NULL) < 0)
        perror("SIG_SETMASK error");
}

int main()
{
  pid_t pid;
  
  TELL_WAIT();
  int aux;
  if((pid = fork()) == 0){
	for(aux=1;aux<21;aux++){
	  if(aux%2 == 0){
	    WAIT_PARENT();
	    printf("Filho: %d\n\n",aux++);
	    TELL_PARENT(getppid());
	  }
	}
    }
    else
    {
    for(aux=1;aux<21;aux++){
      if(aux%2 != 0){
	printf("Pai: %d\n\n",aux++);
	TELL_CHILD(pid);
	WAIT_CHILD();
      }
    }
    }
return 0;
}