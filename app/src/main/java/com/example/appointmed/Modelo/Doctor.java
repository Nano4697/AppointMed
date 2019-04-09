package com.example.appointmed.Modelo;

public class Doctor {
    private String nomnbre;
    private String especialidad;

    public Doctor(String nomnbre, String especialidad) {
        this.nomnbre = nomnbre;
        this.especialidad = especialidad;
    }

    public Doctor() {
    }

    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
