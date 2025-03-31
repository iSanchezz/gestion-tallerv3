package model;

public class Empleado {
    String id;
    String nombre;
    String puesto;
    double salario;

    public Empleado(String id, String nombre, String puesto, double salario) {
        this.id = id;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

}
