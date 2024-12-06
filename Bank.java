
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
	private int nextAccountNumber;
	
	public static void main (String[] args) {
		ArrayList<BankAccount> accounts = new ArrayList<>();
		Bank bank = new Bank();
		Scanner scanner = new Scanner(System.in);
		int response; 
		do {
			System.out.println("Bank Menu: ");
			System.out.println("1. Add checking account");
			System.out.println("2. Add savings account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Display all accounts");
			System.out.println("6. Exit");
			System.out.println("Please select a choice from the menu: ");
			
			response = scanner.nextInt();
			switch (response) {
            case 1 -> {
                System.out.print("Set balance: ");
                double checkingBalance = scanner.nextDouble();
                System.out.print("Set overdraft limit: ");
                double overdraftLimit = scanner.nextDouble();

                
                while (!bank.isAccountNumberUnique(accounts, bank.nextAccountNumber)) {
                    bank.nextAccountNumber++;
                }

                accounts.add(new CheckingAccount(bank.nextAccountNumber++, "Checking", checkingBalance, overdraftLimit));
                System.out.println("Checking account " + accounts.get(accounts.size() - 1).getAccountNumber() + " now available");
            }

            case 2 -> {
                System.out.print("Set balance: ");
                double savingsBalance = scanner.nextDouble();
                System.out.print("Set interest rate: ");
                double interestRate = scanner.nextDouble();
            
                accounts.add(new SavingAccount(bank.nextAccountNumber++, "Savings", savingsBalance, interestRate));
                System.out.println("Savings account " + accounts.get(accounts.size() - 1).getAccountNumber()+ " now available");
            }            

            case 3 -> {
                System.out.print("Account number?: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bank.deposit(accounts, accountNumber, depositAmount);
            }

            case 4 -> {
                System.out.print("Account number?: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                bank.withdraw(accounts, accountNumber, withdrawAmount);
            }

            case 5 -> bank.displayAllAccounts(accounts);

            case 6 -> {
            	System.out.println("Closing...");
            	System.exit(0);
            }

            default -> System.out.println("Invalid choice. Pls Try again");
        }
    } while (response != 6);

    scanner.close();
}

public void deposit(ArrayList<BankAccount> accounts, int accountNumber, double amount) {
    if (amount <= 0) {
        System.out.println("Deposit amount must be greater than zero.");
        return;
    }
    for (BankAccount account : accounts) {
        if (account.getAccountNumber() == accountNumber) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " to account " + accountNumber);
            return;
        }
    }
    System.out.println("Error. Account not found.");
}

public void withdraw(ArrayList<BankAccount> accounts, int accountNumber, double amount) {
    if (amount <= 0) {
        System.out.println("Withdrawal amount must be greater than zero.");
        return;
    }
    for (BankAccount account : accounts) {
        if (account.getAccountNumber() == accountNumber) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Withdrawal failed. Either insufficient balance or overdraft limit exceeded.");
            }
            return;
        }
    }
    System.out.println("Account not found.");
}


public void displayAllAccounts(ArrayList<BankAccount> accounts) {
    for (BankAccount account : accounts) {
        System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance() + ", Account Type: " + account.getAccountType());
    }
}

public boolean isAccountNumberUnique(ArrayList<BankAccount> accounts, int accountNumber) {
    for (BankAccount account : accounts) {
        if (account.getAccountNumber() == accountNumber) {
            return false;  
        }
    }
    return true;  
}
}
