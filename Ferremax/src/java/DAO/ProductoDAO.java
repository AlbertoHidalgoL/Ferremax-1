package dao;
import modelo.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    private List<Producto> lista;
    public boolean agregar(Producto p){
        String sql="INSERT INTO productos(nombre, precio, cantidad) VALUES(?,?,?)";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            return ps.executeUpdate() > 0;
        }catch(Exception e){ e.printStackTrace(); return false;}
    }

    public List<Producto> listar(){
        String sql="SELECT * FROM productos";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                lista.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad")));
            }
        }catch(Exception e){ e.printStackTrace(); }
        return lista;
    }

    public Producto obtenerPorId(int id){
        String sql = "SELECT * FROM productos WHERE id=?";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
                }
            }
        }catch(Exception e){ e.printStackTrace(); }
        return null;
    }

    public boolean actualizar(Producto p){
        String sql = "UPDATE productos SET nombre=?, precio=?, cantidad=? WHERE id=?";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,p.getNombre()); ps.setDouble(2,p.getPrecio()); ps.setInt(3,p.getCantidad()); ps.setInt(4,p.getId());
            return ps.executeUpdate() > 0;
        }catch(Exception e){ e.printStackTrace(); return false;}
    }

    public boolean eliminar(int id){
        String sql = "DELETE FROM productos WHERE id=?";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);
            return ps.executeUpdate() > 0;
        }catch(Exception e){ e.printStackTrace(); return false;}
    }

    private static class lista {

        private static void add(Producto producto) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        public lista() {
        }
    }
}
