#include <string>
#include <iostream>
#include <fstream>
#include "cardapio.h"

using namespace std;

cardapio::cardapio(){ //construtor.
  quantidade = 0; // a quantidade do elemento do cardapio é por padrão 0.
  pico = "Não"; // o pico do elemento do cardapio é por padrão Não e mais a frente será alterado.
}

cardapio::cardapio(int c,string t,string i,float p){ //construtor.
	codigo = c;
	tipo = t;
	item = i;
	preco = p;
	pico = "Não";
	quantidade = 0;

}

/*Função de cópia simples, copia todos os elementos de um tipo cardapio para outro.
 Ela é utilizada para a cópia de um item do vetor cardapio principal para um item do vetor do cardapio do pedido*/
void cardapio::copiaCardapio(cardapio card){
  codigo = card.pegaCodigo();
  tipo = card.pegaTipo();
  item = card.pegaItem();
  preco = card.pegaPreco();
}

//Função get.
int cardapio::pegaCodigo(){
  return codigo;
}

//Função get.
string cardapio::pegaItem(){
  return item;
}

//Função get.
string cardapio::pegaTipo(){
  return tipo;
}

//Função get.
float cardapio::pegaPreco(){
  return preco;
}

//Função get.
int cardapio::pegaQuantidade()
{
  return quantidade;
}

//Função de alteração de parâmetro pico. Seta o pico de Não para Sim.
void cardapio::alteraPico()
{
  pico = "Sim";
}

//Função que altera a quantidade. Recebe um inteiro.
void cardapio::alteraQuantidade(int q){
  quantidade = q;
}

//Função utilizada para incrementar a quantidade total de um determinado item do vetor de cardapio principal.
void cardapio::incrementaQuantidade(int q)
{
  quantidade += q;
}


//Função booleana de comparação de código, criada para ordenação.
bool cardapio::comparaCodigo(cardapio c1,cardapio c2)
{
  return (c1.codigo < c2.codigo);
}

//Função booleana de comparação de quantidade, criada para ordenação do relatório.
bool cardapio::comparaQuantidade(cardapio c1, cardapio c2)
{
  if(c1.pegaQuantidade() == c2.pegaQuantidade())
    return comparaItem(c1,c2);
  return (c1.pegaQuantidade() > c2.pegaQuantidade());
}

//Função booleana de comparação do nome do item, criada para ordenação do relatório.
bool cardapio::comparaItem(cardapio c1, cardapio c2){
  return (c1.pegaItem().compare(c2.pegaItem()) < 0);
}


//Função de impressão interna no trabalho.
void cardapio::imprime(){
  cout << codigo << ";"<< item<<";"<<preco<<"\t"<<quantidade<<endl;
}

//Função de impressão no relatório.
void cardapio::imprimeRelatorio(ofstream& saida){
  saida<<item<<";"<<quantidade<<";"<<pico<<endl;
}