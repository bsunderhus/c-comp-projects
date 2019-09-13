package cgd;

//And thy father said:
//"Son, be prepared. Up ahead, a shitload of methods awaits you."
import cln.cdp.Question;
import static cln.cdp.Category.CULTURE;
import static cln.cdp.Category.SPORT;
import static cln.cdp.Category.GEOGRAPHY;
import static cln.cdp.Category.HISTORY;
import static cln.cdp.Category.SCIENCE;
import static cln.cdp.Difficulty.EASY;
import static cln.cdp.Difficulty.MEDIUM;
import static cln.cdp.Difficulty.HARD;

import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.*;
import java.io.File;

public class QuestionDAO {

    //Constructor

    public QuestionDAO() {
    }

    public static boolean registerQuestion(Question question) {
        if (question.getCategory() == CULTURE) {
            if (question.getDifficulty() == EASY) {
                ArrayList<Question> toInsert = loadQuestionCultureEasy();
                toInsert.add(question);
                return saveQuestionCultureEasy(toInsert);
            } else if (question.getDifficulty() == MEDIUM) {
                ArrayList<Question> toInsert = loadQuestionCultureMedium();
                toInsert.add(question);
                return saveQuestionCultureMedium(toInsert);
            } else if (question.getDifficulty() == HARD) {
                ArrayList<Question> toInsert = loadQuestionCultureHard();
                toInsert.add(question);
                return saveQuestionCultureHard(toInsert);
            }
        } else if (question.getCategory() == SPORT) {
            if (question.getDifficulty() == EASY) {
                ArrayList<Question> toInsert = loadQuestionSportEasy();
                toInsert.add(question);
                return saveQuestionSportEasy(toInsert);
            } else if (question.getDifficulty() == MEDIUM) {
                ArrayList<Question> toInsert = loadQuestionSportMedium();
                toInsert.add(question);
                return saveQuestionSportMedium(toInsert);
            } else if (question.getDifficulty() == HARD) {
                ArrayList<Question> toInsert = loadQuestionSportHard();
                toInsert.add(question);
                return saveQuestionSportHard(toInsert);
            }
        } else if (question.getCategory() == GEOGRAPHY) {
            if (question.getDifficulty() == EASY) {
                ArrayList<Question> toInsert = loadQuestionGeographyEasy();
                toInsert.add(question);
                return saveQuestionGeographyEasy(toInsert);
            } else if (question.getDifficulty() == MEDIUM) {
                ArrayList<Question> toInsert = loadQuestionGeographyMedium();
                toInsert.add(question);
                return saveQuestionGeographyMedium(toInsert);
            } else if (question.getDifficulty() == HARD) {
                ArrayList<Question> toInsert = loadQuestionGeographyHard();
                toInsert.add(question);
                return saveQuestionGeographyHard(toInsert);
            }
        } else if (question.getCategory() == HISTORY) {
            if (question.getDifficulty() == EASY) {
                ArrayList<Question> toInsert = loadQuestionHistoryEasy();
                toInsert.add(question);
                return saveQuestionHistoryEasy(toInsert);
            } else if (question.getDifficulty() == MEDIUM) {
                ArrayList<Question> toInsert = loadQuestionHistoryMedium();
                toInsert.add(question);
                return saveQuestionHistoryMedium(toInsert);
            } else if (question.getDifficulty() == HARD) {
                ArrayList<Question> toInsert = loadQuestionHistoryHard();
                toInsert.add(question);
                return saveQuestionHistoryHard(toInsert);
            }
        } else if (question.getCategory() == SCIENCE) {
            if (question.getDifficulty() == EASY) {
                ArrayList<Question> toInsert = loadQuestionScienceEasy();
                toInsert.add(question);
                return saveQuestionScienceEasy(toInsert);
            } else if (question.getDifficulty() == MEDIUM) {
                ArrayList<Question> toInsert = loadQuestionScienceMedium();
                toInsert.add(question);
                return saveQuestionScienceMedium(toInsert);
            } else if (question.getDifficulty() == HARD) {
                ArrayList<Question> toInsert = loadQuestionScienceHard();
                toInsert.add(question);
                return saveQuestionScienceHard(toInsert);
            }
        }

        return false;
    }

