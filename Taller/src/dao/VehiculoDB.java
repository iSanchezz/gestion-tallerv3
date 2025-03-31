package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Vehiculo {
 
    
    public void insertarVehiculo(model.Vehiculo vehiculo){
        Connection conexion= dao.ConexionDB.conectar();
           
        String marca=vehiculo.getMarca();
        String modelo=vehiculo.getModelo();
        String matricula=vehiculo.getMatricula();
        String estado=vehiculo.getEstado();

        String query="INSERT INTO vehiculos (marca, modelo, matricula, estado) VALUES (?,?,?,?)";

        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, matricula);
            stmt.setString(4, estado);

            

            System.out.println("los datos se han introducido con exito");

        }catch(SQLException e){

            System.out.println("error al introducir datos");

        }

    }
}
