
import java.util.Random;
import br.inf.ufes.pp2016_01.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class IdGenerator {

    private static int id = 0;

    private static String[] names = {"Arwen", "Elvellon", "Baranon", "Eruvadhor", "Panthael", "Nirthol", "Eruetelehto", "Caliel", "Gloriel", "Thargon",
        "Arwen", "Fili", "Kili", "Balin", "Dwalin", "Oin", "Gloin", "Dori", "Nori", "Ori", "Ori", "Bifuir", "Bofur", "Bombur", "Bilbo Baggins", "Gandalf" , "Radagast"
    };

    public static int getNewId() {
        id++;
        return id;
    }

    public static String getNewName() {
        Random r = new Random();
        int i = r.nextInt(names.length-1);
        return names[i];
    }
}
