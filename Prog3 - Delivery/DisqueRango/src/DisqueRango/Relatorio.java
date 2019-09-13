package DisqueRango;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Relatorio {
	final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
	Relatorio(ArrayList<Entregador> e,ArrayList<Cardapio> c,ArrayList<Pedidos> pedDia,Scanner s,Calendar calen){
		PedidosDoDia(pedDia,s,calen);
		entregadores(e,s);
		ItensVendidos(c,e,s);
		
	}
	public void PedidosDoDia(ArrayList<Pedidos> p, Scanner s,Calendar calen){
		
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String dia = form.format(calen.getTime());
		System.out.println("Relatório de pedidos do dia:");
		String nome = (String)s.next();
		try {
			FileWriter fileOut = new FileWriter(nome);
			BufferedWriter out = new BufferedWriter(fileOut);
			out.write("Nome;Telefone;Data;Hora;Valor total\n");
			for(Pedidos pn:p){
				out.write(pn.c.nome + ";" + pn.c.telefone + ";" + pn.data + ";" + pn.hora + ";" + nf.format(pn.preco) + "\n" );
			}
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void entregadores(ArrayList<Entregador> e , Scanner s){
		Collections.sort(e, new Entregador());
		double comicao;
		double total=0;
		System.out.println("Relatório de entregadores:");
		String nome = (String)s.next();
		try {
			FileWriter fileOut = new FileWriter(nome);
			BufferedWriter out = new BufferedWriter(fileOut);
			out.write("Entregador;Qtd. entregas;Valor total;Comissão\n");
			for(Entregador en:e){
				for(Pedidos pe:en.pedidos){
					total = total + pe.preco;
				}
			comicao = total*0.05;
			out.write(en.Nome + ";" + en.pedidos.size() + ";" + nf.format(total) + ";" + nf.format(comicao) + "\n");
			total = 0;
			}
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void ItensVendidos(ArrayList<Cardapio> cardapio,ArrayList<Entregador> e , Scanner s){
		System.out.println("Relatório de itens vendidos:\n");
		String nome = (String)s.next();
		try {
			FileWriter fileOut = new FileWriter(nome);
			BufferedWriter out = new BufferedWriter(fileOut);
			out.write("Item;Qtd. vendida;Pico de procura\n");
			
			Collections.sort(cardapio, new Cardapio());
			for(Cardapio c : cardapio)
					out.write(c.Item + ";" + c.quantidade + ";" + c.pico + "\n");
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
