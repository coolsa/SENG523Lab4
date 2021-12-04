package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnterPinScreen;
import view.WelcomeScreen;
import view.WithDrawAmountScreen;

import model.BankCard;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showInputDialog;;

public class EnterPinScreenController {

	private EnterPinScreen enterPinScreen;

	public EnterPinScreenController(EnterPinScreen enterPinScreen) {
		this.enterPinScreen = enterPinScreen;

	}

	public void reset() {
		enterPinScreen.dispose();
		ATMProject.start();
	}

	public void runController() {

		// Enter Pin:
		enterPinScreen.getEnterButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Requires some checks in the DB to verify if the card
				// Exists or not. Also will need to pass in the card verified onto the
				// withdrawScreen

				int cardPin = Integer.parseInt(enterPinScreen.getPinField().getText());
				BankCard bc = enterPinScreen.getCard();
				int count = 0;
				while (cardPin != bc.getPinNumber() && count < 3) {
					enterPinScreen.dispose();
					String msg = "Incorrect pin, you have " + (3 - count) + " attempt left";
					cardPin = Integer.parseInt(showInputDialog(msg));
					count++;

				}
				if (cardPin == bc.getPinNumber()) {
					WithDrawAmountScreen withdrawScreen = new WithDrawAmountScreen();
					withdrawScreen.displayFrame();
					enterPinScreen.dispose();
				} else {
					showMessageDialog(null,
							"Incorrect pin was used too many times!!! Program will return to the start.");
					reset();
				}

				// Assuming pin is right, pass onto next screen. (Withdraw amount)

			}
		});

		// Cancel:
		enterPinScreen.getCancelButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enterPinScreen.dispose();
			}
		});

	}

}
