package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hevfacma
 */
public class MySQLConnector {

    private Connection con = null;

    private final static String DATA_BASE = "supermarket";
    private final static String URL = "jdbc:mysql://127.0.0.1:3306";
    private final static String USER = "root";
    private final static String PASSWORD = "example";

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlConnection = String.format("%s/%s", URL, DATA_BASE);
            con = DriverManager.getConnection(urlConnection, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
