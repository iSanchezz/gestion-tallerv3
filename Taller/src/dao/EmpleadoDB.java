package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmpleadoDB {
    

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

        public void modificarNombreEmpleado(int id, String nuevonombre){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET nombre = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevonombre);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarPuestoEmpleado(int id, String nuevopuesto){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET puesto = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevopuesto);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarSalarioEmpleado(int id, Double nuevosalario){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET salario = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setDouble(1, nuevosalario);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
}


