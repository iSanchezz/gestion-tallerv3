package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDB {

    public void insertarCliente(model.Cliente cliente) {
        Connection conexion = dao.ConexionDB.conectar();

        String id = cliente.getId();
        String nombre = cliente.getNombre();
        int telefono = cliente.getTelefono();

        String query = "INSERT INTO clientes (id, nombre, telefono) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);
            stmt.executeUpdate();

            System.out.println("los datos se han introducido con exito");

        } catch (SQLException e) {

            System.out.println("error al introducir datos");

        }

    }


    public void modificarNombreCliente(String id, String nuevonombre){

        Connection conexion= dao.ConexionDB.conectar();

        String query="UPDATE clientes SET nombre = ? WHERE id="+id;

        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            stmt.setString(1, nuevonombre);
            stmt.executeUpdate();

            System.out.println("los datos se han actualizado con exito");


        }catch(SQLException e){
            System.out.println("error al actualizar datos");
        }



    }

    public void modificarTelefonoCliente(String id, int nuevotelefono){

        Connection conexion= dao.ConexionDB.conectar();

        String query="UPDATE clientes SET telefono = ? WHERE id="+id;

        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            stmt.setInt(1, nuevotelefono);
            stmt.executeUpdate();

            System.out.println("los datos se han actualizado con exito");


        }catch(SQLException e){
            System.out.println("error al actualizar datos");
        }

    }

    public void borrarCliente(String id){

        Connection conexion= dao.ConexionDB.conectar();

        String query= "DELETE * FROM clientes WHERE id="+id;

        try(PreparedStatement stmt= conexion.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("los datos se han actualizado con exito");
        }catch(SQLException e){
            System.out.println("error al actualizar datos");

        }
    }
    public void mostrarClientes(){

        Connection conexion= dao.ConexionDB.conectar();

        String query="SELECT * FROM clientes";
        try(Statement stmt = conexion.createStatement();
        ResultSet rs=stmt.executeQuery(query)){
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getString("id"));
                System.out.println("Nombre: "+ rs.getString("nombre"));
                System.out.println("Telefono: "+ rs.getString("telefono"));
                System.out.println("-------------------------");

            }

        }catch(SQLException e){
            System.out.println("error al realizar la consulta"+ e.getMessage());

        }
    }
        public void mostrarClientesID(String id){

            Connection conexion= dao.ConexionDB.conectar();
    
            String query="SELECT * FROM clientes WHERE id="+id;
            try(Statement stmt = conexion.createStatement();
            ResultSet rs=stmt.executeQuery(query)){
                
                while(rs.next()){
                    System.out.println("ID: "+ rs.getString("id"));
                    System.out.println("Nombre: "+ rs.getString("nombre"));
                    System.out.println("Telefono: "+ rs.getString("telefono"));
                    System.out.println("-------------------------");
    
                }
                
            }catch(SQLException e){
                System.out.println("error al realizar la consulta"+ e.getMessage());
    
            }
        }

        public boolean comprobarCliente(String id){

            ResultSet resultado=null;
            Connection conexion= dao.ConexionDB.conectar();
            String query="SELECT COUNT FROM clientes WHERE id= ?";


            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, id);
                resultado=stmt.executeQuery();
                if (resultado.next()) {           
                            return true;
                    }

            }catch(SQLException e){
                System.out.println("error al verificar el dato"+ e.getMessage());

            }
            return false;
        }
}   
