#include <string>
#include <vector>
#include <fstream>

#include "cliente.h"
#include "cardapio.h"
#include "tempo.h"

#ifndef PEDIDOS_H_
#define PEDIDOS_H_

using namespace std;

class pedidos{
  float preco;
  cliente c;
  tempo t;
  
public:
	vector<cardapio> ped;
	pedidos();
	void  imprime();
	void imprimeRelatorio(ofstream& saida);
	void alteraPreco(float p, int quant);
	int pegaQuantRegistrado();
	float pegaPreco();
	void alteraCliente(cliente& cl);
	void horaPedido(tempo& novoTempo);
};

#endif //PEDIDOS_H_