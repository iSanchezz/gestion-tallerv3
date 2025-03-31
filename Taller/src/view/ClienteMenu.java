package view;

import java.util.*;
import model.Cliente;

public class ClienteMenu {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
                    System.out.println("1. Crear cliente");
                    System.out.println("2. Modificar cliente");
                    System.out.println("3. Borrar cliente");
                    
                    opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> crearCliente();
                            //case 2 -> modificarCliente();
                            //case 3 -> borrarCliente();
                        }

    }

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
    
}
