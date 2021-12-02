package model;


// The SCB model. Requires some setup for Systems. 
public class SCB {

	// SCB Values
	private int amountFive, amountTen, amountTwenty, amountFifty, amountHundred;
	private double amountTotal;
	private int dispenseAmount; //can keep it as integer, as only dispensing in bills, not coins. 
	
	// Booleans for states.
	private boolean pinValid, withdrawing, cardInserted, cancelledTransaction, sysShutDown, sysFailed, verifiedDispense;

    public static final SCB INSTANCE = new SCB(250, 100, 50, 25, 10, 250*5+100*10+50*20+25*50+10*100, 0, false, false, false, false, false, false, false);

	//To-Do: SCB states. 
	// Constructor (sorry for large) 
	// Could also change default constructor to follow behavior of Lab4 system initialization. 
	public SCB(int amountFive, int amountTen, int amountTwenty, int amountFifty, int amountHundred,
			double amountTotal, int dispenseAmount, boolean pinValid, boolean withdrawing, boolean cardInserted,
			boolean cancelledTransaction, boolean sysShutdown, boolean sysFailed, boolean verifiedDispense) {
		
		//Multiple declarations on 1 line to save space - can change if wanted. 
		this.amountFive = amountFive; this.amountTen = amountTen; this.amountTwenty = amountTwenty;
		this.amountFifty = amountFifty; this.amountHundred = amountHundred;
		
		this.amountTotal = amountTotal; this.dispenseAmount = dispenseAmount;
		
		this.pinValid = pinValid; this.withdrawing = withdrawing; this.cardInserted = cardInserted;
		this.cancelledTransaction = cancelledTransaction; this.sysShutDown = sysShutdown; 
		this.sysFailed = sysFailed; this.verifiedDispense = verifiedDispense;
	}
	
	
	//getters and setters: 
	public int getAmountFifty() {
		return amountFifty;
	}

	public void setAmountFifty(int amountFifty) {
		this.amountFifty = amountFifty;
	}

	public int getAmountFive() {
		return amountFive;
	}

	public void setAmountFive(int amountFive) {
		this.amountFive = amountFive;
	}

	public double getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(double amountTotal) {
		this.amountTotal = amountTotal;
	}

	public int getAmountTwenty() {
		return amountTwenty;
	}

	public void setAmountTwenty(int amountTwenty) {
		this.amountTwenty = amountTwenty;
	}

	public int getAmountHundred() {
		return amountHundred;
	}

	public void setAmountHundred(int amountHundred) {
		this.amountHundred = amountHundred;
	}

	public int getAmountTen() {
		return amountTen;
	}

	public void setAmountTen(int amountTen) {
		this.amountTen = amountTen;
	}

	public int getDispenseAmount() {
		return dispenseAmount;
	}

	public void setDispenseAmount(int dispenseAmount) {
		this.dispenseAmount = dispenseAmount;
	}

	public boolean isPinValid() {
		return pinValid;
	}

	public void setPinValid(boolean pinValid) {
		this.pinValid = pinValid;
	}

	public boolean isSysFailed() {
		return sysFailed;
	}

	public void setSysFailed(boolean sysFailed) {
		this.sysFailed = sysFailed;
	}

	public boolean isWithdrawing() {
		return withdrawing;
	}

	public void setWithdrawing(boolean withdrawing) {
		this.withdrawing = withdrawing;
	}

	public boolean isCancelledTransaction() {
		return cancelledTransaction;
	}

	public void setCancelledTransaction(boolean cancelledTransaction) {
		this.cancelledTransaction = cancelledTransaction;
	}

	public boolean isSysShutDown() {
		return sysShutDown;
	}

	public void setSysShutDown(boolean sysShutDown) {
		this.sysShutDown = sysShutDown;
	}

	public boolean isVerifiedDispense() {
		return verifiedDispense;
	}

	public void setVerifiedDispense(boolean verifiedDispense) {
		this.verifiedDispense = verifiedDispense;
	}
	

	public boolean isCardInserted() {
		return cardInserted;
	}
	
	public void setCardInserted(boolean cardInserted) {
		this.cardInserted = cardInserted;
	}
	
	
}
