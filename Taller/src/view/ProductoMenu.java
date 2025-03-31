package view;

import java.util.Scanner;

public class ProductoMenu {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
                    System.out.println("1. Crear producto");
                    System.out.println("2. Modificar producto");
                    System.out.println("3. Borrar producto");
                    
                    opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> crearProducto();
                            //case 2 -> modificarProducto();
                            //case 3 -> borrarProducto();
                        }

    }
    
}
