import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}

public class ConvertCSVToJavaObjects {
    public static void main(String[] args) throws CsvValidationException {
        String csvFile = "src/main/resources/students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                Student student = new Student(nextLine[0], nextLine[1], Integer.parseInt(nextLine[2]), Integer.parseInt(nextLine[3]));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
