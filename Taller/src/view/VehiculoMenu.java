package view;

import dao.VehiculoDB;
import java.util.Scanner;
import model.Vehiculo;

public class VehiculoMenu {
    Scanner sc = new Scanner(System.in);
    VehiculoDB vehiculoDB = new VehiculoDB();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear vehiculo");
        System.out.println("2. Modificar vehiculo");
        System.out.println("3. Borrar vehiculo");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> vehiculoDB.insertarVehiculo(crearVehiculo());
             case 2 -> modificarVehiculo();
             case 3 -> borrarVehiculo();
        }
    }

    public Vehiculo crearVehiculo() {
        String marca = "";
        String modelo = "";
        String matricula = "";
        String estado = "";
        boolean exito ;
        String respuesta = "";
        String dueño="";

        do {
            exito=false;
            try {
                System.out.println("Marca: ");
                marca = sc.next();

                System.out.println("Modelo: ");
                modelo = sc.next();

                System.out.println("Matrícula: ");
                matricula = sc.next();

                System.out.println("Estado: ");
                estado = sc.next();

                System.out.println("ID del dueño del vehiculo: ");
                dueño=sc.next();


                Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, estado, dueño);
                System.out.println("El vehículo " + marca + " " + modelo + " con matrícula " + matricula + " y estado "
                        + estado + " se ha creado correctamente");
                exito = true;

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

        System.out.println("El vehículo " + marca + " " + modelo + " con matrícula " + matricula + " y estado "
                        + estado + " se ha creado correctamente");
                return new Vehiculo(marca, modelo, respuesta, estado, dueño);
    }

    public void modificarVehiculo() {
        String id;
        int opcion;

        System.out.println("ID del vehiculo: ");
        id = sc.next();

        String nuevoEstado;

        System.out.println("Qué quieres modificar?");
        System.out.println("1. Estado");
        System.out.println("2. Salir");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo estado: ");
                nuevoEstado = sc.next();
                vehiculoDB.modificarEstadoVehiculo(id, nuevoEstado);
            }

            case 2 -> {
                menu();
            }

            default -> System.out.println("Opcion no valida");
        }

    }

}
