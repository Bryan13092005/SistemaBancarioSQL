package SistemaBancario;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/sistemabancario";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
            return null;
        }
    }
}
