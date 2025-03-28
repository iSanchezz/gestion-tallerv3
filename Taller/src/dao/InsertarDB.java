package dao;

import java.sql.*;

public class InsertarDB {
    public static void agregarCliente(String nombre, String telefono, String direccion) {
        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
        String query = "INSERT INTO clientes (nombre, telefono, direccion) VALUES (?, ?, ?)";

            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre); // Asigna el valor del nombre
            stmt.setString(2, telefono); // Asigna el valor del teléfono
            stmt.setString(3, direccion); // Asigna la dirección
            stmt.executeUpdate(); // Ejecuta la consulta de inserción
            System.out.println("Cliente agregado exitosamente.");
            
            } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
            }
        }
    }

}
