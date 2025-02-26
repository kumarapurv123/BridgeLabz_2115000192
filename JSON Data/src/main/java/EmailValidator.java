import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SchemaValidatorsConfig;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class EmailValidator {

    public static void main(String[] args) throws IOException {
       
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = schemaFactory.getSchema(new File("schema.json"));

       
        String jsonData = "{\"email\":\"example@example.com\"}";

     
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonData);

       
        Set<ValidationMessage> validationMessages = schema.validate(jsonNode);

        if (validationMessages.isEmpty()) {
            
            JsonNode emailNode = jsonNode.get("email");
            if (emailNode != null && EmailValidator.getInstance().isValid(emailNode.asText())) {
                System.out.println("Email is valid.");
            } else {
                System.out.println("Email format is invalid.");
            }
        } else {
            for (ValidationMessage message : validationMessages) {
                System.out.println("Validation error: " + message.getMessage());
            }
        }
    }
}
