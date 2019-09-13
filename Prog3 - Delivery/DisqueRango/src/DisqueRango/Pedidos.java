package DisqueRango;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pedidos implements Serializable {
	float preco;
	ArrayList<Cardapio> ped = new ArrayList<Cardapio>();
	String hora;
	String data;
	Cliente c;
	
	public String toString(){
			return c.nome + ";" + c.telefone + ";" + data + ";" + hora + ";" +preco;
	}
}
