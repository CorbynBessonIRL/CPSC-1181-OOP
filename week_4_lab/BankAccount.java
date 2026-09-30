package week_4_lab;

public class BankAccount {
    protected String ownerName;
    protected double balance;

    private static int totalAccounts = 0;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
        }
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void printInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: $" + balance);
    }
}
