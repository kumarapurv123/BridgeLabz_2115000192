class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager Employee ID: " + employeeID);
        System.out.println("Manager Department: " + department);
    }
}

public class MainEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "IT", 50000.00);
        employee.displayDetails();
        employee.setSalary(55000.00);
        System.out.println("Updated Salary: " + employee.getSalary());

        Manager manager = new Manager(102, "HR", 60000.00);
        manager.displayManagerDetails();
    }
}