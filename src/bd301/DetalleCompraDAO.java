package bd301;

import java.sql.*;
import java.util.*;

public class DetalleCompraDAO {
    private Connection conn;

    public DetalleCompraDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(DetalleCompra d) throws SQLException {
        String sql = "INSERT INTO detalle_compras (id_compra, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, d.getIdCompra());
            stmt.setInt(2, d.getIdProducto());
            stmt.setInt(3, d.getCantidad());
            stmt.setDouble(4, d.getPrecioUnitario());
            stmt.setDouble(5, d.getSubtotal());
            stmt.executeUpdate();
        }
    }

    public List<DetalleCompra> listar() throws SQLException {
        List<DetalleCompra> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_compras";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DetalleCompra d = new DetalleCompra(
                    rs.getInt("id"),
                    rs.getInt("id_compra"),
                    rs.getInt("id_producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("subtotal")
                );
                lista.add(d);
            }
        }
        return lista;
    }
}