
package personnelOperations;

import connection.Permit;
import connection.ConnectionPermits;
import connection.ConnectionEmployee;
import connection.DbHelper;
import connection.Employee;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class PersonnelPermits extends javax.swing.JFrame  {
    
    DefaultTableModel model;
    String queryEmployees="select * from employee";
    ConnectionEmployee connectionEmployee=new ConnectionEmployee();
    
    String queryPermits="select * from permits";
    ConnectionPermits connectionPermits=new ConnectionPermits();
    
    DefaultTableModel modelPermitRequest;
    
    public PersonnelPermits() {
        initComponents();   
        populateTable(queryEmployees,tblEmployees);     
    }

    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Employee>employees=getEmployees(sql);
            for (Employee employee:employees) {
                Object[]row={
                    employee.getId(),employee.getName(),employee.getLastname(), employee.getTc()}; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Employee>getEmployees(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Employee>employees=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            employees=new ArrayList<Employee>();
            
            while(resultSet.next()){
                employees.add(new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"), 
                        resultSet.getString("gender"),
                        resultSet.getString("tc"),
                        resultSet.getString("address"),
                        resultSet.getString("userName"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getInt("salary")
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return employees;
    }
   
    public void addPermitRequest(){
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String sql="INSERT INTO permitRequests(tc, name,lastname,remainingPermitAmount,permitStart,permitFinish,permitType,usedPermitAmount,response) VALUES (?,?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            
            statement.setString(1, tbxTc.getText());
            statement.setString(2, tbxName.getText());
            statement.setString(3, tbxLastname.getText());
            statement.setInt(4, Integer.valueOf(tbxRemainingPermit.getText()));
            statement.setString(5, tbxPermitStart.getText());
            statement.setString(6, tbxPermitFinish.getText());
            statement.setString(7, tbxPermitType.getText());
            statement.setInt(8, Integer.valueOf(tbxUsedPermit.getText()));
            statement.setString(9, "Beklemede");
            statement.executeUpdate();
            clean();
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close(); 
               
            }catch(SQLException exception){
           
           dbHelper.showErrorMessage(exception);
            }           
        }
    }
     
    public void getData(String tc) throws SQLException{
        String sql="select * from permits WHERE tc='"+tc+"'";
             
        try {
            ArrayList<Permit>permits=connectionPermits.getPermits(sql);
            for (Permit permit:permits) {
                tbxName.setText(permit.getName());
                tbxLastname.setText(permit.getLastname());
                tbxRemainingPermit.setText(String.valueOf(permit.getRemainingPermitAmount()));
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }
    }
    
    public void clean(){
        tbxTc.setText("");    
        tbxName.setText("");
        tbxLastname.setText("");
        tbxRemainingPermit.setText("");
        tbxPermitStart.setText("");
        tbxPermitFinish.setText("");
        tbxPermitType.setText("");
        tbxUsedPermit.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbxTc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbxName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbxLastname = new javax.swing.JTextField();
        tbxRemainingPermit = new javax.swing.JTextField();
        tbxPermitStart = new javax.swing.JTextField();
        tbxPermitFinish = new javax.swing.JTextField();
        tbxPermitType = new javax.swing.JTextField();
        tbxUsedPermit = new javax.swing.JTextField();
        btnPermitRequest = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tc");

        jLabel2.setText("İsim");

        jLabel3.setText("Soyisim");

        jLabel4.setText("Kalan İzin Miktarı");

        jLabel5.setText("İzin Başlangıç");

        jLabel6.setText("İzin Bitiş");

        jLabel7.setText("İzin Türü");

        jLabel8.setText("Kullanılan İzin Miktarı");

        btnPermitRequest.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPermitRequest.setText("İzin Talebi Oluştur");
        btnPermitRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermitRequestActionPerformed(evt);
            }
        });

        btnComeBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        btnSearch.setText("Ara");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel10.setText("Kalan izin mikarını güncelleyiniz");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnComeBack))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbxUsedPermit)
                            .addComponent(tbxPermitType)
                            .addComponent(tbxPermitFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(tbxPermitStart)
                            .addComponent(tbxRemainingPermit)
                            .addComponent(tbxTc)
                            .addComponent(tbxName)
                            .addComponent(tbxLastname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch)
                            .addComponent(jLabel10))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnPermitRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbxTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbxLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbxRemainingPermit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tbxPermitStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbxPermitFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbxPermitType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tbxUsedPermit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnPermitRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnComeBack)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(588, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Yeni İzin Talebi Oluştur", jPanel2);

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "İsim", "Soyisim", "Tc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(0).setResizable(false);
            tblEmployees.getColumnModel().getColumn(1).setResizable(false);
            tblEmployees.getColumnModel().getColumn(2).setResizable(false);
            tblEmployees.getColumnModel().getColumn(3).setResizable(false);
        }

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kayıt No", "TC", "İsim", "Soyisim", "Kalan İzin", "İzin Başlangıç", "İzin Bitiş", "İzin Türü", "Kullanılan İzin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetail);
        if (tblDetail.getColumnModel().getColumnCount() > 0) {
            tblDetail.getColumnModel().getColumn(0).setResizable(false);
            tblDetail.getColumnModel().getColumn(1).setResizable(false);
            tblDetail.getColumnModel().getColumn(2).setResizable(false);
            tblDetail.getColumnModel().getColumn(3).setResizable(false);
            tblDetail.getColumnModel().getColumn(4).setResizable(false);
            tblDetail.getColumnModel().getColumn(5).setResizable(false);
            tblDetail.getColumnModel().getColumn(6).setResizable(false);
            tblDetail.getColumnModel().getColumn(7).setResizable(false);
            tblDetail.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );

        jTabbedPane1.addTab("İzinleri Görüntüle", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked

        String tc=(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 3).toString());
        String sql="select * from permits where tc='"+tc+"'";
        connectionPermits.populateTable(sql, tblDetail);
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnPermitRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermitRequestActionPerformed
        addPermitRequest();
    }//GEN-LAST:event_btnPermitRequestActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new PersonnelPage().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String tc=tbxTc.getText();
        try {
            getData(tc);
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelPermits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    
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
            java.util.logging.Logger.getLogger(PersonnelPermits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnelPermits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnelPermits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnelPermits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonnelPermits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnPermitRequest;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField tbxLastname;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPermitFinish;
    private javax.swing.JTextField tbxPermitStart;
    private javax.swing.JTextField tbxPermitType;
    private javax.swing.JTextField tbxRemainingPermit;
    private javax.swing.JTextField tbxTc;
    private javax.swing.JTextField tbxUsedPermit;
    // End of variables declaration//GEN-END:variables
}
