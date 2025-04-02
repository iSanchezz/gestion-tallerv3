package view;

import dao.ProveedorDB;
import java.util.Scanner;
import model.Proveedor;

public class ProveedorMenu {
    Scanner sc = new Scanner(System.in);
    ProveedorDB proveedorDB = new ProveedorDB();
    Taller taller = new Taller();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear proveedor");
        System.out.println("2. Modificar proveedor");
        System.out.println("3. Borrar proveedor");
        System.out.println("4. Salir");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> proveedorDB.insertarProveedor(crearProveedor());
            case 2 -> modificarProveedor();
            case 3 -> borrarProveedor();
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

    public Proveedor crearProveedor() {
        String id = "";
        String nombre = "";
        int telefono = 0;
        boolean exito;
        String respuesta = "";

        do {
            exito=false;
            try {
                System.out.println("ID: ");
                id = sc.next();

                System.out.println("Nombre: ");
                nombre = sc.next();

                System.out.println("Teléfono: ");
                telefono = sc.nextInt();

               
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                    exito=true;
                } else {
                  return null;
                }
            }
        } while (exito);
        System.out.println("El proveedor " + nombre + " con ID " + id + " y teléfono " + telefono
                        + " se ha creado correctamente");
                return new Proveedor(id, nombre, telefono);

    }

    public void modificarProveedor() {
        String id;
        int opcion;

        System.out.println("ID del proveedor: ");
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
                proveedorDB.modificarNombreProveedor(id, nuevoNombre);
            }

            case 2 -> {
                System.out.println("Nuevo telefono: ");
                nuevoTelefono = sc.nextInt();
                proveedorDB.modificarTelefonoProveedor(id, nuevoTelefono); // Error porque telefono aqui es int y en el
                                                                           // DAO es String
            }

            case 3 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();

                System.out.println("Nuevo telefono:");
                nuevoTelefono = sc.nextInt();
                proveedorDB.modificarNombreProveedor(id, nuevoNombre);
                proveedorDB.modificarTelefonoProveedor(id, nuevoTelefono); // Mismo error que en el caso 2
            }

            case 4 -> menu();

            default -> System.out.println("Opcion no valida");
        }

    }

    public void borrarProveedor() {
        String id;
        String respuesta;

        System.out.println("ID del proveedor: ");
        id = sc.next();

        System.out.println("El proveedor ");
        proveedorDB.mostrarProveedoresID(id);
        System.out.println(" se borrará.");
        System.out.println("Quieres continuar?");
        respuesta = sc.next();
        respuesta = respuesta.toLowerCase();

        if ("si".equals(respuesta)) {
            proveedorDB.borrarProveedor(id);
            System.out.println("El proveedor ha sido eliminado con éxito");

        } else { 
            System.out.println("Se ha cancelado la operación");
        }
        menu();
    }

}
