import java.util.*;

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

class FullTimeEmployee extends Employee {
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
}

class PartTimeEmployee extends Employee {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
}

interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

class EmployeeDepartment implements Department {
    private String departmentName;

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(1, "Employee1", 50000, 20000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(2, "Employee2", 20000, 100, 100);

        employees.add(fullTimeEmployee);
        employees.add(partTimeEmployee);

        EmployeeDepartment department1 = new EmployeeDepartment();
        department1.assignDepartment("Engineering");

        EmployeeDepartment department2 = new EmployeeDepartment();
        department2.assignDepartment("Marketing");

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("Salary: " + employee.calculateSalary());
            System.out.println(department1.getDepartmentDetails());
            System.out.println(department2.getDepartmentDetails());
            System.out.println();
        }
    }
}
