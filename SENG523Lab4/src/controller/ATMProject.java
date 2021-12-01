package controller;

import view.GUI;

// Where main is located. Will set up dummy data for the DB, a few credit cards, total amount in system, 
// System states, etc. - SEE SCB stuff for set up. 
public class ATMProject {
	
	public static void main(String[] Args) {
		System.out.println("Starting up.... ");
		
		// Doing setup:
		ATMProject atmProject = new ATMProject();
		atmProject.systemInitialization();
	}
	
	public void systemInitialization() { // also handles dispatch and deployment? 
		// do everything as per Lab 4.
		// Initialize clock, states, bill storage. and then set up monitor welcome (call gui.runGUI) 
		
		//Run GUI (displays welcome screen) 
		GUI gui = new GUI();
		gui.runGUI();
	}
	
	
}
