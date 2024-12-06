
public class SavingAccount extends BankAccount {
	private static double interestRate;
	
	public SavingAccount(int accountNumber, String accountType, double balance, double interestRate){
		super(accountNumber,accountType, balance);
		SavingAccount.interestRate = interestRate;
	}
	
	public static void setInterestRate(double rate) {
        interestRate = rate;
    }
		
	public void applyInterest() {
		double interest = calculateInterest();
		setBalance(getBalance() + interest);
		System.out.println("With interest factored in, your new balance is: " + getBalance());
	}

	public double calculateInterest(){
		return interestRate * getBalance();
	}
}
