package model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {
    int numeroCita;
    LocalDate fecha;
    LocalDateTime hora;

    public Cita(int numeroCita, LocalDate fecha, LocalDateTime hora) {
        this.numeroCita = numeroCita;
        this.fecha = fecha;
        this.hora = hora;
    }
}
