package model;

public class Vehiculo {
    String id;
    String marca;
    String modelo;
    String estado;

    public Vehiculo(String marca, String modelo, String id, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
        this.estado = estado;
    }


    public String getMarca(){return this.marca;}

    public String getModelo(){return this.modelo;}

    public String getId(){return this.id;}

    public String getEstado(){return this.estado;}

}
