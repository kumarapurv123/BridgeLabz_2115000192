import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class IPLCensorAnalyzer {

    public static void main(String[] args) throws IOException {
        File jsonInputFile = new File("src/main/resources/ipl_matches.json");
        File csvInputFile = new File("src/main/resources/ipl_matches.csv");

        // Process JSON data
        processJsonData(jsonInputFile);

        // Process CSV data
        processCsvData(csvInputFile);
    }

    private static void processJsonData(File inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputFile);

        for (JsonNode matchNode : rootNode) {
            // Censor team names
            ((ObjectNode) matchNode).put("team1", censorTeamName(matchNode.get("team1").asText()));
            ((ObjectNode) matchNode).put("team2", censorTeamName(matchNode.get("team2").asText()));
            // Redact player of the match
            ((ObjectNode) matchNode).put("player_of_match", "REDACTED");
        }

        // Write censored data to new JSON file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("censored_ipl_matches.json"), rootNode);
    }

    private static void processCsvData(File inputFile) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder().setUseHeader(true).build();

        List<Map<String, String>> rows = csvMapper.readerFor(Map.class).with(schema).readValues(inputFile).readAll();
        List<Map<String, String>> censoredRows = new ArrayList<>();

        for (Map<String, String> row : rows) {
            row.put("team1", censorTeamName(row.get("team1")));
            row.put("team2", censorTeamName(row.get("team2")));
            row.put("player_of_match", "REDACTED");
            censoredRows.add(row);
        }

        // Write censored data to new CSV file
        csvMapper.writer(schema).writeValue(new File("censored_ipl_matches.csv"), censoredRows);
    }

    private static String censorTeamName(String teamName) {
        int index = teamName.indexOf(' ');
        return index == -1 ? teamName : teamName.substring(0, index) + " ***";
    }
}
