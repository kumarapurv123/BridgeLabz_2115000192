import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}

public class GenerateCSVReport {
    private static final String CSV_FILE = "src/main/resources/employee_report.csv";

    public static void main(String[] args) {
        List<Employee> employees = fetchEmployeesFromDatabase();

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            String[] header = { "Employee ID", "Name", "Department", "Salary" };
            writer.writeNext(header);

            for (Employee employee : employees) {
                String[] record = {
                        String.valueOf(employee.getId()),
                        employee.getName(),
                        employee.getDepartment(),
                        String.valueOf(employee.getSalary())
                };
                writer.writeNext(record);
            }

            System.out.println("CSV report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> fetchEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database",
                    "apurvkumar", "xxxxxxx");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, department, salary FROM employees");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                int salary = resultSet.getInt("salary");
                employees.add(new Employee(id, name, department, salary));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
