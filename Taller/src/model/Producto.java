package model;

public class Producto {

    String id;
    String nombre;
    double precio;

public Producto(String id, String nombre, double precio){

    this.id=id;
    this.nombre=nombre;
    this.precio=precio;


    }

public String getId(){
    return this.id;
}
public String getNombre(){
    return this.nombre;
}
public double getPrecio(){
    return this.precio;
}

}
