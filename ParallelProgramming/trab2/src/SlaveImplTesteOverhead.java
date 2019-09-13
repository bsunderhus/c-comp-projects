/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author thiago
 */
public class SlaveImplTesteOverhead implements Slave {

    private SlaveManager master;
    private int id;
    private long currentIndex;
    private List<String> words;
    private Slave remoteReference;
    private String slaveName;
    private ScheduledExecutorService checkpointScheduler;
    private final ScheduledExecutorService registrationScheduler;
    private String host;

    public SlaveImplTesteOverhead() {
        currentIndex = 0;
        words = new ArrayList<>();
        checkpointScheduler = Executors.newScheduledThreadPool(1);
        registrationScheduler = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void startSubAttack(byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex, SlaveManager callbackinterface) throws RemoteException {
        addCheckpointScheduler();
        callbackinterface.checkpoint(currentIndex);
        checkpointScheduler.shutdown();
        checkpointScheduler = Executors.newScheduledThreadPool(1);
    }

    public void addCheckpointScheduler() {
        checkpointScheduler = Executors.newScheduledThreadPool(1);
        Runnable automaticCheckpoint = new Runnable() {

            @Override
            public void run() {
                try {
                    master.checkpoint(currentIndex);
                } catch (RemoteException ex) {
                    System.out.println("Não foi possível enviar o checkpoint ao mestre");
                }
            }
        };
        final ScheduledFuture<?> beeperHandle = checkpointScheduler.scheduleAtFixedRate(automaticCheckpoint, 10, 10, SECONDS);
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            SlaveImplTesteOverhead slave = new SlaveImplTesteOverhead();
            slave.initAutomaticRegistrationTimer();
            slave.loadDictionary();
            slave.slaveName = IdGenerator.getNewName();
            slave.host = host;
            slave.remoteReference = (Slave) UnicastRemoteObject.exportObject(slave, 0);
            slave.attachShutDownHook();
            initRemoteConnection(slave, host);
        } catch (RemoteException | NotBoundException e) {
            System.out.println("Não foi possível registrar o escravo.");
            e.printStackTrace();
        }
    }

    public void initAutomaticRegistrationTimer() {
        Runnable automaticRegistration = new Runnable() {
            @Override
            public void run() {
                try {
                    initRemoteConnection(SlaveImplTesteOverhead.this, host);
                } catch (Exception ex) {
                    System.out.println("Não foi possível efetuar o registro novamente. Tentando novamente em 30 segundos");
                }
            }
        };
        final ScheduledFuture<?> automaticRegistrationHandle = registrationScheduler.scheduleAtFixedRate(automaticRegistration, 30, 30, SECONDS);
    }

    public void loadDictionary() {
        InputStream ins = null; // raw byte-stream
        Reader r = null; // cooked reader
        BufferedReader br = null; // buffered for readLine()
        try {
            String s;
            ins = new FileInputStream("dados/dicionario.txt");
            r = new InputStreamReader(ins, "UTF-8"); // leave charset out for default
            br = new BufferedReader(r);
            while ((s = br.readLine()) != null) {
                this.words.add(s);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
            if (r != null) {
                try {
                    r.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (Throwable t) { /* ensure close happens */ }
            }
        }
    }

    public static void initRemoteConnection(SlaveImplTesteOverhead slave, String host) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host);
        SlaveManager master = (SlaveManager) registry.lookup("mestre");
        slave.master = master;
        slave.id = master.addSlave(slave.remoteReference, slave.slaveName);
    }

    /**
     * Método utilizado para iniciar uma thread quando o escravo morrer e assim
     * poder desconecta-lo do mestre
     */
    public void attachShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    master.removeSlave(id);
                } catch (RemoteException ex) {

                }
            }
        });
    }
}
