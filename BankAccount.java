public abstract class BankAccount {
    private int accountNumber;
    private String accountType;
    private double balance;

    public BankAccount(int accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() { 
        return accountNumber;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return false;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
        return true;
    }

    public String getAccountType() {
        return accountType;
    }
}



