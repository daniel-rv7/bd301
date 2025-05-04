package bd301;

import java.sql.*;
import java.util.*;

public class RolDAO {
    private Connection conn;

    public RolDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Rol r) throws SQLException {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, r.getNombre());
            stmt.executeUpdate();
        }
    }

    public List<Rol> listar() throws SQLException {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Rol r = new Rol(
                    rs.getInt("id"),
                    rs.getString("nombre")
                );
                lista.add(r);
            }
        }
        return lista;
    }
}
