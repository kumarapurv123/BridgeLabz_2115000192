import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Applying for loan...");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 0.5;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Applying for loan...");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 0.3;
    }
}

interface Loanable {
    void applyForLoan();

    double calculateLoanEligibility();
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savingsAccount = new SavingsAccount("SA12345", "Customer1", 10000, 3);
        CurrentAccount currentAccount = new CurrentAccount("CA12345", "Customer2", 5000, 2);

        accounts.add(savingsAccount);
        accounts.add(currentAccount);

        for (BankAccount account : accounts) {
            account.displayDetails();
            double interest = account.calculateInterest();
            System.out.println("Interest: " + interest);

            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                loanable.applyForLoan();
                double loanEligibility = loanable.calculateLoanEligibility();
                System.out.println("Loan Eligibility: " + loanEligibility);
            }
            System.out.println();
        }
    }
}
