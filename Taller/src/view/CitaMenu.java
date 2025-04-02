package view;

import dao.CitaDB;
import dao.VehiculoDB;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import model.Cita;

public class CitaMenu {
    Scanner sc = new Scanner(System.in);
    Taller taller = new Taller();
    CitaDB citaDB = new CitaDB();
    VehiculoDB vehiculoDB = new VehiculoDB();

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

    public Cita crearCita() {
        int numeroCita;
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


                numeroCita = citaDB.generarNumCita();
                Cita cita = new Cita(numeroCita, fecha, hora, idVehiculo);
                exito=true;
                System.out.println("Se ha creado una cita el " + fecha + " a las " + hora + " con el cliente " + dueño);
                return cita;

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


    public void modificarCita() {
        LocalDate nuevaFecha;
        LocalTime nuevoHorario;
        int numeroCita;
        int opcion;
        int nuevoDia;
        int nuevoMes;
        int nuevoAño;
        int nuevaHora;
        int nuevosMinutos;


            System.out.println("Qué cita quieres modificar?");
            citaDB.mostrarCitasFuturo();
            numeroCita = sc.nextInt();

            System.out.println("Que quieres modificar?");
            System.out.println("1. Fecha");
            System.out.println("2. Hora");
            System.out.println("3. Todo");

            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("Dia: ");
                    nuevoDia = sc.nextInt();

                    System.out.println("Mes: ");
                    nuevoMes = sc.nextInt();

                    System.out.println("Año: ");
                    nuevoAño = sc.nextInt();

                    nuevaFecha = LocalDate.of(nuevoAño, nuevoMes, nuevoDia);
                    citaDB.modificarFechaCita(numeroCita, nuevaFecha);
                }
                case 2 -> {
                    System.out.println("Hora: ");
                    nuevaHora = sc.nextInt();

                    System.out.println("Minutos:");
                    nuevosMinutos = sc.nextInt();

                    nuevoHorario = LocalTime.of(nuevaHora, nuevosMinutos);
                    citaDB.modificarHoraCita(numeroCita, nuevoHorario);
                }
                case 3 -> {
                    System.out.println("Dia: ");
                    nuevoDia = sc.nextInt();

                    System.out.println("Mes: ");
                    nuevoMes = sc.nextInt();

                    System.out.println("Año: ");
                    nuevoAño = sc.nextInt();

                    System.out.println("Hora: ");
                    nuevaHora = sc.nextInt();

                    System.out.println("Minutos:");
                    nuevosMinutos = sc.nextInt();

                    nuevaFecha = LocalDate.of(nuevoAño, nuevoMes, nuevoDia);
                    citaDB.modificarFechaCita(numeroCita, nuevaFecha);

                    nuevoHorario = LocalTime.of(nuevaHora, nuevosMinutos);
                    citaDB.modificarHoraCita(numeroCita, nuevoHorario);

                }
            }
    }

    public void borrarCita() {
        int numeroCita;
        String respuesta;

        System.out.println("Numero de la Cita: ");
        numeroCita = sc.nextInt();

        System.out.println("La cita ");
        citaDB.mostrarCitasID(numeroCita);
        System.out.println("se borrara"); 
        System.out.println("Quieres continuar?");
        respuesta = sc.next();
        respuesta = respuesta.toLowerCase();

        if ("si".equals(respuesta)) {
            citaDB.borrarCita(numeroCita);
            System.out.println("La cita ha sido eliminada con éxito");

        } else { 
            System.out.println("Se ha cancelado la operación");
        }
        menu();

    }
}
