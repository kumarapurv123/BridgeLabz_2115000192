import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadLargeCSV {
    public static void main(String[] args) throws CsvException {
        String csvFile = "src/main/resources/large_file.csv";
        int chunkSize = 100;
        int recordCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records;
            reader.readNext();
            while ((records = reader.readAll()).size() > 0) {
                records.forEach(record -> {
                    System.out.println(String.join(", ", record));
                });
                recordCount += records.size();
                System.out.println("Processed records count: " + recordCount);
                if (records.size() < chunkSize) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
