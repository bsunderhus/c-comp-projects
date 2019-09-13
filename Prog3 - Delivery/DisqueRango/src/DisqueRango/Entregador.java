package DisqueRango;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Entregador implements Comparable<Entregador> , Serializable, Comparator<Entregador>{
	String Nome;
	String Placa;
	ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
	static int entdavez=0;
	
	protected boolean ordem;
	
	public String toString(){
		return Nome + " / " + Placa;
	}
	
	public void Imprime(ArrayList<Entregador> entregador){
		for(int i=0; i < entregador.size(); i++){
			System.out.println(entregador.get(i));
		}
	}
	
	public void ImprimePedidos(ArrayList<Entregador> ent){
		for(int i=0;i<ent.size();i++){
			System.out.println(ent.get(i).Nome);
			for(int j=0;j<ent.get(i).pedidos.size();j++){
				System.out.println(ent.get(i).pedidos.get(j).preco);
			}
		}
	}

	@Override
	public int compareTo(Entregador o) {
			return (this.Placa).compareTo(o.Placa);
	}
	
	@Override
	public int compare(Entregador o1, Entregador o2) {
			return o1.Nome.compareTo(o2.Nome);
	}
	
	public int entDaVez(ArrayList<Entregador> e){
		int out;
		if(entdavez>=e.size()){
			out = 0;
			entdavez=1;
		}else{
			out = entdavez;
			entdavez++;
		}
		return out;
	}
}