package org.example.DB;

import org.example.MODEL.NonExistentWordTypeException;
import org.example.MODEL.Word;
import org.example.MODEL.WordType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WordSet {
    static Connection connection;
    static Statement stmt;
    static {
        try{
            connection = DBConnection.connect();
            if (connection != null)
                stmt = connection.createStatement();
        } catch (SQLException se) {
            System.out.println("Connection failed!");
        }
    }

    public static List<Word> getVerbs() {
        try {
             List<Word> ret = new ArrayList<>();
             ResultSet result = stmt.executeQuery("""
                    SELECT * FROM words
                    INNER JOIN word_types ON words.word_type_id = word_types.id
                    WHERE word_types.type_name = 'Verb';
                    """);
             while (result.next()) {

                 ret.add(new Word(result.getInt("id"),
                 result.getString("german"),
                 result.getString("hungarian"),
                 null,
                 result.getString("type_name")));
             }
             return ret;
        } catch (SQLException exp) {
            System.out.println("Error with the sql connection or the statement");
            System.out.println(exp.getMessage());
            return null;
        }
    }


    public static void main(String[] args) {
        List<Word> verbs = WordSet.getVerbs();
        System.out.println(verbs);
    }
}
