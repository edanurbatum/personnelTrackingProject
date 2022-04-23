
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionPermits {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Permit>permits=getPermits(sql);
            for (Permit permit:permits) {
                Object[]row={
                    permit.getPermitRecordNo(),permit.getTc(),permit.getName(),permit.getLastname(),
                    permit.getRemainingPermitAmount(),permit.getPermitStart(),permit.getPermitFinish(),
                    permit.getPermitType(),permit.getUsedPermitAmount()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Permit>getPermits(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Permit>permits=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            permits=new ArrayList<Permit>();
            
            while(resultSet.next()){
                permits.add(new Permit(
                        resultSet.getInt("permitRecordNo"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"), 
                        resultSet.getString("lastname"),
                        resultSet.getInt("remainingPermitAmount"),
                        resultSet.getString("permitStart"),
                        resultSet.getString("permitFinish"),
                        resultSet.getString("permitType"),
                        resultSet.getInt("usedPermitAmount")
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return permits;
    }
}
