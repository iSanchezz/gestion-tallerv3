package view;

import dao.ProductoDB;
import java.util.Scanner;
import model.Producto;

public class ProductoMenu {
    Scanner sc = new Scanner(System.in);
    ProductoDB productoDB = new ProductoDB();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Borrar producto");
        System.out.println("4. Salir");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> crearProducto();
            case 2 -> modificarProducto();
            case 3 -> borrarProducto();
            // case 4 -> Salir no implementado
        }

    }

    public void crearProducto() {
        String id;
        String nombre;
        double precio;

        System.out.println("ID: ");
        id = sc.next();

        System.out.println("Nombre: ");
        nombre = sc.next();

        System.out.println(" Precio: ");
        precio = sc.nextDouble();

        Producto producto = new Producto(id, nombre, precio);
        productoDB.insertaProducto(producto);

    }

    public void modificarProducto() {
        String id;
        int opcion;
        System.out.println("ID del producto: ");
        id = sc.next();
        String nuevoNombre;
        double nuevoPrecio;

        System.out.println("Qué quieres modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Precio");
        System.out.println("3. Todo");
        System.out.println("4. Salir");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();
                productoDB.modificarNombreProducto(id, nuevoNombre);
            }

            case 2 -> {
                System.out.println("Nuevo precio: ");
                nuevoPrecio = sc.nextDouble();
                productoDB.modificarPrecioProducto(id, nuevoPrecio);
            }

            case 3 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();

                System.out.println("Nuevo precio:");
                nuevoPrecio = sc.nextDouble();
                productoDB.modificarNombreProducto(id, nuevoNombre);
                productoDB.modificarPrecioProducto(id, nuevoPrecio);
            }

            case 4 -> menu();

            default -> System.out.println("Opcion no valida");
        }

    }

    public void borrarProducto() {
        String id;
        String respuesta;

        System.out.println("ID del producto: ");
        id = sc.next();

        System.out.println("El producto " + productoDB.productoByID(id) + " se borrará.");
        System.out.println("Quieres continuar?");
        respuesta = sc.next();
        respuesta = respuesta.toLowerCase();

        if ("si".equals(respuesta)) {
            productoDB.borrarProducto(id);
            System.out.println("El producto ha sido eliminado con éxito");

        } else { 
            System.out.println("Se ha cancelado la operación");
        }
        menu();
    }

}
