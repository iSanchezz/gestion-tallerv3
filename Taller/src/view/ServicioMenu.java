package view;

import java.util.Scanner;
import dao.ServiciosDB;
import model.Servicios;

public class ServicioMenu {
    Scanner sc = new Scanner(System.in);
    ServiciosDB serviciosDB = new ServiciosDB();
    Taller taller = new Taller();

    public void menu() {
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Registrar nuevo servicio");
        System.out.println("2. Mostrar servicios");
        System.out.println("3. Buscar servicio");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {
            case 1 -> registrarServicio();
            case 2 -> mostrarServicios();
            case 3 -> buscarServicio();
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

    public void registrarServicio() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        
        System.out.print("ID del Empleado: ");
        String idEmpleado = sc.next();

        System.out.print("ID del Cliente: ");
        String idCliente = sc.next();
        
        System.out.print("ID del vehiculo: ");
        String idVehiculo = sc.next();
        sc.nextLine();

        System.out.println("Numero de cita: ");
        int numeroCita = sc.nextInt();

        System.out.println("Precio del servicio: ");
        double precio = sc.nextDouble();

        System.out.println("Descripcion del servicio: ");
        String descripcion = sc.nextLine();
        
        Servicios servicio = new Servicios(id, idEmpleado, idCliente, idVehiculo, numeroCita, precio, descripcion);
        serviciosDB.insertarServicio(servicio);
        
        System.out.println("Servicio registrado correctamente");
        menu();
    }

    public void mostrarServicios() {
        serviciosDB.mostrarServicios();
        menu();
    }

    public void buscarServicio() {
        System.out.print("Introduce el ID del servicio: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        serviciosDB.mostrarServiciosID(id);
        menu();
    }


    public void borrarServicio() {
        System.out.println("Qué introduce la ID del servicio a borrar");
        int id = sc.nextInt();
        String respuesta;

        System.out.println("El servicio ");
        serviciosDB.mostrarServiciosID(id);
        System.out.println("se borrará.");
        System.out.println("Quieres continuar?");

        respuesta = sc.next();
        respuesta =  respuesta.toLowerCase();

        if (respuesta.equals("si")) {
            serviciosDB.borrarServicio(id);
            System.out.println("El servicio se ha borrado correctamente");
        
        } else {
            System.out.println("Se ha cancelado la operacion");
        }   
        menu();
    }
}
