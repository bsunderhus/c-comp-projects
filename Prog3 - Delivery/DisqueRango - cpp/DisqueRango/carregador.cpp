#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <cstdlib>
#include <sstream>
#include <stdexcept> 
#include <algorithm>


#include "carregador.h"
#include "entregador.h"
#include "cardapio.h"
#include "iterador.h"
#include "erro.h"
#include "tempo.h"

using namespace std;

carregador::carregador(){} // construtor default.


/*construtor que recebe a quantidade de argumentos da entrada, os argumentos da entrada, o vetor de entregadores e o vetor do cardapio principal.*/
carregador::carregador(int ac,char** av,vector<entregador>& e,vector<cardapio>& c, tempo& t){
	int k = 1;
	if(ac<=1){ // se quantidade de argumentos da entrada for menor ou igual a um, saia do programa.
		cout<<"Arquivos de entreda não especificados."<<endl;
		exit(0);
	}
	stringstream cs;
	string par1; //string par1 recebe o segundo elemento do dos argumentos da entrada.
	cs << av[k];
	cs >>par1;
	if(par1.compare("-teste") == 0){// caso par1 seja -teste, execute o comando de teste.
		tempo dataAlterada(av[k]);
		t = dataAlterada;
		k++;
	}else{//se não...
		tempo dataAlterada(1);
		t = dataAlterada;
		if(ac < 4){//se a quantidade de argumentos da entrada for menor do que 4, saida do programa.
			cout<<"Arquivos de entrada não especificados. Use: -e <entregadores> -c <cardápio>"<<endl;
			exit(0);
		}
		stringstream cs2;
		string par2;//par2 recebe o quarto elemento.
		cs2 << av[k+2];
		cs2 >> par2;
		if(par1.compare("-e") != 0 || par2.compare("-c") != 0){//se par1 n for -e ou par2 n for -c, saia do programa.
			cout<<"Arquivos de entrada não especificados. Use: -e <entregadores> -c <cardápio>"<<endl;
			exit(0);
		}
	}
		carregaEntregador(e,av[k+1],av[k+3]);
		carregaCardapio(c,av[k+1],av[k+3]);
}

/*Função de leitura do entregadores.csv*/
void carregador::carregaEntregador(vector<entregador>& e,char* args1, char* args2){
	string dados;
	string parametros[2];
	iterador itie;
	try{
		ifstream ent_entrada(args1);
		getline(ent_entrada,dados);
		while(getline(ent_entrada,dados)){
			stringstream data;//stringstream é uma string q funciona como uma stream, usada para passar uma linha inteira como parametro.
			data.str(dados);
			getline(data,parametros[0],';');//pega o parametro nome.
			getline(data,parametros[1],';');//pega o parametro placa.
			itie.incrementaEntregador(e,parametros[0],parametros[1]);//invoca o iterador pra incrementar um novo entregador ao vetor.
		}
		sort(e.begin(),e.end(),entregador::comparaPlaca);//organiza na ordem alfabetica de placas.
	}catch (ifstream::failure& e){
			cerr<<"Erro na abertura do arquivo: "<<e.what()<<endl; //copiada dos slides. VERIFICAR!!
		}
}

/*Função de leitura de cardapio.csv*/
void carregador::carregaCardapio(vector<cardapio>& c,char* args1, char* args2){
	string dados;
	stringstream data;
	string parametros[6];
	iterador itic;
	try{
		ifstream ent_entrada(args2);
		getline(ent_entrada,dados);
		while(getline(ent_entrada,dados)){
			stringstream data;
			data.str(dados);
			getline(data,parametros[0],';');//lê o código.
			getline(data,parametros[1],';');//lê o tipo.
			getline(data,parametros[2],';');//lê o nome.
			getline(data,parametros[3],';');//lê o preço.
			getline(data,parametros[4],';');//lê se é quente. (caso não seja uma refeiçãp e seja quente a função verificadora irá aptar)
			getline(data,parametros[5],';');//lê o volume. (caso não seja uma bebida e tenha volume a função verificadora irá aptar)
			
			verificadorCardapio(parametros,args1,args2);//verifica o formato dos parâmetros de entrada.
			int nCodigo = atoi(parametros[0].c_str());//converte o código de string para inteiro.
			size_t tam = parametros[3].find(",");// converte o . para , de um preço.
			if(tam != std::string::npos)
			  parametros[3].replace(parametros[3].find(","),1,".");
			float nPreco = atof(parametros[3].c_str());//converte o preço de string para float.
			int volume = atoi(parametros[5].c_str());//converte o volume de string para inteiro.
			itic.incrementaCardapio(c,nCodigo,parametros[1],parametros[2],nPreco, parametros[4], volume);//invoca o iterador pra incrementar um novo tipo cardapio ao vetor.
		}
		sort(c.begin(),c.end(),cardapio::comparaCodigo);//organiza o cardapio principal em ordem crescente de código.
	}catch (ifstream::failure& e){
			cerr<<"Erro na abertura do arquivo:  "<<e.what()<<endl; //copiada dos slides. VERIFICAR!!
		}
}

/*Função que verifica o formato dos parâmetros de entrada.*/
void carregador::verificadorCardapio(string* parametro,char* args1,char* args2){
		if(parametro[0].size() == 0 || parametro[1].size() == 0 || parametro[2].size() == 0 || parametro[3].size() == 0)
			new erro(args1,args2);

		if(parametro[1].compare("R") == false && parametro[1].compare("B") == false && parametro[1].compare("S") == false)
			 new erro(args1,args2);
		
		if(parametro[1].compare("S") == true)
				if(parametro->size() > 4)
					new erro(args1,args2);
		
		if(parametro[1].compare("B") == true)
			if(parametro->size() > 4)
				if(parametro[4].size() != 0)
					new erro(args1,args2);
		
		if(parametro[1].compare("R") == true)
			if(parametro->size() > 5)
				if(parametro[5].size() != 0)
					new erro(args1,args2);
		
		if(parametro[1] == "B")
		{
			if(parametro[5].size() == 0)
				new erro(args1,args2);
			try{
				int volume = atoi(parametro[5].c_str());
			}catch(std::invalid_argument& er){
				 new erro(args1,args2);
			}
		}
		try{
			int codigo = atoi(parametro[0].c_str());
		}catch(std::invalid_argument& er){
			 new erro(args1,args2);
		}
		
		try{
			float preco = atof(parametro[3].c_str());
		}catch(invalid_argument& er){
			 new erro(args1,args2);
		}
}