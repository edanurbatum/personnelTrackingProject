
package personnelOperations;

import connection.DbHelper;
import connection.Refectory;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RefectoryManager extends javax.swing.JFrame {

    DefaultTableModel model;
    DefaultListModel modelList;
            
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement =null;
    DbHelper dbHelper=new DbHelper();
        
    public RefectoryManager() {
        initComponents();
        String query="SELECT * FROM refectory;";
        populateTable(query,tblDays);
    }
    
    
    public void populateJList(String query) throws SQLException{
        
        modelList = new DefaultListModel();
        
        connection=dbHelper.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query); 
       
        while (resultSet.next()) 
        {
            String ItemList1 = resultSet.getString("food1"); 
            String ItemList2 = resultSet.getString("food2");
            String ItemList3 = resultSet.getString("food3");
            String ItemList4 = resultSet.getString("food4");
            String ItemList5 = resultSet.getString("food5");
            modelList.addElement(ItemList1); 
            modelList.addElement(ItemList2);
            modelList.addElement(ItemList3);
            modelList.addElement(ItemList4);
            modelList.addElement(ItemList5);
        }
         listFood.setModel(modelList);
    }
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Refectory>refectoryList=getRefectory(sql);
            for (Refectory refectory:refectoryList) {
                Object[]row={
                    refectory.getDate(),refectory.getDay()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Refectory>getRefectory(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Refectory>refectoryList=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            refectoryList=new ArrayList<Refectory>();
            
            while(resultSet.next()){
                refectoryList.add(new Refectory(
                        resultSet.getString("date"),
                        resultSet.getString("day"),
                        resultSet.getString("food1"),
                        resultSet.getString("food2"),
                        resultSet.getString("food3"),
                        resultSet.getString("food4"),
                        resultSet.getString("food5")
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return refectoryList;
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDays = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFood = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnComeBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarih", "Gün"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaysMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDays);
        if (tblDays.getColumnModel().getColumnCount() > 0) {
            tblDays.getColumnModel().getColumn(0).setResizable(false);
            tblDays.getColumnModel().getColumn(1).setResizable(false);
        }

        listFood.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listFood);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Menüyü Görmek İçin Güne Tıklayınız");

        btnComeBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComeBack)
                        .addGap(11, 11, 11)))
                .addGap(31, 424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(btnComeBack)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDaysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaysMouseClicked
     
        String date=(String.valueOf(tblDays.getValueAt(tblDays.getSelectedRow(), 0).toString()));
        String sql="select * from refectory where date='"+date+"'";
        try {
            populateJList(sql);
        } catch (SQLException ex) {
            Logger.getLogger(RefectoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDaysMouseClicked

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new PersonnelPage().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    
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
            java.util.logging.Logger.getLogger(RefectoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RefectoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RefectoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RefectoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RefectoryManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listFood;
    private javax.swing.JTable tblDays;
    // End of variables declaration//GEN-END:variables
}
