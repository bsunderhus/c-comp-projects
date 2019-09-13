#include <iostream>
#include <fstream>
#include <ctime>
#include <sstream>

#include "pedidos.h"
#include "cliente.h"
#include "tempo.h"


pedidos::pedidos(){preco=0;}//construtor default.

/*posteriormente implementar o construtor com parametros*/

//Função para alterar o preço de um pedido. é passado o preço novo e a quantidade para multiplicação.
void pedidos::alteraPreco(float p, int quant)
{
  preco = (p *quant) + preco;
}

//Função de impressão, usada somente para resolução de problemas internos.
void pedidos::imprime(){
  char tempoPedido[25];
  t.data(tempoPedido);
  cout<<c.pegaNome()<<";"<<c.pegaTelefone()<<";"<<tempoPedido<<";"<<preco<<endl;
}

//Função de impressão para o relatório.
void pedidos::imprimeRelatorio(ofstream& saida){
  char ss[50];
  t.data(ss);
  
  saida.unsetf(ios::floatfield);//1
  saida.precision(2);//2
  locale adVirgula("");//3
  saida.imbue(adVirgula);//4 --- 1,2,3,4 --- funções para fazer float usar , ao invés de .
  saida<<c.pegaNome()<<";"<<c.pegaTelefone()<<";"<<ss<<";"<<"R$ "<<fixed<<preco<<endl;
}

//Função get.
int pedidos::pegaQuantRegistrado(){
  return ped.size();
}

//Função get.
float pedidos::pegaPreco(){
  return preco;
}

//Função de alteração para mudar o parametro cliente.
void pedidos::alteraCliente(cliente& cl){
  c = cl;
}

void pedidos::horaPedido(tempo& novoTempo){
  (*t.datas) = (*novoTempo.datas);
}
