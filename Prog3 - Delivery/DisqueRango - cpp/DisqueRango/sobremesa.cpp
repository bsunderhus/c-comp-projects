#include <string>
#include "sobremesa.h"

using namespace std;

sobremesa::sobremesa(){}

sobremesa::sobremesa(int c,string t, string i, float p) : cardapio(c,t,i,p)
{
  quente = false;
}

sobremesa::~sobremesa(){}