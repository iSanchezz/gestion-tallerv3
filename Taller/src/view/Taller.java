package view;

import java.util.Scanner;
import model.Cliente;
import model.Empleado;
import model.Producto;
import model.Proveedor;
import model.Vehiculo;

public class Taller {
    Scanner sc = new Scanner(System.in);

    public Cliente crearCliente() {
        String id = "";
        String nombre = "";
        int telefono = 0;
        boolean exito = false;
        String respuesta = "";

        do {
            try {
                System.out.println("ID: ");
                id = sc.next();
        
                System.out.println("Nombre: ");
                nombre = sc.next();
        
                System.out.println("Telefono: ");
                telefono = sc.nextInt();
    
                
                System.out.println("El cliente " +  nombre + " con ID " + id + " y telefono " + telefono + " se ha creado correctamente");
                exito = true;
                return   new Cliente(id, nombre, telefono);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                } else {
                    exito = true;

                }
                return null;
            }
        } while (exito);
    }
        

    public void crearEmpleado() {
        String id = "";
        String nombre = "";
        String puesto = "";
        double salario = 0;
        boolean exito = false;
        String respuesta;

        do { 
            try {
                System.out.println("ID: ");
                id = sc.next();
        
                System.out.println("Nombre: ");
                nombre = sc.next();
        
                System.out.println("Puesto: ");
                puesto = sc.next();
    
                System.out.println("Salario: ");
                salario = sc.nextDouble();
    
                Empleado empleado = new Empleado(id, nombre, puesto, salario);
                
            } catch (Exception e) {
                
                System.out.println("Error: " + e.getMessage());
                System.out.println("Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                } else {
                    exito = true;
                }
            }
            System.out.println("El empleado " +  nombre + " con ID " + id + ", puesto " + puesto + " y salario " + salario + " se ha creado correctamente");
            
        } while (exito);
  
        

    }

    public void crearVehiculo() {
        String marca = "";
        String modelo = "";
        String matricula = "";
        String estado = "";
        boolean exito = false;
        String respuesta = "";

        do {
            try {
                System.out.println("Marca: ");
                marca = sc.next();
        
                System.out.println("Modelo: ");
                modelo = sc.next();
        
                System.out.println("Matrícula: ");
                matricula = sc.next();

                System.out.println("Estado: ");
                estado = sc.next();
    
                Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, estado);
                System.out.println("El vehículo " + marca + " " + modelo + " con matrícula " + matricula + " y estado " + estado + " se ha creado correctamente");
                exito = true;
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                } else {
                    exito = true;
                }
            }
        } while (!exito);
    }

    public void crearProveedor() {
        int id = 0;
        String nombre = "";
        int telefono = 0;
        boolean exito = false;
        String respuesta = "";


        do {
            try {
                System.out.println("ID: ");
                id = sc.nextInt();
        
                System.out.println("Nombre: ");
                nombre = sc.next();
        
                System.out.println("Teléfono: ");
                telefono = sc.nextInt();
    
                Proveedor proveedor = new Proveedor(id, nombre, telefono);
                System.out.println("El proveedor " + nombre + " con ID " + id + " y teléfono " + telefono + " se ha creado correctamente");
                exito = true;
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                } else {
                    exito = true;
                }
            }
        } while (!exito);

    }

    public void crearProducto(){
        int id;
        String nombre;
        double precio;
        boolean exito = false;
        String respuesta;

        do {
            try {
                System.out.println("ID: ");
                id = sc.nextInt();
        
                System.out.println("Nombre: ");
                nombre = sc.next();
        
                System.out.println("Precio: ");
                precio = sc.nextDouble();
    
                Producto producto = new Producto(id, nombre, precio);
                System.out.println("El proveedor " + nombre + " con ID " + id + " y teléfono " + precio + " se ha creado correctamente");
                exito = true;
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();

                if (respuesta.equals("si")) {
                } else {
                    exito = true;
                }
            }
        } while (!exito);
    }
}