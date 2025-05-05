package bd301;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Registrar nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, numero, correo, identificacion, contrasena, id_rol, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conectar.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getNumero());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getIdentificacion());
            stmt.setString(6, usuario.getContrasena()); // Nueva línea
            stmt.setInt(7, usuario.getIdRol());
            stmt.setString(8, usuario.getEstado());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error registrando usuario: " + e.getMessage());
            return false;
        }
    }

    // Iniciar sesión (login)
    public Usuario iniciarSesion(String correo, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ? AND estado = 'activo'";

        try (Connection conn = Conectar.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setContrasena(rs.getString("contrasena")); // Seteamos contraseña si es necesario
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setEstado(rs.getString("estado"));
                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error iniciando sesión: " + e.getMessage());
        }

        return null; // No encontrado
    }

    // Obtener todos los usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = Conectar.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error listando usuarios: " + e.getMessage());
        }

        return lista;
    }
}
 