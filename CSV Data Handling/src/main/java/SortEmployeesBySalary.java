import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = new ArrayList<>();
            String[] header = reader.readNext(); 

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                records.add(nextLine);
            }
            Collections.sort(records, new Comparator<String[]>() {
                @Override
                public int compare(String[] a, String[] b) {
                    return Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3]));
                }
            });

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println("ID: " + records.get(i)[0] + ", Name: " + records.get(i)[1] +
                                   ", Department: " + records.get(i)[2] + ", Salary: " + records.get(i)[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
