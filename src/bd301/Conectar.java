
package bd301;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    private static Connection conn;
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String pass = "Pr0gr4m4c10n123.";
    private static String url = "jdbc:mysql://localhost:3306/biker_control";

    public Conectar() {
        conn = null;
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("Conexión establecida");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error conectando " +e.getMessage()); 
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void close(){
        conn = null;
        System.out.println("Conexión cerrada");
    }
}