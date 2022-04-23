
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ConnectionPermitRequests {
    
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<PermitRequest>permitRequests=getPermitRequests(sql);
            for (PermitRequest permitRequest:permitRequests) {
                Object[]row={
                    permitRequest.getTc(),permitRequest.getName(),permitRequest.getLastname(),
                    permitRequest.getRemainingPermitAmount(),permitRequest.getPermitStart(),permitRequest.getPermitFinish(),
                    permitRequest.getPermitType(),permitRequest.getUsedPermitAmount(),permitRequest.getResponse()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<PermitRequest>getPermitRequests(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<PermitRequest>permitRequests=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            permitRequests=new ArrayList<PermitRequest>();
            
            while(resultSet.next()){
                permitRequests.add(new PermitRequest(
                        resultSet.getString("tc"),
                        resultSet.getString("name"), 
                        resultSet.getString("lastname"),
                        resultSet.getInt("remainingPermitAmount"),
                        resultSet.getString("permitStart"),
                        resultSet.getString("permitFinish"),
                        resultSet.getString("permitType"),
                        resultSet.getInt("usedPermitAmount"),
                        resultSet.getString("response")
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return permitRequests;
    }
}
