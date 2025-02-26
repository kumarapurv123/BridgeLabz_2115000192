import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonToXml {
    public static void main(String[] args) {
 
        String jsonFilePath = "src/main/resources/data.json";

        try {
   
            String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

       
            JSONArray jsonArray = new JSONArray(jsonString);
            String xml = XML.toString(new JSONObject().put("root", jsonArray));

    
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
