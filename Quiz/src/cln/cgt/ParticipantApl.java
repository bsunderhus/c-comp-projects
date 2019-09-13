/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cln.cgt;

import cln.cdp.*;
import cgd.*;
import static cgd.ParticipantDAO.registerParticipant;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author thiago
 */
public class ParticipantApl {

    //Método que busca username em arraylist de participantes
    public static Participant lookForParticipant(String userName) {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        for (Participant p : participants) {
            if (p.getUserName().equals(userName)) {
                return p;
            }
        }
        return null;
    }

    //Métodos de mudar userName 
    static public boolean updateUserName(Participant currentUser, String userName) {
        //Começa verificando se username novo já existe. Se não entra if.
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        Participant temp = lookForParticipant(userName);
        if (temp == null) {
            //Loop abaixo acha index para remoção do velho
            int i = 0;
            for (Participant p : participants) {
                if (p.getUserName().equals(currentUser.getUserName())) {
                    break;
                }
                i++;
            }
            participants.remove(i);
            //Muda dado e então salva
            currentUser.setUserName(userName);
            participants.add(currentUser);
            ParticipantDAO.saveParticipants(participants);
            return true;
        } //Se já tem na lista ou password está errado, pula pra cá
        else {
            return false;
        }
    }

    public static boolean updateRealName(Participant currentUser, String realName) {
        //Começa verificando se username novo já existe. Se não entra if.
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        Participant temp = lookForParticipant(realName);
        if (temp == null) {
            //Loop abaixo acha index para remoção do velho
            int i = 0;
            for (Participant p : participants) {
                if (p.getRealName().equals(currentUser.getRealName())) {
                    break;
                }
                i++;
            }
            participants.remove(i);
            //Muda dado e então salva
            currentUser.setRealName(realName);
            participants.add(currentUser);
            ParticipantDAO.saveParticipants(participants);
            return true;
        } //Se já tem na lista ou password está errado, pula pra cá
        else {
            return false;
        }
    }

    static public boolean updateEmail(Participant currentUser, String email) {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        //Loop abaixo acha index para remoção do velho
        int i = 0;
        for (Participant p : participants) {
            if (p.getUserName().equals(currentUser.getUserName())) {
                break;
            }
            i++;
        }
        participants.remove(i);
        //Muda dado e então salva
        currentUser.setEmail(email);
        participants.add(currentUser);
        return ParticipantDAO.saveParticipants(participants);
    }

    static public boolean updatePassword(Participant currentUser, String passwordNew) {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        //Loop abaixo acha index para remoção do velho
        int i = 0;
        for (Participant p : participants) {
            if (p.getUserName().equals(currentUser.getUserName())) {
                break;
            }
            i++;
        }
        participants.remove(i);
        //Muda dado e então salva
        currentUser.setPassword(passwordNew);
        participants.add(currentUser);
        return ParticipantDAO.saveParticipants(participants);

    }

    //Método para entrar na conta
    static public Participant login(String userName, String password) {
        Participant participant = lookForParticipant(userName);
        //Menssagem aqui que esse usuário não existe
        if (participant == null) {
            return null;
        }
        if (password.equals(participant.getPassword())) {
            return participant;
        } //Menssagem aqui que senha errada
        else {
            return null;
        }
    }

   //Método que deleta um usuário
    static public boolean excludeUser(String userName) {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        Participant temp = lookForParticipant(userName);
        if (temp != null) {
            //Loop abaixo acha index para remoção do usuário
            int i = 0;
            for (Participant p : participants) {
                if (p.getUserName().equals(userName)) {
                    break;
                }
                i++;
            }
            
            //Se não jogou, deleta, se jogou remove informações mas mantem no sistema
            if(temp.getRecord().isEmpty())
            participants.remove(i);
            else{
                //Deleta informações, inclundo password, impossibilitando entrada
                temp.setEmail(null);
                temp.setRealName(null);
                temp.setPassword(null);
                //Ao fazer virar admin, tira ele da lista
                temp.setAdmin();
                participants.remove(i);
                participants.add(temp);
            }
            ParticipantDAO.saveParticipants(participants);
            return true;
        } //Se usuário não existe
        else {
            return false;
        }
    }

    //Método para fazer um participante virar admin
    static public boolean turnAdminOn(Participant currentUser, String userName) {
        //Verifica se é o primeiro admin. Se sim adciona imediatamente
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        if (participants.isEmpty()) {
            currentUser.setAdmin();
            participants.add(currentUser);
            return ParticipantDAO.saveParticipants(participants);
        }

        //Verifica senha e estatus de admin.
        if (currentUser.isAdmin()) {
            //Loop abaixo acha index para remoção do velho
            int i = 0;
            Participant newAdmin = null;
            for (Participant p : participants) {
                if (p.getUserName().equals(userName)) {
                    newAdmin = p;
                    break;
                }
                i++;
            }
            //Se i é maior ou igual ao tamanho, esse usuário não existe. 
            if (i >= participants.size()) {
                return false;
            }
            participants.remove(i);
            //Muda dado e então salva
            newAdmin.setAdmin();
            participants.add(newAdmin);
            ParticipantDAO.saveParticipants(participants);
            return true;
        } //Se não é admin
        else {
            return false;
        }
    }

    //Check inicial feito toda vez que se abre o programa. Cria o todo poderoso rei admin admin
    public static boolean initialCheck() {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        if (participants.isEmpty()) {
            Participant admin = new Participant("admin", "changethisemail", "admin", "admin");
            return turnAdminOn(admin, "admin");
        } else {
            return false;
        }
    }

    public static boolean register(Participant newParticipant) {
        if (ParticipantApl.lookForParticipant(newParticipant.getUserName()) == null) {
            return registerParticipant(newParticipant);
        }
        return false;
    }

    //Obtem ranking dos participantes
    public final static ArrayList<Participant> getRanking() {
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        Collections.sort(participants);
        return participants;
    }

    //Retorna array com todos os usernames menos os de admin (a não ser que seja ele mesmo)
//Se só tem 1 admin, ele não pode se excluir
    public static String[] allUserNames(Participant currentUser) {
        //Contabiliza admins e os remove do array
        ArrayList<Participant> participants = ParticipantDAO.loadParticipants();
        Participant p;
        String[] userNames;
        int numberOfAdmins = 0;
        ArrayList<Participant> admins = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            p = participants.get(i);
            if (p.isAdmin()) {
                admins.add(p);
                numberOfAdmins++;
            }
        }
        //Remove os admins
        for (Participant o : admins) {
            participants.remove(o);
        }
        //Se mais de um admin, permite ao admin atual se excluir
        if (numberOfAdmins > 1) {
            participants.add(currentUser);
        }

        userNames = new String[participants.size()];
        for (int i = 0; i < participants.size(); i++) {
            userNames[i] = participants.get(i).getUserName();
        }

        return userNames;
    }
    
    //Verifica se string está em um vetor de strings
    public final static boolean containsName(String[] userNames, String userName){
        for(int i=0;i<userNames.length;i++){
            if(userName.equals(userNames[i])) return true;
    }
        return false;
    }
}
