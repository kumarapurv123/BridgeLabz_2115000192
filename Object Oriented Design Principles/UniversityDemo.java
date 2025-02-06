import java.util.ArrayList;
import java.util.List;

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayDepartmentDetails();
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
        }
    }
}

class Department {
    private String name;
    private List<Faculty> faculties;

    public Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayDepartmentDetails() {
        System.out.println("Department: " + name);
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University university = new University("University");

        Faculty faculty1 = new Faculty("Dr. Sharma");
        Faculty faculty2 = new Faculty("Prof. Mehta");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.addDepartment("Computer Science");
        university.addDepartment("Mathematics");

        university.displayUniversityDetails();
    }
}
