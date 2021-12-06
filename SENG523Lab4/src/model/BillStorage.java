package model;

public class BillStorage {
	private int amountFive, amountTen, amountTwenty, amountFifty, amountHundred;
	private double amountTotal;
	private boolean storageState;

	public static BillStorage INSTANCE;
	
	public BillStorage(int five, int ten, int twenty, int fifty, int hundred, double amountTotal,
			boolean storageState) {
		this.amountFifty = five;
		this.amountTen = ten;
		this.amountTwenty = twenty;
		this.amountFifty = fifty;
		this.amountHundred = hundred;
		this.amountTotal = amountTotal;
		this.storageState = storageState;
		SCB.INSTANCE.setAmountTotal(amountTotal);
	}

	// getters and setters:
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

	public boolean isStorageState() {
		return storageState;
	}

	public void setStorageState(boolean storageState) {
		this.storageState = storageState;
	}

	public boolean verifyBillAvailability() {
		if (this.storageState == false) {
			// Unavailable
			SCB.INSTANCE.setVerifiedDispense(false);
			SCB.INSTANCE.setSysFailed(true);
			return true; // This is the same as DispInsufficientFunds
		} else if (SCB.INSTANCE.getDispenseAmount() == 100) {
			if (SCB.INSTANCE.getAmountHundred() > 1) { // Available
				SCB.INSTANCE.setVerifiedDispense(true);
			} else { // Unavailable
				SCB.INSTANCE.setVerifiedDispense(false);
			}
		} else if (SCB.INSTANCE.getDispenseAmount() == 50) {
			if (SCB.INSTANCE.getAmountFifty() > 1) { // Available
				SCB.INSTANCE.setVerifiedDispense(true);
			} else { // Unavailable
				SCB.INSTANCE.setVerifiedDispense(false);
			}
		} else if (SCB.INSTANCE.getDispenseAmount() == 20) {
			if (SCB.INSTANCE.getAmountTwenty() > 1) { // Available
				SCB.INSTANCE.setVerifiedDispense(true);
			} else { // Unavailable
				SCB.INSTANCE.setVerifiedDispense(false);
			}
		} else if (SCB.INSTANCE.getDispenseAmount() == 10) {
			if (SCB.INSTANCE.getAmountTen() > 1) { // Available
				SCB.INSTANCE.setVerifiedDispense(true);
			} else { // Unavailable
				SCB.INSTANCE.setVerifiedDispense(false);
			}
		} else if (SCB.INSTANCE.getDispenseAmount() == 5) {
			if (SCB.INSTANCE.getAmountFive() > 1) { // Available
				SCB.INSTANCE.setVerifiedDispense(true);
			} else { // Unavailable
				SCB.INSTANCE.setVerifiedDispense(false);
			}
		}
		if (SCB.INSTANCE.getAmountHundred() <= 0 && SCB.INSTANCE.getAmountFifty() <= 0
				&& SCB.INSTANCE.getAmountTwenty() <= 0 && SCB.INSTANCE.getAmountTen() <= 0
				&& SCB.INSTANCE.getAmountFive() <= 0) {
			this.setStorageState(false);
			SCB.INSTANCE.setVerifiedDispense(false);
		}
		return false;
	}

}
