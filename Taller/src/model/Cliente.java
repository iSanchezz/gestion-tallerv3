package model;

public class Cliente {
    String id;
    String nombre;
    int telefono;
    


    public Cliente(String id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public  String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getTelefono() {
        return this.telefono;
    }

}
