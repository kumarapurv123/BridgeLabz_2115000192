import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonObjects2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

       
        JsonNode node1 = mapper.readTree(new File("src/main/resources/json1.json"));
        JsonNode node2 = mapper.readTree(new File("src/main/resources/json2.json"));

        ObjectNode merged = ((ObjectNode) node1).setAll((ObjectNode) node2);

        System.out.println(mapper.writeValueAsString(merged));
    }
}
