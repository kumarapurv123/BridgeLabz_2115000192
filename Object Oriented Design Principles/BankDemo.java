import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        System.out.println("Bank: " + name);
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName());
            customer.viewBalance();
        }
    }
}

class Customer {
    private String name;
    private double balance;
    private Bank bank;

    public Customer(String name, Bank bank, double initialBalance) {
        this.name = name;
        this.bank = bank;
        this.balance = initialBalance;
        bank.openAccount(this);
    }

    public String getName() {
        return name;
    }

    public void viewBalance() {
        System.out.println("Balance for " + name + ": " + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("Union Bank");

        Customer customer1 = new Customer("Amit", bank1, 5000);
        Customer customer2 = new Customer("Rahul", bank1, 7000);
        Customer customer3 = new Customer("Yash", bank2, 10000);

        bank1.displayCustomers();
        bank2.displayCustomers();
    }
}
