package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Excepciones.*;

public class TrabajadorBD {
    
    public static Trabajador buscarDni(Trabajador t, Centro c){
        try
        {
            GenericoBD.abrirConexion();
            String plantilla="SELECT * FROM Trabajador WHERE dni = ?";

            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
            ResultSet resultado = ps.executeQuery();                 
            
            if (resultado.next()== false)
            {
                t =  null;
            }
            else
            {
                    if (resultado.getString("tipo").compareToIgnoreCase("A")== 0)
                        t = new Administracion();
                    else
                        t = new TransporteLogistica();
                    
                    t.setDni(resultado.getString("dni"));
                    t.setNombre(resultado.getString("nombre"));
                    t.setApellido1(resultado.getString("apellido1"));
                    t.setApellido2(resultado.getString("apellido2"));
                    t.setCalle(resultado.getString("calle"));
                    t.setNumero(resultado.getString("numero"));
                    t.setPiso(resultado.getString("piso"));
                    t.setMano(resultado.getString("mano"));
                    t.setTlf_empresa(resultado.getString("tlf_empresa"));
                    t.setTlf_personal(resultado.getString("tlf_personal"));
                    t.setSalario(resultado.getFloat("salario"));
                    t.setFecha_nac(resultado.getDate("fecha_nac"));
                    t.setTipo(resultado.getString("tipo"));
                
            }
            return t;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningun trabajador con ese dni");
            return null;
        }
        finally
        {
            GenericoBD.cerrarConexion();
        }
    }   
    
    public static boolean borrarTrabajador(Trabajador t){
        
    try
        {
            GenericoBD.abrirConexion();   
            
            String plantilla="delete from trabajador where dni= ? ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
             
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
    
    public static boolean actualizar(Trabajador t, String tipo){
        try
        {
            GenericoBD.abrirConexion();   

            String plantilla="update trabajador set nombre = ?,apellido1= ?,apellido2 = ?,calle = ?,numero = ?,piso = ?, mano = ?, tlf_empresa = ?, tlf_personal = ?,salario = ?,fecha_nac = ?,tipo = ? where dni= ? ";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);

            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido1());
            ps.setString(3, t.getApellido2());
            ps.setString(4, t.getCalle());
            ps.setString(5, t.getNumero());
            ps.setString(6, t.getPiso());
            ps.setString(7, t.getMano());
            ps.setString(8, t.getTlf_empresa());
            ps.setString(9, t.getTlf_personal());
            ps.setFloat(10, t.getSalario());
            Date fecha = new Date(t.getFecha_nac().getTime());
            ps.setDate(11, fecha);
            ps.setString(12, t.getTipo());
            ps.setString(13, t.getDni());

            ps.executeUpdate();
            //GenericoBD.getCon().commit();
            
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
    
    public static boolean insertar(Trabajador t, String tipo){
        try
        {
            GenericoBD.abrirConexion();   

            String plantilla="insert into trabajador values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = GenericoBD.getCon().prepareStatement(plantilla);
            ps.setString(1, t.getDni());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido1());
            ps.setString(4, t.getApellido2());
            ps.setString(5, t.getCalle());
            ps.setString(6, t.getNumero());
            ps.setString(7, t.getPiso());
            ps.setString(8, t.getMano());
            ps.setString(9, t.getTlf_empresa());
            ps.setString(10, t.getTlf_personal());
            ps.setFloat(11, t.getSalario());
            Date fecha = new Date(t.getFecha_nac().getTime());
            ps.setDate(12, fecha);
            ps.setString(13, t.getTipo());

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

