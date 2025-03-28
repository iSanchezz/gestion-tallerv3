package view;

import dao.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import model.Cliente;
import model.Empleado;
import model.Proveedor;
import model.Vehiculo;

public class Taller {
        Scanner sc = new Scanner(System.in);
    HashMap<Object, ArrayList> listaProveedores= new HashMap<>();
    HashMap<Object, ArrayList> listaClientes= new HashMap<>();

    public void crearCliente() {
        Connection conexion= ConexionDB.conectar();
        String id = "";
        String nombre = "";
        int telefono = 0;
        boolean continuar = false;
        String query="INSERT INTO clientes (id, nombre, telefono) VALUES ("+id+","+nombre+","+telefono+")";

        do {   
            try {
                System.out.println("Introduce el id del Cliente");
                id = sc.next();
                System.out.println("Introduce el nombre del Cliente");
                nombre = sc.next();
                System.out.println("Introduce el telefono del Cliente");
                telefono = sc.nextInt();
                continuar = true;
            
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("No se ha podido crear el Cliente");
                System.out.println("Quieres volver a intentarlo?");
                
                
                String respuesta = sc.next();
                respuesta = respuesta.toUpperCase();
                
                if (respuesta.equals("SI")) {
                    id = "";
                    nombre = "";
                
                } else {
                    continuar = true;
                }

            }

        } while (!continuar);

        
        try(PreparedStatement stmt= conexion.prepareStatement(query)){ 

        
        


            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("El cliente " + nombre + " con ID " + id + " y telefono " + telefono + " ha sido creado correctamente");

        }catch(SQLException e){
            System.out.println("Error al crear cliente");

        }

            

 
        Cliente cliente = new Cliente(id, nombre, telefono);
        
        System.out.println("El cliente " + nombre + " con ID " + id + " y telefono " + telefono + " ha sido creado correctamente");


    }

    public void crearProveedor(){

        Connection conexion= ConexionDB.conectar();
        Scanner sc= new Scanner(System.in);
        
        String valortotal="";
        String opcionminus;
        String opcion;
        int id=0;
        String nombre="";
        int telefono=0;
       
        String query="INSERT INTO proveedores (id, nombre, productos) VALUES ("+id+","+nombre+","+telefono+")";
        System.out.println("ID:");
        
        id=sc.nextInt();
    
        System.out.println("Nombre:");
    
        nombre= sc.next();
    

        try(PreparedStatement stmt= conexion.prepareStatement(query)){ 

            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("El proveedor " + nombre + " con ID " + id + " ha sido creado correctamente");

        }catch(SQLException e){
            System.out.println("Error al crear cliente");
        }

        
        
        Proveedor proveedor= new Proveedor(id, nombre, telefono);
       
    }
    
    public void crearEmpleado(){
        Connection conexion = ConexionDB.conectar();

        int id=0;
        String nombre="";
        String puesto="";
        double salario=0;
        boolean exito=true;

        try{
        System.out.println("ID: ");
        id=sc.nextInt();
        System.out.println("Nombre: ");
        nombre=sc.next();
        System.out.println("Puesto: ");
        puesto=sc.next();
        System.out.println("Salario: ");
        salario=sc.nextDouble();
  
        Empleado empleado= new Empleado(id, nombre, puesto, salario);

            }catch(Exception e){
           System.err.print(e.getMessage());
           exito=false;
        }  
        if(exito){
            String query="INSERT INTO empleados (id, nombre, puesto, salario) VALUES ("+id+","+nombre+","+puesto+","+salario+")";
        }
        


        }

        public void crearVehiculo(){

            String marca="";  
            String modelo="";  
            String matricula="";  
            String estado = "";

            System.out.println("Marcar: ");
            marca=sc.next();
            System.out.println("Modelo: ");
            modelo=sc.nextLine(); sc.next();
            System.out.println("Matricula: ");
            matricula=sc.next();

            Vehiculo vehiculo= new Vehiculo(marca, modelo, matricula, estado);

        }
       
    public void crearProducto(){
        Connection conexion= ConexionDB.conectar();
        int id=0;
        String nombre="";
        double precio=0;

        String query="INSERT INTO productos (id, nombre, precio) VALUES ("+id+","+nombre+","+precio+")";


        System.out.println("ID:");
        id=sc.nextInt();
        System.out.println("Nombre:");
        nombre=sc.next();
        System.out.println("Precio");
        precio=sc.nextDouble();


        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setDouble(3, precio);

            System.out.println("El producto " + nombre + " con ID " + id + " y precio " + precio + " ha sido creado correctamente");

        }catch(SQLException e){

            System.out.println("error al crear el producto");

        }




    }  

}
