package week_4_lab;

public class ChequingAccount extends BankAccount {
    private double transactionFee;

    public ChequingAccount(String ownerName,
            double balance,
            double transactionFee) {
        super(ownerName, balance);
        this.transactionFee = transactionFee;
    }

    @Override
    public void withdraw(double amount) {
        double total = amount + transactionFee;

        if (total > 0 && balance - total >= 0) {
            balance -= total;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Chequing Account");
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: $" + balance);
        System.out.println("Transaction Fee: $" + transactionFee);
    }
}