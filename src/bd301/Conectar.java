package bd301;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    private static Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "Pr0gr4m4c10n123.";
    private static final String URL = "jdbc:mysql://localhost:3306/biker_control";

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error conectando: " + e.getMessage());
        }
    }
    // ✅ Ahora es método estático
    public static Connection getConnection() {
        return conn;
    }

    public static void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
