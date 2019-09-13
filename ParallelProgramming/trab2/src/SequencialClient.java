import br.inf.ufes.pp2016_01.*;
import java.io.IOException;
import static java.lang.System.exit;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SequencialClient {

    private final String fileNameBytes;
    private final byte[] knownString;
    private int sizeOfBytesVector;
    private byte[] cipherText;
    private List<String> dictionary;

    public SequencialClient(String fileNameBytes, String knownString) {
        this.fileNameBytes = fileNameBytes;
        this.knownString = knownString.getBytes();
        dictionary = new ArrayList<>();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Informe os argumentos:\n"
                    + "1 - nome do arquivo que contém o vetor de bytes\n"
                    + "2 - palavra conhecida que consta da mensagem\n"
                    + "3 - tamahho do vetor gerado (opcional)");
            exit(0);
        }

        SequencialClient sequencialClient = new SequencialClient(args[0], args[1]);
        if (args.length == 3) {
            sequencialClient.sizeOfBytesVector = Integer.parseInt(args[2]);
        }

        sequencialClient.dictionary = Util.loadDictionary();
        sequencialClient.setCipherBytesArray();
        sequencialClient.attackAndSaveFile();
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

        for (String key : dictionary) {
            try {
                SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");

                Cipher cipher = Cipher.getInstance("Blowfish");
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
                byte[] decrypted = cipher.doFinal(this.cipherText);
                if (Util.containsSubArray(decrypted, this.knownString)) {
                    Util.saveFile(key + ".msg", decrypted);
                    System.out.println("message size (bytes) = " + this.cipherText.length);
                }
            } catch (Exception ex) {

            }
        }
    }
}
