
public class CheckingAccount extends BankAccount{
	private double overDraftLimit;
	
	public CheckingAccount(int accountNumber, String accountType, double balance, double overDraftLimit) {
		super(accountNumber, accountType, balance);
		this.overDraftLimit = overDraftLimit;
	}
	public double getoverDraftLimit() {
		return overDraftLimit;
	}
	
	@Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return false;
        }
        if (getBalance() - amount < overDraftLimit) {
            System.out.println("You've reached your withdrawal limit.");
            return false;
        } else {
			setBalance(getBalance()-amount);
			System.out.println("Withdrawal successful. New balance: " + getBalance());
			return true;
		
		}
	}
}
