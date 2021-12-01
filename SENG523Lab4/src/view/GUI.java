package view;

import model.BankCard;
import model.CardDatabase;

public class GUI {

	// Holds instances of card, DB, etc. All other Screens extend this class so they can 
	// Access the same records. 
	
	BankCard bankCard;
	//CardDatabase cardDatabase;
	
	
	public GUI() {
	}
	
	public void runGUI() {
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		welcomeScreen.displayFrame();
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.runGUI();
	}
	
	
}
