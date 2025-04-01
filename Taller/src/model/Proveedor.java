package model;

public class Proveedor {
    String id;
    String nombre;
    int telefono;
    
    public Proveedor(String id,String nombre, int telefono){
    
    this.id=id;
    this.nombre=nombre;
    this.telefono=telefono;
    
        }
    
    public String getId(){return this.id;}
    
    public String getNombre(){return this.nombre;}

    public int getTelefono(){return this.telefono;}
    
    public void setId(){this.id=id;}
    
    public void setNombre(){this.nombre=nombre;}

}
