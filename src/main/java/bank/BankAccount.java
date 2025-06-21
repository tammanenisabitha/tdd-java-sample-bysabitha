package bank;

public class BankAccount {

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }
}
