package DisqueRango;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Cliente implements Serializable {
	protected String nome;
	protected String endereco;
	protected String pontoDeReferencia;
	protected String telefone;
	protected Pedidos p = new Pedidos();
	
	protected void Recadastro(String t,Scanner s){
		this.telefone = t;
		System.out.printf("Recadastrando cliente (telefone %s):\n",t);
		this.DadosCdt(t,s);
	}
	
	protected void Cadastro(String t,Scanner s){
		this.telefone = t;
		System.out.printf("Cliente não cadastrado. Novo cadastro:\n");
		this.DadosCdt(t,s);
	}
	protected void DadosCdt(String t,Scanner s){
		String jumpBlackSpace = s.nextLine();
		System.out.printf("\tNome:\n");
		this.nome = s.nextLine();
		System.out.printf("\tEndereço:\n");
		this.endereco = s.nextLine();
		System.out.printf("\tPonto de referência:\n");
		this.pontoDeReferencia = s.nextLine();
		
		this.OpcaoCad(t,s);
	}
	
	protected void OpcaoCad(String t,Scanner s){
		System.out.printf("Cliente cadastrado: %s\n[C]onfirma ou [R]ecadastra?\n",this.nome);
		String conf = s.next();
		if(conf.equals("C")|| conf.equals("c")){
			return;
		}else if(conf.equals("R")|| conf.equals("r")){
			this.Recadastro(t,s);
		}else{
			System.out.printf("Informação não reconhecida.\n");
			this.OpcaoCad(t,s);
		}
	}

	
	public Cliente procuraCliente(String telefone2,ArrayList<Cliente> clientes){
		for(Cliente c:clientes){
			if(c.telefone.equals(telefone2)){
				return c;
			}
		}
		return null;
	}
	
	
	public String toString(){
		return nome + " " + telefone;
	}
	
	public void Imprime(ArrayList<Cliente> e){
		for(int i=0;i<e.size();i++){
			System.out.println(e.get(i));
		}
	}
	
	public int Indice(ArrayList<Cliente> c){
		if(c.size() == 0){
			return 0;
		}else{
			return c.size()-1;
		}
	}
}
