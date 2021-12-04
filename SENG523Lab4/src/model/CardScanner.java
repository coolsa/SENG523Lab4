package model;

import java.util.ArrayList;

public class CardScanner {

	// Holds an instance of SCB to notify SCB of state cardInserted.
	private SCB scb;
	private CardDatabase cardDB;
	private boolean cardStatus; // T = Valid, F = Invalid
	private boolean ejected;

	public CardScanner(SCB scb) {
		this.setScb(scb);
	}

	public SCB getScb() {
		return scb;
	}

	public void setScb(SCB scb) {
		this.scb = scb;
	}

	public boolean isCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(boolean cardStatus) {
		this.cardStatus = cardStatus;
	}

	public boolean isEjected() {
		return ejected;
	}

	public void setEjected(boolean ejected) {
		this.ejected = ejected;
	}

	// Quick and dirty way to check our mock DB cards. Good enough for now since
	// We don't have an actual DB and will only hold a few example cards.
	public boolean scannedCardIsValid(BankCard insertedCard, int pin) {
		ArrayList<BankCard> cardHolders = cardDB.getCardHolders();

		for (int i = 0; i < cardHolders.size(); i++) {
			if (insertedCard.getCardNumber() == cardHolders.get(i).getCardNumber()) {
				if (pin == insertedCard.getPinNumber()) {
					setEjected(false);
					setCardStatus(true);
					return true;
				}
			}
		}

		setCardStatus(false);
		setEjected(true);
		return false;
	}

}
