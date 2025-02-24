import java.lang.reflect.*;

public class ClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "java.util.ArrayList"; // Replace with user input if needed
        Class<?> cls = Class.forName(className);

        System.out.println("Methods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }

        System.out.println("Fields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("Constructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }
}
