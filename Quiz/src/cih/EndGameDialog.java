/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cih;

import cci.GameControl;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Bernardo
 */
public class EndGameDialog extends javax.swing.JDialog {
    
    GameControl gameControl;

    /**
     * Creates new form endGameDialog
     * @param parent
     * @param modal
     */
    public EndGameDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        escapeKeyStroke();
    }
    
    public EndGameDialog(java.awt.Frame parent, boolean modal, GameControl gameControl) {
        super(parent, modal);
        initComponents();
        
        this.gameControl = gameControl;
        this.getRootPane().setDefaultButton(backButton);
        
        escapeKeyStroke();
    }
    
    public void setScores(Integer roundScore, Integer beforeTotalScore, Integer afterTotalScore){
        roundScoreLabel.setText(roundScore.toString());
        beforeTotalScoreLabel.setText(beforeTotalScore.toString());
        afterTotalScoreLabel.setText(afterTotalScore.toString());
        if(beforeTotalScore.compareTo(afterTotalScore) > 0)
            elevatingReducingLabel.setText("Reducing your total score from");
        else if(beforeTotalScore.compareTo(afterTotalScore) < 0)
            elevatingReducingLabel.setText("Elevating your total score from");
        else
            elevatingReducingLabel.setText("Keeping your total score from");
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameOverLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        elevatingReducingLabel = new javax.swing.JLabel();
        roundScoreLabel = new javax.swing.JLabel();
        beforeTotalScoreLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        afterTotalScoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gameOverLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        gameOverLabel.setText("Game Over! You scored");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        elevatingReducingLabel.setText("Elevating/Reducing your total score from");

        roundScoreLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N

        toLabel.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gameOverLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundScoreLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(elevatingReducingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(beforeTotalScoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(afterTotalScoreLabel)))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameOverLabel)
                    .addComponent(roundScoreLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elevatingReducingLabel)
                    .addComponent(beforeTotalScoreLabel)
                    .addComponent(toLabel)
                    .addComponent(afterTotalScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.gameControl.endGamedialogClose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EndGameDialog dialog = new EndGameDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void escapeKeyStroke(){
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        }; 
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel afterTotalScoreLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel beforeTotalScoreLabel;
    private javax.swing.JLabel elevatingReducingLabel;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.JLabel roundScoreLabel;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}
