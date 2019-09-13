/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Imports para usar os tipos enumerados
package cln.cgt;

import cgd.ParticipantDAO;
import static cln.cdp.Category.CULTURE;
import static cln.cdp.Category.SPORT;
import static cln.cdp.Category.GEOGRAPHY;
import static cln.cdp.Category.HISTORY;
import static cln.cdp.Difficulty.EASY;
import static cln.cdp.Difficulty.MEDIUM;

import cln.cdp.*;
import java.util.ArrayList;
import cgd.QuestionDAO;

/**
 *
 * @author thiago
 */
public class GameApl {
    
    //Método para ele começar um jogo (altera o record dele)
    //Método para ele começar um jogo (altera o record dele)
    static public Participation play(Participant participant,Category category, Difficulty difficulty, int numberOfQuestions){
        ArrayList<Question> questions;
        if(category == CULTURE){
            if(difficulty == EASY){
                questions = QuestionDAO.loadQuestionCultureEasy();
            }
            else if(difficulty == MEDIUM){
                questions = QuestionDAO.loadQuestionCultureMedium();
            }
            else{
                questions = QuestionDAO.loadQuestionCultureHard();
            }
        }
        else if(category == SPORT){
             if(difficulty == EASY){
                questions = QuestionDAO.loadQuestionSportEasy();
            }
            else if(difficulty == MEDIUM){
                questions = QuestionDAO.loadQuestionSportMedium();
            }
            else{
                questions = QuestionDAO.loadQuestionSportHard();
            }
        }
        else if(category == GEOGRAPHY){
             if(difficulty == EASY){
                questions = QuestionDAO.loadQuestionGeographyEasy();
            }
            else if(difficulty == MEDIUM){
                questions = QuestionDAO.loadQuestionGeographyMedium();
            }
            else{
                questions = QuestionDAO.loadQuestionGeographyHard();
            }
        }
        else if(category == HISTORY){
             if(difficulty == EASY){
                questions = QuestionDAO.loadQuestionHistoryEasy();
            }
            else if(difficulty == MEDIUM){
                questions = QuestionDAO.loadQuestionHistoryMedium();
            }
            else{
                questions = QuestionDAO.loadQuestionHistoryHard();
            }
        }
        else{
             if(difficulty == EASY){
                questions = QuestionDAO.loadQuestionScienceEasy();
            }
            else if(difficulty == MEDIUM){
                questions = QuestionDAO.loadQuestionScienceMedium();
            }
            else{
                questions = QuestionDAO.loadQuestionScienceHard();
            }
        }
        //retorna nulo se não há questões o bastante 
        if(questions.size() < numberOfQuestions) return null;
    	Participation newParticipation = new Participation(questions, numberOfQuestions);
        participant.addToRecord(newParticipation);
        return newParticipation;
    }
    
    //Avança Pergunta
    public static final Question nextQuestion(Participation participation){
        
        int currentQuestion = participation.getAnswers().size();
        if(currentQuestion == participation.getQuestions().size()){
            return null;
        }
        return participation.getQuestions().get(currentQuestion);
    }
    
    //Guarda se ele acertou ou errou e retorna score
    public static final int getAnswer(Participation participation,boolean answer){
        ArrayList<Boolean> temp = participation.getAnswers();
        temp.add(answer);
        if(answer == true){
            //Salva resposta da participação
            participation.setAnswers(temp);
            
            Difficulty dif = participation.getQuestions().get(0).getDifficulty();
            if(dif == EASY){
                return 1;
            }
            else if(dif == MEDIUM){
                return 3;
            }
            else return 7;
        }
        else return -3;
    }
    
    public final static void endGame(Participant participant, int score){
        //Pega arraylist e atualiza score
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        participant.changeScore(score);
        
        //Loop abaixo acha index para remoção do velho
        int i = 0;
        for(Participant p : participants){
        if (p.getUserName().equals(participant.getUserName())) break;
        i++;
        }
        participants.remove(i);
        //Salva participantes
        participants.add(participant);
        ParticipantDAO.saveParticipants(participants);
        }
    
}
