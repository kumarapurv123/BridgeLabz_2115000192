import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(this).toString());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jsonMap.toString().replace("=", ": ").replace(", ", ",").replace("{", "{").replace("}", "}");
    }
}

public class JsonSerializationExample {
    public static void main(String[] args) {
        User user = new User("Student1", 22);
        System.out.println(user.toJson());
    }
}
