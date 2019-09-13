package br.inf.ufes.pp2016_01;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class Decrypt {

	private static byte[] readFile(String filename) throws IOException {

		File file = new File(filename);
		InputStream is = new FileInputStream(file);
		long length = file.length();

		  //creates array (assumes file length<Integer.MAX_VALUE)
		byte[] data = new byte[(int)length];

		int offset = 0;
		int count = 0;

		while((offset < data.length) && (count = is.read(data, offset, data.length-offset)) >= 0 ){
			offset += count;
		}
		is.close();
		return data;
	}

	private static void saveFile(String filename, byte[] data) throws IOException {

		FileOutputStream out = new FileOutputStream(filename);
		out.write(data);
		out.close();

	}


	public static void main(String[] args) {
		// args[0] e a chave a ser usada
		// args[1] e o nome do arquivo de entrada

		try {

			byte[] key = args[0].getBytes();
			SecretKeySpec keySpec = new SecretKeySpec(key, "Blowfish");

			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, keySpec);

			byte[] message = readFile(args[1]);
			System.out.println("message size (bytes) = "+ message.length);

			byte[] decrypted = cipher.doFinal(message);

			saveFile(args[0]+".msg", decrypted);

		} catch (javax.crypto.BadPaddingException e) {
			// essa excecao e jogada quando a senha esta incorreta
			// porem nao quer dizer que a senha esta correta se nao jogar essa excecao
			System.out.println("Senha invalida.");

		} catch (Exception e) {
			//dont try this at home
			e.printStackTrace();
		}
	}

}
