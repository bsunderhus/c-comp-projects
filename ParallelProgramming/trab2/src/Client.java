/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import static java.lang.System.exit;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import br.inf.ufes.pp2016_01.*;

public class Client {

    private final String host;
    private final String fileNameBytes;
    private final byte[] knownString;
    private int sizeOfBytesVector;
    private Attacker master;
    private byte[] cipherText;

    public Client(String host, String fileNameBytes, String knownString) {
        this.host = host;
        this.fileNameBytes = fileNameBytes;
        this.knownString = knownString.getBytes();
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Informe os argumentos:\n"
                    + "1 - Host\n"
                    + "2 - nome do arquivo que contém o vetor de bytes\n"
                    + "3 - palavra conhecida que consta da mensagem\n"
                    + "4 - tamahho do vetor gerado (opcional)");
            exit(0);
        }

        Client client = new Client(args[0], args[1], args[2]);
        if (args.length == 4) {
            client.sizeOfBytesVector = Integer.parseInt(args[3]);
        }

        client.setMasterReference();
        client.setCipherBytesArray();
        client.attackAndSaveFile();

    }

    public void setMasterReference() {
        try {
            Registry registry = LocateRegistry.getRegistry(host.equals("null") ? null : host);
            master = (Attacker) registry.lookup("mestre");
        } catch (Exception ex) {
            System.out.println("Erro ao localizar o mestre");
            ex.printStackTrace();
        }
    }

    public void setCipherBytesArray() {
        try {
            cipherText = Util.readFile(fileNameBytes);
        } catch (IOException ex) {
            this.generateRandomBytes();
        }
    }

    public void generateRandomBytes() {
        int randomNumber = 0;
        if (sizeOfBytesVector == 0) {
            Random random = new Random();
            //get the range, casting to long to avoid overflow problems
            long range = (long) Util.MAX_VALUE_TAM_BYTES - (long) Util.MIN_VALUE_TAM_BYTES + 1;
            // compute a fraction of the range, 0 <= frac < range
            long fraction = (long) (range * random.nextDouble());
            randomNumber = (int) (fraction + Util.MIN_VALUE_TAM_BYTES);
            cipherText = Util.randonBytes(randomNumber);
            try {
                Util.saveFile("vetorAleatorioBytes", cipherText);
            } catch (IOException ex) {
                System.out.println("Erro ao salvar o arquivo de bytes gerado aleatoriamente");
            }
        } else {
            cipherText = Util.randonBytes(sizeOfBytesVector);
        }
    }

    public void attackAndSaveFile() {
        try {
            long start = System.nanoTime();
            Guess[] guesses = this.master.attack(cipherText, knownString);
            long end = System.nanoTime();
            long elapsedTime = end - start;
            double seconds = (double) elapsedTime / 1000000000.0;
            System.out.println("Foram gastos " + seconds + " para achar a resposta");

            if (guesses == null) {
                return;
            }

            System.out.println("Quantidade de Possíveis Chaves:" + guesses.length);
            for (Guess guess : guesses) {
                Util.saveFile(guess.getKey() + ".msg", guess.getMessage());
            }
        } catch (RemoteException ex) {
            System.out.println("Erro ao invocar o ataque no mestre");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o arquivo com os resultados encontrados");
            ex.printStackTrace();
        }
    }
}
