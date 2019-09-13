#include <string>
#include "bebida.h"

using namespace std;

bebida::bebida(){} //construtor.

bebida::bebida(int c,string t, string i,float p, int v) : cardapio(c,t,i,p) //construtor.
{
  volume = v; //altera o volume.
  quente = false; //passa o valor booleano de quente para false já q uma bebida não pode ser quente.
}

bebida::~bebida(){} //destrutor. não foi implementado.