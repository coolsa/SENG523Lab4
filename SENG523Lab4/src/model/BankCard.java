package model;


// The bank card model. Holds card number, account status, pin number, and balance. 
public class BankCard {

	private int cardNumber;
	private int pinNumber;
	private double balance;
	private boolean accountStatus;
	
	public BankCard(int cardNumber, int pinNumber, double balance, boolean accountStatus) {
		this.setCardNumber(cardNumber);
		this.setPinNumber(pinNumber);
		this.setBalance(balance);
		this.setAccountStatus(accountStatus);
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Will need to add more logic here relating to the InputWithdrawAmount on LAB3 - see verify balance. 
	public void withDrawAmount(double amount) {
		if(getBalance() - amount > 0)
			this.balance -= amount;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
