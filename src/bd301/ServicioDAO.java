package bd301;

import java.sql.*;
import java.util.*;

public class ServicioDAO {
    private Connection conn;

    public ServicioDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Servicio s) throws SQLException {
        String sql = "INSERT INTO servicios (nombre, descripcion, duracion_min, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getNombre());
            stmt.setString(2, s.getDescripcion());
            stmt.setInt(3, s.getDuracionMin());
            stmt.setDouble(4, s.getPrecio());
            stmt.executeUpdate();
        }
    }

    public List<Servicio> listar() throws SQLException {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicios";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Servicio s = new Servicio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("duracion_min"),
                    rs.getDouble("precio")
                );
                lista.add(s);
            }
        }
        return lista;
    }
}
