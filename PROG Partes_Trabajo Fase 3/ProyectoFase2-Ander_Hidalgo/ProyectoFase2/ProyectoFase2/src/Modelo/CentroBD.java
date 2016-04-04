package Modelo;

import static Modelo.GenericoBD.abrirConexion;
import static Modelo.GenericoBD.cerrarConexion;
import static Modelo.GenericoBD.getCon;
import java.sql.*;
import java.util.ArrayList;

public class CentroBD {
    
    private static Centro c;
    
    
     public static ArrayList <Integer> buscarCentros() throws Exception
             
    {
        ArrayList <Integer> listaids = new ArrayList();
        
        
        GenericoBD.abrirConexion();
            Statement sentencia = GenericoBD.getCon().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT id_centro FROM centro");
            
            while (resultado.next())
            {
                listaids.add(resultado.getInt(1)); 
            }
        GenericoBD.cerrarConexion();
            return listaids;
            
            
    }
    
    public static Centro centrosId (int id) throws Exception
            
    {
         
        GenericoBD.abrirConexion();
        
            String plantilla = "SELECT * FROM centro WHERE id = ?";
            PreparedStatement sentenciaCon = GenericoBD.getCon().prepareStatement(plantilla);
            sentenciaCon.setInt(1,id);
            ResultSet resultado = sentenciaCon.executeQuery();
            
            if (resultado.next())
                {
                    c = new Centro();
                
                    c.setId(id);
                    c.setNombre(resultado.getString("nombre"));
                }
            else
                c = null;
            
        GenericoBD.cerrarConexion();
        
        return c;
    }
    
        
    
    public static void borrar( String id_centro){
        
    try
        {
            GenericoBD.abrirConexion();   
            
            
            String plantilla= " DELETE FROM Centro WHERE id_centro= ? ";
           
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, c.getId_centro());
             
            ps.executeUpdate();
            System.out.println("Centro borrado");
         
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static void actualizar(String id_centro, String nom, String fijo, String codp, String prov, String ciu, String cal, String num){
        try
        {
            GenericoBD.abrirConexion();   
            
            String plantilla="UPDATE Centro SET id_centro = ?, nombre = ?, tlf_fijo = ?, cp = ?, provincia = ?, ciudad = ?, calle = ?, numero = ? WHERE id_centro = ?  ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            
           ps.setString(1, id_centro);
            ps.setString(2, nom);
            ps.setString(3, fijo);
            ps.setString(4, codp);
            ps.setString(5, prov);
            ps.setString(6, ciu);
            ps.setString(7, cal);
            ps.setString(8, num);
            
            ps.setString(9, id_centro);
            
            
            ps.executeUpdate();
            System.out.println("Centro actualizado");
           
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static void insertar(String id_centro, String nom, String fijo, String codp, String prov, String ciu, String cal, String num){
        try
        {
            GenericoBD.abrirConexion();   
            
            
            String plantilla="INSERT INTO Centro VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            
            ps.setString(1, id_centro);
            ps.setString(2, nom);
            ps.setString(3, fijo);
            ps.setString(4, codp);
            ps.setString(5, prov);
            ps.setString(6, ciu);
            ps.setString(7, cal);
            ps.setString(8, num);
            
            
            
            ps.executeUpdate();
            System.out.println("Centro insertado");
            

        }
        
        catch(Exception e)
            
        {
            
        }
        finally
            
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    
    
}
