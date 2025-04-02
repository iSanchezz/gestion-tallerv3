package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProductoDB {
    

    public void insertaProducto(model.Producto producto){
        Connection conexion= dao.ConexionDB.conectar();

            String id= producto.getId();
            String nombre= producto.getNombre();
            double precio=producto.getPrecio();

            String query="INSERT INTO productos (id, nombre, precio) VALUES (?,?,?)";

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, id);
                stmt.setString(2, nombre);                  
                stmt.setDouble(4, precio);
                stmt.executeUpdate();

                System.out.println("los datos se han introducido con exito");

            }catch(SQLException e){
                System.out.println("error al introducir datos");

                }


        }

        public void modificarNombreProducto(String id, String nuevonombre){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE productos SET nombre = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevonombre);
                stmt.executeUpdate();

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarPrecioProducto(String id, Double nuevoprecio){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE productos SET precio = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setDouble(1, nuevoprecio);
                stmt.executeUpdate();

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void borrarProducto(String id){

            Connection conexion= dao.ConexionDB.conectar();
    
            String query= "DELETE * FROM productos WHERE id="+id;
    
            try(PreparedStatement stmt= conexion.prepareStatement(query)){
                stmt.executeUpdate();
                System.out.println("los datos se han actualizado con exito");
            }catch(SQLException e){
                System.out.println("error al actualizar datos");
    
            }
        }

        public void mostrarProductos(){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM productos";
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getString("id"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Precio: "+ rs.getDouble("precio"));
                System.out.println("-------------------------");

            }

        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
    public void mostrarProductosID(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM productos WHERE id="+id;
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getString("id"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Precio: "+ rs.getDouble("precio"));
                System.out.println("-------------------------");

            }
            
        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
}
