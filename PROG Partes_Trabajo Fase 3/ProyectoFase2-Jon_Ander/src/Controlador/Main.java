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
    private static Trabajador t;
    private static Centro c;
    private static ArrayList<String> nombres = new ArrayList();    
    private static ArrayList<Integer> centros = new ArrayList();  
    
    public static void main(String[] args) {
        GenericoBD.abrirConexion();
        rs = CentroBD.buscarCentro();
        mostrarCentro();              
    }
    
    public static ArrayList<Integer> convertir(ResultSet rs){
        try{
            while(rs.next()){
                centros.add(rs.getInt(1));
                nombres.add(rs.getString(2));
            }
            return centros;
        }
        catch(Exception e){
            return null;
        }      
    }
    
    public static String getCentro(Integer p){
        return nombres.get(p);
    }
    
    public static void mostrarCentro(){
        vc = new VentanaCentro(convertir(rs));
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

    public static boolean buscarDni(String d) throws Exception{
        t = new Trabajador(d);
        t = TrabajadorBD.buscarDni(t, c);
        if (t == null)
            return false;
        return true;
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
    
    public static String getNumero(){
        return t.getNumero();
    }
    
    public static String getPiso(){
        return t.getPiso();
    }
    
    public static String getMano(){
        return t.getMano();
    }
    
    public static String getTlf_empresa(){
        return t.getTlf_empresa();
    }
    
    public static String getTlf_personal(){
        return t.getTlf_personal();
    }
    
    public static Calendar getFecha_Nac(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(t.getFecha_nac());
        return cal;
    }
    
    public static Float getSalario(){
        return t.getSalario();
    }
 
    public static boolean getTipo(){
         if (t instanceof Administracion)
            return true;
         else   
            return false;
     }
    
    public static void altaTrabajador(String d, String n, String a1, String a2, String c, String num, String pi, String m, String te, String tp, String s, Calendar fecha, String tipo)
    {
        t = new Trabajador();
        t.setDni(d);
        t.setNombre(n);
        t.setApellido1(a1);
        t.setApellido2(a2);
        t.setCalle(c);
        t.setNumero(num);
        t.setPiso(pi);
        t.setTlf_empresa(te);
        t.setTlf_personal(tp);
        t.setSalario(Float.parseFloat(s));
        t.setFecha_nac(fecha.getTime());
        t.setTipo(tipo);
        
        TrabajadorBD.insertar(t, tipo);
    }
    
    public static void modificarTrabajador(String d, String n, String a1, String a2, String c, String num, String pi, String m, String te, String tp, String s, Calendar fecha, String tipo)
    {
        t.setDni(d);
        t.setNombre(n);
        t.setApellido1(a1);
        t.setApellido2(a2);
        t.setCalle(c);
        t.setNumero(num);
        t.setPiso(pi);
        t.setTlf_empresa(te);
        t.setTlf_personal(tp);
        t.setSalario(Float.parseFloat(s));
        t.setFecha_nac(fecha.getTime());
        t.setTipo(tipo);
        
        TrabajadorBD.actualizar(t, tipo);
    }
    
    public static void bajaTrabajador()
    {
        TrabajadorBD.borrarTrabajador(t);
    }
    
    public static void borrarCentro(){
        centros.remove(c);
        CentroBD.borrar(c);
    }
    
    public static void añadirCentro(String id, String n, String tlf, String cp, String p, String ciu, String ca, String num){
        c = new Centro();
        c.setId_centro(id);
        c.setNombre(n);
        c.setTlf_fijo(tlf);
        c.setCp(cp);
        c.setProvincia(p);
        c.setCiudad(ciu);
        c.setCalle(ca);
        c.setNumero(num);
        
        CentroBD.añadir(c);
    }
    
    public static void modificarCentro(String id, String n, String tlf, String cp, String p, String ciu, String ca, String num){
        c.setId_centro(id);
        c.setNombre(n);
        c.setTlf_fijo(tlf);
        c.setCp(cp);
        c.setProvincia(p);
        c.setCiudad(ciu);
        c.setCalle(ca);
        c.setNumero(num);
        
        CentroBD.modificar(c);
    }
   /* 
    public static String getCId(){
        return c.getNombre();
    }
    
    public static String getCNombre(){
        return c.getNombre();
    }
    
    public static String getCTlf(){
        return c.getNombre();
    }
    
    public static String getCCp(){
        return c.getNombre();
    }
    
    public static String getCProvincia(){
        return c.getNombre();
    }
    
    public static String getCCiudad(){
        return c.getNombre();
    }
    
    public static String getCCalle(){
        return c.getNombre();
    }
    
    public static String getCNumero(){
        return c.getNombre();
    }
    
    */
    
    public static void finalizarVentana(){
        vp.dispose();
        System.exit(0);
    }
}
