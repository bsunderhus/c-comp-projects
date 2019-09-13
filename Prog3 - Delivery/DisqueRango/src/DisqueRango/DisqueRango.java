package DisqueRango;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class DisqueRango {	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Calendar can = Calendar.getInstance();
		ArrayList<Entregador> entregador = new ArrayList<Entregador>();
		ArrayList<Cardapio> cardapio = new ArrayList<Cardapio>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Pedidos> pedidosDia = new ArrayList<Pedidos>();
		new Carregador(args,cardapio,entregador,clientes,can);
		new Interface(clientes,cardapio,pedidosDia,entregador,s,can,args[0]);
		new Persistencia().Serializador(cardapio, entregador, clientes);
		new Relatorio(entregador,cardapio,pedidosDia,s,can);
		s.close();
	}
}
