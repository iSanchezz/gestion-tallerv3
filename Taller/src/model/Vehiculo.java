package model;

public class Vehiculo {
    String marca;
    String modelo;
    String matricula;
    String estado;

    public Vehiculo(String marca, String modelo, String matricula, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.estado = estado;
    }


    public String getMarca(){return this.marca;}

    public String getModelo(){return this.modelo;}

    public String getMatricula(){return this.matricula;}

}
