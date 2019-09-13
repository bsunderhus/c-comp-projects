#
# ­*­ coding: utf­8 ­*­

def distanciaEuclidiana(ponto,centroide):#distancia Euclidiana...
	centroide = [(-x) for x in centroide]
	lista = [sum(i) for i in zip(ponto, centroide)]#usei a funcao zip que pelo que entendi me permite acessar duas listas ao mesmo tempo.
	lista = [pow(i,2) for i in lista]
	return (sum(lista)**.5)
	
def CriaGrupos(listaPontos,k):# cria os K grupos com o ponto inicial como centroide
	listaGrupos = []
	listaGrupos.append(Grupo(listaPontos[0]))
	Grupao = Grupo(listaPontos.pop(0))
	while(k > 1):
		listaPontos = sorted(listaPontos, key=lambda s:distanciaEuclidiana(s,Grupao.Centroide), reverse=True)#usado sort com distanciaEuclidiana como parametro de comparacao
		listaGrupos.append(Grupo(listaPontos[0]))
		Grupao.AddPonto(listaPontos.pop(0))
		Grupao.CalcCentroide()#calcula o centroide do grupo utilizado como comparativo para escolher o proximo ponto.
		k-= 1
	return listaGrupos
		
def MenorDistancia(listaPontos,listaGrupos):#escolher todos os pontos que tem a menor distancia para cada centroides.
	while (len(listaPontos) != 0):
		aux = 1e309 # infinito...
		ponto = listaPontos.pop(0)
		for x in listaGrupos :
			if (distanciaEuclidiana(ponto,x.Centroide) < aux):#distanciaEuclidiana do ponto avaliado a todos os centroides.
				aux = distanciaEuclidiana(ponto,x.Centroide)#da a aux o valor da menor distanciaEuclidiana.
		for x in listaGrupos :
			if(distanciaEuclidiana(ponto,x.Centroide) == aux):#pesquisa ate achar o ponto que tem a distancia aux, que e a menor distancia.
				x.AddPonto(ponto)#adiciona o ponto em seu devido grupo.
				break
	for x in listaGrupos:
		x.CalcCentroide()#calcula o centroide somente no final. Depois de todos os Grupos estarem completos.

def removePontos(listaGrupos):
	for x in listaGrupos:
		x.Pontos = []

def SSE (listaGrupos):#faz o calculo da SSE...
	sum = 0
	for x in listaGrupos:
		for y in x.Pontos:
			sum += pow(distanciaEuclidiana(y,x.Centroide),2)
	return sum

def Print (listaGrupos,listaOriginal,saida,result):
	for x in listaGrupos:
		lista = []
		for y in x.Pontos:
			lista.append((listaOriginal.index(y))+1)
			listaOriginal[listaOriginal.index(y)] = 0
			lista = list(set(lista))
			lista.sort()
		saida.write(', '.join(map(str, lista)))
		saida.write ("\n\n")
	result.write ("%.4f" % (SSE(listaGrupos)))

from sys import argv
from operator import itemgetter, attrgetter
from Grupo import Grupo
import copy
script = argv
k = int(argv[1])
 
entrada = open('entrada.txt','r')
saida = open('saida.txt','w')
result = open('result.txt','w')
listaOriginal = []
listaPontos = []


for line in entrada:
	listaPontos.append((map(float,(line.rstrip('\n').split())))) # insere na lista de pontos todos os pontos do arquivo de entrada em formato de lista.
	listaOriginal.append((map(float,(line.rstrip('\n').split()))))# lista usada no final do arquivo para a impressao dos pontos na ordem original.

listaPontos.sort()#organiza a lista de pontos em ordem crescente pelo primeiro elemento da lista interior.
listaPontos = sorted(listaPontos, key=lambda s:sum(s))# organiza a lista pela soma dos pontos.

tamListaPontos = len(listaPontos)
auxListaPontos = list(listaPontos)#usado para recomecar a lista de pontos ja que na implementacao e usado pop.
	
listaGrupos = CriaGrupos(listaPontos,k)
while (tamListaPontos > 0):#aqui acontece o algoritmo. enquanto o contador for maior que zero.
	auxlistaGrupos = copy.deepcopy(listaGrupos) # cria uma lista auxiliar para servir de comparacao e garantir o ponto de parada caso aja repeticao.
	removePontos(listaGrupos)#os pontos sao removidos das listas de grupos, para entao serem recalculados.
	listaPontos = list(auxListaPontos)#a lista de pontos eh resetada.
	MenorDistancia(listaPontos, listaGrupos)
	if( listaGrupos == auxlistaGrupos or tamListaPontos == 1):#compara se a lista de grupos e igual a sua anterior ou se esta no final da iteracao.
		break
	tamListaPontos -= 1


Print(listaGrupos,listaOriginal,saida,result)#chamada da funcao que produz os arquivos 'saida.txt' e 'result.txt'


