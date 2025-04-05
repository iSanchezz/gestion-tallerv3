package view;

import dao.*;
import java.util.*;
import model.Cliente;

public class ClienteMenu {
    Scanner sc = new Scanner(System.in);
    ClienteDB clienteDB = new ClienteDB();
    Taller taller = new Taller();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Borrar cliente");
        System.out.println("4. Salir");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> clienteDB.insertarCliente(crearCliente());
            case 2 -> modificarCliente();
            case 3 -> borrarCliente();
            case 4 -> {
                System.out.println("1. Al menú principal");
                System.out.println("2. Cerrar programa.");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> taller.menu();
                    case 2 -> System.exit(0);
                }
            }
        }

    }

    public Cliente crearCliente() {
        String id = "";
        String nombre = "";
        int telefono = 0;
        boolean exito;
        String respuesta = "";

        do {
            exito = false;
            try {
                System.out.println("ID: ");
                id = sc.next();

                System.out.println("Nombre: ");
                nombre = sc.next();

                System.out.println("Telefono: ");
                telefono = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                    exito = true;
                } else {
                    return null;
                }
            }
        } while (exito);
        System.out.println(
                "El cliente " + nombre + " con ID " + id + " y telefono " + telefono + " se ha creado correctamente");
        return new Cliente(id, nombre, telefono);

    }

    public void modificarCliente() {
        String id;
        int opcion;
        String nuevoNombre;
        int nuevoTelefono;
        boolean exito;
        String respuesta;

        do {
            exito = false;
            try {
                System.out.println("ID del cliente: ");
                id = sc.next();

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
                exito = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo? (si/no)");
                respuesta = sc.next().toLowerCase();
                if (!respuesta.equals("si")) {
                    exito = true;
                }
            }
        } while (!exito);
        menu();
    }

    public void borrarCliente() {
        String id;
        String respuesta;
        boolean exito;

        do {
            exito = false;
            try {
                System.out.println("ID del cliente: ");
                id = sc.next();

                System.out.println("El cliente ");
                clienteDB.mostrarClientesID(id);
                System.out.println("se borrara");
                System.out.println("Quieres continuar?");
                respuesta = sc.next().toLowerCase();

                if ("si".equals(respuesta)) {
                    clienteDB.borrarCliente(id);
                    System.out.println("El cliente ha sido eliminado con éxito");
                } else {
                    System.out.println("Se ha cancelado la operación");
                }
                exito = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo? (si/no)");
                respuesta = sc.next().toLowerCase();
                if (!respuesta.equals("si")) {
                    exito = true;
                }
            }
        } while (!exito);
        menu();
    }

}
