package bloodforlife;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/search_db","root","");
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
