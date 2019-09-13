#include <string>
#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>

#include "entregador.h"
#include "pedidos.h"


using namespace std;

entregador::entregador(){}//construtor default.

entregador::entregador(string n, string p){
	nome = n;
	placa = p;
}

//Função de impressão para auxilio.
void entregador::imprime(){
	cout<<nome<<";"<<placa<<endl;
}

//Função de impressão no relatório.
void entregador::imprimeRelatorio(ofstream& saida)
{
  saida<<nome<<";"<<p.size()<<";";
}

//Função get.
string entregador::pegaPlaca()
{
  return placa;
}

//Função get.
string entregador::pegaNome(){
  return nome;  
}

//Função de comparação utilizada para ordenação por ordem do parâmetro nome.
bool entregador::comparaNome(entregador e1,entregador e2)
{
  return (e1.nome.compare(e2.nome) < 0);
}

//Função de comparação utilizada para ordenação por ordem do parâmetro placa.
bool entregador::comparaPlaca(entregador e1,entregador e2)
{
  return (e1.placa.compare(e2.placa) < 0);
}