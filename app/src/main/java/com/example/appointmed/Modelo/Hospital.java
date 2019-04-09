package com.example.appointmed.Modelo;

public class Hospital {
    private String nombre;
    private String dicreccion;

    public Hospital(String nombre, String dicreccion) {
        this.nombre = nombre;
        this.dicreccion = dicreccion;
    }

    public Hospital() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDicreccion() {
        return dicreccion;
    }

    public void setDicreccion(String dicreccion) {
        this.dicreccion = dicreccion;
    }
}
