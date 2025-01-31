public class Employee {
    private String name;
    private int salary;
    private int id;

    public Employee(String name, int salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        System.out.println("Employee Name is : " + this.name);
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getID() {
        System.out.println("Employee ID is : " + this.id);
        return this.id;
    }

    public void setID(int newID) {
        this.id = newID;
    }

    public int getSalary() {
        System.out.println("Employee Salary is : " + this.salary);
        return this.salary;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee Id: " + this.id);
        System.out.println("Employee salary: " + this.salary);
    }

}