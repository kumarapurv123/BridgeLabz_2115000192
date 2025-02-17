import java.io.*;

public class FileReadingComparison {

    public static void main(String[] args) throws IOException {
        String filePath = "Sample.txt";

        long fileReaderTime = readFileWithFileReader(filePath);
        long inputStreamReaderTime = readFileWithInputStreamReader(filePath);

        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
    }

    private static long readFileWithFileReader(String filePath) throws IOException {
        long startTime = System.currentTimeMillis();
        FileReader fileReader = new FileReader(filePath);
        while (fileReader.read() != -1) {
        }
        fileReader.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long readFileWithInputStreamReader(String filePath) throws IOException {
        long startTime = System.currentTimeMillis();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        while (inputStreamReader.read() != -1) {
        }
        inputStreamReader.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}