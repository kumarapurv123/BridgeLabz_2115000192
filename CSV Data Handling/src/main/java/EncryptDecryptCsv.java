import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.codec.binary.Base64;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptDecryptCsv {

    private static final String CSV_FILE = "src/main/resources/encrypted_employees.csv";
    private static final String OUTPUT_CSV_FILE = "src/main/resources/decrypted_employees.csv";

    public static void main(String[] args) {
        encryptCsvData();
        decryptCsvData();
    }

    public static void encryptCsvData() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            String[] header = {"ID", "Name", "Department", "Encrypted Salary", "Encrypted Email"};
            writer.writeNext(header);

            String[] employee1 = {"1", "Alice Johnson", "HR", encrypt("55000"), encrypt("alice@example.com")};
            String[] employee2 = {"2", "Bob Smith", "IT", encrypt("65000"), encrypt("bob@example.com")};
            String[] employee3 = {"3", "Charlie Brown", "Finance", encrypt("60000"), encrypt("charlie@example.com")};

            writer.writeNext(employee1);
            writer.writeNext(employee2);
            writer.writeNext(employee3);

            System.out.println("Data encrypted and CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptCsvData() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE));
             CSVWriter writer = new CSVWriter(new FileWriter(OUTPUT_CSV_FILE))) {
            String[] header = reader.readNext();
            writer.writeNext(header);

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String[] decryptedRecord = {
                    nextLine[0],
                    nextLine[1],
                    nextLine[2],
                    decrypt(nextLine[3]),
                    decrypt(nextLine[4])
                };
                writer.writeNext(decryptedRecord);
            }

            System.out.println("Data decrypted and CSV file created successfully.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String data) {
        return Base64.encodeBase64String(data.getBytes());
    }

    private static String decrypt(String data) {
        return new String(Base64.decodeBase64(data));
    }
}
