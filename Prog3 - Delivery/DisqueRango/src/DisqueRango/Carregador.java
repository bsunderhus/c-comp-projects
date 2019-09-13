package DisqueRango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;



public class Carregador {
	public Carregador(String[] args , ArrayList<Cardapio> cardapio, ArrayList<Entregador> entregador, ArrayList<Cliente> clientes, Calendar calen){
		int k = 0;
		if(args.length < 1){
			System.out.println("Arquivos de entrada não especificados.");
			System.exit(0);
		}
		if(args[k].equals("-teste"))
		{
			calen.set(2013,Calendar.DECEMBER,20,23,59,59);
			k++;
		}
		if(args[k].equals("-p") == true)
		{
			new Persistencia().Deserializador(cardapio, entregador, clientes);
			for(int i = 0; i < cardapio.size(); i++)
			{
				cardapio.get(i).codigoInterno = i;
			}
		}
		else{
			if(args.length < 4){
				System.out.printf("Arquivos de entrada não especificados. Use: -e <entregadores> -c <cardápio>\n");
				System.exit(0);
			}if(args[k].equals("-e") == false || args[k+2].equals("-c") == false){
				System.out.printf("Arquivos de entrada não especificados. Use: -e <entregadores> -c <cardápio>\n");
				System.exit(0);
			}
			else{
				Entregador(entregador,args[k+1], args[k+3]);
				Cardapio(cardapio,args[k+1],args[k+3]);
				for(int i = 0; i < cardapio.size(); i++)
				{
					cardapio.get(i).codigoInterno = i;
				}
			}
		}
	}
	
	public void Entregador(ArrayList<Entregador> entregador,String args1, String args2){
		String data;
		String[] parametros;
	try{
		FileReader file1 = new FileReader(args1);
		BufferedReader entreg = new BufferedReader(file1);
		entreg.readLine();
		while((data = entreg.readLine()) != null){
		parametros = data.split(";");
		if(parametros[0].length() == 0 || parametros[1].length()== 0){new Erro(args1,args2);}
		Entregador ent = new Entregador();
		ent.Nome = parametros[0];
		ent.Placa = parametros[1];
		int aux = 0;
		for(int i = 0; i < entregador.size();i++)
		{
			if(entregador.get(i).Placa.equals(ent.Placa))
			aux = 1;
			entregador.get(i).ordem = true;
		}
		if(aux == 0)
			entregador.add(ent);
		}
		Collections.sort(entregador);
		entreg.close();
		
	}catch(IOException e){
		System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
	public void Cardapio(ArrayList<Cardapio> cardapio,String args1, String args2){
		String data;
		String[] parametros;
		try{
		FileReader file = new FileReader(args2);
		BufferedReader arq = new BufferedReader(file);
		arq.readLine();
		while((data = arq.readLine()) != null){
			data = data.replace(",", ".");
			parametros = data.split(";");
			VerificadorC(parametros,args1,args2);
			Cardapio card = new Cardapio();
				if(parametros[1] == "R")
				{
					card = new Refeicao();
					if( parametros[4] == "x")
						((Refeicao)card).Quente = true;
					else
						((Refeicao)card).Quente = false;
				}
				if(parametros[1] == "S")
					card = new Sobremesa();
				if(parametros[1] == "B")
				{
					card = new Bebida();
					((Bebida)card).Volume = Integer.parseInt(parametros[5]);
				}
				card.Codigo = Integer.parseInt(parametros[0]);
				card.Tipo = parametros[1];
				card.Item = parametros[2];
				card.Preco = Float.parseFloat(parametros[3]);
				int aux = 0;
				for(int i = 0; i < cardapio.size();i++)
				{
					if(cardapio.get(i).Codigo == (card.Codigo))
						aux = 1;
				}
				if(aux == 0)
					cardapio.add(card);
		}
		Collections.sort(cardapio);
		arq.close();
		}catch (IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
	private void VerificadorC (String[] parametro,String args1, String args2) //Usado na Cardapio para verificar as especificacoes.
	{
		if(parametro.length > 6 || parametro.length < 4)
			new Erro(args1,args2);
		if(parametro[0].length() == 0 || parametro[1].length() == 0 || parametro[2].length() == 0 || parametro[3].length() == 0)
			new Erro(args1,args2);

		if(parametro[1].equals("R") == false && parametro[1].equals("B") == false && parametro[1].equals("S") == false)
			new Erro(args1,args2);
		
		if(parametro[1].equals("S") == true)
				if(parametro.length > 4)
					new Erro(args1,args2);
		
		if(parametro[1].equals("B") == true)
			if(parametro.length > 4)
				if(parametro[4].length() != 0)
					new Erro(args1,args2);
		
		if(parametro[1].equals("R") == true)
			if(parametro.length > 5)
				if(parametro[5].length() != 0)
					new Erro(args1,args2);
		
		if(parametro[1] == "B")
		{
			if(parametro[5].length() == 0)
				new Erro(args1,args2);
			try{
				@SuppressWarnings("unused")
				int volume = Integer.parseInt(parametro[5]);
			}catch(NumberFormatException er){
				new Erro(args1,args2);
			}
		}
		try{
			@SuppressWarnings("unused")
			int codigo = Integer.parseInt(parametro[0]);
		}catch(NumberFormatException er){
			new Erro(args1,args2);
		}
		
		try{
			@SuppressWarnings("unused")
			float preco = Float.parseFloat(parametro[3]);
		}catch(NumberFormatException er){
			new Erro(args1,args2);
		}
	}
	
}
