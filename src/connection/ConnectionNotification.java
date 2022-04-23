
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ConnectionNotification {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Notification>notificationList=getNotification(sql);
            for (Notification notification:notificationList) {
                Object[]row={
                    notification.getNotificationId(),notification.getNotification(),notification.getResult()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Notification>getNotification(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Notification>notificationList=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            notificationList=new ArrayList<Notification>();
            
            while(resultSet.next()){
                notificationList.add(new Notification(
                        resultSet.getString("notificationId"),
                        resultSet.getString("notification"),
                        resultSet.getString("result")
                ));
            }           
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return notificationList;
    }
}
