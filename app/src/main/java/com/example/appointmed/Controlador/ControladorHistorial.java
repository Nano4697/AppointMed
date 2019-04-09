package com.example.appointmed.Controlador;
import com.example.appointmed.Modelo.Historial;

import java.util.ArrayList;

public class ControladorHistorial {
    public ArrayList<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }

    private ArrayList<Historial> historiales;

    public ControladorHistorial(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }

    public Historial verHistorial(String cedula){
        Historial his = null;
        for(int i=0;i<=historiales.size()-1;i++){
            if (cedula.equals(historiales.get(i).getCedula())) {
                his = historiales.get(i);
            }

        }
        return his;
    }
}
