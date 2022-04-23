
package personnelOperations;

import connection.ConnectionEmployee;
import connection.ConnectionNotification;
import connection.ConnectionPersonnelInbox;
import connection.DbHelper;
import connection.Employee;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GetInbox extends javax.swing.JFrame {

    ConnectionNotification connectionNotification=new ConnectionNotification();
    String querySelect="SELECT * FROM notification where result='Okunmadı'";
    
    ConnectionEmployee connectionEmployee=new ConnectionEmployee();
    
    ConnectionPersonnelInbox connectionPersonnelInbox=new ConnectionPersonnelInbox();
    
    public GetInbox() {
        initComponents();  
        connectionNotification.populateTable(querySelect, tblNotifications);
    }

    public void read(String tc){
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        ArrayList<Employee>employees;
        
        try{
            connection=dbHelper.getConnection();
            String sql="INSERT INTO personnelInbox(notification,name,lastname,tc,result) VALUES (?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            
            String query="select * from employee where tc='"+tc+"'";
            
           
            employees =connectionEmployee.getEmployees(query);
            for (Employee employee:employees) {    
                
                statement.setString(1, tblNotifications.getValueAt(tblNotifications.getSelectedRow(), 1).toString());
                statement.setString(2, employee.getName());
                statement.setString(3, employee.getLastname());
                statement.setString(4,tc);
                statement.setString(5,"Okundu");
            }
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Duyuru okundu işaretlendi.");
            changeResult();
            tbxTC.setText("");
            txtNotification.setText("");
            
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
    
    public void changeResult(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            int id=Integer.valueOf(tblNotifications.getValueAt(tblNotifications.getSelectedRow(), 0).toString());
            String queryUpdate="UPDATE notification SET result='Okundu' where notificationId='"+id+"'";         
            statement=connection.prepareStatement(queryUpdate);
            
            statement.executeUpdate();
            
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotifications = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotification = new javax.swing.JTextArea();
        btnRead = new javax.swing.JButton();
        tbxTC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnComeBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInbox = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtShowNotification = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        tbxShowTc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Duyuru Id", "Duyuru"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNotifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotificationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNotifications);
        if (tblNotifications.getColumnModel().getColumnCount() > 0) {
            tblNotifications.getColumnModel().getColumn(0).setResizable(false);
        }

        txtNotification.setColumns(20);
        txtNotification.setRows(5);
        jScrollPane2.setViewportView(txtNotification);

        btnRead.setText("Okundu İşaretle");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        jLabel1.setText("TC");

        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btnRead))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(tbxTC, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRead)
                .addGap(18, 18, 18)
                .addComponent(btnComeBack)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Okunmamış Duyurular", jPanel1);

        tblInbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Bildiri", "İsim", "Soyisim", "Tc", "Sonuç"
            }
        ));
        tblInbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInboxMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblInbox);
        if (tblInbox.getColumnModel().getColumnCount() > 0) {
            tblInbox.getColumnModel().getColumn(0).setResizable(false);
            tblInbox.getColumnModel().getColumn(1).setResizable(false);
            tblInbox.getColumnModel().getColumn(2).setResizable(false);
            tblInbox.getColumnModel().getColumn(3).setResizable(false);
        }

        txtShowNotification.setColumns(20);
        txtShowNotification.setRows(5);
        jScrollPane4.setViewportView(txtShowNotification);

        jLabel2.setText("Tc");

        tbxShowTc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbxShowTcKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel2)
                        .addGap(87, 87, 87)
                        .addComponent(tbxShowTc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbxShowTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geçmiş Duyurular", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNotificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotificationsMouseClicked
        txtNotification.setText(tblNotifications.getValueAt(tblNotifications.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblNotificationsMouseClicked

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        read(tbxTC.getText());
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new PersonnelPage().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void tblInboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInboxMouseClicked
        txtShowNotification.setText(tblInbox.getValueAt(tblInbox.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblInboxMouseClicked

    private void tbxShowTcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbxShowTcKeyReleased
        
        String queryInbox="SELECT * FROM personnelInbox where result='Okundu' and tc='"+tbxShowTc.getText()+"'";
        connectionPersonnelInbox.populateTable(queryInbox, tblInbox);
    }//GEN-LAST:event_tbxShowTcKeyReleased

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
            java.util.logging.Logger.getLogger(GetInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetInbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetInbox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnRead;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblInbox;
    private javax.swing.JTable tblNotifications;
    private javax.swing.JTextField tbxShowTc;
    private javax.swing.JTextField tbxTC;
    private javax.swing.JTextArea txtNotification;
    private javax.swing.JTextArea txtShowNotification;
    // End of variables declaration//GEN-END:variables
}
