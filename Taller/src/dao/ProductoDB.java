package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProductoDB {
    

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

        public void modificarNombreProducto(int id, String nuevonombre){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE productos SET nombre = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, nuevonombre);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }
        public void modificarPrecioProducto(int id, Double nuevoprecio){
            Connection conexion= dao.ConexionDB.conectar();

            String query="UPDATE productos SET precio = ? WHERE id="+id;

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setDouble(1, nuevoprecio);

                System.out.println("los datos se han actualizado con exito");


            }catch(SQLException e){
                System.out.println("error al actualizar datos");
            }

        }

}
