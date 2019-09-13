/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cln.cdp;

import java.io.Serializable;
import java.util.ArrayList;
import cln.cgt.ParticipantApl;

import cgd.ParticipantDAO;

public class Participant implements Serializable, Comparable<Participant> {

    private static final long serialVersionUID = 32764824682L;
    private String userName;
    private String email;
    private String realName;
    private String password;
    private boolean admin;
    private int score;
    private ArrayList<Participation> record;

    //Construtor de participante
    public Participant(String userName, String email, String realName, String password) {
        this.userName = userName;
        this.email = email;
        this.realName = realName;
        this.password = password;
        this.admin = false;
        this.record = new ArrayList<>();
        this.score = 0;
    }

    public int compareTo(Participant p) {
        return  p.getScore() - this.getScore();

    }

    //Métodos get
    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Participation> getRecord() {
        return this.record;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public int getScore() {
        return this.score;
    }

    public String getRealName() {
        return realName;
    }

    //Métodos get
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addToRecord(Participation participation) {
        this.record.add(participation);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin() {
        this.admin = true;
    }

    public void changeScore(int change) {
        this.score += change;
    }

    //Método para que participante delete a própria conta
    public ArrayList<Participant> excludeSelf(String password) {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        if (password.equals(this.password)) {
            participants.remove(ParticipantApl.lookForParticipant(this.userName));
        }
        return participants;
    }

}
