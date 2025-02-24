import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_SECRET_KEY";

    public static void printKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Configuration.class;

        Field apiKeyField = cls.getDeclaredField("API_KEY");

        apiKeyField.setAccessible(true);

        apiKeyField.set(null, "NEW_SECRET_KEY");

        Configuration.printKey();
    }
}
