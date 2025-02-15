import java.io.*;

public class BinaryToTextReader {
    public static void readFileAsText(String filePath, String charset) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";
        String charset = "UTF-8";
        readFileAsText(filePath, charset);
    }
}
