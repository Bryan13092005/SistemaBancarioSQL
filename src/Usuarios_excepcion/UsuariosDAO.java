package Usuarios_excepcion;

import SistemaBancario.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {
    public static void insertarCliente(Usuario u){
        String sql = "insert into cuentasUsuario(usuario,clave,monto) values(?,?,?)";

        try (Connection con= Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,u.getUsuario());
            ps.setString(2,u.getClave());
            ps.setDouble(3, u.getMonto());

            ps.executeUpdate();

        } catch (Exception _e){
            _e.printStackTrace();
        }
    }
    public static boolean existeUsuario(String usuario) {

        String sql = "SELECT 1 FROM cuentasUsuario WHERE usuario = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Usuario validarLogin(String usuario, String clave) {

        String sql = "SELECT * FROM cuentasUsuario WHERE usuario = ? AND clave = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("usuario"),
                        rs.getString("clave"),
                        rs.getDouble("monto")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
