package com.example.appointmed.Modelo;

public class Expdiente {
   private int telefono;
   private int contacto;
   private String tipoSangre;
   private String direccion;
   private String alergia;
   private String medicamento;
   private int cedula;

    public Expdiente(int telefono, int contacto, String tipoSangre, String direccion, String alergia, String medicamento, int cedula) {
        this.telefono = telefono;
        this.contacto = contacto;
        this.tipoSangre = tipoSangre;
        this.direccion = direccion;
        this.alergia = alergia;
        this.medicamento = medicamento;
        this.cedula = cedula;
    }

    public Expdiente() {
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

}
