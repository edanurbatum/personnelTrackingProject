package connection;


import java.sql.*;


public class DbHelper {
    String userName="root";
    String password="MySqlWorkBench1234";
    String url="jdbc:mysql://localhost:3306/personnelTracking";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, userName,password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error kodu: "+exception.getErrorCode());
    }
}
