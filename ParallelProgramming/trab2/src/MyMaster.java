import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import br.inf.ufes.pp2016_01.*;




class MyMaster implements Master{
  private ConcurrentMap<Integer, Slave> slaveMap = new ConcurrentHashMap<>();
  private ConcurrentMap<Integer, String> slaveNameMap = new ConcurrentHashMap<>();
  private List<SlaveAttack> attacks = new ArrayList<>();
  private int registry = 0;
  private List<Guess> guesses = new ArrayList<>();
  protected byte[] cipherText;
  protected byte[] knownText;
  private int dictionarySize;
  protected Master callbackInterface;
  private long WATCH_TIMER = 12000;

  public void setCallBackInterface(Master cb){
    callbackInterface = cb;
  }

  public MyMaster(int dictionarySize){
    this.dictionarySize = dictionarySize;
  }

  /**
  * Registra escravo no mestre. Deve ser chamada a cada 30s
  * por um escravo para se re-registrar.
  * @param s referência para o escravo
  * @param slaveName identificador para o escravo
  * @return chave que identifica o escravo para posterior remoção
  * @throws RemoteException
  */
  public int addSlave(Slave slave, String slaveName)throws RemoteException{
    if(slaveNameMap.containsValue(slaveName)){
      for (ConcurrentMap.Entry<Integer,String> entry : slaveNameMap.entrySet()) {
        if(entry.getValue().equals(slaveName)){
          int key = entry.getKey();
          slaveMap.put(key, slave);
          return key;
        }
      }
    }
    int key = registry++;
    slaveNameMap.put(key, slaveName);
    slaveMap.put(key, slave);
    System.out.println("Slave "+ slaveName +" added.");
    return key;
  }

  /**
  * Desregistra escravo no mestre.
  * @param slaveKey chave que identifica o escravo
  * @throws RemoteException
  */
  public void removeSlave(int slaveKey)throws RemoteException{
    Slave slave = slaveMap.remove(slaveKey);
    if(slave != null){
      synchronized(attacks){
        Iterator<SlaveAttack> i = attacks.iterator();
        while (i.hasNext()) {
          SlaveAttack attack = i.next();
          if(attack.getKey() == slaveKey){
            i.remove();
          }
        }
      }
      System.out.println("Slave "+ slaveNameMap.remove(slaveKey)+" removed.");
    }
  }

  /**
  * Indica para o mestre que o escravo achou uma chave candidata.
  * @param currentindex índice da chave candidata no dicionário
  * @param currentguess chute que inclui chave candidata e
  * mensagem decriptografada com a chave candidata
  * @throws RemoteException
  */
  public void foundGuess(long currentindex,Guess currentguess)throws RemoteException{
    SlaveAttack attack = findSlaveAttackByIndex(currentindex);
    if(attack == null){
      System.out.println("Could not find slave responsible for the guess in the index "+ currentindex);
      System.out.println("Guess discarted");
    }else{
      System.out.println("Found Guess!");
      System.out.println("Slave name: " + slaveNameMap.get(attack.getKey()));
      System.out.println("Current Index: " + currentindex);
      guesses.add(currentguess);
    }
    System.out.println();
  }

  /**
  * Encontra o escravo responsavel pelo processamento do dado indice
  * @param index.
  * @throws RemoteException
  */
  private SlaveAttack findSlaveAttackByIndex(long index){
    Iterator<SlaveAttack> i = attacks.iterator();
    while (i.hasNext()) {
      SlaveAttack attack = i.next();
      if(index <= attack.getFinalWordIndex() && index >= attack.getInitialWordIndex()){
        return attack;
      }
    }
    return null;
  }

  /**
  * Chamado por cada escravo a cada 10s durante ataque para indicar
  * progresso no ataque, e ao final do ataque.
  * @param currentindex índice da chave já verificada
  * @throws RemoteException
  */
  public synchronized void checkpoint(long currentindex)throws RemoteException{
    Iterator<SlaveAttack> i = attacks.iterator();
    SlaveAttack attack = findSlaveAttackByIndex(currentindex);
    if(attack != null){
      attack.setCurrentWordIndex(currentindex);
      attack.setLastCall(System.currentTimeMillis());
      // System.out.println("Checkpoint received:");
      // System.out.println("Slave name: " + slaveNameMap.get(attack.getKey()));
      // System.out.println("Index: " + currentindex);
      System.out.println(attack);
      if (allFinished()) {
        this.notify();
      }
    }else{
      System.out.println("Checkpoint failed on index "+currentindex);
    }
    System.out.println();
  }

