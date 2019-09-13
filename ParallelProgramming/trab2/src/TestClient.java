import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.exit;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import br.inf.ufes.pp2016_01.*;

public class TestClient {

    //private String fileNameBytes;
    private final byte[] knownString;
    private int sizeOfBytesVector;
    private byte[] cipherText;
    private List<String> dictionary;
    private Master master;
    private String host;

    public TestClient(String knownString) {
        this.knownString = knownString.getBytes();
        dictionary = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Informe os argumentos:\n"
                        + "1 - 1(sequencial) / 2 (paralelo)\n"
                        + "2 - palavra conhecida que consta da mensagem\n"
                        + "3 - host ( opcional)");
                exit(0);
            }

            String host = args.length == 3 ? args[2] : null;
            TestClient Client = new TestClient(args[1]);
            Client.dictionary = Util.loadDictionary();
            int nElementos;

            if (Integer.valueOf(args[0]) == 1) {

                PrintWriter writer = new PrintWriter("teste_sequencial.csv", "UTF-8");
                writer.println("numero de elementos ; tempo (s)");

                for (String line : Files.readAllLines(Paths.get("dados/tamanhoVetores"), Charset.defaultCharset())) {
                    nElementos = Integer.valueOf(line);
                    Client.sizeOfBytesVector = nElementos;
                    Client.setCipherBytesArray();
                    Client.sequentialattack(writer, nElementos);
                }

                writer.close();

            } else if (Integer.valueOf(args[0]) == 2) {
                Client.setMasterReference();
                Client.host = host;

                PrintWriter writer = new PrintWriter("teste_paralelo.csv", "UTF-8");
                writer.println("numero de elementos ; tempo (s)");

                for (String line : Files.readAllLines(Paths.get("dados/tamanhoVetores"), Charset.defaultCharset())) {
                    nElementos = Integer.valueOf(line);
                    Client.sizeOfBytesVector = nElementos;
                    Client.setCipherBytesArray();
                    Client.parallelattack(writer, nElementos);
                }

                writer.close();
            }

            exit(0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCipherBytesArray() {
        this.generateRandomBytes();
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

    public void sequentialattack(PrintWriter writer, int nElementos) {
        long start = System.nanoTime();

        for (String key : dictionary) {
            try {
                SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");

                Cipher cipher = Cipher.getInstance("Blowfish");
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
                byte[] decrypted = cipher.doFinal(this.cipherText);
                if (Util.containsSubArray(decrypted, this.knownString)) {
//                    Util.saveFile(new String(key, Charset.defaultCharset()) + ".msg", decrypted);
//                    System.out.println("message size (bytes) = " + this.cipherText.length);
                }
            } catch (Exception ex) {

            }
        }

        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double) elapsedTime / 1000000000.0;
        writer.println(nElementos + " ; " + seconds);
    }

    public void parallelattack(PrintWriter writer, int nElementos) {

        try {
            long start = System.nanoTime();
            this.master.attack(cipherText, knownString);
            long end = System.nanoTime();
            long elapsedTime = end - start;

            double seconds = (double) elapsedTime / 1000000000.0;

            writer.println(nElementos + " ; " + seconds);

//            System.out.println("Foram gastos " + seconds + " para achar a resposta");
//            System.out.println("Quantidade de Possíveis Chaves:" + guesses.length);
//            for (Guess guess : guesses) {
//                Util.saveFile(guess.getKey() + ".msg", guess.getMessage());
//            }
        } catch (RemoteException ex) {
            System.out.println("Erro ao invocar o ataque no mestre");
            ex.printStackTrace();
        }
    }

    public void setMasterReference() {
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            master = (Master) registry.lookup("mestre");
        } catch (Exception ex) {
            System.out.println("Erro ao localizar o mestre");
            ex.printStackTrace();
        }
    }

}
