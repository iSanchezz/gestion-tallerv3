package view;
import dao.ConexionDB;
import java.sql.Connection;
import java.util.Scanner;

public class Taller {
    public void menu() {

        Connection conexion = ConexionDB.conectar();
        Scanner sc = new Scanner(System.in);
        int opcion;
        if (conexion != null) {

            System.out.println("Exito al conectar");
        }

        if (conexion == null) {

             System.out.println("Error al conectar");
        }

        ClienteMenu menuCliente = new ClienteMenu();
        EmpleadoMenu menuEmpleado = new EmpleadoMenu();
        ProductoMenu menuProducto = new ProductoMenu();
        ProveedorMenu menuProveedor = new ProveedorMenu();
        VehiculoMenu menuVehiculo = new VehiculoMenu();
        CitaMenu menuCita = new CitaMenu();
        EconomiaMenu menuEconomia = new EconomiaMenu();
       
        boolean continuar = false;

        do {
            System.out.println("Menú principal");
            System.out.println("1. Clientes");
            System.out.println("2. Empleados");
            System.out.println("3. Proveedores");
            System.out.println("4. Inventario");
            System.out.println("5. Vehiculo");
            System.out.println("6. Citas");
            System.out.println("7. Economía");
            System.out.println("8. Salir");

            opcion = sc.nextInt();
            switch (opcion) {

                case 1 -> menuCliente.menu();
                case 2 -> menuEmpleado.menu();
                case 3 -> menuProveedor.menu();
                case 4 -> menuProducto.menu();
                case 5 -> menuVehiculo.menu();
                case 6 -> menuCita.menu();
                case 7 -> menuEconomia.menu();
                case 8 -> continuar = true;

            }

        } while (!continuar);
    }
}