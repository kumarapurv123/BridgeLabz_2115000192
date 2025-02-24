import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer exception occurs")
    @BugReport(description = "Performance issue under high load")
    void buggyMethod() {
        System.out.println("Buggy method executed.");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("buggyMethod");
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            System.out.println("Bug Reports:");
            for (BugReport bug : bugReports) {
                System.out.println("- " + bug.description());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
