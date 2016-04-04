package Modelo;

import java.sql.*;

public class GenericoBD {
        private static Connection con;

    public static Connection getCon() {
        return con;
    }
        
    public static boolean abrirConexion(){
        
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
            String user = "daw10";
            String pass = "daw10";
            String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
            
            con = DriverManager.getConnection (url, user, pass);
            
            return true;
            
        }
        catch(Exception e){
            return false;
        }
    }
    
    public static boolean cerrarConexion(){
        try{
            con.close();            
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }

}