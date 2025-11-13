package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/wk10_lab_RavindraPatil";
    private static final String USER = "root";
    private static final String PASS = "myTest1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("DB Connection Error: " + e.getMessage());
            return null;
        }
    }
}
