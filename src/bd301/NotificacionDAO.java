package bd301;

import java.sql.*;
import java.util.*;

public class NotificacionDAO {
    private Connection conn;

    public NotificacionDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Notificacion n) throws SQLException {
        String sql = "INSERT INTO notificaciones (id_usuario, mensaje, fecha, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, n.getIdUsuario());
            stmt.setString(2, n.getMensaje());
            stmt.setDate(3, new java.sql.Date(n.getFecha().getTime()));
            stmt.setString(4, n.getEstado());
            stmt.executeUpdate();
        }
    }

    public List<Notificacion> listar() throws SQLException {
        List<Notificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM notificaciones";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Notificacion n = new Notificacion(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getString("mensaje"),
                    rs.getDate("fecha"),
                    rs.getString("estado")
                );
                lista.add(n);
            }
        }
        return lista;
    }
}
