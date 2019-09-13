#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include<locale>

#include "iterador.h"
#include "cardapio.h"
#include "refeicao.h"
#include "bebida.h"
#include "sobremesa.h"
#include "entregador.h"
#include "cliente.h"
#include "pedidos.h"

using namespace std;

iterador::iterador(){}//construtor default.

/*Função para adicionar um novo entregador ao vetor de entregadores.*/
void iterador::incrementaEntregador(vector<entregador>& e,string n,string p){
	vector<entregador>::iterator ite;//cria um iterator para navegar no vetor.
	for(ite = e.begin();ite != e.end();ite++){
	  if(ite->pegaNome() == n){//caso aja um entregador com o mesmo nome, n será possivel cadastrar...
	    return;//eu pessoalmente acho isso meio...sem sentido...mas ok...
	  }
	}
	entregador novoEnt(n,p);//cria-se então um novo entregador.
	ite = e.begin();
	e.insert(ite,novoEnt);//adiciona o novo entregador no inicio do vetor.
}

/*Função para adicionar um novo elemento de ardapio ao vetor de cardapio principal.*/
void iterador::incrementaCardapio(vector<cardapio>& c,int co, string t, string i,float p , string quente , int volume){
  vector<cardapio>::iterator itc;//cria um iterator para navegar no vetor.
    for(itc = c.begin();itc != c.end();itc++){
      if(itc->pegaCodigo() == co){//caso aja um item com código igual, não será possivel cadastrar.
	return;
      }
    }
    cardapio novoItem;//cria-se então um novo tipo cardapio e logo em seguida usamos um polimorfismo para definir seu tipo entre as subclasses.
    if(t.compare("S") == 0)
    {
      novoItem = sobremesa(co,t,i,p);
    }
    if(t.compare("R") == 0)
    {
      novoItem = refeicao(co,t,i,p,quente); 
    }
    if(t.compare("B") == 0)
    {
      novoItem = bebida(co,t,i,p,volume);
    }
    itc = c.begin();
    c.insert(itc,novoItem);//adiciona o novo tipo cardapio no inicio do vetor cardapio principal.
}

void iterador::incrementaCliente(vector<cliente>& cl,cliente& c){
    vector<cliente>::iterator itc;//cria um iterator para navegar no vetor.
    itc = cl.begin();
    cl.insert(itc,c);//adiciona o novo cliente no inicio do vetor de clientes.
    //cl.push_back(c);
}
void iterador::incrementaPedido(vector<cardapio>& p, cardapio& card){//é preciso passar o cardapio principal para poder passar o item do cardapio.
    vector<cardapio>::iterator itp;//cria um iterator para navegar no vetor.
    itp = p.begin();
    p.insert(itp,card);//adiciona o novo item do cardapio do pedido no vetor de cardapio do pedido.
}

void iterador::incrementaPedidosDia(vector<pedidos>& pedDia, pedidos& p){
  vector<pedidos>::iterator itp;//cria um iterator para navegar no vetor.
  itp = pedDia.begin();
  pedDia.insert(itp,p);//adiciona um novo pedido ao vetor de pedidos.
}

void iterador::incrementaQuantidade(vector<cardapio>& c1, vector<cardapio>& c2)//o primeiro é o cardapio do cliente e o segundo é o cardapio principal.
{
  vector<cardapio>::iterator itc1;//cria um iterator para navegar no vetor c1.
  vector<cardapio>::iterator itc2;//cria um iterator para navegar no vetor c2.
  for(itc1 = c1.begin(); itc1 != c1.end(); itc1++)
    for(itc2 = c2.begin() ; itc2 != c2.end() ; itc2++)
      if(itc2->codigo == itc1->codigo){//se o item do cardapio principal for igual ao item do cardapio do pedido do cliente.
	itc2->incrementaQuantidade(itc1->pegaQuantidade());//incremente o cardapio principal com a quantidade do cardapio do pedido do cliente.
	if(itc1->pegaQuantidade() > 4)//caso a quantidade no cardapio do pedido do cliente for maior que 4.
	  itc2->alteraPico();//altere o valor de pico para Sim.
	break;
      }
}


 void iterador::incrementaPedidoEntregador(entregador& e, pedidos& p){
   vector<pedidos>::iterator itp;//cria um iterator para navegar no vetor.
   itp = e.p.begin();
   e.p.insert(itp,p);//insere o pedido no entregador.
}

