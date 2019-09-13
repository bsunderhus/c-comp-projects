#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <locale>
#include <sstream>
#include <stdexcept> 


#include "interface.h"
#include "cardapio.h"
#include "entregador.h"
#include "pedidos.h"
#include "cliente.h"
#include "iterador.h"
#include "tempo.h"
#include "erro.h"

using namespace std;

interface::interface(){}

interface::interface(vector<cliente>& cl,vector<cardapio>& card,vector<pedidos>& pedDia,vector<entregador>& ent,char* teste, tempo& t){
  bool loop = true;
  iterador iti;
  while(loop){
    cout<<"Telefone (0 para sair):"<<endl;
    string telefone;
    cin>>telefone;
    cin.ignore();
    if(telefone.compare("0") == 0){
      loop = false;
    }else{
      cliente *auxCliente;
      cliente novoCliente;
      if(cl.size() == 0){
	novoCliente = cadastro(telefone);
	iti.incrementaCliente(cl,novoCliente);
	fazerPedidos(card,novoCliente);
	finalizaPedidos(ent,card,pedDia, novoCliente,teste,t);
      }else{
	auxCliente = (iti.verificaCliente(cl,telefone));
	if(auxCliente == NULL){
	novoCliente = cadastro(telefone);
	iti.incrementaCliente(cl,novoCliente);
	fazerPedidos(card,novoCliente);
	finalizaPedidos(ent,card,pedDia, novoCliente,teste,t);
      }else{
	*auxCliente = opcaoCadastro(telefone,*auxCliente);
	fazerPedidos(card,*auxCliente);
	finalizaPedidos(ent,card,pedDia, *auxCliente,teste,t);
	}
      }
    }
  }
}
void interface::fazerPedidos(vector<cardapio>& card, cliente& c){
  bool loop = true;
  iterador it;
  while(loop){
    cout<<"Adicionar item número (? para cardápio, 0 para finalizar):"<<endl;
    string opcao;
    getline(cin,opcao);
    if(opcao.compare("?") == 0){
      it.imprimeCardapio(card);
    }else if(opcao.compare("0") == 0){
      loop = false;
    }else{
      adicionarPedidos(opcao,card,*c.pegaPedido());
    }
  }
}
void interface::adicionarPedidos(string codigo, vector<cardapio>& card,pedidos& p){
  int i = 0;
  try{
    iterador ip;
    vector<cardapio>::iterator itc;
    for(itc = card.begin(); itc !=card.end();itc++){
      if(itc->pegaCodigo() == atoi(codigo.c_str())){
	cardapio novoItem;
	novoItem.copiaCardapio((*itc));
	cout<<"\tAdicionando \""<<itc->pegaItem()<<"\" ao pedido. Quantidade:"<<endl;
	string entrada;
	int quant = 0;
	getline(cin,entrada);
	quant = atoi(entrada.c_str());
	novoItem.alteraQuantidade(quant);
	ip.incrementaPedido(p.ped,novoItem);
	p.alteraPreco(novoItem.pegaPreco(),quant);
	break;
      }
      i++;
    }if(i>=card.size()){
      cout<<"\tNão há item com código "<<codigo<<" no cardápio."<<endl;
    }
  }catch(invalid_argument& er){
    cout<<"\tNão há item com código "<<codigo<<" no cardápio."<<endl;
  }
}

void interface::finalizaPedidos(vector<entregador>& ent,vector<cardapio>& card,vector<pedidos>& pedDia,cliente& c,string teste,tempo& t){
  if(c.pegaQuantPedidos() == 0){
    cout<<"Nenhum pedido registrado."<<endl;
    return;
  }else{
    cout.unsetf(ios::floatfield);//cria a precisão
    cout.precision(2);//precisão de 2 casas deciamais
    locale adVirgula("");//adiciona a localização pela região da máquina
    cout.imbue(adVirgula);//faz com que o cout tenha a região descrita
    cout<<"Total: R$ "<< fixed << c.pegaTotal() <<". Confirma?"<<endl;//fixed repara para não arredondar
    string opcao;
    getline(cin,opcao);
    if(opcao.compare("S") == 0 || opcao.compare("s") == 0){
      stringstream cs;
      string tes;
      cs << teste;
      cs >> tes;
      if(tes.compare("-teste") == 0){
        c.pegaPedido()->horaPedido(t);
	iterador it;
	c.pedidoDeCliente();
        int edv = it.entregadorDaVez(ent);
	it.incrementaPedidoEntregador(ent[edv],*c.pegaPedido());
	it.incrementaPedidosDia(pedDia,*c.pegaPedido());
	it.incrementaQuantidade(c.pegaPedido()->ped, card);
 	char teste[28];
 	t.data(teste);
 	cout<<teste;
 	t.adicionaDezMin();
	c.novoPedido();
	return;
    }else{
      iterador it;
      c.pedidoDeCliente();
      int edv = it.entregadorDaVez(ent);
      it.incrementaPedidoEntregador(ent[edv],*c.pegaPedido());
      it.incrementaPedidosDia(pedDia,*c.pegaPedido());
      it.incrementaQuantidade(c.pegaPedido()->ped, card);
      tempo novoTempo(1);
      t = novoTempo;
      c.pegaPedido()->horaPedido(t);
      c.novoPedido();
      return;
      }
    }
  }
}
cliente interface::cadastro(string tel){
  cout<<"Cliente não cadastrado. Novo cadastro:"<<endl;
  return dadosCadastro(tel);
}
cliente interface::recadastro(string tel){
  cout<<"Recadastrando cliente (telefone "+tel+"):"<<endl;
  return dadosCadastro(tel);
}
cliente interface::dadosCadastro(string tel){
  string nome, endereco,pontoRef;
  cout<<"\tNome:"<<endl;
  getline(cin,nome);
  cout<<"\tEndereço:"<<endl;
  getline(cin,endereco);
  cout<<"\tPonto de referência:"<<endl;
  getline(cin,pontoRef);
  cliente novoCliente(nome, endereco, tel, pontoRef);
  return opcaoCadastro(tel,novoCliente);
}
cliente interface::opcaoCadastro(string tel, cliente& c){
  cout<<"Cliente cadastrado: "<<c.pegaNome()<<"\n"<<"[C]onfirma ou [R]ecadastra?"<<endl;
  string opcao;
  getline(cin,opcao);
  if(opcao.compare("C") == 0 ||opcao.compare("c") == 0){
    return c;
  }else if(opcao.compare("R") == 0 ||opcao.compare("r") == 0){
    return recadastro(tel);
  }else{
    cout<<"Informação não reconhecida."<<endl;
    return opcaoCadastro(tel,c);
  }
}
