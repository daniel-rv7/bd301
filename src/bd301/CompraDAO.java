package bd301;

import java.sql.*;
import java.util.*;

public class CompraDAO {
    private Connection conn;

    public CompraDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Compra c) throws SQLException {
        String sql = "INSERT INTO compras (id_usuario, fecha, total) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getIdUsuario());
            stmt.setDate(2, new java.sql.Date(c.getFecha().getTime()));
            stmt.setDouble(3, c.getTotal());
            stmt.executeUpdate();
        }
    }

    public List<Compra> listar() throws SQLException {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM compras";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Compra c = new Compra(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getDate("fecha"),
                    rs.getDouble("total")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}