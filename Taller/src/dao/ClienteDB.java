package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDB {

    public void insertarCliente(model.Cliente cliente) {
        Connection conexion = dao.ConexionDB.conectar();

        String id = cliente.getId();
        String nombre = cliente.getNombre();
        int telefono = cliente.getTelefono();

        String query = "INSERT INTO clientes (id, nombre, telefono) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

    }

}
