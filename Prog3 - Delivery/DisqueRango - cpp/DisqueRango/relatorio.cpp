#include <vector>
#include <string>
#include <fstream>
#include <algorithm>

#include "relatorio.h"
#include "iterador.h"

using namespace std;

relatorio::relatorio(vector<entregador> e,vector<cardapio> c,vector<pedidos> pedDia)
{
  pedidosDoDia(pedDia);
  entregadores(e);
  itensVendidos(e,c);
}

void relatorio::pedidosDoDia(vector<pedidos> pedDia)
{
  cout<<"Relatório de pedidos do dia:"<<endl;
  string nome;
  cin>>nome;
  std::ofstream saida;
  saida.open (nome.c_str(), std::ofstream::out);
  saida<<"Nome;Telefone;Data;Hora;Valor total"<<endl;
  iterador itp;
  itp.imprimePedidosRelatorio(pedDia,saida);
  /*for(Pedidos pn:p){
				out.write(pn.c.nome + ";" + pn.c.telefone + ";" + pn.data + ";" + pn.hora + ";" + nf.format(pn.preco) + "\n" );
			}*/
  saida.close();
}

void relatorio::entregadores(vector<entregador> e)
{
  cout<<"Relatório de entregadores:"<<endl;
  string nome;
  cin>>nome;
  std::ofstream saida;
  saida.open(nome.c_str() ,std::ofstream::out);
  saida<<"Entregador;Qtd. entregas;Valor total;Comissão"<<endl;
  sort(e.begin(),e.end(), entregador::comparaNome);
  iterador ite;
  ite.imprimeEntregadorRelatorio(e,saida);
  /*for(Entregador en:e){
				for(Pedidos pe:en.pedidos){
					total = total + pe.preco;
				}
			comicao = total*0.05;
			out.write(en.Nome + ";" + en.pedidos.size() + ";" + nf.format(total) + ";" + nf.format(comicao) + "\n");
			total = 0;*/
  saida.close();
}

void relatorio::itensVendidos(vector<entregador>e,vector<cardapio>c)
{
  cout<<"Relatório de itens vendidos:"<<endl;
  string nome;
  cin>>nome;
  std::ofstream saida;
  saida.open(nome.c_str() ,std::ofstream::out);
  saida<<"Item;Qtd. vendida;Pico de procura"<<endl;
  sort(c.begin(),c.end(), cardapio::comparaQuantidade);
  iterador itc;
    itc.imprimeCardapioRelatorio(c,saida);
  /*for(Cardapio c : cardapio)
					out.write(c.Item + ";" + c.quantidade + ";" + c.pico + "\n");*/
  saida.close();
}