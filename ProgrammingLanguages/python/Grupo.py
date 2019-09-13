#
# ­*­ coding: utf­8 ­*­
class Grupo:
	Centroide = []#uma lista com o centroide [x,y,z,...]
	Pontos = []#uma lista com os pontos [[x1,y1,z1,...][x2,y2,z2,...]...]
	def __init__(self, *centro):#contrutor que permite criacao de um grupo com varios pontos como entrada...inutil, mas mesmo assim implementado...
		self.Pontos = list(centro)
		lista = [sum(i) for i in zip(*self.Pontos)]#zip utilizado para acessar ao mesmo tempo todas as possiveis listas dentro de self.Pontos.
		self.Centroide = [(x*(1.0/len(self.Pontos))) for x in lista]#calculo do centroide.
	def AddPonto(self,ponto):#adiciona o ponto sem calcular a mudanca no centroide.
		self.Pontos.append(ponto)
	def CalcCentroide (self):
		lista = [sum(i) for i in zip(*self.Pontos)]#zip utilizado para acessar ao mesmo tempo todas as possiveis listas dentro de self.Pontos.
		self.Centroide = [(x*(1.0/len(self.Pontos))) for x in lista]#calculo do centroide.
	def __str__(self):#reescrita do __str__ para printar e ajudar no desenvolvimento do trabalho.
		return "Centro: " + str(self.Centroide) +"\nPontos: " + str(self.Pontos)
	def __eq__(self,other):#reescrita do operador de comparacao '=' para facilitar na hora de comparar se dois grupos sao iguais.
		return (self.Pontos == other.Pontos and self.Centroide == other.Centroide)