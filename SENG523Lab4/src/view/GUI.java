package view;

import model.BankCard;
import model.CardDatabase;
import model.SCB;

public class GUI {

	// Holds instances of card, DB, etc. All other Screens extend this class so they
	// can
	// Access the same records.

	BankCard bankCard;
	// CardDatabase cardDatabase;
	CardDatabase cardDB;
	SCB scb;

	public GUI(SCB scb, CardDatabase db) {
		this.scb = scb;
		this.cardDB = db;
	}

	public void runGUI() {
		WelcomeScreen welcomeScreen = new WelcomeScreen(scb, cardDB);
		welcomeScreen.displayFrame();
	}

	// public static void main(String[] args) {
	// GUI gui = new GUI();
	// gui.runGUI();
	// }

}
