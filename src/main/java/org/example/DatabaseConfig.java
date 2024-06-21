package org.example;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DatabaseConfig {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                System.out.println("Input stream is null");
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }

    public static String getURL() {
        return props.getProperty("db.url");
    }

    public static String getUser() {
        return props.getProperty("db.user");
    }

    public static String getPWD() {
        return props.getProperty("db.password");
    }
}
