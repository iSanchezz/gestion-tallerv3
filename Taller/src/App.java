
import dao.ConexionDB;
import java.sql.Connection;
import java.util.*;
import view.*;

public class App {

    
   

    public static void main(String[] args) {

        Connection conexion = ConexionDB.conectar();
        Scanner sc = new Scanner(System.in);
        int opcion;
        if (conexion != null) {

            System.out.println("exito al conectar");
        }

        if (conexion == null) {

            System.out.println("error al conectar");
        }

        ClienteMenu cm = new ClienteMenu();
        EmpleadoMenu em = new EmpleadoMenu();
        ProductoMenu prodm = new ProductoMenu();
        ProveedorMenu provm = new ProveedorMenu();
        VehiculoMenu vm = new VehiculoMenu();
        
       
        boolean continuar = false;

        do {
            System.out.println("Menú principal");
            System.out.println("1. Clientes");
            System.out.println("2. Empleados");
            System.out.println("3. Proveedores");
            System.out.println("4. Inventario");
            System.out.println("5. Vehiculo");
            System.out.println("7. Salir");

            opcion = sc.nextInt();
            switch (opcion) {

                case 1 -> menuCliente.menu();
                case 2 -> menuEmpleado.menu();
                case 3 -> menuProducto.menu();
                case 4 -> menuProveedor.menu();
                case 5 -> menuVehiculo.menu();
                case 6 -> menuCita.menu();
                case 7 -> continuar = true;

            }

        } while (!continuar);
    }

}
