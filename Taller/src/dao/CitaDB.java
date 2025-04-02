package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

public class CitaDB {
    



public int generarNumCita(){
     Connection conexion = dao.ConexionDB.conectar();

    String query="SELECT MAX(numerocita) FROM citas";

     try(Statement stmt = conexion.createStatement();
            ResultSet rs=stmt.executeQuery(query)){
            
                   return rs.getInt(query);

            }catch(SQLException e){
                System.out.println("error al realizar la consulta"+ e.getMessage());
                
            }
            return 0;
    }

public void insertarCita(model.Cita cita){
    Connection conexion = dao.ConexionDB.conectar();

    int numerocita=cita.getNumeroCita();
    LocalDate fecha=cita.getFecha();    
    LocalTime hora=cita.getHora();
    String idvehiculo = cita.getIdVehiculo();


    String query = "INSERT INTO citas (numerocita, fecha, hora, idvehiculo) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, numerocita);
            stmt.setDate(2, java.sql.Date.valueOf(fecha));
            stmt.setTime(3, java.sql.Time.valueOf(hora));
            stmt.setString(4, idvehiculo);


            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

}
}