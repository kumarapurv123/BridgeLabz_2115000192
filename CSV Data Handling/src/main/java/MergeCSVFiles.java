import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) throws CsvValidationException {
        String file1 = "src/main/resources/students1.csv";
        String file2 = "src/main/resources/students2.csv";
        String outputFile = "src/main/resources/merged_students.csv";

        Map<String, String[]> data = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1));
             CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] nextLine;

            reader1.readNext();
            while ((nextLine = reader1.readNext()) != null) {
                data.put(nextLine[0], nextLine);
            }

            reader2.readNext();
            while ((nextLine = reader2.readNext()) != null) {
                String id = nextLine[0];
                if (data.containsKey(id)) {
                    String[] student1 = data.get(id);
                    String[] merged = new String[student1.length + nextLine.length - 1];
                    System.arraycopy(student1, 0, merged, 0, student1.length);
                    System.arraycopy(nextLine, 1, merged, student1.length, nextLine.length - 1);
                    data.put(id, merged);
                }
            }

            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (String[] record : data.values()) {
                writer.writeNext(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
