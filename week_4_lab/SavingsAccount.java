package week_4_lab;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String ownerName,
            double balance,
            double interestRate) {
        super(ownerName, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }

    @Override
    public void printInfo() {
        double interestAmount = balance * interestRate;

        System.out.println("Savings Account");
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Current Interest Amount: $" + interestAmount);
    }
}
