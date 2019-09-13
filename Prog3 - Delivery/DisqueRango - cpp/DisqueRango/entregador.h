#include <string>
#include <vector>
#include <fstream>

#include "pedidos.h"

#ifndef ENTREGADOR_H_
#define ENTREGADOR_H_

using namespace std;

class entregador{
	string nome;
	string placa;
public:
	vector<pedidos> p;
	entregador();
	entregador(string n,string p);
	string pegaNome();
	void imprime();
	void imprimeRelatorio(ofstream& saida);
	string pegaPlaca();
	static bool comparaNome(entregador e1,entregador e2);
	static bool comparaPlaca(entregador e1, entregador e2);
};

#endif //ENTREGADOR_H_