package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion{
    
    public Connection Conectar(){
        Connection conec = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=SIALC;user=sa;password=123;";
            conec = DriverManager.getConnection(url);   
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conec;
    }
    public static void main(String[] args) {
        Connection cn = new Conexion().Conectar();
        System.out.println("connection");
    }
    
}
