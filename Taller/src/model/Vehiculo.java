package model;

public class Vehiculo {
    String id;
    String marca;
    String modelo;
    String estado;
    String duenio;

    public Vehiculo(String marca, String modelo, String id, String estado, String duenio) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
        this.estado = estado;
        this.duenio = duenio;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getId() {
        return this.id;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getduenio() {
        return this.duenio;
    }

}
