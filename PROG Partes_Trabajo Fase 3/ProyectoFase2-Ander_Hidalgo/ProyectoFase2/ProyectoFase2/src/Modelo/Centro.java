package Modelo;

import java.util.ArrayList;


public class Centro {
    
    private Integer id;
    private String nombre;
    private String calle;
    private Integer numero;
    private Integer cp;
    private String ciudad;
    private String provincia;
    private String telefono;

    public static ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public static void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        Centro.listaTrabajadores = listaTrabajadores;
    }
    
    private static ArrayList <Trabajador> listaTrabajadores;
    
    public Centro() {
    }

    public Centro(Integer id, String nombre, String calle, Integer numero, Integer cp, String ciudad, String provincia, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    String getId_centro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    
}
