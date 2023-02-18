import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static final Connection connection = getConnection();

    private static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        Connection con;
        try {
            con = (
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBTest",
                            "postgres", "timur321"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
