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
        String sql = "SELECT SUM(CASE WHEN tipo = 'INGRESO' THEN cantidad ELSE -cantidad END) AS balance FROM transacciones";
        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular balance: " + e.getMessage());
        }
        return 0.0;
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

    public double calcularIngresosPorPeriodo(LocalDate inicio, LocalDate fin) {
        String sql = "SELECT SUM(cantidad) AS total FROM transacciones WHERE tipo = 'INGRESO' AND DATE(fecha) BETWEEN ? AND ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, java.sql.Date.valueOf(inicio));
            pstmt.setDate(2, java.sql.Date.valueOf(fin));
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular ingresos: " + e.getMessage());
        }
        return 0.0;
    }

    public double calcularGastosPorPeriodo(LocalDate inicio, LocalDate fin) {
        String sql = "SELECT SUM(cantidad) AS total FROM transacciones WHERE tipo = 'GASTO' AND DATE(fecha) BETWEEN ? AND ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, java.sql.Date.valueOf(inicio));
            pstmt.setDate(2, java.sql.Date.valueOf(fin));
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular gastos: " + e.getMessage());
        }
        return 0.0;
    }
} 