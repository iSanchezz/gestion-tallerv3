package model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    int numeroCita;
    LocalDate fecha;
    LocalTime hora;
    String idVehiculo;

    public Cita(int numeroCita, LocalDate fecha, LocalTime hora, String idVehiculo) {
        this.numeroCita = numeroCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idVehiculo = idVehiculo;
    }

    public int getNumeroCita(){
        return this.numeroCita;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public LocalTime getHora(){
        return this.hora;
    }

    public String getIdVehiculo(){
        return this.idVehiculo;
    }
    
    
}
