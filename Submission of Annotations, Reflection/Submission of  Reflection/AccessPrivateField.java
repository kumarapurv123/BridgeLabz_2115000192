import java.lang.reflect.*;

class Person {
    private int age = 22;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field ageField = Person.class.getDeclaredField("age");

        ageField.setAccessible(true);

        ageField.set(person, 30);
        System.out.println(ageField.get(person));

    }
}
