package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedorDB {

    public void insertarProveedor(model.Proveedor proveedor) {
        Connection conexion = dao.ConexionDB.conectar();

        String id = proveedor.getId();
        String nombre = proveedor.getNombre();
        int telefono = proveedor.getTelefono();

        String query = "INSERT INTO proveedores (id, nombre, telefono) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

    }

    public void modificarNombreProveedor(String id, String nuevonombre) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE proveedores SET nombre = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevonombre);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {
            System.out.println("error al actualizar datos");
        }

    }

    public void modificarTelefonoProveedor(String id, int nuevotelefono) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE proveedores SET telefono = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, nuevotelefono);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {

            System.out.println("error al alcuatilizar datos");

        }
    }
    public void borrarProveedor(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query= "DELETE * FROM proveedores WHERE id="+id;

        try(PreparedStatement stmt= conexion.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("los datos se han actualizado con exito");
        }catch(SQLException e){
            System.out.println("error al actualizar datos");

        }
    }
}
