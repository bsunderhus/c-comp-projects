package cgd;

//And thy mother said:
//"Daughter, be prepared. Up ahead, a bunch of kinky functions awaits you."
import cln.cdp.Participant;

import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.*;
import java.io.File;

public class ParticipantDAO {

    //Constructor

    public ParticipantDAO() {
    }

    //Save & load methods related to PARTICIPANT
    public static boolean saveParticipants(ArrayList<Participant> participants) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "participants";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "participants.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(participants);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Participant> loadParticipants() {
        ArrayList<Participant> participants;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "participants";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "participants.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            participants = (ArrayList<Participant>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            //Error! .dat file not found.
            ArrayList<Participant> participantsNew = new ArrayList<>();//Vai retornar um arraylist vazio
            return participantsNew;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return participants;
    }

    public static boolean registerParticipant(Participant participant) {
            ArrayList<Participant> toInsert = loadParticipants();
            toInsert.add(participant);
            return saveParticipants(toInsert);
    }
}
