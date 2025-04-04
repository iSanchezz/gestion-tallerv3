package dao;

import java.sql.*;
import java.time.LocalDate;
import model.Transaccion;

public class EconomiaDB {
    
    public void insertarTransaccion(Transaccion transaccion) {
        String sql = "INSERT INTO transacciones (id, tipo, cantidad, descripcion, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, transaccion.getId());
            pstmt.setString(2, transaccion.getTipo());
            pstmt.setDouble(3, transaccion.getCantidad());
            pstmt.setString(4, transaccion.getDescripcion());
            pstmt.setTimestamp(5, Timestamp.valueOf(transaccion.getFecha()));
            
            pstmt.executeUpdate();
            System.out.println("Transacción registrada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar transacción: " + e.getMessage());
        }
    }

    public double calcularBalance() {
        double ingresos = 0.0;
        double gastos = 0.0;
        
        // Calcular ingresos
        String sqlIngresos = "SELECT SUM(cantidad) AS total FROM transacciones WHERE tipo = 'INGRESO'";
        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlIngresos)) {
            
            if (rs.next()) {
                ingresos = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular ingresos: " + e.getMessage());
        }
        
        // Calcular gastos
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
        
        // Calcular balance final
        return ingresos - gastos;
    }


    public void mostrarTransaccionesPorPeriodo(LocalDate inicio, LocalDate fin) {
        String sql = "SELECT * FROM transacciones WHERE DATE(fecha) BETWEEN ? AND ? ORDER BY fecha DESC";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, java.sql.Date.valueOf(inicio));
            pstmt.setDate(2, java.sql.Date.valueOf(fin));
            ResultSet rs = pstmt.executeQuery();
            
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