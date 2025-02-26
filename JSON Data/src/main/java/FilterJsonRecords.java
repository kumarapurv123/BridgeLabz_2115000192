import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class FilterJsonRecords {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("src/main/resources/input.json"));

        List<JsonNode> filteredRecords = new ArrayList<>();
        for (JsonNode record : root) {
            if (record.get("age").asInt() > 25) {
                filteredRecords.add(record);
            }
        }

        String filteredJson = mapper.writeValueAsString(filteredRecords);
        System.out.println(filteredJson);
    }
}
