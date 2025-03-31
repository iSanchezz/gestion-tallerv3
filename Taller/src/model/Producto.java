package model;

public class Producto {

    int id;
    String nombre;
    double precio;

public Producto(int id, String nombre, double precio){

    this.id=id;
    this.nombre=nombre;
    this.precio=precio;


    }

public int getId(){
    return this.id;
}
public String getNombre(){
    return this.nombre;
}
public double getPrecio(){
    return this.precio;
}

}
