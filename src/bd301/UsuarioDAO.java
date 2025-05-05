package bd301;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellido, numero, correo, identificacion, id_rol, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getApellido());
            stmt.setString(3, u.getNumero());
            stmt.setString(4, u.getCorreo());
            stmt.setString(5, u.getIdentificacion());
            stmt.setInt(6, u.getIdRol());
            stmt.setString(7, u.getEstado());
            stmt.executeUpdate();
        }
    }
    
    public Usuario verificarLogin(String correo, String identificacion) {
    String sql = "SELECT * FROM usuarios WHERE correo = ? AND identificacion = ?";
    try (Connection con = Conectar.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, correo);
        ps.setString(2, identificacion);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setIdentificacion(rs.getString("identificacion"));
            usuario.setNumero(rs.getString("numero"));
            usuario.setIdRol(rs.getInt("id_rol"));
            usuario.setEstado(rs.getString("estado"));
            return usuario;
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar login: " + e.getMessage());
    }
    return null;
}


    public List<Usuario> listar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("numero"),
                    rs.getString("correo"),
                    rs.getString("identificacion"),
                    rs.getInt("id_rol"),
                    rs.getString("estado")
                );
                lista.add(u);
            }
        }
        return lista;
    }
}
