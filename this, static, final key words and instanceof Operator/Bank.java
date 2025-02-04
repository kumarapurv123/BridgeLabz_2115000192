class Bank {
    private static String bankName = "Union Bank";
    private static int totalAccounts = 0;
    private final int accNumber;
    private String accHolder;

    public Bank(String accHolderName, int accNumber) {
        this.accHolder = accHolderName;
        this.accNumber = accNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Account Number: " + accNumber);
    }

    public static void main(String[] args) {
        Bank ac1 = new Bank("Apurv Kumar", 7830);
        Bank ac2 = new Bank(" Kumar", 7831);

        ac1.displayDetails();
        ac2.displayDetails();

        System.out.println("Total Accounts: " + Bank.getTotalAccounts());
    }
}
