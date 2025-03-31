import dao.ClienteDB;
import dao.ConexionDB;
import dao.InsertarDB;
import java.sql.Connection;
import java.util.*;

import view.*;
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


    

        
        ClienteMenu cm = new ClienteMenu();
        EmpleadoMenu em = new EmpleadoMenu();
        ProductoMenu prodm = new ProductoMenu();
        ProveedorMenu provm = new ProveedorMenu();
        VehiculoMenu vm = new VehiculoMenu();
        ClienteDB clienteDB= new ClienteDB();   
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

                case 1 -> cm.menu();
                case 2 -> em.menu();   
                case 3 -> prodm.menu();
                case 4 -> provm.menu(); 
                case 5 -> vm.menu();
                case 6 -> continuar = true;
                  
            }
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

