package view;

import dao.EmpleadoDB;
import java.util.*;
import model.Empleado;

public class EmpleadoMenu {
    Scanner sc = new Scanner(System.in);
    EmpleadoDB empleadoDB = new EmpleadoDB();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Crear empleado");
        System.out.println("2. Modificar empleado");
        System.out.println("3. Borrar empleado");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> empleadoDB.insertarEmpleado(crearEmpleado());
            case 2 -> modificarEmpleado();
            // case 3 -> borrarEmpleado();
            // case 4 -> Salir no implementado
        }
    }

    public Empleado crearEmpleado() {
        String id = "";
        String nombre = "";
        String puesto = "";
        double salario = 0;
        boolean exito;
        String respuesta;

        do {
                exito=false;
            try {
                System.out.println("ID: ");
                id = sc.next();

                System.out.println("Nombre: ");
                nombre = sc.next();

                System.out.println("Puesto: ");
                puesto = sc.next();

                System.out.println("Salario: ");
                salario = sc.nextDouble();

               
            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {
                    exito=true;
                } else {
                    return null;
                }
            }
        } while (exito);
        System.out.println("El empleado " + nombre + " con ID " + id + ", puesto " + puesto + " y salario "+ salario + " se ha creado correctamente");
        return new Empleado(id, nombre, puesto, salario);

    }

    public void modificarEmpleado() {
        String id;
        int opcion;

        System.out.println("ID del empleado: ");
        id = sc.next();

        String nuevoNombre;
        String nuevoPuesto;
        double nuevoSalario;

        System.out.println("Qué quieres modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Puesto");
        System.out.println("3. Salario");
        System.out.println("4. Todo");
        System.out.println("5. Salir");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();
                empleadoDB.modificarNombreEmpleado(id, nuevoNombre);
            }

            case 2 -> {
                System.out.println("Nuevo puesto: ");
                nuevoPuesto = sc.next();
                empleadoDB.modificarPuestoEmpleado(id, nuevoPuesto);
            }

            case 3 -> {
                System.out.println("Nuevo Salario: ");
                nuevoSalario = sc.nextDouble();
                empleadoDB.modificarSalarioEmpleado(id, nuevoSalario);
            }

            case 4 -> {
                System.out.println("Nuevo nombre: ");
                nuevoNombre = sc.next();

                System.out.println("Nuevo puesto:");
                nuevoPuesto = sc.next();

                System.out.println("Nuevo salario: ");
                nuevoSalario = sc.nextDouble();

                empleadoDB.modificarNombreEmpleado(id, nuevoNombre);
                empleadoDB.modificarPuestoEmpleado(id, nuevoPuesto);
                empleadoDB.modificarSalarioEmpleado(id, nuevoSalario);
            }

            case 5 -> menu();

            default -> System.out.println("Opcion no valida");
        }

    }

    public void borrarEmpleado() {
        String id;
        String respuesta;

        System.out.println("ID del empleado: ");
        id = sc.next();

        System.out.println("El empleado " + empleadoDB.empleadoByID(id) + " se borrará.");
        System.out.println("Quieres continuar?");
        respuesta = sc.next();
        respuesta = respuesta.toLowerCase();

        if ("si".equals(respuesta)) {
            empleadoDB.borrarEmpleado(id);
            System.out.println("El empleado ha sido eliminado con éxito");

        } else { 
            System.out.println("Se ha cancelado la operación");
        }
        menu();
    }

}
