import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import br.inf.ufes.pp2016_01.*;

class SlaveAttack{
  private Slave slave;
  private int key;

  private long initialWordIndex;
  private long finalWordIndex;
  private long currentWordIndex;
  private MyMaster master;

  private long lastCall;
  private long timeInit;


  public SlaveAttack(ConcurrentMap.Entry<Integer, Slave> entry,long i, long f, MyMaster m){
    slave = entry.getValue();
    key = entry.getKey();
    initialWordIndex = i;
    finalWordIndex = f;
    currentWordIndex = i;
    master = m;
  }

  public void startSubAttack()throws RemoteException{
    timeInit = System.currentTimeMillis();
    lastCall = timeInit;
    try {
      slave.startSubAttack(master.cipherText,master.knownText,initialWordIndex,finalWordIndex,(SlaveManager)master.callbackInterface);
    }
    catch (RemoteException e) {
      master.removeSlave(key);
      master.spreadAttack(currentWordIndex,finalWordIndex);
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
    return key +"  " +initialWordIndex + "   " + currentWordIndex + "   " + finalWordIndex + "   "+ lastCall;
  }
}
