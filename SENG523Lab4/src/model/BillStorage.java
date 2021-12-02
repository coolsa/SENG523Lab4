package model;

public class BillStorage {
	private int amountFive, amountTen, amountTwenty, amountFifty, amountHundred;
	private double amountTotal;
	private boolean storageState;
	
	public BillStorage(int five, int ten, int twenty, int fifty, int hundred, double amountTotal, 
			boolean storageState) {
		this.amountFifty = five; this.amountTen = ten; this.amountTwenty = twenty;
		this.amountFifty = fifty; this.amountHundred = hundred;
		this.amountTotal = amountTotal;
		this.storageState = storageState;
		
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

		public boolean isStorageState() {
			return storageState;
		}

		public void setStorageState(boolean storageState) {
			this.storageState = storageState;
		}
	
}
