package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
public void borrarServicio(int idServicio){

    Connection conexion= dao.ConexionDB.conectar();

    String query= "DELETE * FROM servicios WHERE id="+idServicio;

    try(PreparedStatement stmt= conexion.prepareStatement(query)){
        stmt.executeUpdate();
        System.out.println("los datos se han actualizado con exito");
    }catch(SQLException e){
        System.out.println("error al actualizar datos");

    }
}
public void mostrarServicios(){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM servicios";
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("ID: "+ rs.getString("id"));
            System.out.println("Empleado: "+ rs.getString("idempleado"));
            System.out.println("Cliente: "+ rs.getDouble("idcliente"));
            System.out.println("Vehiculo: "+ rs.getDouble("idvehiculo"));
            System.out.println("Cita: "+ rs.getDouble("numerocita"));
            System.out.println("Precio: "+ rs.getDouble("precio"));
           
            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}
public void mostrarServiciosID(int idservicio){

    Connection conexion= dao.ConexionDB.conectar();

    String query="SELECT * FROM servicios WHERE id= "+idservicio; 
    try(Statement stmt = conexion.createStatement();
    ResultSet rs=stmt.executeQuery(query)){
        
        while(rs.next()){
            System.out.println("ID: "+ rs.getString("id"));
            System.out.println("Empleado: "+ rs.getString("idempleado"));
            System.out.println("Cliente: "+ rs.getDouble("idcliente"));
            System.out.println("Vehiculo: "+ rs.getDouble("idvehiculo"));
            System.out.println("Cita: "+ rs.getDouble("numerocita"));
            System.out.println("Precio: "+ rs.getDouble("precio"));
            System.out.println("Descrippcion: "+ rs.getDouble("descripcion"));
            System.out.println("-------------------------");

        }

    }catch(SQLException e){
        System.out.println("error al realizar la consulta"+ e.getMessage());

    }
}

}
