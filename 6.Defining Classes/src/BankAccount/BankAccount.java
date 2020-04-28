package BankAccount;

public class BankAccount {
    private final static double DEFAULT_iNTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_iNTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountCount++;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

   public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return interestRate * years * this.balance;
    }

}
