import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Objects;

public class ReadCSV {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "students.csv";

        try (CSVReader reader = new CSVReader(new InputStreamReader(
                Objects.requireNonNull(ReadCSV.class.getClassLoader().getResourceAsStream(csvFile))))) {
            String[] student;
            while ((student = reader.readNext()) != null) {
                System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Age: " + student[2] + ", Marks: " + student[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
