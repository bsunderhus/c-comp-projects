/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cln.cdp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.io.Serializable;

/**
 *
 * @author Bernardo
 */
public class Participation implements Serializable {

    private final ArrayList<Question> questions;
    private ArrayList<Boolean> answers;
    private boolean concluded;
    private Calendar date;

    //Construtor de Participação. Recebe lista de questões do tipo e dificuldade determinada
    public Participation(ArrayList<Question> questions, int amount) {
        //Inicializa as questões selecionadas aleatoriamente
        this.questions = new ArrayList<>();

        //Para garantir que não haverá repetição de questões
        ArrayList<Integer> random = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            random.add(i);
        }
        Collections.shuffle(random);
        for (int i = 0; i < amount; i++) {
            this.questions.add(questions.get(random.get(i)));
        }

        //Inicializa data e se está concluido.
        this.date = Calendar.getInstance();
        this.concluded = false;
        //Inicializa lista de respostas
        this.answers = new ArrayList<>();
    }

    //Métodos get
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public ArrayList<Boolean> getAnswers() {
        return this.answers;
    }

    public boolean isConcluded() {
        return this.concluded;
    }

    //Métodos set
    public void setAnswers(ArrayList<Boolean> answers) {
        this.answers = answers;
    }

    public void setConcluded() {
        this.concluded = true;
    }
}
