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
        boolean exito;

        do {
            exito = false;
            try {
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                taller.menu();
            }
        } while (!exito);
    }

    public void registrarTransaccion(String tipo) {
        int id;
        double cantidad = 0;
        String descripcion;
        boolean exito;
        String respuesta;

        do {
            exito = false;
            try {
                System.out.println("ID: ");
                id = sc.nextInt();

                System.out.println("Cantidad: ");
                cantidad = sc.nextDouble();
                sc.nextLine();

                System.out.println("Descripción: ");
                descripcion = sc.nextLine();

                System.out.println("Se introducirá la fecha actual");

                Transaccion transaccion = new Transaccion(id, tipo, cantidad, descripcion);
                economiaDB.insertarTransaccion(transaccion);
                exito = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo?");
                respuesta = sc.next().toLowerCase();
                if (respuesta.equals("si")) {
                    sc.nextLine();
                } else {
                    exito = true;
                }
            }
        } while (!exito);

        System.out.println("Transacción registrada correctamente: " + tipo + " de " + cantidad + "€");
        menu();
    }

    public void mostrarBalance() {
        boolean exito;
        String respuesta;

        do {
            exito = false;
            try {
                double balance = economiaDB.calcularBalance();
                System.out.println("Balance actual: " + balance + "€");
                exito = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo? (si/no)");
                respuesta = sc.next().toLowerCase();
                if (respuesta.equals("si")) {
                    sc.nextLine();
                } else {
                    exito = true;
                }
            }
        } while (!exito);
        menu();
    }

    public void mostrarTransacciones() {
        int dia;
        int mes;
        int año;
        LocalDate inicio;
        LocalDate fin;
        boolean exito;
        String respuesta;

        do {
            exito = false;
            try {
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
                exito = true;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("¿Quieres volver a intentarlo? (si/no)");
                respuesta = sc.next().toLowerCase();
                if (respuesta.equals("si")) {
                    sc.nextLine();
                } else {
                    exito = true;
                }
            }
        } while (!exito);
        menu();
    }
}