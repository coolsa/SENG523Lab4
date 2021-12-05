package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WithDrawAmountScreen;

import model.BankCard;
import model.BillDisburse;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;;

// Remember to do checks for verify balance as per Lab 3. 
public class WithDrawAmountScreenController {

	private WithDrawAmountScreen withdrawAmountScreen;
	
	public WithDrawAmountScreenController(WithDrawAmountScreen withdrawAmountScreen) {
		this.withdrawAmountScreen = withdrawAmountScreen;
	}
	
	public void reset() {
		withdrawAmountScreen.dispose();
		ATMProject.start();
	}
	public void runController() {
		
		// Enter 
		withdrawAmountScreen.getEnterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Todo: Logic and checking if funds available. If not, display error screen.
				System.out.println(withdrawAmountScreen.getWithdrawField().getText());
				double withdrawamount = Integer.parseInt(withdrawAmountScreen.getWithdrawField().getText());
				if (withdrawamount <= withdrawAmountScreen.getAmountInAccount()) {
					
					//code that dispenses cash should go here 
				} else {
					showMessageDialog(null,
							"Not enough funds for withdrawel, Please restart transaction.");
					reset();
				}
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
