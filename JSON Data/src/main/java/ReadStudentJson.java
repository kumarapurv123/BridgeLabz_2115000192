import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String[] subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}

public class ReadStudentJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
   
            ClassLoader classLoader = ReadStudentJson.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("student.json");

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found! Check the path.");
            }

        
            List<Student> students = mapper.readValue(inputStream, new TypeReference<List<Student>>() {});

          
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Subjects: " + Arrays.toString(student.getSubjects()));
                System.out.println("---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
