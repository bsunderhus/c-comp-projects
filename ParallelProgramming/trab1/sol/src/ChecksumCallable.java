import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;


/*
 * Implements Callable<Byte>
 * A Callable method must exist to make the connection between Master and Slave asynchronous
 */
class ChecksumCallable implements Callable<Byte> {

  //The responsible to run the checksum in an asynchronous envinronment
  private Checksum checker;
  private boolean overhead = false;
  //The list of Byte that'll be passed to the checker
  private List<Byte> list = null;

  //Constructor -- initiates the checker.
  public ChecksumCallable(Checksum checker){
    this.checker = checker;
  }

  public Byte call() throws RemoteException, ExecutionException{
    // if list is not initiated cancel the call and throw exception
    if(list == null)
      throw new ExecutionException("list must be initiated", null);
    //else return the checksum of the checker
    if(!overhead)
      return Byte.valueOf(checker.checksum(list));
    return Byte.valueOf(checker.getOverhead(list));
  }

  //SETTERS ---
  public void setList(List<Byte> list){
    this.list = list;
  }

  public void setOverhead(boolean b){
    overhead = b;
  }

  //GETTERS

  public boolean isOverhead(){
    return overhead;
  }

  public Checksum getChecker(){
    return checker;
  }

  public List<Byte> getList(){
    return list;
  }
}
