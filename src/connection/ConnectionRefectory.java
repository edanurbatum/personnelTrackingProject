
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ConnectionRefectory {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Refectory>refectoryList=getRefectory(sql);
            for (Refectory refectory:refectoryList) {
                Object[]row={
                    refectory.getDate(),refectory.getDay(),refectory.getFood1(),refectory.getFood2(),
                    refectory.getFood3(),refectory.getFood4(),refectory.getFood5()
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
}
