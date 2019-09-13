/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cih.AddQuestionDialog;
import cih.MainFrame;
import cih.ManageAccDialog;
import cih.QuestionLogFrame;
import cih.RankingFrame;
import cih.SuccessFailDialog;
import cln.cdp.Category;
import cln.cdp.Difficulty;
import cln.cdp.Participant;
import cln.cdp.Question;
import cln.cgt.ParticipantApl;
import static cln.cgt.ParticipantApl.allUserNames;
import static cln.cgt.ParticipantApl.containsName;
import static cln.cgt.ParticipantApl.getRanking;
import static cln.cgt.ParticipantApl.turnAdminOn;
import cln.cgt.QuestionApl;
import static java.lang.System.exit;
import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class MainControl {

    private final EntryControl entryControl;
    private final GameControl gameControl;
    
    private MainFrame mainFrame;
    private RankingFrame rankingFrame;
    private AddQuestionDialog addQuestionDialog;
    private ManageAccDialog manageAccDialog;
    private QuestionLogFrame questionLogFrame;
    
    protected Participant participant;

    public MainControl() {
        ParticipantApl.initialCheck();
        entryControl = new EntryControl(this);
        gameControl = new GameControl(this);
    }

    public boolean mainFrameOpen(String userName, String password) {
        participant = ParticipantApl.login(userName, password);
        if (participant != null) {
            mainFrame = new MainFrame(this);
            mainFrame.setLocationRelativeTo(this.entryControl.loginFrame);
            mainFrame.setUserNameLabel(participant.getUserName());
            if (participant.isAdmin()) {
                mainFrame.setQuestionsLogButton();
            }
            mainFrame.setVisible(true);
            this.entryControl.loginFrame.dispose();
            return true;
        }
        return false;
    }

    public void mainFrameClose() {
        mainFrame.dispose();
    }

    public void rankingFrameOpen() {
        rankingFrame = new RankingFrame(this);
        rankingFrame.setLocationRelativeTo(this.mainFrame);

        ArrayList<Participant> participants = getRanking();

        for (Participant participant : participants) {
            rankingFrame.addRowToRankingTable(participant.getUserName(), participant.getScore());
        }

        rankingFrame.setVisible(true);
    }
    
    public void questionLogOpen(){
        questionLogFrame = new QuestionLogFrame(this);
        questionLogFrame.setLocationRelativeTo(this.mainFrame);
        
        ArrayList<Question> cultureQuestions = QuestionApl.getAllCategoryQuestions(Category.CULTURE);
        ArrayList<Question> geographyQuestions = QuestionApl.getAllCategoryQuestions(Category.GEOGRAPHY);
        ArrayList<Question> historyQuestions = QuestionApl.getAllCategoryQuestions(Category.HISTORY);
        ArrayList<Question> scienceQuestions = QuestionApl.getAllCategoryQuestions(Category.SCIENCE);
        ArrayList<Question> sportQuestions = QuestionApl.getAllCategoryQuestions(Category.SPORT);
        
        for (Question question : cultureQuestions){
            questionLogFrame.addRowToQuestionLogTable(question);
        }
        for (Question question : geographyQuestions)
            questionLogFrame.addRowToQuestionLogTable(question);
        for (Question question : historyQuestions)
            questionLogFrame.addRowToQuestionLogTable(question);
        for (Question question : scienceQuestions)
            questionLogFrame.addRowToQuestionLogTable(question);
        for (Question question : sportQuestions)
            questionLogFrame.addRowToQuestionLogTable(question);
        
        questionLogFrame.setVisible(true);
    }

    public void playDialogOpen(Object level, Object category, Object numberOfQuestions) {
        gameControl.playDialogOpen(level, category, numberOfQuestions);
    }

    public void addQuestionDialogOpen() {
        addQuestionDialog = new AddQuestionDialog(this.questionLogFrame, true, this);
        addQuestionDialog.setLocationRelativeTo(addQuestionDialog.getRootPane());
        addQuestionDialog.setVisible(true);
    }
    
    public void removeQuestion(String question, Category category, Difficulty difficulty){
        QuestionApl.removeQuestion(question,category,difficulty);
    }

    public void addQuestion(Object category, Object difficulty, String question, ArrayList<String> answers) {
        Question newQuestion = new Question(Category.valueOf(category.toString().toUpperCase()),
                Difficulty.valueOf(difficulty.toString().toUpperCase()), question, answers);
        QuestionApl.registerQuestion(newQuestion);
        
        questionLogFrame.addRowToQuestionLogTable(newQuestion);
    }

    public void manageAccDialogOpen() {
        manageAccDialog = new ManageAccDialog(this.getMainFrame(), true, this, participant, allUserNames(participant));
        manageAccDialog.setLocationRelativeTo(manageAccDialog.getRootPane());
        manageAccDialog.setVisible(true);
        mainFrame.setUserNameLabel(participant.getUserName());
    }

    public void successFailDialogOpen(boolean state, String string) {
        SuccessFailDialog successFailDialog = new SuccessFailDialog(this.getMainFrame(), true, state, string);
        successFailDialog.setLocationRelativeTo(successFailDialog.getRootPane());
        successFailDialog.setVisible(true);
    }

    protected MainFrame getMainFrame() {
        return mainFrame;
    }

    public String changeUsername(String newUsername, String pswd) {
        if (!participant.getPassword().equals(pswd)) {
            successFailDialogOpen(false, "Wrong password!");
            return null;
        }
        ParticipantApl.updateUserName(participant, newUsername);
        successFailDialogOpen(true, " ");

        return newUsername;
    }

    public String changeRealName(String newRealName, String pswd) {
        if (!participant.getPassword().equals(pswd)) {
            successFailDialogOpen(false, "Wrong password!");
            return null;
        }

        ParticipantApl.updateRealName(participant, newRealName);
        successFailDialogOpen(true, " ");

        return newRealName;
    }

    public String changeEMail(String newEMail, String pswd) {
        if (!participant.getPassword().equals(pswd)) {
            successFailDialogOpen(false, "Wrong password!");
            return null;
        }
        ParticipantApl.updateEmail(participant, newEMail);
        successFailDialogOpen(true, " ");

        return newEMail;

    }

    public String changePswd(String newPswd, String pswd) {
        if (!participant.getPassword().equals(pswd)) {
            successFailDialogOpen(false, "Wrong password!");
            return null;
        }
        ParticipantApl.updatePassword(participant, newPswd);
        successFailDialogOpen(true, " ");

        return newPswd;

    }

    public void turnInAdmin(String username, String pswd) {
        if (participant.getPassword().equals(pswd)) {
            if (turnAdminOn(participant, username)) {
                successFailDialogOpen(true, " ");
                manageAccDialog.refreshComboBox(allUserNames(participant));
            } else {
                successFailDialogOpen(false, "User not found.");
            }
        } else {
            successFailDialogOpen(false, "Wrong password!");
        }
    }

    public void excludeUserParticipant(String pswd) {
        if (participant.getPassword().equals(pswd)) {
            ParticipantApl.excludeUser(participant.getUserName());
            successFailDialogOpen(true, "You just deleted yourself.");
            exit(0);
        }
    }

    public void excludeUserAdmin(String username, String pswd) {
        if (participant.getPassword().equals(pswd)) {
            if (!containsName(allUserNames(participant), username)) {
                successFailDialogOpen(false, "User not found.");
                return;
            }
            /*if (ParticipantApl.lookForParticipant(username) != null && ParticipantApl.lookForParticipant(username).getUserName().equals(participant.getUserName())) {
                ParticipantApl.excludeUser(username);
                successFailDialogOpen(true, "You just deleted yourself.");
                exit(0);
            }*/
            if (ParticipantApl.excludeUser(username)) {
                successFailDialogOpen(true, " ");
                manageAccDialog.refreshComboBox(allUserNames(participant));
            } else {
                successFailDialogOpen(false, "User not found.");
            }
        } else {
            successFailDialogOpen(false, "Wrong password!");
        }
    }

}
