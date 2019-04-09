package com.example.appointmed.Controlador;
import com.example.appointmed.Modelo.Cita;

public class ControladorCita {
    public Cita cita;

    public ControladorCita(Cita cita) {
        this.cita = cita;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public void crearCita(String hora, String fecha, String doctor,int cedula){
        cita.setHora(hora);
        cita.setFecha(fecha);
        cita.setDoctor(doctor);
        cita.setCedula(cedula);
    }
}
