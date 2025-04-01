package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}