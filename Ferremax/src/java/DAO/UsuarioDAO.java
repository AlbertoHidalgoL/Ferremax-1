package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.Conexion;

public class UsuarioDAO {

    public boolean validar(String usuario, String clave){
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // MÉTODO NUEVO PARA RECUPERAR CONTRASEÑA
    public String obtenerClave(String usuario) {
    String sql = "SELECT clave FROM usuarios WHERE usuario=?";

    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("clave");
        }
        return null;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}
