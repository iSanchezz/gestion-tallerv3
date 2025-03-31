package view;

import model.Empleado;
import java.util.*;

public class EmpleadoMenu {
    Scanner sc = new Scanner(System.in);
    public void menu(){
        int opcion;
        System.out.println("Qué quieres hacer?");
                    System.out.println("1. Crear empleado");
                    System.out.println("2. Modificar empleado");
                    System.out.println("3. Borrar empleado");
                    
                    opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> crearEmpleado();
                            //case 2 -> modificarEmpleado();
                            //case 3 -> borrarEmpleado();
                        }
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
