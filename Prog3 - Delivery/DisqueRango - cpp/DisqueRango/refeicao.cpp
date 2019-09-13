#include <string>

#include "cardapio.h"
#include "refeicao.h"

using namespace std;

refeicao::refeicao(){}

refeicao::refeicao(int c,string t, string i,float p, string quente) : cardapio(c,t,i,p)
{
  if( quente.compare("x") || quente.compare("X"))
    this->quente = true;
  else
    this->quente = false;
}

refeicao::~refeicao(){}