    //Save & load methods related to CULTURE
    public static boolean saveQuestionCultureEasy(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureEasy.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionCultureEasy() {
        ArrayList<Question> cultureEasy;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureEasy.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            cultureEasy = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return cultureEasy;
    }

    public static boolean saveQuestionCultureMedium(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureMedium.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionCultureMedium() {
        ArrayList<Question> cultureMedium;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureMedium.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            cultureMedium = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return cultureMedium;
    }

    public static boolean saveQuestionCultureHard(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureHard.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionCultureHard() {
        ArrayList<Question> cultureHard;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "culture";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "cultureHard.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            cultureHard = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return cultureHard;
    }

    //Save & load methods related to SPORT
    public static boolean saveQuestionSportEasy(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportEasy.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionSportEasy() {
        ArrayList<Question> sportEasy;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportEasy.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            sportEasy = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return sportEasy;
    }

    public static boolean saveQuestionSportMedium(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportMedium.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionSportMedium() {
        ArrayList<Question> sportMedium;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportMedium.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            sportMedium = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return sportMedium;
    }

    public static boolean saveQuestionSportHard(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportHard.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionSportHard() {
        ArrayList<Question> sportHard;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "sport";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "sportHard.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            sportHard = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return sportHard;
    }

    //Save & load methods related to GEOGRAPHY
    public static boolean saveQuestionGeographyEasy(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyEasy.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionGeographyEasy() {
        ArrayList<Question> geographyEasy;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyEasy.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            geographyEasy = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return geographyEasy;
    }

    public static boolean saveQuestionGeographyMedium(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyMedium.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionGeographyMedium() {
        ArrayList<Question> geographyMedium;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyMedium.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            geographyMedium = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return geographyMedium;
    }

    public static boolean saveQuestionGeographyHard(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyHard.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionGeographyHard() {
        ArrayList<Question> geographyHard;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "geography";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "geographyHard.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            geographyHard = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return geographyHard;
    }

    //Save & load methods related to HISTORY
    public static boolean saveQuestionHistoryEasy(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyEasy.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionHistoryEasy() {
        ArrayList<Question> historyEasy;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyEasy.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            historyEasy = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return historyEasy;
    }

    public static boolean saveQuestionHistoryMedium(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyMedium.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionHistoryMedium() {
        ArrayList<Question> historyMedium;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyMedium.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            historyMedium = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return historyMedium;
    }

    public static boolean saveQuestionHistoryHard(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyHard.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionHistoryHard() {
        ArrayList<Question> historyHard;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "history";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "historyHard.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            historyHard = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return historyHard;
    }

    //Save & load methods related to SCIENCE
    public static boolean saveQuestionScienceEasy(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceEasy.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionScienceEasy() {
        ArrayList<Question> scienceEasy;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceEasy.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            scienceEasy = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return scienceEasy;
    }

    public static boolean saveQuestionScienceMedium(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceMedium.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionScienceMedium() {
        ArrayList<Question> scienceMedium;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceMedium.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            scienceMedium = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return scienceMedium;
    }

    public static boolean saveQuestionScienceHard(ArrayList<Question> questions) {
        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //the indicated directory is created
            File fileName = new File(pathName);
            fileName.mkdirs();

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceHard.dat";

            FileOutputStream saveFile = new FileOutputStream(pathName);
            ObjectOutputStream temp = new ObjectOutputStream(saveFile);

            //save the indicated list into our database
            temp.writeObject(questions);

            temp.close();
            saveFile.close();
        } catch (IOException e) {
            //Error! A failure has been detected! Do NOT try to load the .dat created!
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Question> loadQuestionScienceHard() {
        ArrayList<Question> scienceHard;

        try {
            //get the current path
            Path currentRelativePath = Paths.get("");
            String pathName = currentRelativePath.toAbsolutePath().toString() + File.separator + "database" + File.separator + "science";

            //within the previously created directory, the file will be created
            pathName = pathName + File.separator + "scienceHard.dat";

            FileInputStream loadFile = new FileInputStream(pathName);
            ObjectInputStream temp = new ObjectInputStream(loadFile);

            scienceHard = (ArrayList<Question>) temp.readObject();

            temp.close();
            loadFile.close();
        } catch (IOException e) {
            ArrayList<Question> questions = new ArrayList<>();//Error! .dat file not found!
            return questions;
        } catch (ClassNotFoundException e) {
            //Error! .dat file does not contain the indicated class!
            return null;
        }

        return scienceHard;
    }
}
