package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WithDrawAmountScreen;

// Remember to do checks for verify balance as per Lab 3. 
public class WithDrawAmountScreenController {

	private WithDrawAmountScreen withdrawAmountScreen;
	
	public WithDrawAmountScreenController(WithDrawAmountScreen withdrawAmountScreen) {
		this.withdrawAmountScreen = withdrawAmountScreen;
	}
	
	public void runController() {
		
		// Enter 
		withdrawAmountScreen.getEnterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Todo: Logic and checking if funds available. If not, display error screen.
				System.out.println(withdrawAmountScreen.getWithdrawField().getText());
			}
		});
		
		
		// Cancel.
		withdrawAmountScreen.getCancelButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				withdrawAmountScreen.dispose();
				//Open a new Welcome Screen? 
			}
		});
		
	}
	
}
