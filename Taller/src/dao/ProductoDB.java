package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Producto {
    

    public void insertaProducto(model.Producto producto){
        Connection conexion= dao.ConexionDB.conectar();

            int id= producto.getId();
            String nombre= producto.getNombre();
            double precio=producto.getPrecio();

            String query="INSERT INTO productos (id, nombre, precio) VALUES (?,?,?)";

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setInt(1, id);
                stmt.setString(2, nombre);                  
                stmt.setDouble(4, precio);
    
                System.out.println("los datos se han introducido con exito");

            }catch(SQLException e){
                System.out.println("error al introducir datos");

                }


        }
}
