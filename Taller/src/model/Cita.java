package model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {
    LocalDate fecha;
    LocalDateTime hora;

    public Cita(LocalDate fecha, LocalDateTime hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
}
