import java.lang.reflect.*;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object studentObj = cls.getDeclaredConstructor().newInstance();

        Method displayMethod = cls.getMethod("display");
        displayMethod.invoke(studentObj);
    }
}
