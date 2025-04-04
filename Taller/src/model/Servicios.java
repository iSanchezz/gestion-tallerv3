package model;

public class Servicios {
    int id;
    String idEmpleado;
    String idCliente;
    String idVehiculo;
    int numeroCita;
    double precio;
    String descripcion;


    public Servicios(int id, String idEmpleado, String idcliente, String idvehiculo, int numeroCita, double precio, String descripcion){

        this.id=id;
        this.idEmpleado=idEmpleado;
        this.idCliente=idCliente;
        this.idVehiculo=idvehiculo;
        this.numeroCita=numeroCita;
        this.precio=precio;
        this.descripcion=descripcion;
     }
    public int getId(){return this.id;}
    public String getidEmpleado(){return this.idEmpleado;}
    public String getidCliente(){return this.idCliente;}
    public String getidVehiculo(){return this.idVehiculo;}
    public int getNumeroCita(){return this.numeroCita;}
    public double getprecio(){return this.precio;}
    public String getDescripcion(){return this.descripcion;}
}
