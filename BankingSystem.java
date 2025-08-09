package BMS;

public class BankingSystem {

    public static void main(String[] args) {
        System.out.println("========== BANKING SYSTEM SIMULATION ==========\n");

        Bank bank = new Bank();

        SavingsAccount account1 = new SavingsAccount("SA001", "John Smith", 1500.00, 0.05);
        SavingsAccount account2 = new SavingsAccount("SA002", "Emma Johnson", 2500.00, 0.04);
        SavingsAccount account3 = new SavingsAccount("SA003", "Michael Brown", 800.00, 0.06);  // Low balance account
        SavingsAccount account4 = new SavingsAccount("SA004", "Sarah Davis", 5000.00, 0.045);

        System.out.println("Adding accounts to the bank:");
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        bank.displayAllAccounts();

        bank.processOperations();

        System.out.println("\n========== FINAL ACCOUNT STATUS ==========");
        bank.displayAllAccounts();

        System.out.println("\n========== BALANCE CHECK SUMMARY ==========");
        for (int i = 0; i < 4; i++) {
            SavingsAccount acc = (i == 0) ? account1 : (i == 1) ? account2 : (i == 2) ? account3 : account4;
            if (acc.getBalance() < 1000) {
                System.out.println("Account " + acc.getAccountNumber() + " - LOW BALANCE: $" + acc.getBalance());
            } else if (acc.getBalance() >= 1000 && acc.getBalance() < 2000) {
                System.out.println("Account " + acc.getAccountNumber() + " - MODERATE BALANCE: $" + acc.getBalance());
            } else {
                System.out.println("Account " + acc.getAccountNumber() + " - GOOD BALANCE: $" + acc.getBalance());
            }
        }

        System.out.println("\n========== BANKING SYSTEM SIMULATION COMPLETE ==========");
    }
}
