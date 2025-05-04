package bd301;

import java.sql.*;
import java.util.*;

public class HorarioDAO {
    private Connection conn;

    public HorarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Horario h) throws SQLException {
        String sql = "INSERT INTO horarios (id_empleado, dia_semana, horario_inicio, hora_fin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, h.getIdEmpleado());
            stmt.setString(2, h.getDiaSemana());
            stmt.setString(3, h.getHorarioInicio());
            stmt.setString(4, h.getHoraFin());
            stmt.executeUpdate();
        }
    }

    public List<Horario> listar() throws SQLException {
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT * FROM horarios";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Horario h = new Horario(
                    rs.getInt("id"),
                    rs.getInt("id_empleado"),
                    rs.getString("dia_semana"),
                    rs.getString("horario_inicio"),
                    rs.getString("hora_fin")
                );
                lista.add(h);
            }
        }
        return lista;
    }
}
