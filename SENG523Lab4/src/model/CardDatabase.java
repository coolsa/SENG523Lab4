package model;

import java.util.ArrayList;

// The card Database Model. Used to simulate a real database. Holds several instances of BankCard. 
// AKA the system database from Lab 3
public class CardDatabase {

	private ArrayList<BankCard> cardHolders;
	int numberCardHolders; //number of card holders (max value = 10,000 as per Lab3) 
	
	
	public CardDatabase(ArrayList<BankCard> cardHolders) {
		this.setCardHolders(cardHolders);	
		setNumberCardHolders(cardHolders.size());
	}

	
	public ArrayList<BankCard> getCardHolders() {
		return cardHolders;
	}

	public void setCardHolders(ArrayList<BankCard> cardHolders) {
		this.cardHolders = cardHolders;
	}
	
	public void setNumberCardHolders(int numberCardHolders) {
		this.numberCardHolders = numberCardHolders;
	}
	
	public int getNumberCardHolders() {
		return numberCardHolders;
	}
	
	
	
}
