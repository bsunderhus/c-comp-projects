/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cih.AnswerDialog;
import cih.EndGameDialog;
import cih.PlayDialog;
import cln.cdp.Category;
import cln.cdp.Difficulty;
import cln.cdp.Question;
import static cln.cgt.GameApl.endGame;
import static cln.cgt.GameApl.getAnswer;
import static cln.cgt.GameApl.nextQuestion;
import static cln.cgt.GameApl.play;
import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class GameControl {

    private final MainControl mainControl;
    private PlayDialog playDialog;
    private AnswerDialog answerDialog;
    private EndGameDialog endGameDialog;
    private Question question;
    private int score;

    public GameControl(MainControl mainControl) {
        this.mainControl = mainControl;
    }

    public void playDialogOpen(Object level, Object category, Object numberOfQuestions) {
        score = 0;
        if (play(mainControl.participant, Category.valueOf(category.toString().toUpperCase()),
                Difficulty.valueOf(level.toString().toUpperCase()),
                Integer.valueOf(numberOfQuestions.toString())) != null) {

            next();
            
            ArrayList<String> answers = new ArrayList<>();
            answers.addAll(question.getAnswers());

            playDialog = new PlayDialog(mainControl.getMainFrame(), true, this, question.getQuestion(), answers);
            playDialog.setLocationRelativeTo(playDialog.getRootPane());
            playDialog.setVisible(true);
        }
    }

    public void next() {
        question = nextQuestion(mainControl.participant.getRecord().get(mainControl.participant.getRecord().size() - 1));
    }

    private void refreshPlayDialog() {
        next();
        if (question != null) {
            ArrayList<String> answers = new ArrayList<>();
            answers.addAll(question.getAnswers());

            playDialog.answers = answers;

            playDialog.setQuestionTextArea(question.getQuestion());
            playDialog.setAnswersButtonText();
        } else {
            playDialog.dispose();
            endGameDialogOpen();
        }
    }

    public void answerDialogOpen(String answer) {
        if (answer.equals(question.getAnswers().get(0))) {
            answerDialog = new AnswerDialog(mainControl.getMainFrame(), true, this);
            answerDialog.setLocationRelativeTo(answerDialog.getRootPane());
            answerDialog.setVisible(true);
            score += getAnswer(mainControl.participant.getRecord().get(mainControl.participant.getRecord().size() - 1), true);
            refreshPlayDialog();
        } else {
            answerDialog = new AnswerDialog(mainControl.getMainFrame(), true, this, question.getAnswers().get(0));
            answerDialog.setLocationRelativeTo(answerDialog.getRootPane());
            answerDialog.setVisible(true);
            score += getAnswer(mainControl.participant.getRecord().get(mainControl.participant.getRecord().size() - 1), false);
            refreshPlayDialog();
        }

    }

    private void endGameDialogOpen() {
        endGameDialog = new EndGameDialog(mainControl.getMainFrame(), true, this);
        endGameDialog.setLocationRelativeTo(endGameDialog.getRootPane());
        endGameDialog.setScores(score, mainControl.participant.getScore(), mainControl.participant.getScore() + score);
        endGame(mainControl.participant, score);
        endGameDialog.setVisible(true);
    }

    public void endGamedialogClose() {
        endGameDialog.dispose();
    }
}
