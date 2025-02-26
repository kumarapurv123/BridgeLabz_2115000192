import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class ReadJsonAndPrint {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("src/main/resources/data.json"));

            printJsonNode(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printJsonNode(JsonNode node) {
        if (node.isObject()) {
            Iterator<Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                System.out.println(field.getKey() + ": " + field.getValue());
                printJsonNode(field.getValue());
            }
        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                printJsonNode(arrayItem);
            }
        } else {
            
        }
    }
}
