package com.example.appointmed.Modelo;

public class Usuario {
    private String nombre;
    private int cedula;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, int cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
