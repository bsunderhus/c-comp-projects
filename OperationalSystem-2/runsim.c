/* Trabalho de S.O*/

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

#define MAX_CANON 100



int makeargv(const char *s, const char *delimiters, char ***argvp){
  int error;
  int i;
  int numtokens;
  const char *snew;
  char *t;
  if ((s == NULL) || (delimiters == NULL) || (argvp == NULL)) {
    errno = EINVAL;
    return -1;
  }
  *argvp = NULL;
  snew = s + strspn(s, delimiters); /* snew is real start of string */
  if ((t = malloc(strlen(snew) + 1)) == NULL)
    return -1;
  strcpy(t, snew);
  numtokens = 0;
  if (strtok(t, delimiters) != NULL) /* count the number of tokens in s */
    for (numtokens = 1; strtok(NULL, delimiters) != NULL; numtokens++) ;
    /* create argument array for ptrs to the tokens */
    if ((*argvp = malloc((numtokens + 1)*sizeof(char *))) == NULL) {
      error = errno;
      free(t);
      errno = error;
      return -1;
    }
    if (numtokens == 0)
      free(t);
    else {
      strcpy(t, snew);
      **argvp = strtok(t, delimiters);
      for (i = 1; i < numtokens; i++)
	*((*argvp) + i) = strtok(NULL, delimiters);
      
    }
    *((*argvp) + numtokens) = NULL; /* put in final NULL pointer */
    return numtokens;
  
} 

int main(int argc,char* argv[])
{
  char comand[MAX_CANON];
  char delim[] = " \t";
  char** myargv;
  int pr_limit, pr_count = 0;
  pid_t childPid;
  pid_t result;
  
  if (argc != 2)
  { /* check for valid number of command-line arguments */
  fprintf(stderr, "Usage: %s processes\n", argv[0]);
  return 1;
  }
  pr_limit = atoi(argv[1]);
  
  for(;;)
  {
    if(gets(comand) == NULL)
    {
      wait();
      exit(0);
    }
    else
    {
      if (makeargv(comand, delim, &myargv) == -1)
	perror("Child failed to construct argument array");
      childPid = fork();
      pr_count++;
      if(childPid == 0)
      {
	system(comand);
	return 0;
      }
    }
    if(pr_count == pr_limit && childPid > 0)
    {
      wait();
      pr_count--;
    }
  }
  
  return 0;
}