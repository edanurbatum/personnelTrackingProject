
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionPersonnelInbox {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<PersonnelInbox>inboxList=getPersonnelInbox(sql);
            for (PersonnelInbox personnelInbox:inboxList) {
                Object[]row={
                    personnelInbox.getNotificationId(),personnelInbox.getNotification(),personnelInbox.getName(),
                    personnelInbox.getLastName(),personnelInbox.getTc(),personnelInbox.getResult()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<PersonnelInbox>getPersonnelInbox(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<PersonnelInbox>inboxList=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            inboxList=new ArrayList<PersonnelInbox>();
            
            while(resultSet.next()){
                inboxList.add(new PersonnelInbox(
                        resultSet.getString("notificationId"),
                        resultSet.getString("notification"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("tc"),
                        resultSet.getString("result")
                ));
            }           
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return inboxList;
    }
}
