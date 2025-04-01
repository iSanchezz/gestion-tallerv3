package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        public void modificarNombreEmpleado(String id, String nuevonombre){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET nombre = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevonombre);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarPuestoEmpleado(String id, String nuevopuesto){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET puesto = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevopuesto);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarSalarioEmpleado(String id, Double nuevosalario){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE empleados SET salario = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setDouble(1, nuevosalario);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }
        }
        public void borrarEmpleado(String id){

            Connection conexion= dao.ConexionDB.conectar();
    
            String query= "DELETE * FROM empleados WHERE id="+id;
    
            try(PreparedStatement stmt= conexion.prepareStatement(query)){
                stmt.executeUpdate();
                System.out.println("los datos se han actualizado con exito");
            }catch(SQLException e){
                System.out.println("error al actualizar datos");
    
            }
        }
        public void mostrarEmpleados(){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM empleados";
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getString("id"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Puesto: "+ rs.getString("puesto"));
                System.out.println("Salario: "+ rs.getDouble("salario"));
                System.out.println("-------------------------");

            }

        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
    public void mostrarEmpleadosID(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM empleados WHERE id="+id;
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getString("id"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Puesto: "+ rs.getString("puesto"));
                System.out.println("Salario: "+ rs.getDouble("salario"));
                System.out.println("-------------------------");

            }
            
        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
}


