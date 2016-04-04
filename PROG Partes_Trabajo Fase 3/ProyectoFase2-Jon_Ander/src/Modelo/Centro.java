package Modelo;

import java.util.ArrayList;

public class Centro {
    
    private String id_centro;
    private String nombre;
    private String tlf_fijo;
    private String cp;
    private String provincia;
    private String ciudad;
    private String calle;
    private String numero;
    private ArrayList<Trabajador> listaTrabajadores;

    public Centro(){
        
    }

    public String getId_centro() {
        return id_centro;
    }

    public void setId_centro(String id_centro) {
        this.id_centro = id_centro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf_fijo() {
        return tlf_fijo;
    }

    public void setTlf_fijo(String tlf_fijo) {
        this.tlf_fijo = tlf_fijo;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }     

}
