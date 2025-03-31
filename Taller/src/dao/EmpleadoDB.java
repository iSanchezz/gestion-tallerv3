package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Empleado {
    

    public void insertarEmpleado(model.Empleado empleado){
        Connection conexion= dao.ConexionDB.conectar();

            String id= empleado.getId();
            String nombre= empleado.getNombre();
            String puesto=empleado.getPuesto();
            double salario=empleado.getSalario();

            String query="INSERT INTO empleados (id, nombre, puesto, salario) VALUES (?,?,?,?)";

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, id);
                stmt.setString(2, nombre);
                stmt.setString(3, puesto);
                stmt.setDouble(4, salario);
    
                System.out.println("los datos se han introducido con exito");

            }catch(SQLException e){
                System.out.println("error al introducir datos");

                }


        }
}
