import java.io.*;

public class CFileWriter {
    public static void main(String[] args) {
        String filePath = "output.txt";

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWrite = new FileWriter(filePath, true);
                BufferedWriter bufferedWrite = new BufferedWriter(fileWrite)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWrite.write(input);
                bufferedWrite.newLine();
            }

            System.out.println(filePath);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
