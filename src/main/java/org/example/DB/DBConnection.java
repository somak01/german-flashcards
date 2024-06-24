package org.example.DB;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection {
    public static Connection connect() throws SQLException{
        try {
            System.out.println("Connections is successful!");
            return DriverManager.getConnection(DatabaseConfig.getURL(), DatabaseConfig.getUser(), DatabaseConfig.getPWD());
        } catch (SQLException se) {
            System.out.println("Connection failed due to an exception!");
            System.err.println(se.getMessage());
            return null;
        }
    }
}
