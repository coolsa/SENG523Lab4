package controller;

import java.util.ArrayList;

import model.BankCard;
import model.BillStorage;
import model.CardDatabase;
import model.SCB;
import view.GUI;

// Where main is located. Will set up dummy data for the DB, a few credit cards, total amount in system, 
// System states, etc. - SEE SCB stuff for set up. 
public class ATMProject {

	private CardDatabase cardDB;
	private SCB scb;
	private BillStorage billStorage;

	public static void main(String[] Args) {
		System.out.println("Starting up.... ");
		ATMProject atmProject = new ATMProject();
		atmProject.buildDummyCardDatabase();
		atmProject.systemInitialization();

	}

	public static void terminate() {
		System.exit(0);
	}

	public static void start() {
		// Doing setup:
		ATMProject atmProject = new ATMProject();
		atmProject.buildDummyCardDatabase();
		atmProject.systemInitialization();
	}

	public void systemInitialization() { // also handles dispatch and deployment?
		// do everything as per Lab 4.
		// Initialize clock, states, bill storage. and then set up monitor welcome (call
		// gui.runGUI)

		scb = SCB.INSTANCE; // set the scb to the only instance of the SCB (singleton)

		// To-Do: clock.

		// Run GUI (displays welcome screen)
		GUI gui = new GUI(scb, cardDB);
		gui.runGUI();
	}

	public void buildDummyCardDatabase() {
		BankCard card1 = new BankCard(111111111, 1111, 250.0, true);
		BankCard card2 = new BankCard(222222222, 2222, 100, true);
		BankCard card3 = new BankCard(333333333, 3333, 10, true);
		BankCard card4 = new BankCard(444444444, 4444, 10, true);
		ArrayList<BankCard> cardList = new ArrayList<BankCard>();
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		setCardDB(new CardDatabase(cardList));

	}

	public CardDatabase getCardDB() {
		return cardDB;
	}

	public void setCardDB(CardDatabase cardDB) {
		this.cardDB = cardDB;
	}

	public BillStorage getBillStorage() {
		return billStorage;
	}

	public void setBillStorage(BillStorage billStorage) {
		this.billStorage = billStorage;
	}

	public SCB getScb() {
		return scb;
	}

	public void setScb(SCB scb) {
		this.scb = scb;
	}

}
