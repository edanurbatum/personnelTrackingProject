
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionRequirement {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Requirement>requirementList=getRequirement(sql);
            for (Requirement requirement:requirementList) {
                Object[]row={
                    requirement.getRequirementId(),requirement.getRequirement(),requirement.getName(),
                    requirement.getLastName(),requirement.getTc(),requirement.getResult()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Requirement>getRequirement(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Requirement>requirementList=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            requirementList=new ArrayList<Requirement>();
            
            while(resultSet.next()){
                requirementList.add(new Requirement(
                        resultSet.getString("requirementId"),
                        resultSet.getString("requirement"),
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
        return requirementList;
    }
}
