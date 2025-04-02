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
    LocalDate  fecha=cita.getFecha();
    LocalTime hora=cita.getHora();
    String idvehiculo=cita.getIdVehiculo();


    String query = "INSERT INTO citas (numerocita, fecha, hora, idvehiculo) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, numerocita);
            stmt.setDate(2, java.sql.Date.valueOf(fecha));
            stmt.setTime(3, java.sql.Time.valueOf(hora));
            stmt.setString(4, idvehiculo);

            stmt.executeUpdate();
            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }
}
public void modificarFechaCita(int numerocita, LocalDate nuevafecha){

    Connection conexion= dao.ConexionDB.conectar();

    String query="UPDATE citas SET fecha = ? WHERE numerocita="+numerocita;

    try(PreparedStatement stmt= conexion.prepareStatement(query)){

        stmt.setDate(2, java.sql.Date.valueOf(nuevafecha));
        System.out.println("los datos se han actualizado con exito");

        stmt.executeUpdate();

    }catch(SQLException e){
        System.out.println("error al actualizar datos");
    }
}
public void modificarHoraCita(int numerocita, LocalTime nuevahora){

    Connection conexion= dao.ConexionDB.conectar();

    String query="UPDATE citas SET hora = ? WHERE numerocita="+numerocita;

    try(PreparedStatement stmt= conexion.prepareStatement(query)){

        stmt.setTime(2, java.sql.Time.valueOf(nuevahora));
        stmt.executeUpdate();

        System.out.println("los datos se han actualizado con exito");


    }catch(SQLException e){
        System.out.println("error al actualizar datos");
    }
}
public void borrarCita(int numeroCita){

    Connection conexion= dao.ConexionDB.conectar();

    String query= "DELETE * FROM citas WHERE id="+numeroCita;

    try(PreparedStatement stmt= conexion.prepareStatement(query)){
        stmt.executeUpdate();
        System.out.println("los datos se han actualizado con exito");
    }catch(SQLException e){
        System.out.println("error al actualizar datos");

    }
}
public void mostrarCitasFuturo(){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM citas WHERE fecha >= CURDATE()";
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("Numero: "+ rs.getInt("numerocita"));
            System.out.println("Nombre: "+ rs.getDate("fecha"));
            System.out.println("Telefono: "+ rs.getTime("hora"));
            System.out.println("Telefono: "+ rs.getString("idvehiculo"));

            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}
public void mostrarCitasPasado(){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM citas WHERE fecha < CURDATE()";
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("Numero: "+ rs.getInt("numerocita"));
            System.out.println("Nombre: "+ rs.getDate("fecha"));
            System.out.println("Telefono: "+ rs.getTime("hora"));
            System.out.println("Telefono: "+ rs.getString("idvehiculo"));

            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}
public void mostrarCitasHoy(){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM citas WHERE fecha = CURDATE()";
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("Numero: "+ rs.getInt("numerocita"));
            System.out.println("Nombre: "+ rs.getDate("fecha"));
            System.out.println("Telefono: "+ rs.getTime("hora"));
            System.out.println("Telefono: "+ rs.getString("idvehiculo"));

            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}

public void mostrarCitasID(int numerocita){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM citas WHERE numerocita="+ numerocita;
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("Numero: "+ rs.getInt("numerocita"));
            System.out.println("Nombre: "+ rs.getDate("fecha"));
            System.out.println("Telefono: "+ rs.getTime("hora"));
            System.out.println("Telefono: "+ rs.getString("idvehiculo"));

            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}
}