package DisqueRango;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia {
	
	public void Serializador(ArrayList<Cardapio> cardapio, ArrayList<Entregador> entregador,ArrayList<Cliente> clientes)
	{
				try {
					FileOutputStream fileOut = new FileOutputStream("diskrango.dat");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(cardapio);
					out.writeObject(entregador);
					out.writeObject(clientes);
			        out.close();
			        fileOut.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
	}
	@SuppressWarnings("unchecked")
	public void Deserializador(ArrayList<Cardapio> cardapio, ArrayList<Entregador> entregador, ArrayList<Cliente> clientes)
	{
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("diskrango.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ArrayList<Cardapio> c = (ArrayList<Cardapio>) in.readObject();
	         ArrayList<Entregador> e = (ArrayList<Entregador>) in.readObject();
	         ArrayList<Cliente> cl = (ArrayList<Cliente>) in.readObject();
	         cardapio.addAll(c);
	         entregador.addAll(e);
	         clientes.addAll(cl);
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Not found");
	         c.printStackTrace();
	         return;
	      }
	    }
	}
