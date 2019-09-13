#include <string>
#include <vector>
#include <iostream>

#include "pedidos.h"
#include "iterador.h" //REMOVER ISSO! SE NÃO FOR UTIL

using namespace std;

cliente::cliente(){}//construtor default.

//contrutor de passagem de parametro.
cliente::cliente(string n,string e,string t,string pdr){
  nome = n;
  endereco = e;
  telefone = t;
  pontoDeReferencia = pdr;
  p = new pedidos();
}

//Função get.
string cliente::pegaNome(){
  return nome;
}

//Função get.
string cliente::pegaTelefone(){
  return telefone;
}


//Função get.
pedidos* cliente::pegaPedido(){
  return p;
}

//Função get.
float cliente::pegaTotal(){
  return p->pegaPreco();
}


//Função get.
int cliente::pegaQuantPedidos(){
  return p->pegaQuantRegistrado();
}

void cliente::pedidoDeCliente(){
  p->alteraCliente(*this);
}

void cliente::imprime(){
  cout<<nome<<";"<<telefone<<";"<<endereco<<";"<<endl;
  iterador it;
  it.imprimePedidos(*p);
}

void cliente::novoPedido(){
  p = new pedidos();
}