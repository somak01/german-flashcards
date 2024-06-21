package org.example;

import java.sql.SQLException;

public class DbMain {
    public static void main(String[] args) {
        try (var connection = DBConnection.connect()) {
            if (connection != null) {
                System.out.println("Nem null");
                var stmt = connection.createStatement();
               // stmt.execute("CREATE TABLE test( id serial PRIMARY KEY, name VARCHAR(100));");
                stmt.executeUpdate("INSERT INTO test (name) VALUES ('maki');");
                System.out.println("Yee haw baby!");
            }
        } catch (SQLException se) {
            System.out.println("Connection failed");
            System.err.println(se.getMessage());
        }
    }
}
