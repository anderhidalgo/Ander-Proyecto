package Modelo;

import java.sql.*;
import oracle.jdbc.OracleTypes;

public class CentroBD {
    
    public static ResultSet buscarCentro(){
        try
        {
            GenericoBD.abrirConexion();
            
            CallableStatement cst = GenericoBD.getCon().prepareCall("{call FASE3.VER_CENTROS(?)}");
            
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet) cst.getObject(1);
            return rs;
        }
        catch(Exception e)
        {
            return null;
        }        
    }
    
    public static boolean borrar(Centro c){
        
    try
        {
            GenericoBD.abrirConexion();   
            
            String plantilla="delete from centro where id_centro = ? ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, c.getId_centro());
             
            ps.executeUpdate();
            
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            GenericoBD.cerrarConexion();
        } 
    }
    
    public static boolean añadir(Centro c){
        try
        {
            GenericoBD.abrirConexion();   

            String plantilla="insert into centro values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, c.getId_centro());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getCalle());
            ps.setString(4, c.getNumero());
            ps.setString(5, c.getCp());
            ps.setString(6, c.getProvincia());
            ps.setString(7, c.getCiudad());
            ps.setString(8, c.getNumero());

            ps.executeUpdate();

            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
    }
    
    public static boolean modificar(Centro c){
        try
        {
            GenericoBD.abrirConexion();   

            String plantilla="update centro set id_centro = ?, nombre = ?, calle = ?, numero = ?, cp = ?, provincia = ?, ciudad = ?, numero = ? where id_centro= ? ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, c.getId_centro());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getCalle());
            ps.setString(4, c.getNumero());
            ps.setString(5, c.getCp());
            ps.setString(6, c.getProvincia());
            ps.setString(7, c.getCiudad());
            ps.setString(8, c.getNumero());
            ps.setString(9, c.getId_centro());

            ps.executeUpdate();
            
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
}
