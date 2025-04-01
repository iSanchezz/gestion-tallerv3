package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedorDb {

    public void insertarProveedor(model.Proveedor proveedor) {
        Connection conexion = dao.ConexionDB.conectar();

        int id = proveedor.getId();
        String nombre = proveedor.getNombre();
        int telefono = proveedor.getTelefono();

        String query = "INSERT INTO proveedores (id, nombre, telefono) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

    }

    public void modificarNombreProveedor(int id, String nuevonombre) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE proveedores SET nombre = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevonombre);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {
            System.out.println("error al actualizar datos");
        }

    }

    public void modificarTelefonoProveedor(int id, int nuevotelefono) {
        Connection conexion = dao.ConexionDB.conectar();

        String query = "UPDATE proveedores SET telefono = ? WHERE id=" + id;

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, nuevotelefono);

            System.out.println("los datos se han actualizado con exito");

        } catch (SQLException e) {

            System.out.println("error al alcuatilizar datos");

        }
    }
}
