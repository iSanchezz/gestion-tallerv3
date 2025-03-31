package view;

import dao.ClienteDB;
import java.util.*;
import model.Cliente;

public class ClienteMenu {
    Scanner sc = new Scanner(System.in);
    ClienteDB clienteDB = new ClienteDB();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Borrar cliente");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> crearCliente();
            case 2 -> modificarCliente();
            // case 3 -> borrarCliente();
            // case 4 -> Salir no implementado
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
                System.out.println("El cliente " + nombre + " con ID " + id + " y telefono " + telefono
                        + " se ha creado correctamente");
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

    public void modificarCliente() {
        String id;
        int opcion;

        System.out.println("ID del cliente: ");
        id = sc.next();

        String nuevoNombre;
        int nuevoTelefono;

        System.out.println("Qué quieres modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Telefono");
        System.out.println("3. Todo");
        System.out.println("4. Salir");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();
                clienteDB.modificarNombreCliente(id, nuevoNombre);
            }

            case 2 -> {
                System.out.println("Nuevo telefono: ");
                nuevoTelefono = sc.nextInt();
                clienteDB.modificarTelefonoCliente(id, nuevoTelefono);
            }

            case 3 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();

                System.out.println("Nuevo telefono:");
                nuevoTelefono = sc.nextInt();
                clienteDB.modificarNombreCliente(id, nuevoNombre);
                clienteDB.modificarTelefonoCliente(id, nuevoTelefono);
            }

            case 4 -> menu();

            default -> System.out.println("Opcion no valida");
        }

    }

}
