#include <string>
#include <iostream>
#include <cstdlib>

#include "erro.h"

using namespace std;

erro::erro(){}

erro::erro(char* args1,char* args2){
  cerr<<"Não foi possível processar os arquivos especificados:"<< args1 << ", " << args2 << endl;
  exit(0);
}