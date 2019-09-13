/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cln.cdp;

import cgd.QuestionDAO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class Question implements Serializable {

    private final Category category;
    private final Difficulty difficulty;
    private final String question;
    private final ArrayList<String> answers; //First is always the right answer

    //Construtor de questão
    public Question(Category category, Difficulty difficulty, String question, ArrayList<String> answers) {
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.answers = answers;

    }

    public Category getCategory() {
        return category;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    public static void register(Question newQuestion) {
        QuestionDAO.registerQuestion(newQuestion);
    }

}
