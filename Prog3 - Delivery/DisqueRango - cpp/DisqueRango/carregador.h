#include <vector>
#include "entregador.h"
#include "cardapio.h"
#include "tempo.h"


#ifndef CARREGADOR_H_
#define CARREGADOR_H_
class carregador{
	public:
	carregador();
	carregador(int ac,char** av,vector<entregador>& e,vector<cardapio>& c, tempo& t);
	void carregaEntregador(vector<entregador>& e, char* args1,char* args2);
	void carregaCardapio(vector<cardapio>& c, char* args1, char* args2);
	void verificadorCardapio(string* parametros,char* args1,char* args2);
};
#endif //CARREGADOR_H_