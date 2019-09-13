package DisqueRango;

public class Erro {
	Erro (String a,String b)
	{
		System.out.printf("Não foi possível processar os arquivos especificados: %s, %s\n",a,b);
		System.exit(1);
	}
}