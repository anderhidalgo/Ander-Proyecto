package Modelo;

import java.util.Date;

public class Trabajador {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String calle;
    private String numero;
    private String piso;
    private String mano;
    private String tlf_empresa;
    private String tlf_personal;
    private Date fecha_nac;
    private float salario;
    private String tipo;

    public Trabajador() {
    }

    public Trabajador(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getTlf_empresa() {
        return tlf_empresa;
    }

    public void setTlf_empresa(String tlf_empresa) {
        this.tlf_empresa = tlf_empresa;
    }

    public String getTlf_personal() {
        return tlf_personal;
    }

    public void setTlf_personal(String tlf_personal) {
        this.tlf_personal = tlf_personal;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
