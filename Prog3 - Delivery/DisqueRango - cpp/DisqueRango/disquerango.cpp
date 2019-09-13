#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>

#include "entregador.h"
#include "cardapio.h"
#include "carregador.h"
#include "iterador.h"
#include "cliente.h"
#include "pedidos.h"
#include "interface.h"
#include "relatorio.h"
#include "tempo.h"

using namespace std;


bool comparaCodigo(const cardapio c1, const cardapio c2)
{
  return (c1.codigo < c2.codigo);
}

int main(int argc,char** argv){
	tempo t;
	vector<entregador> ent;
	vector<cardapio> card;
	vector<cliente> clientes;
	vector<pedidos> pedidosDia;
	carregador c(argc,argv,ent,card,t);
	interface i(clientes,card,pedidosDia,ent,argv[1],t);
	relatorio r(ent,card,pedidosDia);
}