import dao.ConexionDB;
import java.sql.Connection;
import java.util.*;
import model.Proveedor;
import view.*;
public class App {

    public static void main(String[] args) {

        Connection conexion= ConexionDB.conectar();
        Scanner sc = new Scanner(System.in);
        int opcion;
        if(conexion !=null) {

            System.out.println("exito al conectar");
        }

        if(conexion == null){

            System.out.println("error al conectar");
        }


    
        
        Taller taller = new Taller();
        boolean continuar = false;

        do { 
            System.out.println("Menú principal");
            System.out.println("1. Clientes");
            System.out.println("2. Empleados");
            System.out.println("3. Proveedores");
            System.out.println("4. Inventario");
            System.out.println("5. Vehiculo");
            System.out.println("6. Salir");
    
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> ClienteMenu.menu();
                case 2 -> EmpleadoMenu.menu();   
                case 3 -> ProveedorMenu.menu();
                case 4 -> ProductoMenu.menu(); 
                case 5 -> VehiculoMenu.menu();
                case 6 -> continuar = true;
                  
            }
        } while (!continuar);
    } 
     
}

