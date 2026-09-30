public class BankAccountExceptionDemo {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount("A100", 500.00);
            System.out.println(account);

            account.deposit(200.00);
            System.out.println(account);

            account.withdraw(1000.00);
            System.out.println(account);
        }
        catch (InvalidBankOperationException exception) {
            System.out.println("Bank operation failed.");
            System.out.println(exception.getMessage());
        }

        try {
            BankAccount badAccount = new BankAccount("B200", -50.00);
            System.out.println(badAccount);
        }
        catch (InvalidBankOperationException exception) {
            System.out.println("Could not create account.");
            System.out.println(exception.getMessage());
        }
    }

    public static class BankAccount {
        private String accountNumber;
        private double balance;

        public BankAccount() {
            this.accountNumber = "UNKNOWN";
            this.balance = 0.0;
        }

        public BankAccount(String accountNumber, double openingBalance) {
            if (accountNumber == null || accountNumber.length() == 0) {
                throw new InvalidBankOperationException("Account number cannot be empty.");
            }

            if (openingBalance < 0) {
                throw new InvalidBankOperationException("Opening balance cannot be negative.");
            }

            this.accountNumber = accountNumber;
            this.balance = openingBalance;
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public double getBalance() {
            return this.balance;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                throw new InvalidBankOperationException("Deposit amount must be positive.");
            }

            this.balance = this.balance + amount;
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                throw new InvalidBankOperationException("Withdrawal amount must be positive.");
            }

            if (amount > this.balance) {
                throw new InvalidBankOperationException("Insufficient funds. Balance is " + this.balance + ".");
            }

            this.balance = this.balance - amount;
        }

        public String toString() {
            return "BankAccount{accountNumber='" + this.accountNumber + "', balance=" + this.balance + "}";
        }
    }

    public static class InvalidBankOperationException extends RuntimeException {
        public InvalidBankOperationException(String message) {
            super(message);
        }
    }
}
