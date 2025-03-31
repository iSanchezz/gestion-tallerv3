package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Proveedor {
    

    public void insertarProveedor(model.Proveedor proveedor ){
        Connection conexion= dao.ConexionDB.conectar();

        int id = proveedor.getId();
        String nombre = proveedor.getNombre();
        int telefono = proveedor.getTelefono();

        String query="INSERT INTO proveedores (id, nombre, telefono) VALUES (?,?,?)";

        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("los datos se han introducido con exito");

        }catch(SQLException e){

            System.out.println("error al introducir datos");

        }


    }
}
