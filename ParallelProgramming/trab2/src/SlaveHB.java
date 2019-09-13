import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import br.inf.ufes.pp2016_01.*;

public class SlaveBH implements Slave{

  private SlaveManager master;
  private int id;
  private long currentIndex;
  private List<String> dictionarySlice;
  private Slave remoteReference;
  private String slaveName;
  private ScheduledExecutorService checkpointScheduler;
  private final ScheduledExecutorService registrationScheduler;
  private String host;

  public SlaveBH() {
    currentIndex = 0;
    dictionarySlice = new ArrayList<>();
    checkpointScheduler = Executors.newScheduledThreadPool(1);
    registrationScheduler = Executors.newScheduledThreadPool(1);
  }

  @Override
  public void startSubAttack(byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex, SlaveManager callbackinterface) throws RemoteException {
    SlaveBH self = this;
    Thread thread = new Thread(new Runnable(){
      @Override
      public void run(){
        addCheckpointScheduler(callbackinterface);
        try {
          System.out.println("Beginning the Attack: " + initialwordindex);
          long start = System.nanoTime();
          for (long index = initialwordindex; index <= finalwordindex; index++) {
            try {
              currentIndex = index;
              String key = self.dictionarySlice.get((int) index);
              SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
              Cipher cipher = Cipher.getInstance("Blowfish");
              cipher.init(Cipher.DECRYPT_MODE, keySpec);
              byte[] decrypted = cipher.doFinal(ciphertext);

              if (Util.containsSubArray(decrypted, knowntext)) {
                Guess guess = new Guess();
                guess.setKey(key);
                guess.setMessage(decrypted);
                callbackinterface.foundGuess(index, guess);
              }
            } catch (Exception ex) {
              //System.out.println("Error during decrypting");
            }
          }
          System.out.println("last checkpoint!");
          callbackinterface.checkpoint(currentIndex);
          long end = System.nanoTime();
          long elapsedTime = end - start;
          double seconds = (double) elapsedTime / 1000000000.0;
          System.out.println("Ending the Attack till: " + finalwordindex);
          System.out.println("The slave "+ slaveName +" spend " + seconds + " seconds to find the answer\n");
        }
        catch (RemoteException e) {
          e.printStackTrace();
        }
        finally {
          System.out.println("in the end!!!");
          checkpointScheduler.shutdown();
          checkpointScheduler = Executors.newScheduledThreadPool(1);
        }
      }
    });
    thread.start();
  }

  public void startSubAttackOverhead(byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex, SlaveManager callbackinterface) throws java.rmi.RemoteException {

  }

  public void addCheckpointScheduler(SlaveManager callbackinterface) {
    checkpointScheduler = Executors.newScheduledThreadPool(1);
    Runnable automaticCheckpoint = new Runnable() {

      @Override
      public void run() {
        try {
          callbackinterface.checkpoint(currentIndex);
        } catch (RemoteException ex) {
          System.out.println("It wasn't possible send a checkpoint to the Master");
        }
      }
    };
    final ScheduledFuture<?> beeperHandle = checkpointScheduler.scheduleAtFixedRate(automaticCheckpoint, 10, 10, SECONDS);
  }

  /*
  *  Creates and executes a periodic action that becomes enabled first immediately
  * and subsequently with the given period of 30 seconds this executions will commence after
  * initialDelay then initialDelay+period, then initialDelay + 2 * period, and so on.
  * Always trying to addSlave on Master every 30 seconds, but if it fails
  * looks up on the name service for the Master again
  */
  public void reRegistrationHook() {
    final ScheduledFuture<?> automaticRegistrationHandle = registrationScheduler.scheduleAtFixedRate(
    new Runnable() {
      boolean lookUp = false;
      @Override
      public void run() {
        try {
          if(lookUp) {
            Registry registry = LocateRegistry.getRegistry(host);
            master = (SlaveManager) registry.lookup("mestre");
          }
          id = master.addSlave(remoteReference, slaveName);
        } catch (Exception ex) {
          System.out.println("It wasn't possible to find \"mestre\" on Name Service.");
          lookUp = true;
          System.out.println("Looking up on Name service again in 30 seconds...");
        }
      }
    },
    0, 30, SECONDS);
  }

  /*
  * Initialize a Thread which remove the Slave on Master
  */
  public void attachShutDownHook() {
    // Runtime.getRuntime().addShutdownHook(new Thread() {
    //   @Override
    //   public void run() {
    //     try {
    //       master.removeSlave(id);
    //       System.out.println("Removing Slave " + slaveName + "...");
    //     } catch (RemoteException ex) {
    //
    //     }
    //   }
    // });
  }

  public static void main(String[] args) {
    String host = (args.length < 1) ? null : args[0];

    if (args.length < 2) {
      System.out.println("Try:\njava SlaveBH -Djava.rmi.server.hostname=SlaveIP MasterIP SlaveName");
      System.exit(0);
    }

    //Util.getRidOfPrint();

    SlaveBH slave = new SlaveBH();
    slave.slaveName = args[1];
    slave.dictionarySlice = Util.loadDictionary();
    slave.host = host;
    try {
      slave.remoteReference = (Slave) UnicastRemoteObject.exportObject(slave, 0);
      // Looking up for the very first time on Name service the Master
      Registry registry = LocateRegistry.getRegistry(host);
      slave.master = (SlaveManager) registry.lookup("mestre");
      // Garantee the Slave stays registered on Master
      slave.reRegistrationHook();
      // Garantee the Slave deregister when it's finished
      slave.attachShutDownHook();
    } catch (RemoteException | NotBoundException e) {
      System.out.println("It wasn't possible to register Slave " + slave.slaveName + ".");
      e.printStackTrace();
    }
  }
}
