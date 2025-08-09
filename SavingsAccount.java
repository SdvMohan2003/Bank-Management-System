package BMS;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("\n=== Savings Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((balance - amount) >= 1000) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Warning: Minimum balance of $1000 must be maintained!");
                System.out.println("Cannot withdraw $" + amount + ". Current balance: $" + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of $" + interest + " added. New balance: $" + balance);
    }

    public double getInterestRate() {
        return interestRate;
    }
}