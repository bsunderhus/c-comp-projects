make:
	g++ -c bebida.cpp refeicao.cpp sobremesa.cpp cardapio.cpp carregador.cpp cliente.cpp entregador.cpp erro.cpp interface.cpp iterador.cpp pedidos.cpp disquerango.cpp relatorio.cpp tempo.cpp
	g++ -o disquerango disquerango.o bebida.o sobremesa.o cardapio.o carregador.o cliente.o entregador.o erro.o interface.o iterador.o pedidos.o refeicao.o relatorio.o tempo.o
run:
	./disquerango -e entregadores.csv -c cardapio.csv
clean:
	rm -rf disquerango.o bebida.o refeicao.o sobremesa.o cardapio.o carregador.o cliente.o entregador.o erro.o interface.o iterador.o pedidos.o refeicao.o relatorio.o tempo.o
