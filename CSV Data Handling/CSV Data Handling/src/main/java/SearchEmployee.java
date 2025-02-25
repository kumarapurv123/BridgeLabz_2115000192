import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class SearchEmployee {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/employees.csv";
        String searchName = "Bob Smith";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            reader.readNext(); 

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + nextLine[2] + ", Salary: " + nextLine[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
