package view;

import dao.CitaDB;
import java.util.Scanner;

public class CitaMenu {
    Scanner sc = new Scanner(System.in);
    CitaDB citaDB = new CitaDB();

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
    
}
