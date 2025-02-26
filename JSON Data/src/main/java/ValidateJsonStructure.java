import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.File;
import java.io.IOException;

public class ValidateJsonStructure {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("src/main/resources/input.json"));

            if (root.isArray()) {
                boolean isValid = true;
                for (JsonNode node : root) {
                    if (!(node.has("name") && node.get("name").getNodeType() == JsonNodeType.STRING &&
                          node.has("age") && node.get("age").getNodeType() == JsonNodeType.NUMBER)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println("Valid JSON structure.");
                } else {
                    System.out.println("Invalid JSON structure.");
                }
            } else {
                System.out.println("Invalid JSON structure.");
            }
        } catch (IOException e) {
            System.out.println("Invalid JSON structure.");
        }
    }
}
