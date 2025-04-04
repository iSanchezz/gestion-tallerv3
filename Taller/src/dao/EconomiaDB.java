package dao;

import java.sql.*;
import java.time.LocalDate;
import model.Transaccion;

public class EconomiaDB {
    
    public void insertarTransaccion(Transaccion transaccion) {

        int id=transaccion.getId();
        String tipo= transaccion.getTipo();
        Double cantidad=transaccion.getCantidad();
        String Descripcion= transaccion.getDescripcion();
        

        String query = "INSERT INTO transacciones (id, tipo, cantidad, descripcion, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            stmt.setString(2, tipo);
            stmt.setDouble(3, cantidad);
            stmt.setString(4, Descripcion);
            stmt.setTimestamp(5, Timestamp.valueOf(transaccion.getFecha()));
            
            stmt.executeUpdate();
            System.out.println("Transacción registrada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar transacción: " + e.getMessage());
        }
    }

    public double calcularBalance() {
        double ingresos = 0;
        double gastos = 0;
        
       
        String query = "SELECT SUM(cantidad) AS total FROM transacciones WHERE tipo = 'INGRESO'";
        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            if (rs.next()) {
                ingresos = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular ingresos: " + e.getMessage());
        }
        
        
        String sqlGastos = "SELECT SUM(cantidad) AS total FROM transacciones WHERE tipo = 'GASTO'";
        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlGastos)) {
            
            if (rs.next()) {
                gastos = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular gastos: " + e.getMessage());
        }
        
      
        return ingresos - gastos;
    }


    public void mostrarTransaccionesPorPeriodo(LocalDate inicio, LocalDate fin) {
        String query = "SELECT * FROM transacciones WHERE DATE(fecha) BETWEEN ? AND ? ORDER BY fecha DESC";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setDate(1, java.sql.Date.valueOf(inicio));
            stmt.setDate(2, java.sql.Date.valueOf(fin));
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Cantidad: " + rs.getDouble("cantidad"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Categoría: " + rs.getString("categoria"));
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar transacciones: " + e.getMessage());
        }
    }
} 