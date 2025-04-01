package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehiculoDB {

    public void insertarVehiculo(model.Vehiculo vehiculo) {
        Connection conexion = dao.ConexionDB.conectar();

        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        String matricula = vehiculo.getId();
        String estado = vehiculo.getEstado();

        String query = "INSERT INTO vehiculos (marca, modelo, matricula, estado) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, matricula);
            stmt.setString(4, estado);

            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

    }

    public void modificarMarcaVehiculo(String id, String nuevamarca) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE vehiculos SET marca = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevamarca);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {
            System.out.println("error al actualizar datos");
        }

    }

    public void modificarModeloVehiculo(String id, String nuevomodelo) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE vehiculos SET modelo = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevomodelo);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {
            System.out.println("error al actualizar datos");
        }

    }

    public void modificarEstadoVehiculo(String id, String nuevoestado) { // Cambiar ID de Vehiculo a String
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE vehiculos SET estado = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevoestado);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {
            System.out.println("error al actualizar datos");
        }

    }
    public void borrarVehiculo(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query= "DELETE * FROM vehiculos WHERE id="+id;

        try(PreparedStatement stmt= conexion.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("los datos se han actualizado con exito");
        }catch(SQLException e){
            System.out.println("error al actualizar datos");

        }
    }
    public void mostrarVehiculos(){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM vehiculos";
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("Matricula: "+ rs.getString("matricula"));
                System.out.println("Marca: "+ rs.getString("marca"));
                System.out.println("Modelo: "+ rs.getString("modelo"));
                System.out.println("Estado: "+ rs.getString("estado"));
                System.out.println("-------------------------");

            }

        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
    public void mostrarVehiculosID(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM vehiculos WHERE id="+id;
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("Matricula: "+ rs.getString("matricula"));
                System.out.println("Marca: "+ rs.getString("marca"));
                System.out.println("Modelo: "+ rs.getString("modelo"));
                System.out.println("Estado: "+ rs.getString("estado"));
                System.out.println("-------------------------");
            }
            
        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
}
