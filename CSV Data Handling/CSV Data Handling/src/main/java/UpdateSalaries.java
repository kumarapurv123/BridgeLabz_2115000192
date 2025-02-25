import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateSalaries {
    public static void main(String[] args) throws CsvValidationException, NumberFormatException {
        String inputCsvFile = "src/main/resources/employees.csv";
        String outputCsvFile = "src/main/resources/employees_updated.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputCsvFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsvFile))) {

            String[] nextLine;
            List<String[]> records = new ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[2].equalsIgnoreCase("IT")) {
                    int salary = Integer.parseInt(nextLine[3]);
                    salary += salary * 0.10; 
                    nextLine[3] = String.valueOf(salary);
                }
                records.add(nextLine);
            }

            writer.writeAll(records);
            System.out.println("Salaries updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
