import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import br.inf.ufes.pp2016_01.*;

class SlaveRunnable implements Runnable {

  private final Slave slave;
  private final int key;
  private final String slaveName;

  private long initialWordIndex;
  private long finalWordIndex;
  private long currentWordIndex;
  private MyMaster master;

  private long lastCall;
  private long timeInit;

  public void setSubAttack(
		long initialWordIndex,
		long finalWordIndex){
        this.initialWordIndex = initialWordIndex;
        this.finalWordIndex = finalWordIndex;
        this.currentWordIndex = initialWordIndex;
  }

  public SlaveRunnable(Slave slave, String slaveName,int key, MyMaster master){
    this.slave = slave;
    this.slaveName = slaveName;
    this.key = key;
    this.master = master;
  }

  @Override
  public void run(){
    timeInit = System.currentTimeMillis();
    lastCall = timeInit;
    try {
      slave.startSubAttack(master.cipherText,master.knownText,initialWordIndex,finalWordIndex,(SlaveManager)master.callbackInterface);
    }
    catch (RemoteException e) {
      try {
        master.removeSlave(key);
        master.spreadAttack(currentWordIndex,finalWordIndex);
      }catch (RemoteException ex) {}
    }
  }

  public void setCurrentWordIndex(long newIndex){
    currentWordIndex = newIndex;
  }

  public void setLastCall(long newTime){
    lastCall = newTime;
  }

  public long getLastCall(){
    return lastCall;
  }

  public long getCurrentWordIndex(){
    return currentWordIndex;
  }

  public long getInitialWordIndex(){
    return currentWordIndex;
  }

  public long getFinalWordIndex(){
    return finalWordIndex;
  }

  public String getSlaveName(){
    return slaveName;
  }

  public Slave getSlave(){
    return slave;
  }

  public int getKey(){
    return key;
  }

  public long getTimeInit(){
    return timeInit;
  }

  public String toString(){
    return slaveName +"  " +initialWordIndex + "   " + currentWordIndex + "   " + finalWordIndex;
  }
}
