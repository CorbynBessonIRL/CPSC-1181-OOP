package week_4_lab;

import java.util.ArrayList;

public class BankDriver {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount("Alice", 1000, 0.05);

        SavingsAccount s2 = new SavingsAccount("Bob", 2000, 0.03);

        ChequingAccount c1 = new ChequingAccount("Charlie", 1500, 2);

        ChequingAccount c2 = new ChequingAccount("David", 2500, 3);

        s1.deposit(500);
        s1.addInterest();

        s2.withdraw(300);
        s2.addInterest();

        c1.withdraw(100);
        c2.deposit(400);

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(s1);
        accounts.add(s2);
        accounts.add(c1);
        accounts.add(c2);

        for (BankAccount account : accounts) {
            account.printInfo();
            System.out.println();
        }

        System.out.println(
                "Total Accounts: " +
                        BankAccount.getTotalAccounts());
    }
}
