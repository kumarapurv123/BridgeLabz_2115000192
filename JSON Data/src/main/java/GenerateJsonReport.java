import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;

public class GenerateJsonReport {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        try (Connection conn = DriverManager.getConnection(jdbcURL);
             Statement stmt = conn.createStatement()) {
            
         
            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50), age INT, email VARCHAR(50))");
            stmt.execute("INSERT INTO users VALUES (1, 'John Doe', 30, 'john.doe@example.com')");
            stmt.execute("INSERT INTO users VALUES (2, 'Alice Smith', 25, 'alice.smith@example.com')");
            stmt.execute("INSERT INTO users VALUES (3, 'Bob Johnson', 35, 'bob.johnson@example.com')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            List<Map<String, Object>> userList = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("name", rs.getString("name"));
                user.put("age", rs.getInt("age"));
                user.put("email", rs.getString("email"));
                userList.add(user);
            }
            
    
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(userList);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
