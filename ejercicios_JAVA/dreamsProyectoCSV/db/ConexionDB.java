package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/dreams";
        String user = "admin";
        String password = "admin123";
        return DriverManager.getConnection(url, user, password);
    }
}
