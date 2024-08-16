package MMDataAccess.MMDataHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MMDataHelper {
    private static final String DB_URL = "jdbc:sqlite:DataBase/MMHormiguero.sqlite";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conexion establecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
