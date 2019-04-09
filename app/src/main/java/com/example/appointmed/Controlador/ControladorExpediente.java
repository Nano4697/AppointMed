package com.example.appointmed.Controlador;
import com.example.appointmed.Modelo.Expdiente;

import java.util.ArrayList;

public class ControladorExpediente {
    private ArrayList<Expdiente> expedientes;

    public ControladorExpediente(ArrayList<Expdiente> expedientes) {
        this.expedientes = expedientes;
    }

    public ArrayList<Expdiente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Expdiente> expedientes) {
        this.expedientes = expedientes;
    }

    public Expdiente verExpediente(String cedula){
        Expdiente exp = null;
        for(int i=0;i<=expedientes.size()-1;i++){
            if (cedula.equals(expedientes.get(i).getCedula())) {
                exp = expedientes.get(i);
            }

        }
        return exp;
    }
}