  /**
  * Operação oferecida pelo mestre para iniciar um ataque.
  * @param ciphertext mensagem critografada
  * @param knowntext trecho conhecido da mensagem decriptografada
  * @return vetor de chutes: chaves candidatas e mensagem
  * decritografada com chaves candidatas
  */
  public Guess[] attack(byte[] ciphertext,byte[] knowntext)throws RemoteException{
    if (slaveMap.isEmpty()) {
      System.out.println("There are no slaves to execute the attack");
      return null;
    }

    attacks = new ArrayList<>();
    this.cipherText = ciphertext;
    this.knownText = knowntext;

    spreadAttack(0,dictionarySize);


    Runnable watchDog = new Runnable() {
      @Override
      public void run() {
        try {
          watchAttack();
        }catch (RemoteException e) {System.out.println(e.getMessage());}
      }
    };

    ScheduledExecutorService guardian = Executors.newScheduledThreadPool(1);
    guardian.scheduleAtFixedRate(watchDog, WATCH_TIMER, WATCH_TIMER, MILLISECONDS);
    try {
      synchronized(this){
        wait();
      }
    }catch (InterruptedException e) {

    }

    guardian.shutdown();
    return guesses.toArray(new Guess[guesses.size()]);
    }

    /**
    * Operação que trata de distribuir cada escravo a sua tarefa.
    * @param initialWordIndex o indice que começa a distribuição
    * @param finalWordIndex o indice que termina
    */
    protected void spreadAttack(long initialWordIndex,long finalWordIndex) throws RemoteException{
      int slaveMapSize = slaveMap.size();
      if(slaveMapSize == 0){
        System.out.println("There are no slaves to execute the attack");
        return;
      }
      long dictionarySize = finalWordIndex - initialWordIndex;
      long slavePartition = dictionarySize/slaveMapSize;
      long extraPartition = dictionarySize%slaveMapSize;

      long aux = initialWordIndex;
      //Iterates over each slave activating a thread for each
      for (ConcurrentMap.Entry<Integer, Slave> entry : slaveMap.entrySet()) {
        SlaveAttack attack;
        if(extraPartition-- > 0){
          attack = new SlaveAttack(entry,aux,aux+slavePartition+1,this);
          attacks.add(attack);
          aux += slavePartition + 1;
        }
        else{
          attack = new SlaveAttack(entry,aux,aux+slavePartition,this);
          attacks.add(attack);
          aux += slavePartition;
        }
        attack.startSubAttack();
      }
    }

    /**
    * Função que verifica se todos os escravos realizaram checkpoint nos ultimos 20 segundos.
    * casp não, o escravo é removido.
    * @throws RemoteException
    */
    public void watchAttack() throws RemoteException {
      Iterator<SlaveAttack> i = attacks.iterator();
      while (i.hasNext()) {
        SlaveAttack attack = i.next();
        if(attack.getLastCall() < System.currentTimeMillis() - WATCH_TIMER) {
          System.out.println("Slave "+slaveNameMap.get(attack.getKey()) + " late for the checkpoint.\n");
          removeSlave(attack.getKey());
          spreadAttack(attack.getCurrentWordIndex(),attack.getFinalWordIndex()+1);
        }
      }
    }


    /**
    * Retorna se todos os escravos já terminaram.
    */
    private synchronized boolean allFinished(){
      boolean aux = true;
      Iterator<SlaveAttack> i = attacks.iterator();
      while (i.hasNext()) {
        SlaveAttack attack = i.next();
        if(attack.getCurrentWordIndex() < attack.getFinalWordIndex()){
          aux = false;
          break;
        }
      }
      return aux;
    }

    public static void main(String[] args) {
      try {
        Registry registry = LocateRegistry.getRegistry();
        List<String> dictionary = Util.loadDictionary();
        MyMaster master = new MyMaster(dictionary.size());
        Master masterRef = (Master) UnicastRemoteObject.exportObject(master,0);
        master.setCallBackInterface(masterRef);

        // Bind the remote object in the registry
        registry.rebind("mestre", masterRef);
        System.out.println("Server ready\n");
      } catch (Exception e) {
        System.err.println("Server exception: " + e.toString());
        e.printStackTrace();
      }
    }
  }
