import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        File input = new File("src/main/resources/data.csv");
        File output = new File("src/main/resources/data.json");
        try {
          
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                                                              .with(schema)
                                                              .readValues(input);
            
            List<Map<String, String>> list = it.readAll();
            
          
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.writeValue(output, list);
            
            System.out.println("CSV data converted to JSON successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
