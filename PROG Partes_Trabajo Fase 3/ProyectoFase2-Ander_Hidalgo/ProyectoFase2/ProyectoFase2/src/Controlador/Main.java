package Controlador;

import Vista.*;
import Modelo.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Main {

    private static VentanaCentro vc;
    private static VentanaPerfil vp; 
    
    private static ResultSet rs;
    
    private static Calendar cal = Calendar.getInstance();
    
    private static Trabajador t;
    private static Centro c;
    
    
    private static ArrayList<String> nombres = new ArrayList();
    
    private static ArrayList<Integer> centros = new ArrayList();
    
    private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    
    private static int y;
    
    public static void main(String[] args) {
        
        mostrarCentro();
        
        
    }
    
    public static ArrayList<Integer> convertir(ResultSet rs)
    {
        try
        
        {
                while(rs.next())
                {
                    centros.add(rs.getInt(1));
                    nombres.add(rs.getString(2));
                }
            return centros;
        }
        catch(Exception e)
            
        {
            return null;
        }
        
    }
    
    
    public static String getCentro(Integer p){
        return nombres.get(p);
    }
    
     public static int getIdCentro(){
         return c.getId();
     }
     
     public static String getNombre(){
         return t.getNombre();
     }
     public static String getApellido1(){
         return t.getApellido1();
     }
     public static String getApellido2(){
         return t.getApellido2();
     }
     public static String getCalle(){
         return t.getCalle();
     }
     public static String getPortal(){
         return t.getPortal();
     }
     public static String getPiso(){
         return t.getPiso().toString();
     }
     public static String getMano(){
         return t.getMano();
     }
     public static String getTelPersonal(){
         return t.getPersonal();
     }
     public static String getTelMovil(){
         return t.getMovil();
     }
     
     public static String getTipo(){
         return t.getTipo();
     }

    public static Centro getC() {
        return c;
    }
     
     
     
     public static java.util.Calendar getFechaNac(){
         
        java.util.Calendar cal = Calendar.getInstance();
        
        cal.setTime(t.getFechanac());
        
        return cal;
     }
     
     public static Float getSalario(){
         return t.getSalario();
     }
     
     public static ArrayList <Integer> datosCombo() throws Exception{
         
        return CentroBD.buscarCentros();
        
    }
     
     
     public static boolean buscarIdCentro(int id) throws Exception
     {
         
         c = CentroBD.centrosId(id);
         
         return c != null;
     }
    
   
     public static boolean buscarDni(String d) throws Exception
     {
         t = new Trabajador();
         
         t =  TrabajadorBD.buscar(d);
         
         if (t == null)
         {
            return false; 
         }
             
         return true;
     }
     
    public static String nombreCentro(int id) throws Exception {
        
         c = CentroBD.centrosId(id);
         return c.getNombre();
    } 
    
    
    public static void obtenerTrabajador(Trabajador t)throws Exception{
        
        t = TrabajadorBD.buscar(t.getDni());
        
    }
     
     public static void borrarTrabajador(String dni)
     {
         t.setDni(dni);
         TrabajadorBD.borrar(t);
     }
    
         public static void insertarTrabajador(String d,String n,String ap1, String ap2 ,String c,String por,String pi,String ma,String tp, String tm,String sal,Calendar fecha,String tipo) throws Exception{
        
         t = new Trabajador();
         t.setDni(d);
         t.setNombre(n);
         t.setApellido1(ap1);
         t.setApellido2(ap2);
         t.setCalle(c);
         t.setPortal(por);
         t.setPiso(pi);
         t.setMano(ma);
         t.setMovil(tm);
         t.setPersonal(tp);
         t.setSalario(Float.parseFloat(sal));
         t.setFechanac(fecha.getTime());
         
         TrabajadorBD.insertar(t,tipo);
     }
    
     public static void ModificarTrabajador(String d,String n,String ap1, String ap2,String ca,String por,String pi,String m,String tp, String tm,String sal,Calendar fecha,String tipo) throws Exception{
         
         t.setDni(d);
         t.setNombre(n);
         t.setApellido1(ap1);
         t.setApellido2(ap2);
         t.setCalle(ca);
         t.setPortal(por);
         t.setPiso(pi);
         t.setMano(m);
         t.setMovil(tm);
         t.setPersonal(tp);
         t.setSalario(Float.parseFloat(sal));
         t.setFechanac(fecha.getTime());
         
         TrabajadorBD.actualizar(t,c,tipo);
     }
     
    public static String getTrabajador(String id) throws Exception
     {
         String resultados = " ";
         int x;
         
         c = new Centro();
         c.setId(Integer.parseInt(id));
         
         ArrayList<Trabajador> lista = c.getListaTrabajadores();
         
         for( x = 0; x < lista.size(); x++)
         {
             resultados += lista.get(x).toString();
         }
         return resultados;
     }
     
    public static void mostrarCentro(){
        vc = new VentanaCentro();
        vc.setVisible(true);
    }
   
    
    public static void mostrarVentanaPerfil(){
        vp = new VentanaPerfil();
        vp.setVisible(true);
    }
    
    public static void volverCentro(){
        vp.setVisible(false);
        mostrarCentro();
    }
    
    public static void pasoPerfil(){
        vc.setVisible(false);
        mostrarVentanaPerfil();
    }

    public static Trabajador getT() {
        return t;
    }

    public static void setT(Trabajador t) {
        Main.t = t;
    }

    public static Calendar getCal() {
        return cal;
    }

    public static void setCal(Calendar cal) {
        Main.cal = cal;
    }
 
}
