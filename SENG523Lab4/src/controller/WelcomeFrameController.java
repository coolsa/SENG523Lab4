package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnterPinScreen;
import view.WelcomeScreen;


//Todo:  add logic into the controller - error check for invalid card, move to withdraw screen for valid. 
public class WelcomeFrameController {

	private WelcomeScreen welcomeScreen;
	
	
	public WelcomeFrameController(WelcomeScreen welcomeScreen) {
		this.welcomeScreen = welcomeScreen;

	}
	
	//Action Listener Events to be added here. 
	public void runController() {
		
		//
		welcomeScreen.getInsertCardButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(welcomeScreen.getCardNumber().getText());
				EnterPinScreen enterPinScreen = new EnterPinScreen();
				enterPinScreen.displayFrame();
				
			}
			
			
		});
		
		
	}
	
	
	
}
