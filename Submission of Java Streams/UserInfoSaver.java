import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        String fileName = "user_info.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileWriter fw = new FileWriter(fileName, true)) {
            String name = br.readLine();
            int age = Integer.parseInt(br.readLine());
            String language = br.readLine();
            fw.write("Name: " + name);
            fw.write("Age: " + age);
            fw.write("Favorite Language: " + language);
            fw.write("");
            System.out.println("User information saved successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age entered.");
        }
    }
}
