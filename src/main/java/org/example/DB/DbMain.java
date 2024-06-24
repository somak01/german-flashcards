package org.example.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbMain {
    public static void main(String[] args) {
        try (var connection = DBConnection.connect()) {
            if (connection != null) {
                System.out.println("Nem null");
                var stmt = connection.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM words INNER JOIN word_types " +
                        "ON words.word_type_id = word_types.id;");
                while (res.next()) {
                    System.out.println(res.getString("german"));
                    System.out.println(res.getString("hungarian"));
                    System.out.println(res.getString("type_name"));
                }
                System.out.println("Yee haw baby!");
            }
        } catch (SQLException se) {
            System.out.println("Connection failed");
            System.err.println(se.getMessage());
        }
    }
}
