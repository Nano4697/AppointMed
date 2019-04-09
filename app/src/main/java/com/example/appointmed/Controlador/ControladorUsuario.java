package com.example.appointmed;

import com.example.appointmed.Modelo.Usuario;

import java.util.ArrayList;

public class ControladorUsuario {
   private ArrayList<Usuario> usuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private Usuario usuario;


    public ControladorUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Boolean usuarioValido(String correo, String contrasenna){
        Boolean e = false;

        for (int i=0;i<=usuarios.size()-1;i++) {
            if (correo.equals(usuarios.get(i).getCorreo()) && contrasenna.equals(usuarios.get(i).getCorreo()))
                e = true;
        }
        return e;
    }

    public void crearUsuario(String nombre, String correo,int cedula, String contrasenna){
          usuario.setNombre(nombre);
          usuario.setCorreo(correo);
          usuario.setCedula(cedula);
          usuario.setContrasena(contrasenna);

    }

}
