
package personnelOperations;

import login.PersonnelLogin;

public class PersonnelPage extends javax.swing.JFrame {

    public PersonnelPage() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPermits = new javax.swing.JButton();
        btnDiningRoom = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();
        btnOpinions = new javax.swing.JButton();
        btnInbox = new javax.swing.JButton();
        btnRequirement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPermits.setText("İzin İşlemleri");
        btnPermits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermitsActionPerformed(evt);
            }
        });

        btnDiningRoom.setText("Yemekhane Listesi");
        btnDiningRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiningRoomActionPerformed(evt);
            }
        });

        btnComeBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        btnOpinions.setText("Yemekhane Şikayet/Talep");
        btnOpinions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpinionsActionPerformed(evt);
            }
        });

        btnInbox.setText("Gelen Kutusu");
        btnInbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInboxActionPerformed(evt);
            }
        });

        btnRequirement.setText("Gereksinim Talebi");
        btnRequirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequirementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 507, Short.MAX_VALUE)
                .addComponent(btnComeBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(470, 470, 470))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPermits, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInbox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpinions, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiningRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnInbox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPermits, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDiningRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpinions, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnComeBack)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPermitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermitsActionPerformed
        this.setVisible(false);
        new PersonnelPermits().setVisible(true);
    }//GEN-LAST:event_btnPermitsActionPerformed

    private void btnDiningRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiningRoomActionPerformed
      
        this.setVisible(false);
        new RefectoryManager().setVisible(true);
    }//GEN-LAST:event_btnDiningRoomActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new PersonnelLogin().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnOpinionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpinionsActionPerformed
        this.setVisible(false);
        new RefectoryOpinions().setVisible(true);
    }//GEN-LAST:event_btnOpinionsActionPerformed

    private void btnInboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInboxActionPerformed
        this.setVisible(false);
        new GetInbox().setVisible(true);
    }//GEN-LAST:event_btnInboxActionPerformed

    private void btnRequirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequirementActionPerformed
        this.setVisible(false);
        new AddRequirement().setVisible(true);
    }//GEN-LAST:event_btnRequirementActionPerformed

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
            java.util.logging.Logger.getLogger(PersonnelPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnelPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnelPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnelPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonnelPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnDiningRoom;
    private javax.swing.JButton btnInbox;
    private javax.swing.JButton btnOpinions;
    private javax.swing.JButton btnPermits;
    private javax.swing.JButton btnRequirement;
    // End of variables declaration//GEN-END:variables
}
