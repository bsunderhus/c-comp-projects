#include <string>
#include <vector>
#include <iostream>



#ifndef CLIENTE_H_
#define CLIENTE_H_

using namespace std;
class pedidos;

class cliente{
  string nome;
  string endereco;
  string telefone;
  string pontoDeReferencia;
  pedidos *p; /*error: field ‘p’ has incomplete type without the parenthesis*/
  friend class pedidos;

public:
	cliente();
	cliente(string n,string e,string t, string pdr);
	string pegaNome();
	string pegaTelefone();
	int pegaQuantPedidos();
	float pegaTotal();
	pedidos* pegaPedido();
	void pedidoDeCliente();
	void novoPedido();
	void imprime();
};

#endif //CLIENTE_H_