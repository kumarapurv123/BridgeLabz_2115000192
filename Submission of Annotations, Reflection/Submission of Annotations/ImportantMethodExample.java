import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ImportantOperations {
    @ImportantMethod(level = "HIGH")
    void criticalOperation() {
        System.out.println(" critical operation...");
    }

    @ImportantMethod(level = "MEDIUM")
    void importantTask() {
        System.out.println("important task...");
    }

    void normalTask() {
        System.out.println("normal task...");
    }
}

public class ImportantMethodExample {
    public static void main(String[] args) {
        try {
            Method[] methods = ImportantOperations.class.getDeclaredMethods();
            System.out.println("Important Methods:");
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("- " + method.getName() + " (Level: " + annotation.level() + ")");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
