
package adminOperations;

import connection.ConnectionRequirement;
import connection.DbHelper;
import java.sql.*;
import javax.swing.JOptionPane;


public class ViewRequirements extends javax.swing.JFrame {

    ConnectionRequirement connectionRequirement=new ConnectionRequirement();
    String query="SELECT * FROM requirement where result='Bekleniyor'";
    
    public ViewRequirements() {
        initComponents();
        connectionRequirement.populateTable(query, tblRequirements);
    }

    public void changeResult(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            int id=Integer.valueOf(tblRequirements.getValueAt(tblRequirements.getSelectedRow(), 0).toString());
            String queryUpdate="UPDATE requirement SET result='Sipariş verildi' where requirementId='"+id+"'";         
            statement=connection.prepareStatement(queryUpdate);
            
            statement.executeUpdate();
            connectionRequirement.populateTable(query, tblRequirements);
            JOptionPane.showConfirmDialog(rootPane, "Talep onaylandı, sipariş verildi");
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close(); 
               
       }catch(SQLException exception){
            }           
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequirements = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRequirements = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblRequirements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Gereksinim", "İsim", "Soyisim", "Tc", "Sonuç"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRequirements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRequirementsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRequirements);
        if (tblRequirements.getColumnModel().getColumnCount() > 0) {
            tblRequirements.getColumnModel().getColumn(0).setResizable(false);
            tblRequirements.getColumnModel().getColumn(1).setResizable(false);
            tblRequirements.getColumnModel().getColumn(2).setResizable(false);
            tblRequirements.getColumnModel().getColumn(3).setResizable(false);
            tblRequirements.getColumnModel().getColumn(4).setResizable(false);
            tblRequirements.getColumnModel().getColumn(5).setResizable(false);
        }

        txtRequirements.setColumns(20);
        txtRequirements.setRows(5);
        jScrollPane2.setViewportView(txtRequirements);

        jLabel1.setText("Gereksinim");

        btnConfirm.setText("Onayla");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(btnConfirm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComeBack)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        changeResult();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void tblRequirementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRequirementsMouseClicked
        txtRequirements.setText(tblRequirements.getValueAt(tblRequirements.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblRequirementsMouseClicked

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new AdminOperations().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRequirements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequirements;
    private javax.swing.JTextArea txtRequirements;
    // End of variables declaration//GEN-END:variables
}
