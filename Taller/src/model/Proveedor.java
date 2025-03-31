package model;

public class Proveedor {
    int id;
    String nombre;
    int telefono;
    
    public Proveedor(int id,String nombre, int telefono){
    
    this.id=id;
    this.nombre=nombre;
    this.telefono=telefono;
    
        }
    
    public int getId(){return this.id;}
    
    public String getNombre(){return this.nombre;}

    public int getTelefono(){return this.telefono;}
    
    public void setId(){this.id=id;}
    
    public void setNombre(){this.nombre=nombre;}

}
