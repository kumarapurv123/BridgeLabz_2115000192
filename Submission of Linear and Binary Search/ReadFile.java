import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        try (FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
