package com.example.appointmed.Modelo;

public class Historial {
    private String registro;
    private String descripcion;
    private String dcotor;
    private String fecha;
    private int cedula;

    public Historial(String registro, String descripcion, String dcotor, String fecha, int cedula) {
        this.registro = registro;
        this.descripcion = descripcion;
        this.dcotor = dcotor;
        this.fecha = fecha;
        this.cedula = cedula;
    }

    public Historial() {
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDcotor() {
        return dcotor;
    }

    public void setDcotor(String dcotor) {
        this.dcotor = dcotor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
