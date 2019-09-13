package DisqueRango;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Interface {
	protected void Pedidos(Scanner s, ArrayList<Cardapio> card,Cliente c){
		boolean loop = true;
		while(loop){
			System.out.printf("Adicionar item número (? para cardápio, 0 para finalizar):\n");
			String cod = s.next();
			if(cod.equals("?")){
				card.get(0).Imprime(card);
			}else if(cod.equals("0")){
				loop=false;
			}else{
				addPedidos(cod,card,c.p,s);
			}
		}
	}

	protected void addPedidos(String cod, ArrayList<Cardapio> card,Pedidos p,Scanner s){
		int i = 0;
		try{
		for(Cardapio c: card){
			if(c.Codigo == Integer.parseInt(cod)){
				Cardapio cardap = new Cardapio();
				cardap.copiaCardapio(c);
				p.ped.add(cardap);
				System.out.printf("\tAdicionando \"%s\" ao pedido. Quantidade:\n",c.Item);
				cardap.quantidade = s.nextInt();
				p.preco += c.Preco*(cardap.quantidade);
				break;
			}
			i++;
		}
		if(i>=card.size()){
			System.out.printf("\tNão há item com código %s no cardápio.\n",cod);
		}
	}catch(NumberFormatException e){
		System.out.printf("\tNão há item com código %s no cardápio.\n",cod);
	}
}
	
	protected void finalizaPedidos(ArrayList<Entregador> e,ArrayList<Cardapio> cardap, ArrayList<Pedidos> pedDia, Cliente c, Scanner s,Calendar calen,String teste){
		if(c.p.ped.size() == 0){
			System.out.printf("Nenhum pedido registrado.\n");
			return;
		}else{
		final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		System.out.println("Total: "+ nf.format(c.p.preco)+ ". Confirma?");
		String r = s.next();
		if(r.equals("S") || r.equals("s")){
			DataEHora(c.p,calen);
			c.p.c = c;
			int y = e.get(0).entDaVez(e);
			e.get(y).pedidos.add(c.p);
			pedDia.add(c.p);
			for(Cardapio incrementar:cardap){
			incrementar.IncrementaQuantidade(c.p.ped);
			}
			if(teste.equals("-teste")){
				calen.add(Calendar.MINUTE, 10);
			}
			c.p = new Pedidos();
		}else{
			c.p = new Pedidos();
			return;
			}
		}
	}

	Interface(ArrayList<Cliente> cl, ArrayList<Cardapio> card, ArrayList<Pedidos> pedDia, ArrayList<Entregador> ent, Scanner s,Calendar calen,String teste){
		boolean loop = true;
		while(loop){
			System.out.printf("Telefone (0 para sair):%n");
			String telefone = s.next();
			if(telefone.equals("0") == true){
				loop = false;
			}else{
				Cliente cn = new Cliente();
				if(cl.size() == 0){
					cn.Cadastro(telefone , s);
					cl.add(cn);
				}else{
					cn = cn.procuraCliente(telefone,cl);
					if(cn == null){
					cn = new Cliente();
					cn.Cadastro(telefone , s);
					cl.add(cn);	
					}else{
						cn.OpcaoCad(telefone , s);
					}
				}
			Pedidos(s, card, cn);
			finalizaPedidos(ent, card, pedDia, cn, s,calen,teste);
				}
			}
		}
	
	public void DataEHora(Pedidos p, Calendar calen){
		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
		p.hora = f2.format(calen.getTime());
		p.data = f1.format(calen.getTime());
	}
}
