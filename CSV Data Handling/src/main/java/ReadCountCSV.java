import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadCountCSV {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/employees.csv";
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
          
            reader.readNext();

            while (reader.readNext() != null) {
                rowCount++;
            }

            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
