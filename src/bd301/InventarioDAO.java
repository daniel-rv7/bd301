package bd301;

import java.sql.*;
import java.util.*;

public class InventarioDAO {
    private Connection conn;

    public InventarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Inventario i) throws SQLException {
        String sql = "INSERT INTO inventario (nombre, descripcion, precio, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getDescripcion());
            stmt.setDouble(3, i.getPrecio());
            stmt.setInt(4, i.getCantidad());
            stmt.executeUpdate();
        }
    }

    public List<Inventario> listar() throws SQLException {
        List<Inventario> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Inventario i = new Inventario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                );
                lista.add(i);
            }
        }
        return lista;
    }
}
