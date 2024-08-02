package org.example.DB;

import org.example.MODEL.NonExistentWordTypeException;
import org.example.MODEL.Word;
import org.example.MODEL.WordType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        return getType(WordType.VERB);
    }
    public static List<Word> getSubtantiv() {
        return getType(WordType.SUBSTANTIV);
    }
    public static List<Word> getAdjektiv() {
        return getType(WordType.ADJEKTIV);
    }
    public static List<Word> getArtikel() {
        System.out.println(getType(WordType.ARTIKEL));
        System.out.println(WordType.ARTIKEL.getType());
        return getType(WordType.ARTIKEL);
    }
    public static List<Word> getType(WordType type) {
        try {
            List<Word> ret = new ArrayList<>();
            ResultSet result = stmt.executeQuery(String.format("""
                    SELECT * FROM words
                    INNER JOIN word_types ON words.word_type_id = word_types.id
                    LEFT JOIN themes ON words.theme_id = themes.id
                    WHERE word_types.type_name = '%s';
                    """, type.getType()));
            while (result.next()) {
                ret.add(new Word(result.getInt("id"),
                        result.getString("german"),
                        result.getString("hungarian"),
                        result.getString("theme_name"),
                        result.getString("type_name")));
            }
            return ret;
        } catch (SQLException exp) {
            System.out.println("Error with the sql connection or the statement");
            System.out.println(exp.getMessage());
            return null;
        }
    }
    public static List<Word> getEveryType() {
        try {
            List<Word> res = new LinkedList<>();
            ResultSet resultSet = stmt.executeQuery("""
                    SELECT * FROM words w
                    LEFT JOIN word_types wt
                    ON w.word_type_id = wt.id
                    LEFT JOIN themes th
                    ON w.theme_id = th.id;"""
            );
            while (resultSet.next()) {
                res.add(new Word(resultSet.getInt("id"),
                        resultSet.getString("german"),
                        resultSet.getString("hungarian"),
                        resultSet.getString("theme_name"),
                        resultSet.getString("type_name")));
            }
            return res;
        } catch (SQLException exp) {
            System.out.println("Error with the sql connection or the statement");
            System.out.println(exp.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        List<Word> verbs = WordSet.getVerbs();
        System.out.println(Arrays.toString(WordSet.lektionNums()));
        List<Word> test = WordSet.getWordsBasedOnSettings("0", "Default");
        System.out.println(test);
    }
    public static List<Word> getWordsBasedOnSettings(String lektion_num, String wordType) {
        try {
            List<Word> res = new LinkedList<>();
            System.out.println(wordType);
            ResultSet rs = stmt.executeQuery("""
                    SELECT * FROM words w
                    LEFT JOIN word_types wt
                    ON w.word_type_id = wt.id
                    LEFT JOIN themes th
                    ON w.theme_id = th.id
                    WHERE wt.type_name LIKE '%s' %s;""".formatted(wordType.equals("Default") ? "%" : wordType,
                                                    lektion_num.equals("0") ? "" : String.format("AND lektion_num = %s", lektion_num)));
            while (rs.next()) {
                res.add(new Word(rs.getInt("id"),
                        rs.getString("german"),
                        rs.getString("hungarian"),
                        rs.getString("theme_name"),
                        rs.getString("type_name")));
            }
            return res;
        } catch (SQLException sqle) {
            System.out.println("Something wrong with the sql query or connection in getWordsBasedOnSettings");
            System.out.println(sqle.getMessage());
            return null;
        }
    }
    public static String[] lektionNums() {
        try {
            List<String> tmp = new LinkedList<>();
            tmp.add("0");
            ResultSet rs = stmt.executeQuery("""
                    SELECT DISTINCT lektion_num FROM words
                    ORDER BY lektion_NUM ASC;
                    """);

            /* 0 is included, because that will be the default value, in this case 0 means all*/
            while (rs.next()) {
                if (rs.getString("lektion_num") != null) {
                    tmp.add(rs.getString("lektion_num"));
                }
            }
            return tmp.toArray(String[]::new);

        } catch (SQLException sqle) {
            System.out.println("Error with the sql conncetion or the statement in lektionNums function of WordSet");
            System.out.println(sqle.getMessage());
            return null;
        }
    }
}
