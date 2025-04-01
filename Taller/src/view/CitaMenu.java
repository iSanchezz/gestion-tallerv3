package view;

import dao.CitaDB;
import model.Cita;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

import java.util.Scanner;

public class CitaMenu {
    Scanner sc = new Scanner(System.in);
    CitaDB citaDB = new CitaDB();
    int totalCitas;

    public void menu() {
        int opcion;

        System.out.println("1. Solicitar cita");
        System.out.println("2. Modificar cita");
        System.out.println("3. Cancelar cita");
        System.out.println("4. Salir");

        opcion = sc.nextInt();

        switch(opcion) {
            case 1 -> crearCita();
            case 2 -> modificarCita();
            case 3 -> borrarCita();
        }
    }    

    public Cita crearCita() {
        boolean exito;
        LocalDate fecha;
        LocalDateTime hora;
        int año;
        int mes;
        int dia;

        do {
            exito =false;
            try {
                System.out.println("Dia: ");
                dia = sc.nextInt();

                System.out.println("Mies: ");
                mes = sc.nextInt();

                System.out.println("Año: ");
                año = sc.nextInt();

                System.out.println("Fecha: ");
                fecha = LocalDate.of(año, mes, dia);



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
        System.out.println("El cliente " + nombre + " con ID " + id + " y telefono " + telefono+ " se ha creado correctamente");
        return new Cliente(id, nombre, telefono);


    }
}
