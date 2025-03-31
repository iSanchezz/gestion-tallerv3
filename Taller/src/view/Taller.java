package view;

import java.util.Scanner;
import model.Cliente;
import model.Empleado;

public class Taller {
    Scanner sc = new Scanner(System.in);

    public void crearCliente() {
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
    
                Cliente cliente = new Cliente(id, nombre, telefono);
                System.out.println("El cliente " +  nombre + " con ID " + id + " y telefono " + telefono + " se ha creado correctamente");
                exito = true;
                
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
}