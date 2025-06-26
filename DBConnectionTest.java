import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/your_database_name"; // Change to your MySQL database URL
    private static final String USER = "root"; // Change to your MySQL user
    private static final String PASSWORD = " "; // Change to your MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successfully!");

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            String sql = "SELECT * FROM User";
            rs = stmt.executeQuery(sql);

            // Check if the result set is empty
            if (!rs.isBeforeFirst()) {
                System.out.println("No data found in the User table.");
            }

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String Username = rs.getString("User_name");
                int Role = rs.getString("Role") != null ? rs.getInt("Role") : 0; // Handle null values
                String password = rs.getString("password");

                System.out.println("ID: " + id);
                System.out.println("Username: " + Username);
                System.out.println("password: " + password);
                System.out.println("Role: " + Role);
                System.out.println("<==========>");
            }
        } catch (SQLException e) {
            if (conn == null) {
                System.out.println("Failed to connect to the database");
            } else {
                e.printStackTrace();
            }
        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
