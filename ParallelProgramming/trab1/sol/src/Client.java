import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {

	public static List<Byte> randomList(){
		Random generator = new Random();
		int size = generator.nextInt(10);
		byte[] bytes = new byte[size];
		generator.nextBytes(bytes);
		List<Byte> list = new ArrayList<>();
		for (byte b : bytes) {
			list.add(new Byte(b));
		}
		return list;
	}

	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
		    Registry registry = LocateRegistry.getRegistry(host);

				List<Byte> list = randomList();
				Checksum masterStub = (Checksum) registry.lookup("Master");
				masterStub.unregister(masterStub,0);

				/*long startTime = System.currentTimeMillis();
				byte sum = masterStub.checksum(list);
				long elapsedTime  = System.currentTimeMillis() - startTime;

        System.out.println("List: "+ list);
        System.out.println("Answer: "+ sum );
        System.out.println("Done in " + elapsedTime + " ms");*/

		} catch (Exception e) {
		    System.err.println("Client exception: " + e.toString());
		    e.printStackTrace();
		}
  }
}
