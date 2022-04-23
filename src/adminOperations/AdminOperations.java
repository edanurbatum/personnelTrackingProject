package adminOperations;


import adminOperations.PersonnelCrud;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.AdminLogin;
import personnelOperations.RefectoryOpinions;

public final class AdminOperations extends javax.swing.JFrame {
  
    public AdminOperations() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPersonnelDetail = new javax.swing.JButton();
        btnPersonnelUpdate = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();
        btnPermit = new javax.swing.JButton();
        btnRefectory = new javax.swing.JButton();
        btnRefectoryOpinions = new javax.swing.JButton();
        btnNotification = new javax.swing.JButton();
        btnRequirements = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPersonnelDetail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPersonnelDetail.setText("Personel Detay Sayfası");
        btnPersonnelDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonnelDetailActionPerformed(evt);
            }
        });

        btnPersonnelUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPersonnelUpdate.setText("Personel İşlemleri");
        btnPersonnelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonnelUpdateActionPerformed(evt);
            }
        });

        btnComeBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        btnPermit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPermit.setText("İzin İşlemleri");
        btnPermit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermitActionPerformed(evt);
            }
        });

        btnRefectory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefectory.setText("Yemekhane İşlemleri");
        btnRefectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefectoryActionPerformed(evt);
            }
        });

        btnRefectoryOpinions.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefectoryOpinions.setText("Yemekhane Görüşleri");
        btnRefectoryOpinions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefectoryOpinionsActionPerformed(evt);
            }
        });

        btnNotification.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNotification.setText("Duyuru Yap");
        btnNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificationActionPerformed(evt);
            }
        });

        btnRequirements.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRequirements.setText("Gereksinim Talepleri");
        btnRequirements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequirementsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPersonnelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPersonnelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPermit, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(btnRefectory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefectoryOpinions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRequirements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnPersonnelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPersonnelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPermit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefectory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefectoryOpinions, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRequirements, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonnelDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonnelDetailActionPerformed
       new PersonnelDetail().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnPersonnelDetailActionPerformed

    private void btnPersonnelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonnelUpdateActionPerformed
        new PersonnelCrud().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPersonnelUpdateActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnPermitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermitActionPerformed
        this.setVisible(false);
        new PermitOperations().setVisible(true);
    }//GEN-LAST:event_btnPermitActionPerformed

    private void btnRefectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefectoryActionPerformed
        this.setVisible(false);
        new RefectoryCrud().setVisible(true);
    }//GEN-LAST:event_btnRefectoryActionPerformed

    private void btnRefectoryOpinionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefectoryOpinionsActionPerformed
        this.setVisible(false);
        new ViewRefectoryOpinions().setVisible(true);
    }//GEN-LAST:event_btnRefectoryOpinionsActionPerformed

    private void btnNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificationActionPerformed
        this.setVisible(false);
        new AdminNotification().setVisible(true);
    }//GEN-LAST:event_btnNotificationActionPerformed

    private void btnRequirementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequirementsActionPerformed
        this.setVisible(false);
        new ViewRequirements().setVisible(true);
    }//GEN-LAST:event_btnRequirementsActionPerformed

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
            java.util.logging.Logger.getLogger(AdminOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminOperations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnNotification;
    private javax.swing.JButton btnPermit;
    private javax.swing.JButton btnPersonnelDetail;
    private javax.swing.JButton btnPersonnelUpdate;
    private javax.swing.JButton btnRefectory;
    private javax.swing.JButton btnRefectoryOpinions;
    private javax.swing.JButton btnRequirements;
    // End of variables declaration//GEN-END:variables
}
