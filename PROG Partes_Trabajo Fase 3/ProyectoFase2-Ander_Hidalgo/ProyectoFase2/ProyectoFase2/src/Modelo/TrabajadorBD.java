
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Controlador.Main;

public class TrabajadorBD {
 
    
    private static Trabajador t;
    
    
    public static Trabajador buscar(String dni){
        
    
         try
        {
            GenericoBD.abrirConexion();
            String plantilla="SELECT * FROM Trabajador WHERE dni = ?";

            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, dni);
            ResultSet resultado = ps.executeQuery();
            
            if (resultado.next() == false)
                {
                    t = null; 
                }
            else
                {
                    
                
                if(resultado.getInt("id")== Controlador.Main.getC().getId())  
                  
                {
                    if (resultado.getString("tipo").compareToIgnoreCase("A") == 0)
                    {
                        
                    
                        t = new Administracion();
                    }
                    else
                        t = new Logistica();
            
                }
            
          
            t.setDni(resultado.getString("dni"));
            
            
            t.setNombre(resultado.getString("nombre"));
            t.setApellido1(resultado.getString("apellido1"));
            t.setApellido2(resultado.getString("apellido2"));
            t.setCalle(resultado.getString("calle"));
            t.setPortal(resultado.getString("portal"));
            t.setPiso(resultado.getString("piso"));
            t.setMano(resultado.getString("mano"));
            t.setPersonal(resultado.getString("personal"));
            t.setMovil(resultado.getString("movil"));
            t.setSalario(resultado.getFloat("salario"));
            t.setFechanac(resultado.getDate("fechanac"));
            
            }
            
          
            return t;
        }
        catch(Exception e)
        {
            return null;
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static void borrar(Trabajador t){
        
    try
        {
            GenericoBD.abrirConexion();   
            
            
            String plantilla= " DELETE FROM Trabajador WHERE dni= ? ";
           
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
             
            ps.executeUpdate();
            System.out.println("Trabajador borrado");
         
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static void actualizar(Trabajador t,Centro c,String tipo){
        try
        {
            GenericoBD.abrirConexion();   
            
            String plantilla="UPDATE Trabajador SET dni = ?,  nombre = ?,apellido1= ?,apellido2 = ?,calle = ?,portal = ?,piso = ?, mano = ?,personal = ?, movil = ?,salario = ?,fechanacimiento = ?, tipo= ? WHERE dni= ? ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido1());
            ps.setString(4, t.getApellido1());
            ps.setString(5, t.getCalle());
            ps.setString(6, t.getPortal());
            ps.setString(7, t.getPiso());
            ps.setString(8, t.getMano());
            ps.setString(9, t.getPersonal());
            ps.setString(10, t.getMovil());
            ps.setFloat(11, t.getSalario());
 
            java.sql.Date fecha = new java.sql.Date(t.getFechanac().getTime());
            ps.setDate(12, fecha);
            ps.setString(13,t.getTipo());
            
            
            ps.executeUpdate();
            System.out.println("Trabajador actualizado");
           
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static void insertar(Trabajador t, String tipo){
        try
        {
            GenericoBD.abrirConexion();   
            
            
            String plantilla="insert into Trabajador values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido1());
            ps.setString(4, t.getApellido1());
            ps.setString(5, t.getCalle());
            ps.setString(6, t.getPortal());
            ps.setString(7, t.getPiso());
            ps.setString(8, t.getMano());
            ps.setString(9, t.getPersonal());
            ps.setString(10, t.getMovil());
            ps.setFloat(11, t.getSalario());
            
            
            java.sql.Date fecha = new java.sql.Date(t.getFechanac().getTime());
            ps.setDate(12, fecha);
            ps.setString(13,t.getTipo());
            
            
            
            ps.executeUpdate();
            System.out.println("Trabajador insertado");
            

        }
        
        catch(Exception e)
            
        {
            
        }
        finally
            
        {
            GenericoBD.cerrarConexion();
        }
        
    }
    
    public static ArrayList<Trabajador> consultaCentro (String id) {
        
        try
        {
            
          ArrayList<Trabajador> listado = new ArrayList();
          
          GenericoBD.abrirConexion();
          
          String plantilla = "SELECT * FROM trabajador WHERE idCentro = ?";
          PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            
          ps.setString(1, id);
          ResultSet resultado = ps.executeQuery();
            
            while(resultado.next() == true)
            {
                    t.setDni(resultado.getString("dni"));
                    t.setNombre(resultado.getString("nombre"));
                    t.setApellido1(resultado.getString("apellido1"));
                    t.setApellido2(resultado.getString("apellido2"));
                    t.setCalle(resultado.getString("calle"));
                    t.setPortal(resultado.getString("portal"));
                    t.setPiso(resultado.getString("piso"));
                    t.setMano(resultado.getString("mano"));
                    t.setMovil(resultado.getString("telmovil"));
                    t.setPersonal(resultado.getString("telpersonal"));
                    t.setSalario(resultado.getFloat("salario"));
                    t.setFechanac(new java.util.Date(resultado.getDate("fechaNac").getTime()));
                    
                    listado.add(t);
            }
            return listado;
        }
        
        catch(Exception e)
        {
            
        }
        
        finally 
        {
            GenericoBD.cerrarConexion();
            
        }
    
    
    
    return null;
    
        }
    
}


