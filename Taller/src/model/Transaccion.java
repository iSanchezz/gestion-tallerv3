package model;

import java.time.LocalDateTime;

public class Transaccion {
    private int id;
    private String tipo;
    private double cantidad;
    private String descripcion;
    private LocalDateTime fecha;

    public Transaccion(int id, String tipo, double cantidad, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();

    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getCantidad() { return cantidad; }
    public String getDescripcion() { return descripcion; }
    public LocalDateTime getFecha() { return fecha; }



    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
} 