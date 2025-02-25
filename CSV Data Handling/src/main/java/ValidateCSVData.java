import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/contacts.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String email = nextLine[2].trim();
                String phone = nextLine[3].trim();

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid email: " + email + " in row: " + String.join(",", nextLine));
                } else if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid phone number: " + phone + " in row: " + String.join(",", nextLine));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
