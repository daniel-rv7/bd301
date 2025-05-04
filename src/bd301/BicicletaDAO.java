package bd301;

import java.sql.*;
import java.util.*;

public class BicicletaDAO {
    private Connection connection;

    public BicicletaDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Bicicleta b) {
        String sql = "INSERT INTO bicicletas (id_usuario, marca, modelo, color, serial) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, b.getIdUsuario());
            stmt.setString(2, b.getMarca());
            stmt.setString(3, b.getModelo());
            stmt.setString(4, b.getColor());
            stmt.setString(5, b.getSerial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error guardando bicicleta: " + e.getMessage());
        }
    }

    public List<Bicicleta> listar() {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicletas";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bicicleta b = new Bicicleta(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("color"),
                    rs.getString("serial")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Error listando bicicletas: " + e.getMessage());
        }
        return lista;
    }
}