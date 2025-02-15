import java.io.*;
import java.util.StringTokenizer;

public class PerformanceCompare {
    public static void main(String[] args) {
        stringConcatenationComparison();
        fileReadingComparison("Sample.txt");
    }

    public static void stringConcatenationComparison() {
        final int iterations = 1_000_000;
        String sampleText = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sampleText);
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(sampleText);
        }
        endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1_000_000 + " ms");
    }

    public static void fileReadingComparison(String filePath) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader(filePath);
        endTime = System.nanoTime();
        System.out.println(wordCountFR);
        System.out.println((endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println(wordCountISR);
        System.out.println((endTime - startTime) / 1_000_000 + " ms");
    }

    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
