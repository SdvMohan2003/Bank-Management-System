package BMS;

public class Bank {

    private SavingsAccount[] accounts;
    private int accountCount;
    private static final int MAX_ACCOUNTS = 100;

    public Bank() {
        accounts = new SavingsAccount[MAX_ACCOUNTS];
        accountCount = 0;
    }

    public void addAccount(SavingsAccount account) {
        if (accountCount < MAX_ACCOUNTS) {
            accounts[accountCount] = account;
            accountCount++;
            System.out.println("Account added successfully!");
        } else {
            System.out.println("Cannot add more accounts. Bank is full!");
        }
    }

    public void displayAllAccounts() {
        System.out.println("\n========== ALL BANK ACCOUNTS ==========");
        if (accountCount == 0) {
            System.out.println("No accounts found.");
            return;
        }

        for (int i = 0; i < accountCount; i++) {
            System.out.println("\nAccount " + (i + 1) + ":");
            accounts[i].showAccountDetails();
            if (accounts[i].getBalance() < 1000) {
                System.out.println("⚠️  LOW BALANCE WARNING!");
            }
        }
    }

    public SavingsAccount findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void processOperations() {
        System.out.println("\n========== PROCESSING BANKING OPERATIONS ==========");
        for (int i = 0; i < accountCount; i++) {
            SavingsAccount account = accounts[i];
            System.out.println("\nProcessing account: " + account.getAccountNumber());

            account.deposit(500);

            account.withdraw(200);

            account.addInterest();

            account.showAccountDetails();

            System.out.println("------------------------");
        }
    }
}