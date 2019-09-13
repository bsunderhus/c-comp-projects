#include <string>
#include <fstream>

#ifndef CARDAPIO_H_
#define CARDAPIO_H_
using namespace std;

class cardapio{
	string tipo;
	string item;
	int quantidade;
	float preco;
	string pico;
	
public:
	int codigo;
	cardapio();
	cardapio(int c,string t,string i,float p);
	int pegaCodigo();
	void copiaCardapio(cardapio card);
	string pegaItem();
	float pegaPreco();
	string pegaTipo();
	int pegaQuantidade();
	void alteraQuantidade(int q);
	void alteraPico();
	void incrementaQuantidade(int q);
	static bool comparaCodigo(cardapio c1,cardapio c2);
	static bool comparaQuantidade(cardapio c1, cardapio c2);
	static bool comparaItem(cardapio c1, cardapio c2);
	void imprime();
	void imprimeRelatorio(ofstream& saida);

};
#endif //CARDAPIO_H_