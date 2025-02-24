import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();

    String assignedTo();

    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement login feature", assignedTo = "Student1", priority = "HIGH")
    void loginFeature() {
        System.out.println("Login feature  pending");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Student2")
    void optimizeDB() {
        System.out.println("Database optimization pending");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Student3", priority = "LOW")
    void improveUI() {
        System.out.println("UI responsiveness improvement pending");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        try {
            Method[] methods = ProjectTasks.class.getDeclaredMethods();
            System.out.println("Pending Tasks:");
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo annotation = method.getAnnotation(Todo.class);
                    System.out.println("- Task: " + annotation.task());
                    System.out.println("  Assigned To: " + annotation.assignedTo());
                    System.out.println("  Priority: " + annotation.priority());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
