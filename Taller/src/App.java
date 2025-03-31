import dao.ClienteDB;
import dao.ConexionDB;
import dao.InsertarDB;
import java.sql.Connection;
import java.util.*;
import view.Taller;


public class App {

    InsertarDB insertar= new InsertarDB();
    Taller taller = new Taller();


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


    
        ClienteDB clienteDB= new ClienteDB();   
        Taller taller = new Taller();
        boolean continuar = false;

        do { 
            System.out.println("Menú principal");
            System.out.println("1. Clientes");
            System.out.println("2. Empleados");
            System.out.println("3. Proveedores");
            System.out.println("4. Inventario");
    
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> { 
                    System.out.println("Qué quieres hacer?");
                    System.out.println("1. Crear cliente");
                    System.out.println("2. Modificar cliente");
                    System.out.println("3. Borrar cliente cliente");
                    
                    opcion = sc.nextInt();
                        switch (opcion) {
                            case 1 -> 
                                   
                                       
                            //case 2 -> taller.modificarCliente();
                            //case 3 -> taller.borrarCliente();
                        }
                  
            }
                case 2 -> taller.crearEmpleado();
                            
                            
                case 3 -> taller.crearProveedor();
                //case 4 -> taller.crearInventario(); 
            }
        } while (!continuar);
     
    }
   
}
