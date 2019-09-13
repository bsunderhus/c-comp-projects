import java.util.List;

interface Checksum extends java.rmi.Remote {
  int registry = 0;
  int getRegistry()throws java.rmi.RemoteException;
  int register (Checksum adder)throws java.rmi.RemoteException;
  void unregister (Checksum adder, int id)throws java.rmi.RemoteException;
  byte checksum (List<Byte> bytes)throws java.rmi.RemoteException;
  byte getOverhead (List<Byte> bytes)throws java.rmi.RemoteException;
}
