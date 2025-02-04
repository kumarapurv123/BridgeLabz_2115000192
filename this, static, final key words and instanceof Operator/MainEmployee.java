class Employee {
    private static String companyName = "Capgemini";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }
}

public class MainEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee("A", 101, "Developer");
        Employee emp2 = new Employee("B", 102, "Manager");
        emp1.displayDetails();
        emp2.displayDetails();
        Employee.displayTotalEmployees();
    }
}
