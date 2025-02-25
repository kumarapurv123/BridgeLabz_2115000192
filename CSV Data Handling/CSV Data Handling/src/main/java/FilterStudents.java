import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterStudents {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            reader.readNext();

            System.out.println("Students who scored more than 80 marks:");
            while ((nextLine = reader.readNext()) != null) {
                int marks = Integer.parseInt(nextLine[3].trim());
                if (marks > 80) {
                    System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Age: " + nextLine[2] + ", Marks: " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
