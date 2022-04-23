package adminOperations;


import connection.ConnectionEmployee;
import connection.DbHelper;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PersonnelCrud extends javax.swing.JFrame {
    DefaultTableModel model;
    String selectEmployee="select * from employee";
    ConnectionEmployee connectionEmployee=new ConnectionEmployee();
    
    public PersonnelCrud() {
        initComponents();
        connectionEmployee.populateTable(selectEmployee, tblEmployees);
    }
    

    public void update(String query, JTextField textField){      
            
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        try{
            
            connection=dbHelper.getConnection();

            statement=connection.prepareStatement(query);
            statement.setString(1,textField.getText());
            statement.setInt(2, Integer.valueOf(tbxId.getText()));
            statement.executeUpdate();
            connectionEmployee.populateTable(selectEmployee, tblEmployees);
            
            }catch(SQLException exception){
                dbHelper.showErrorMessage(exception);
            }finally{
                try{
                   statement.close();
                   connection.close(); 
                   //tbxNewName.setText("");
                }catch(SQLException exception){
                }           
            }             
    }
    public void delete(String query) {                                          
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
                   
            statement=connection.prepareStatement(query);
            statement.setInt(1, Integer.valueOf(tbxId.getText()));
            statement.executeUpdate();
            connectionEmployee.populateTable(selectEmployee, tblEmployees);
            
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
    public void add(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String sql="INSERT INTO employee (name, lastname, gender, tc, address,userName, phoneNumber, salary) VALUES (?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1, tbxName.getText());
            statement.setString(2, tbxLastName.getText());
            statement.setString(3, tbxGender.getText());
            statement.setString(4, tbxTc.getText());
            statement.setString(5, tbxAddress.getText());
            statement.setString(6, tbxUserName.getText());
            statement.setString(7, tbxPhoneNumber.getText());
            statement.setInt(8, Integer.valueOf(tbxSalary.getText()));
            statement.executeUpdate();
            connectionEmployee.populateTable(selectEmployee, tblEmployees);
            
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

        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblTc = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        tbxId = new javax.swing.JTextField();
        tbxName = new javax.swing.JTextField();
        tbxLastName = new javax.swing.JTextField();
        tbxGender = new javax.swing.JTextField();
        tbxTc = new javax.swing.JTextField();
        tbxPhoneNumber = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        tbxSalary = new javax.swing.JTextField();
        tbxUserName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        tbxAddress = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Personel Güncelleme İşlemleri");

        lblId.setText("Id");

        lblName.setText("İsim");

        lblLastName.setText("Soyisim");

        lblGender.setText("Cinsiyet");

        lblTc.setText("Tc");

        lblUserName.setText("Kullanıcı Adı");

        lblPhoneNumber.setText("Telefon");

        lblSalary.setText("Maaş");

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setText("GÜNCELLE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelete.setText("SİL");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setText("EKLE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblAddress.setText("Adres");

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "İsim", "Soyisim", "Cinsiyet", "Tc", "Adres", "K. Adı", "Telefon", "Maaş"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(8).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("GERİ DÖN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnUpdate)
                        .addGap(44, 44, 44)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLastName)
                                        .addComponent(lblGender)
                                        .addComponent(lblUserName)
                                        .addComponent(lblPhoneNumber)
                                        .addComponent(lblSalary)
                                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tbxId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                            .addComponent(tbxName, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbxTc, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbxSalary, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbxUserName, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addComponent(tbxAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddress)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(294, 294, 294))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblId)
                                    .addComponent(tbxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLastName)
                                    .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGender)
                                    .addComponent(tbxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTc)
                                    .addComponent(tbxTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addComponent(lblAddress))
                            .addComponent(tbxAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(tbxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhoneNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalary)
                            .addComponent(tbxSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked

        tbxId.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 0).toString());
        tbxName.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 1).toString());
        tbxLastName.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 2).toString());
        tbxGender.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 3).toString());
        tbxTc.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 4).toString());
        tbxAddress.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 5).toString());
        tbxUserName.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 6).toString());
        tbxPhoneNumber.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 7).toString());
        tbxSalary.setText(tblEmployees.getValueAt(tblEmployees.getSelectedRow(), 8).toString());
              

    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
              
        if(!(tbxName.getText().equals(""))) {
            String sql="UPDATE employee SET name= ? WHERE employeeId=?";
            update(sql,tbxName);
        } 
        if(!(tbxLastName.getText().equals(""))) {
            String sql="UPDATE employee SET lastName= ? WHERE employeeId=?";
            update(sql,tbxLastName);
        }
        if(!(tbxGender.getText().equals(""))) {
            String sql="UPDATE employee SET gender= ? WHERE employeeId=?";
            update(sql,tbxGender);
        }
        if(!(tbxAddress.getText().equals(""))) {
            String sql="UPDATE employee SET address= ? WHERE employeeId=?";
            update(sql,tbxAddress);
        }
        if(!(tbxUserName.getText().equals(""))) {
            String sql="UPDATE employee SET userName= ? WHERE employeeId=?";
            update(sql,tbxUserName);
        }
        if(!(tbxPhoneNumber.getText().equals(""))) {
            String sql="UPDATE employee SET phoneNumber= ? WHERE employeeId=?";
            update(sql,tbxPhoneNumber);
        }
        if(!(tbxSalary.getText().equals(""))) {
            String sql="UPDATE employee SET salary= ? WHERE employeeId=?";
            update(sql,tbxSalary);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         String query="DELETE from employee WHERE employeeId= (?)"; //employee tablosundan silme 
         String query2="DELETE from login WHERE employeeId= (?)"; //login tablosundan silme 
         delete(query);
         delete(query2);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new AdminOperations().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(PersonnelCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnelCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnelCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnelCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonnelCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblTc;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField tbxAddress;
    private javax.swing.JTextField tbxGender;
    private javax.swing.JTextField tbxId;
    private javax.swing.JTextField tbxLastName;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPhoneNumber;
    private javax.swing.JTextField tbxSalary;
    private javax.swing.JTextField tbxTc;
    private javax.swing.JTextField tbxUserName;
    // End of variables declaration//GEN-END:variables
}
