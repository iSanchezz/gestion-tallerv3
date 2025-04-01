package model;

public class Vehiculo {
    String id;
    String marca;
    String modelo;
    String estado;
    String dueño;

    public Vehiculo(String marca, String modelo, String id, String estado, String dueño) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
        this.estado = estado;
        this.dueño=dueño;
    }


    public String getMarca(){return this.marca;}

    public String getModelo(){return this.modelo;}

    public String getId(){return this.id;}

    public String getEstado(){return this.estado;}

    public String getDueño(){return this.dueño;}

}
