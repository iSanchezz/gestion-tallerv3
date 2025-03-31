package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDB {



    public void insertarCliente(model.Cliente cliente ){
        Connection conexion= dao.ConexionDB.conectar();

        String id = cliente.getId();
        String nombre = cliente.getNombre();
        int telefono = cliente.getTelefono();

        String query="INSERT INTO clientes (id, nombre, telefono) VALUES (?,?,?)";

        try(PreparedStatement stmt= conexion.prepareStatement(query)){

            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, telefono);

            System.out.println("los datos se han introducido con exito");

        }catch(SQLException e){

            System.out.println("error al introducir datos");

        }


    }


    public void insertarEmpleado(model.Empleado empleado){
        Connection conexion= dao.ConexionDB.conectar();

            String id= empleado.getId();
            String nombre= empleado.getNombre();
            String puesto=empleado.getPuesto();
            double salario=empleado.getSalario();

            String query="INSERT INTO empleados (id, nombre, puesto, salario) VALUES (?,?,?,?)";

            try(PreparedStatement stmt= conexion.prepareStatement(query)){

                stmt.setString(1, id);
                stmt.setString(2, nombre);
                stmt.setString(3, puesto);
                stmt.setDouble(4, salario);
    
                System.out.println("los datos se han introducido con exito");

            }catch(SQLException e){
                System.out.println("error al introducir datos");

                }


        }

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




