
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionEmployee {
    
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table){
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Employee>employees=getEmployees(sql);
            for (Employee employee:employees) {
                Object[]row={
                    employee.getId(),employee.getName(),employee.getLastname(),employee.getGender(),
                    employee.getTc(),employee.getAddress(),employee.getUserName(),
                    employee.getPhoneNumber(),employee.getSalary()}; 
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
}
