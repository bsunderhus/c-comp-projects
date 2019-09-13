import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;


class Master implements Checksum{
  private HashMap<Integer, ChecksumCallable> slaveMap;
  private int registry = 0;

  public int getRegistry(){
    return registry;
  }
  public byte getOverhead (List<Byte> bytes){
    byte sum = 0;

    //if there is no slave, why bother computation? just leave.
    if(slaveMap.size() == 0){
      //TODO: Create a NoSlaveException to be throw perhaps...
      return sum;
    }

    //Invokes futureMap to generate the threads and to kick in the checksum
    HashMap<Integer,Future<Byte>> futureMap = futureMap(list,true);

    //Iterates over each future to get the results of each slave.
    for (Integer index : futureMap.keySet()) {
      try {
        futureMap.get(index).get();//the sum is equal to a bit-to-bitoperation of each slave checksum
      }

      /*If an exception is thrown, then remove the slave responsible for the exception and
        and compute his part again*/
      catch (InterruptedException | ExecutionException e) {
        ChecksumCallable slaveCaller = slaveMap.get(index);
        unregister(slaveCaller.getChecker(),index);
        checksum(slaveCaller.getList());//Recursion
      }
    }
    return sum;
  }

  public Master(){
    super();//TODO:is this necessary?

    //initiates a new empty ArrayList
    this.slaveMap = new HashMap<>();
  }

  /*
  * Function to create a list with the connection to the threads and
  * to divide the list between them.
  * In - a list.
  * Out - a list.
  */
  private HashMap<Integer,Future<Byte>> futureMap(List<Byte> list,boolean overhead){
    //Creates a pool containing a fixed number of threads equal to the slaveMap size.
    ExecutorService pool = Executors.newFixedThreadPool(slaveMap.size());

    //Creates a list of future object that will return the value for each slave.
    HashMap<Integer,Future<Byte>> futureMap = new HashMap<>();

    int slavePartition = list.size()/slaveMap.size();//Size of the sublist for each slave.
    int extraPartition = list.size()%slaveMap.size();//rest of the division between slaves.

    //auxiliar iterator that defines the value of entry in the list to the sublist
    int aux = 0;
    //Iterates over each slave activating a thread for each
    for (Integer index : slaveMap.keySet()) {
      if(extraPartition-- > 0){
        slaveMap.get(index).setList(new ArrayList<Byte>(list.subList(aux, aux + slavePartition + 1)));
        aux += slavePartition + 1;
      }
      else{
        slaveMap.get(index).setList(new ArrayList<Byte>(list.subList(aux, aux + slavePartition)));
        aux += slavePartition;
      }
      /*Run the slave in a thread and receives a
      future value that will contain the threads answer*/
      slaveMap.get(index).setOverhead(overhead);
      Future<Byte> future = pool.submit(slaveMap.get(index));

      //Add it to the answer list
      futureMap.put(index,future);
    }
    return futureMap;
  }

  @Override
  public byte checksum(List<Byte> list){
    byte sum = 0;

    //if there is no slave, why bother computation? just leave.
    if(slaveMap.size() == 0){
      //TODO: Create a NoSlaveException to be throw perhaps...
      return sum;
    }

    //Invokes futureMap to generate the threads and to kick in the checksum
    HashMap<Integer,Future<Byte>> futureMap = futureMap(list,false);

    //Iterates over each future to get the results of each slave.
    for (Integer index : futureMap.keySet()) {
      try {
        sum ^= futureMap.get(index).get();//the sum is equal to a bit-to-bitoperation of each slave checksum
      }

      /*If an exception is thrown, then remove the slave responsible for the exception and
        and compute his part again*/
      catch (InterruptedException | ExecutionException e) {
        ChecksumCallable slaveCaller = slaveMap.get(index);
        unregister(slaveCaller.getChecker(),index);
        sum ^= checksum(slaveCaller.getList());//Recursion
      }
    }
    return sum;
  }

  /*
  * Function to register the slave
  * In - a slave to be registered.
  * Out - void.
  * Adds the slave into a Callable implementation called
  * SumCallable to run in a fixed thread
  */
  @Override
  public int register(Checksum slave){
    ChecksumCallable s = new ChecksumCallable(slave);
    slaveMap.put(registry, s);
    System.out.println("Slave added.");
    return registry++;
  }


  @Override
  public void unregister(Checksum slave,int id){
    ChecksumCallable slaveRemoved = slaveMap.remove(id);
    System.out.println("Slave " + id + " has been removed");
    if(slaveRemoved == null || slave == null){return;}
    try{
      slaveRemoved.getChecker().unregister(null,-1);
    }catch(RemoteException e){}
  }

  public static void main(String[] args) {
    try {
		    Checksum master = (Checksum) UnicastRemoteObject.exportObject(new Master(),0);
		    // Bind the remote object in the registry
		    Registry registry = LocateRegistry.getRegistry(); // opcional: host
		    registry.rebind("Master", master);
		    System.out.println("Server ready");
		} catch (Exception e) {
		    System.err.println("Server exception: " + e.toString());
        e.printStackTrace();
		}
	}
}
