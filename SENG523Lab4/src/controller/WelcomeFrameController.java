package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnterPinScreen;
import view.WelcomeScreen;
import model.BankCard;
import model.CardScanner;
import model.CardDatabase;

import static javax.swing.JOptionPane.showMessageDialog;

//Todo:  add logic into the controller - error check for invalid card, move to withdraw screen for valid. 
public class WelcomeFrameController {

	private WelcomeScreen welcomeScreen;
	private CardScanner cardScanner;
	private CardDatabase cardDB;

	public WelcomeFrameController(WelcomeScreen welcomeScreen) {
		this.welcomeScreen = welcomeScreen;
		cardScanner = new CardScanner(welcomeScreen.getScb());
		cardDB = welcomeScreen.getCardDB();
	}

	// Action Listener Events to be added here.
	public void runController() {

		//
		welcomeScreen.getInsertCardButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(welcomeScreen.getCardNumber().getText());

				int card = Integer.parseInt(welcomeScreen.getCardNumber().getText());
				BankCard bc = cardDB.getCard(card);
				if (bc.getCardNumber() == 0000 && bc.getBalance() == 0000 && bc.isAccountStatus() == false) {
					showMessageDialog(null, "The card is not valid");
					welcomeScreen.reset();
				} else {
					welcomeScreen.dispose();
					EnterPinScreen enterPinScreen = new EnterPinScreen(bc);
					enterPinScreen.displayFrame();
				}
			}

		});

	}

}
