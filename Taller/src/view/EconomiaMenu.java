package view;

import dao.EconomiaDB;
import java.time.LocalDate;
import java.util.Scanner;
import model.Transaccion;

public class EconomiaMenu {
    Scanner sc = new Scanner(System.in);
    EconomiaDB economiaDB = new EconomiaDB();
    Taller taller = new Taller();

    public void menu() {
        int opcion;
        System.out.println("Qué quieres hacer?");
        System.out.println("1. Registrar ingreso");
        System.out.println("2. Registrar gasto");
        System.out.println("3. Ver balance actual");
        System.out.println("4. Ver transacciones por periodo");
        System.out.println("5. Salir");

        opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> registrarTransaccion("INGRESO");
            case 2 -> registrarTransaccion("GASTO");
            case 3 -> mostrarBalance();
            case 4 -> mostrarTransacciones();
            case 5 -> {
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

    public void registrarTransaccion(String tipo) {
        int id;
        double cantidad;
        String descripcion;

        System.out.println("Qué quieres hacer?");
        System.out.println("ID: ");
        id = sc.nextInt();
        
        System.out.println("Cantidad: ");
        cantidad = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Descripción: ");
        descripcion = sc.nextLine();
        
        Transaccion transaccion = new Transaccion(id, tipo, cantidad, descripcion);
        economiaDB.insertarTransaccion(transaccion);
        menu();
    }

    public void mostrarBalance() {
        double balance = economiaDB.calcularBalance();
        System.out.println("Balance actual: " + balance + "€");
        menu();
    }

    public void mostrarTransacciones() {
        int dia;
        int mes;
        int año;
        LocalDate inicio;
        LocalDate fin;
        
        System.out.println("Fecha inicio:");
        System.out.println("Día: ");
        dia = sc.nextInt();
        System.out.println("Mes: ");
        mes = sc.nextInt();
        System.out.println("Año: ");
        año = sc.nextInt();
        inicio = LocalDate.of(año, mes, dia);
        
        System.out.println("Fecha fin:");
        System.out.println("Día: ");
        dia = sc.nextInt();
        System.out.println("Mes: ");
        mes = sc.nextInt();
        System.out.println("Año: ");
        año = sc.nextInt();
        fin = LocalDate.of(año, mes, dia);
        
        economiaDB.mostrarTransaccionesPorPeriodo(inicio, fin);
        menu();
    }

} 