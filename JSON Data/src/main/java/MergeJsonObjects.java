import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class MergeJsonObjects {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json1 = "{\"name\": \"John\", \"age\": 30}";
        String json2 = "{\"email\": \"john.doe@example.com\", \"phone\": \"123-456-7890\"}";

        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);

        ObjectNode merged = ((ObjectNode) node1).setAll((ObjectNode) node2);

        System.out.println(mapper.writeValueAsString(merged));
    }
}
