/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci;

import cih.LoginFrame;
import cih.SignUpDialog;
import cih.SuccessSignUpDialog;
import cln.cdp.Participant;
import cln.cgt.ParticipantApl;


/**
 *
 * @author Bernardo
 */
public class EntryControl {
    
    protected final LoginFrame loginFrame;
    private SignUpDialog signInDialog;
    private final MainControl mainControl;

    public EntryControl(MainControl MainControl) {
        this.mainControl = MainControl;
        loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }
    
    /*Controler that opens the signInDialog screen relative to jframe and a jbutton*/
    public void signInDialogOpen(){
        signInDialog = new SignUpDialog(loginFrame,true,this); 
        signInDialog.setLocationRelativeTo(signInDialog.getRootPane());
        signInDialog.setVisible(true);
    }
    
    public void successSignUpDialogOpen(){
        SuccessSignUpDialog successSignUpDialog = new SuccessSignUpDialog(this.mainControl.getMainFrame(),true);
        successSignUpDialog.setLocationRelativeTo(signInDialog.getRootPane());
        successSignUpDialog.setVisible(true);
    }
    
    public boolean participantSignUp(String username,String eMail, String realName, String pswd){
        return ParticipantApl.register(new Participant(username, eMail, realName, pswd));
    }
    
    public boolean mainFrameOpen(String userNameTextField, String passwordTextField){
        return mainControl.mainFrameOpen(userNameTextField, passwordTextField);
    }
    
}