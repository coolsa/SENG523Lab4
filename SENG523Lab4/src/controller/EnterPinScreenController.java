package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnterPinScreen;
import view.WithDrawAmountScreen;

public class EnterPinScreenController {
	
	private EnterPinScreen enterPinScreen;
	
	public EnterPinScreenController(EnterPinScreen enterPinScreen) {
		this.enterPinScreen = enterPinScreen;
		
	}
	
	public void runController() {
		
		//Enter Pin: 
		enterPinScreen.getEnterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Requires some checks in the DB to verify if the card 
				// Exists or not. Also will need to pass in the card verified onto the 
				// withdrawScreen 
				
				System.out.println(enterPinScreen.getPinField().getText());
				WithDrawAmountScreen withdrawScreen = new WithDrawAmountScreen();
				withdrawScreen.displayFrame();
				enterPinScreen.dispose(); 
				
				// Assuming pin is right, pass onto next screen. (Withdraw amount) 
				
			}
		});
		
		
		//Cancel: 
		enterPinScreen.getCancelButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterPinScreen.dispose();
			}
		});
		
		
	}
	
	
	
}
