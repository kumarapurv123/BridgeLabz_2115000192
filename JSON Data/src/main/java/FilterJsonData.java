import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FilterJsonData {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("src/main/resources/users.json"));

            for (JsonNode node : root) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    System.out.println("Name: " + node.get("name").asText());
                    System.out.println("Age: " + age);
                    System.out.println("Email: " + node.get("email").asText());
                    System.out.println("---");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
