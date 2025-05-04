package bd301;

import java.sql.*;
import java.util.*;

public class EmpleadoDAO {
    private Connection conn;

    public EmpleadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Empleado e) throws SQLException {
        String sql = "INSERT INTO empleados (id_usuario, horario_inicio, horario_fin) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, e.getIdUsuario());
            stmt.setString(2, e.getHorarioInicio());
            stmt.setString(3, e.getHorarioFin());
            stmt.executeUpdate();
        }
    }

    public List<Empleado> listar() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e = new Empleado(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getString("horario_inicio"),
                    rs.getString("horario_fin")
                );
                lista.add(e);
            }
        }
        return lista;
    }
}