//função utilizada para auxilio interno.
void iterador::imprimeEntregador(vector<entregador>& e){
	vector<entregador>::iterator ite;//cria um iterator para navegar no vetor.
	for(ite = e.begin();ite != e.end();ite++){
		ite->imprime();
	}
}


//Função de impressão de entregadores no relatório. (recebe uma refêrencia para o vetor de entregador e uma refêrencia para a saida de dados)
void iterador::imprimeEntregadorRelatorio(vector<entregador>& e, ofstream& saida)
{
  saida.unsetf(ios::floatfield);//1
  saida.precision(2);//2
  locale adVirgula("");//3
  saida.imbue(adVirgula);//4 --- 1,2,3,4 --- funções para fazer float usar , ao invés de .
  vector<entregador>::iterator ite;
  vector<pedidos>::iterator itp;
  float total=0;
	for(ite = e.begin();ite != e.end();ite++){
	  for(itp = ite->p.begin(); itp != ite->p.end();itp++){
	    total = total + itp->pegaPreco();
	  }
	  ite->imprimeRelatorio(saida);//chama a função que imprime as informações do entregador.
	  float comicao= total*0.05; 
	  saida<< "R$ "<<fixed<<total<<";"<<"R$ "<<fixed<<comicao<<endl;
	  total=0;
	}
}

//função de impressão utilizada para auxilio.
void iterador::imprimeCardapio(vector<cardapio>& c){
  vector<cardapio>::iterator itc;//cria um iterator para navegar no vetor.
  for(itc = c.begin(); itc != c.end(); itc++)
  {
    itc->imprime();
  }
}


//Função de impressão utilizada no relatório.(recebe uma refêrencia para o vetor do cardapio e uma refêrencia para a saida de dados)
void iterador::imprimeCardapioRelatorio(vector<cardapio>& c, ofstream& saida)
{
  vector<cardapio>::iterator itc;//cria um iterator para navegar no vetor.
  for(itc = c.begin(); itc != c.end();itc++)
      itc->imprimeRelatorio(saida);//chamada da função de impressão das informações do cardádapio. passa a saida de dados como parâmetro.
}

//Função de impressão utilizada no relatório(recebe uma refêrencia para o vetor de pedidos e uma refêrencia para a saida de dados)
void iterador::imprimePedidosRelatorio(vector<pedidos>& p, ofstream& saida){
  vector<pedidos>::reverse_iterator itp;//cria um iterator para navegar no vetor.
  for(itp = p.rbegin() ; itp != p.rend(); itp++)
    itp->imprimeRelatorio(saida);//chamda da função de impressão das informações do pedido. passa a saida de dados como parâmetro
}

void iterador::imprimePedidos(pedidos& p){
  imprimeCardapio(p.ped);
  cout<<p.pegaPreco()<<endl;
}

void iterador::imprimeCliente(vector<cliente>& cl){
  vector<cliente>::iterator itc;
  for(itc = cl.begin(); itc != cl.end(); itc++)
  {
    itc->imprime();
  }
}

 cliente* iterador::verificaCliente(vector<cliente>& cl,string t){
   vector<cliente>::iterator itc;
   for(itc = cl.begin();itc !=cl.end();itc++){
     if(t.compare(itc->pegaTelefone()) == 0){
       return &(*itc);
     }
     
    }
    return NULL;
 }
 
 int iterador::entregadorDaVez(vector<entregador>& ent){
    static int entdavez = 0;
    if(entdavez >= ent.size()){
      return entdavez = 0;
    }
    else{
      return entdavez++;
    }
 }