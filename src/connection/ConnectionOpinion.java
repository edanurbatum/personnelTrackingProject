
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionOpinion {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Opinion>opinions=getOpinions(sql);
            for (Opinion opinion:opinions) {
                Object[]row={
                    opinion.getOpinionId(),opinion.getTc(),opinion.getName(),
                    opinion.getLastName(),opinion.getOpinion()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Opinion>getOpinions(String sql)throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Opinion>opinions=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            opinions=new ArrayList<Opinion>();
            
            while(resultSet.next()){
                opinions.add(new Opinion(
                        resultSet.getString("opinionId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("opinion")
                ));
            }           
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return opinions;
    } 
}
