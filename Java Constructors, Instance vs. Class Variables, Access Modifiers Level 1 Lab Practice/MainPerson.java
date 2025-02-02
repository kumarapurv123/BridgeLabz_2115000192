import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class MainPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the Person");
        String name = sc.nextLine();
        System.out.println("Age of the Person");
        int age = sc.nextInt();

        Person person1 = new Person(name, age);
        Person person2 = new Person(person1);

        person1.displayDetails();
        person2.displayDetails();
    }
}