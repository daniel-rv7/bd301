package bd301;

import java.sql.*;
import java.util.*;

public class ReservacionDAO {
    private Connection conn;

    public ReservacionDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Reservacion r) throws SQLException {
        String sql = "INSERT INTO reservaciones (id_bicicleta, id_servicio, id_empleado, fecha, hora_inicio, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, r.getIdBicicleta());
            stmt.setInt(2, r.getIdServicio());
            stmt.setInt(3, r.getIdEmpleado());
            stmt.setDate(4, new java.sql.Date(r.getFecha().getTime()));
            stmt.setString(5, r.getHoraInicio());
            stmt.setString(6, r.getEstado());
            stmt.executeUpdate();
        }
    }

    public List<Reservacion> listar() throws SQLException {
        List<Reservacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservacion r = new Reservacion(
                    rs.getInt("id"),
                    rs.getInt("id_bicicleta"),
                    rs.getInt("id_servicio"),
                    rs.getInt("id_empleado"),
                    rs.getDate("fecha"),
                    rs.getString("hora_inicio"),
                    rs.getString("estado")
                );
                lista.add(r);
            }
        }
        return lista;
    }
}
