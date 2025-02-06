import java.util.ArrayList;
import java.util.List;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void displayDepartments() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.getName());
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department dept1 = new Department("IT");
        dept1.addEmployee("Apurv");
        dept1.addEmployee("Jack");

        Department dept2 = new Department("HR");
        dept2.addEmployee("Tom");

        company.addDepartment("IT");
        company.addDepartment("HR");
        company.displayDepartments();
    }
}
