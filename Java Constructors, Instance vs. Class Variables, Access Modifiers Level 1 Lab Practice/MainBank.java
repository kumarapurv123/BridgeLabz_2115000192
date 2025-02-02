class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Savings Account Number: " + accountNumber);
        System.out.println("Savings Account Holder: " + accountHolder);
    }
}

public class MainBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "Apurv", 1000.00);
        account.displayDetails();
        account.setBalance(1500.00);
        System.out.println("Updated Balance: " + account.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("987654321", "yash", 2000.00);
        savingsAccount.displaySavingsAccountDetails();
    }
}