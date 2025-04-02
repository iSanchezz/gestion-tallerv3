package view;

import dao.CitaDB;
import model.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import dao.ClienteDB;
import java.util.Scanner;
import dao.VehiculoDB;

public class CitaMenu {
    Scanner sc = new Scanner(System.in);
    CitaDB citaDB = new CitaDB();
    VehiculoDB vehiculoDB = new VehiculoDB();
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
            // case 4 -> Salir no implementado;
        }
    }    

    public Cita crearCita() { //Hay que implementar un metodo que devuelva el dueño del vehiculo
        int numeroCita = 0;
        boolean exito;
        LocalDate fecha;
        LocalTime hora;
        int año;
        int mes;
        int dia;
        int horas;
        int minutos;
        String respuesta;
        String idVehiculo;
        String dueño;

        do {
            try {
                System.out.println("ID del vehiculo: ");
                vehiculoDB.mostrarVehiculos();
                idVehiculo = sc.next();
                dueño = vehiculoDB.mostrarDueñoVehiculo(idVehiculo);

                System.out.println("Dia: ");
                dia = sc.nextInt();

                System.out.println("Mes: ");
                mes = sc.nextInt();

                System.out.println("Año: ");
                año = sc.nextInt();


                System.out.println("Hora: ");
                horas = sc.nextInt();

                System.out.println("Minutos: ");
                minutos = sc.nextInt();

                fecha = LocalDate.of(año, mes, dia);
                hora = LocalTime.of(horas, minutos);

                Cita cita = new Cita(numeroCita, fecha, hora, idVehiculo);
                exito=true;
                System.out.println("Se ha creado una cita el " + fecha + " a las " + hora + " con el cliente " + dueño);
                return new Cita(numeroCita, fecha, hora, idVehiculo);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Quieres volver a intentarlo?");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase();
                if (respuesta.equals("si")) {     
                } else {
                    exito=true;
                }
                return null;
            }
        } while (!exito);    
    }
}
