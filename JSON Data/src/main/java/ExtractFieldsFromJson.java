import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ExtractFieldsFromJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/main/resources/input.json"));

        if (root.isArray()) {
            for (JsonNode node : root) {
                String name = node.has("name") ? node.get("name").asText() : "N/A";
                String email = node.has("email") ? node.get("email").asText() : "N/A";
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }
        } else {
            System.out.println("Invalid JSON structure.");
        }
    }
}
