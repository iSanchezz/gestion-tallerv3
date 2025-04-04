package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServiciosDB {

    public void insertarServicio(model.Servicios servicio){
    Connection conexion = dao.ConexionDB.conectar();
    int id=servicio.getId();
    int numerocita=servicio.getNumeroCita();
    String idEmpleado=servicio.getidEmpleado();
    String idCliente=servicio.getidCliente();
    String idVehiculo=servicio.getidVehiculo();
    int numeroCita=servicio.getNumeroCita();
    double precio=servicio.getprecio();
    String descripcion=servicio.getDescripcion();



    String query = "INSERT INTO servicios (id, idempleado, idcliente, idvehiculo, numemrocita, precio, descripcion) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, idEmpleado);
            stmt.setString(3, idCliente);
            stmt.setString(4, idVehiculo);
            stmt.setInt(5, numeroCita);
            stmt.setDouble(6, precio);
            stmt.setString(7, descripcion
            );

            stmt.executeUpdate();
            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }
}

}
