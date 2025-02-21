import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "output.txt";

        convertToLowercase(sourceFile, destinationFile);
    }

    public static void convertToLowercase(String source, String destination) {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("Conversion completed successfully");

        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
