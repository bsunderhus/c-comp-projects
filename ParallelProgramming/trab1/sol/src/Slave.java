import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.io.Serializable;

class Slave implements Checksum, Serializable {

  private static final long serialVersionUID = 0L; //Serializable Id.
  private int registry;

  public int getRegistry() {
    return registry;
  }

  @Override
  public byte getOverhead (List<Byte> bytes){
    return 0;
  }

  /*
  * checksum is a bit-to-bit operator in a range o bytes.
  * it results in a new byte for checksum verificaction.
  */
  @Override
  public byte checksum(List<Byte> bytes){
    byte sum = 0;
    for (byte b : bytes) {
      sum ^= b; // ^= --> xor operator
    }
    return sum;
  }

  /*
  * Implements Checksum interface.
  * register the slave itself into the master.
  * In : A Checksum object to be registered in.
  */
  @Override
  public int register(Checksum master) throws java.rmi.RemoteException{
    Checksum slaveRef = (Checksum) UnicastRemoteObject.exportObject(this,0);
    registry = master.register(this);
    System.out.println("Slave registered");
    return registry;
  }

  /*
  * Implements Checksum interface.
  * kills the slave process.
  */
  @Override
  public void unregister(Checksum master,int id) throws java.rmi.RemoteException{
    if(id == -1){
      System.exit(0);
    }
    master.unregister(null,id);
  }

  public static void main(String[] args) {
    String host = (args.length < 1) ? null : args[0]; // hostname passed as argument.
		try {
		  Registry registry = LocateRegistry.getRegistry(host);
		  Checksum masterStub = (Checksum) registry.lookup("Master");//lookup for the Master object
      Slave self = new Slave(); //Creates a local Slave
      self.register(masterStub);//make the slave register itself on the Master object

      Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						self.unregister(masterStub, self.getRegistry());
					} catch (RemoteException ex) {
            System.err.println("Error connecting with the server.");
					}
          finally{
            System.out.println("Slave " + self.getRegistry() + " was ended with \"Ctrl+C\".");
          }
				}
			});
		} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
		}
  }
}
