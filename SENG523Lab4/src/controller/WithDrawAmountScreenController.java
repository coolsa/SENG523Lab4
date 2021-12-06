package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Check_Balance;
import view.WithDrawAmountScreen;

import model.BankCard;
import model.BillDisburse;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.*;

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

				double withdrawamount = Integer.parseInt(withdrawAmountScreen.getWithdrawField().getText());

				if (withdrawamount <= withdrawAmountScreen.getAmountInAccount()) {
					double newBalance = withdrawAmountScreen.getAmountInAccount() - withdrawamount;
					withdrawAmountScreen.getCard().setBalance(newBalance);
					BillDisburse.INSTANCE.DisburseBills(withdrawamount);
					BillDisburse.INSTANCE.BillDispense();
					showMessageDialog(null, "Transaction was successful.");
					withdrawAmountScreen.dispose();
					Check_Balance checkBalance = new Check_Balance(withdrawAmountScreen.getCard());
					checkBalance.displayFrame();
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
				// Open a new Welcome Screen?
			}
		});

	}

}
