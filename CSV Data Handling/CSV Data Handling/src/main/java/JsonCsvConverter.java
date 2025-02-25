import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.CSVWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {

    private static final String JSON_FILE = "src/main/resources/students.json";
    private static final String CSV_FILE = "src/main/resources/students.csv";
    private static final String OUTPUT_JSON_FILE = "src/main/resources/students_output.json";

    public static void main(String[] args) {
        jsonToCsv();
        csvToJson();
    }

    public static void jsonToCsv() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(JSON_FILE), new TypeReference<List<Map<String, Object>>>() {});

            try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
                String[] header = {"ID", "Name", "Age", "Marks"};
                writer.writeNext(header);

                for (Map<String, Object> student : students) {
                    String[] record = {
                        String.valueOf(student.get("ID")),
                        (String) student.get("Name"),
                        String.valueOf(student.get("Age")),
                        String.valueOf(student.get("Marks"))
                    };
                    writer.writeNext(record);
                }
            }

            System.out.println("JSON converted to CSV successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            List<Map<String, String>> students = new ArrayList<>();
            String[] header = reader.readNext();
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                Map<String, String> student = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    student.put(header[i], nextLine[i]);
                }
                students.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileWriter(OUTPUT_JSON_FILE), students);

            System.out.println("CSV converted to JSON successfully.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
