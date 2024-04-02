package mate.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/book_jdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";
    private static final String PROPERTIES_USER_KEY = "user";
    private static final String PROPERTIES_PASSWORD_KEY = "password";
    private static final Properties DB_PROPERTIES;

    static {
        DB_PROPERTIES = new Properties();
        DB_PROPERTIES.put(PROPERTIES_USER_KEY, DB_USER);
        DB_PROPERTIES.put(PROPERTIES_PASSWORD_KEY, DB_PASSWORD);

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
    }
}
