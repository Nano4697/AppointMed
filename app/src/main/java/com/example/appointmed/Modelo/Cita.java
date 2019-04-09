package com.example.appointmed.Modelo;

public class Cita {
    private String hora;
    private String fecha;
    private String doctor;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    private int cedula;


    public Cita(String hora, String fecha, String doctor, int cedula) {
        this.hora = hora;
        this.fecha = fecha;
        this.doctor = doctor;
        this. cedula = cedula;
    }

    public Cita() {
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
