/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cln.cgt;

import static cln.cdp.Category.CULTURE;
import static cln.cdp.Category.SPORT;
import static cln.cdp.Category.GEOGRAPHY;
import static cln.cdp.Category.HISTORY;
import static cln.cdp.Difficulty.EASY;
import static cln.cdp.Difficulty.MEDIUM;

import java.util.ArrayList;
import cln.cdp.Question;
import cgd.QuestionDAO;
import cln.cdp.Category;
import cln.cdp.Difficulty;

public class QuestionApl {

    //Recebe categoria e retorna todas as questões daquela categoria
    public static ArrayList<Question> getAllCategoryQuestions(Category category) {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Question> qEasy;
        ArrayList<Question> qMedium;
        ArrayList<Question> qHard;

        if (category == CULTURE) {
            qEasy = QuestionDAO.loadQuestionCultureEasy();
            qMedium = QuestionDAO.loadQuestionCultureMedium();
            qHard = QuestionDAO.loadQuestionCultureHard();
        } else if (category == SPORT) {
            qEasy = QuestionDAO.loadQuestionSportEasy();
            qMedium = QuestionDAO.loadQuestionSportMedium();
            qHard = QuestionDAO.loadQuestionSportHard();
        } else if (category == GEOGRAPHY) {
            qEasy = QuestionDAO.loadQuestionGeographyEasy();
            qMedium = QuestionDAO.loadQuestionGeographyMedium();
            qHard = QuestionDAO.loadQuestionGeographyHard();
        } else if (category == HISTORY) {
            qEasy = QuestionDAO.loadQuestionHistoryEasy();
            qMedium = QuestionDAO.loadQuestionHistoryMedium();
            qHard = QuestionDAO.loadQuestionHistoryHard();
        } else {
            qEasy = QuestionDAO.loadQuestionScienceEasy();
            qMedium = QuestionDAO.loadQuestionScienceMedium();
            qHard = QuestionDAO.loadQuestionScienceHard();
        }
        questions.addAll(qEasy);
        questions.addAll(qMedium);
        questions.addAll(qHard);

        return questions;
    }

    public static void removeQuestion(String question, Category category, Difficulty difficulty) {
        ArrayList<Question> questions;
        //Determina arraylist a se carregar
        if (category == CULTURE) {
            if (difficulty == EASY) {
                questions = QuestionDAO.loadQuestionCultureEasy();
            } else if (difficulty == MEDIUM) {
                questions = QuestionDAO.loadQuestionCultureMedium();
            } else {
                questions = QuestionDAO.loadQuestionCultureHard();
            }
        } else if (category == SPORT) {
            if (difficulty == EASY) {
                questions = QuestionDAO.loadQuestionSportEasy();
            } else if (difficulty == MEDIUM) {
                questions = QuestionDAO.loadQuestionSportMedium();
            } else {
                questions = QuestionDAO.loadQuestionSportHard();
            }
        } else if (category == GEOGRAPHY) {
            if (difficulty == EASY) {
                questions = QuestionDAO.loadQuestionGeographyEasy();
            } else if (difficulty == MEDIUM) {
                questions = QuestionDAO.loadQuestionGeographyMedium();
            } else {
                questions = QuestionDAO.loadQuestionGeographyHard();
            }
        } else if (category == HISTORY) {
            if (difficulty == EASY) {
                questions = QuestionDAO.loadQuestionHistoryEasy();
            } else if (difficulty == MEDIUM) {
                questions = QuestionDAO.loadQuestionHistoryMedium();
            } else {
                questions = QuestionDAO.loadQuestionHistoryMedium();
            }
        } else {
            if (difficulty == EASY) {
                questions = QuestionDAO.loadQuestionScienceEasy();
            } else if (difficulty == MEDIUM) {
                questions = QuestionDAO.loadQuestionScienceMedium();
            } else {
                questions = QuestionDAO.loadQuestionScienceHard();
            }
        }

        //Acha index
        int i = 0;
        for (Question q : questions) {
            if (q.getQuestion().equals(question)) {
                break;
            }
            i++;
        }

        questions.remove(i);

        //If else para usar função save
        if (category == CULTURE) {
            if (difficulty == EASY) {
                QuestionDAO.saveQuestionCultureEasy(questions);
            } else if (difficulty == MEDIUM) {
                QuestionDAO.saveQuestionCultureMedium(questions);
            } else {
                QuestionDAO.saveQuestionCultureHard(questions);
            }
        } else if (category == SPORT) {
            if (difficulty == EASY) {
                QuestionDAO.saveQuestionSportEasy(questions);
            } else if (difficulty == MEDIUM) {
                QuestionDAO.saveQuestionSportMedium(questions);
            } else {
                QuestionDAO.saveQuestionSportHard(questions);
            }
        } else if (category == GEOGRAPHY) {
            if (difficulty == EASY) {
                QuestionDAO.saveQuestionGeographyEasy(questions);
            } else if (difficulty == MEDIUM) {
                QuestionDAO.saveQuestionGeographyMedium(questions);
            } else {
                QuestionDAO.saveQuestionGeographyHard(questions);
            }
        } else if (category == HISTORY) {
            if (difficulty == EASY) {
                QuestionDAO.saveQuestionHistoryEasy(questions);
            } else if (difficulty == MEDIUM) {
                QuestionDAO.saveQuestionHistoryMedium(questions);
            } else {
                QuestionDAO.saveQuestionHistoryHard(questions);
            }
        } else {
            if (difficulty == EASY) {
                QuestionDAO.saveQuestionScienceEasy(questions);
            } else if (difficulty == MEDIUM) {
                QuestionDAO.saveQuestionScienceMedium(questions);
            } else {
                QuestionDAO.saveQuestionScienceHard(questions);
            }
        }
        //Fim de salvar 
    }
    
    public static void registerQuestion(Question newQuestion) {
        QuestionDAO.registerQuestion(newQuestion);
    }
}
