/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import java.awt.Cursor;
import cci.EntryControl;

/**
 *
 * @author Bernardo
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form ContactEditorUI
     */
    
    public LoginFrame() {
        this.EntryControl = null;
        initComponents();
        getRootPane().setDefaultButton(okButton);
    }
    
    public LoginFrame(EntryControl EntryControl) {
        this.EntryControl = EntryControl;
        initComponents();
        getRootPane().setDefaultButton(okButton);
        passwordTextField.setTransferHandler(null);
    }
    
    private void warningEvent(boolean event){
        warningLabel.setVisible(true);
        if(!event)
            warningLabel.setText("Username or Password Incorrect.");
        this.pack();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//Begin
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();
        warningLabel = new javax.swing.JLabel();
        warningLabel.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz Game");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("FrameLog"); // NOI18N
        setResizable(false);

        userNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        userNameLabel.setText("Username:");

        userNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameTextFieldKeyReleased(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setText("Password:");

        okButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        okButton.setForeground(new java.awt.Color(102, 102, 102));
        okButton.setText("Ok");
        okButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        img.setIcon(new javax.swing.ImageIcon("./database/img/ShowDoMilhaoLoginImg")); // NOI18N

        signInButton.setBackground(new java.awt.Color(255, 255, 255));
        signInButton.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        signInButton.setForeground(new java.awt.Color(0, 102, 255));
        signInButton.setText("<html><u>" + "Don't have an account?" + "</u></html>");
        signInButton.setToolTipText("");
        signInButton.setAlignmentY(0.0F);
        signInButton.setBorder(null);
        signInButton.setBorderPainted(false);
        signInButton.setContentAreaFilled(false);
        signInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signInButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        signInButton.setName(""); // NOI18N
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyReleased(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Lucida Grande", 3, 10)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel.setText("Warning, Warning!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(img))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(userNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signInButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warningLabel)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signInButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//End

    private void userNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFieldKeyReleased
        if(!userNameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty()){
                okButton.setEnabled(true);
        }
        else{
            okButton.setEnabled(false);
        }
    }
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        warningLabel.setVisible(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        boolean entry = this.EntryControl.mainFrameOpen(userNameTextField.getText(),passwordTextField.getText());
        setCursor(Cursor.getDefaultCursor());
        if(!entry){
            warningEvent(entry);
        }
    }

    private void passwordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyReleased
        if(!userNameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty())
                okButton.setEnabled(true);
            else
                okButton.setEnabled(false);
    }

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        if(this.EntryControl != null)
            EntryControl.signInDialogOpen();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private final cci.EntryControl EntryControl;
    private javax.swing.JLabel img;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration
}