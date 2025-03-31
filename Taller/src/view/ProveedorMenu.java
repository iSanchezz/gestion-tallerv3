package view;

import dao.ProveedorDb;
import java.util.Scanner;
import model.Proveedor;

public class ProveedorMenu {
    Scanner sc = new Scanner(System.in);
    ProveedorDb proveedorDb = new ProveedorDb();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear proveedor");
        System.out.println("2. Modificar proveedor");
        System.out.println("3. Borrar proveedor");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> crearProveedor();
            case 2 -> modificarProveedor();
            // case 3 -> borrarProveedor();
        }
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
                System.out.println("El proveedor " + nombre + " con ID " + id + " y teléfono " + telefono
                        + " se ha creado correctamente");
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

    public void modificarProveedor() {
        int id;
        int opcion;

        System.out.println("ID del proveedor: ");
        id = sc.nextInt();

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
                proveedorDb.modificarNombreProveedor(id, nuevoNombre);
            }

            case 2 -> {
                System.out.println("Nuevo telefono: ");
                nuevoTelefono = sc.nextInt();
                proveedorDb.modificarTelefonoProveedor(id, nuevoTelefono); // Error porque telefono aqui es int y en el
                                                                           // DAO es String
            }

            case 3 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();

                System.out.println("Nuevo telefono:");
                nuevoTelefono = sc.nextInt();
                proveedorDb.modificarNombreProveedor(id, nuevoNombre);
                proveedorDb.modificarTelefonoProveedor(id, nuevoTelefono); // Mismo error que en el caso 2
            }

            case 4 -> menu();

            default -> System.out.println("Opcion no valida");
        }

    }

}
