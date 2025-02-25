import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            Set<String> ids = new HashSet<>();
            Set<String[]> duplicates = new HashSet<>();
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                if (!ids.add(nextLine[0])) {
                    duplicates.add(nextLine);
                }
            }

            System.out.println("Duplicate records:");
            for (String[] record : duplicates) {
                System.out.println(String.join(", ", record));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
