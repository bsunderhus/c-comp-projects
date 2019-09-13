package DisqueRango;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

@SuppressWarnings("serial")
public class Cardapio implements  Comparable<Cardapio>, Serializable , Comparator<Cardapio> {
	int Codigo;
	String Tipo;
	String Item;
	int quantidade;
	float Preco;
	
	protected String pico = "Não";
	protected int codigoInterno;
	
	public void copiaCardapio(Cardapio cardap){
		this.Codigo = cardap.Codigo;
		this.Tipo = cardap.Tipo;
		this.Item = cardap.Item;
		this.quantidade = cardap.quantidade;
		this.Preco = cardap.Preco;
		this.codigoInterno = cardap.codigoInterno;
	}
	
	public String toString(){
		final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		return "\t" + Codigo + "\t" + nf.format(Preco) + " \t" + Item ;
	}
	public void Imprime(ArrayList<Cardapio> cardapio){
		  for(int i=0; i < cardapio.size(); i++){
		   System.out.println(cardapio.get(i));
		  }
	}
	@Override
	public int compareTo(Cardapio arg0) {
			return (this.Codigo) - (arg0.Codigo);
	}

	@Override
	public int compare(Cardapio o1, Cardapio o2) {
		if(o1.quantidade == o2.quantidade)
			return o1.Item.compareTo(o2.Item);
		else
			return o2.quantidade - o1.quantidade;
	}
	
	public void IncrementaQuantidade(ArrayList<Cardapio> pedidos){
		for(Cardapio incrementador:pedidos){
				if(this.compareTo(incrementador) == 0){
					this.quantidade += incrementador.quantidade;
					if(incrementador.quantidade > 4)
						this.pico = "Sim";
					break;
			}
		}
	}
}



@SuppressWarnings("serial")
class Bebida extends Cardapio{
	String Tipo = "B";
	boolean Quente = false;	
	int Volume;
}

@SuppressWarnings("serial")
class Refeicao extends Cardapio{
	String Tipo = "R";
	boolean Quente;
}
@SuppressWarnings("serial")
class Sobremesa extends Cardapio{
	String Tipo = "S";
	boolean Quente = false;
}
