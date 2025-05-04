package bd301;

import java.sql.Connection;

public class Bd301 {
    public static void main(String[] args) {
        Conectar con = new Conectar();
        Connection conn = con.getConnection();

    }       
}
