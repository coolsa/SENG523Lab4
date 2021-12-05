package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnterPinScreen;
import view.WelcomeScreen;
import model.BankCard;
import model.CardScanner;
import model.CardDatabase;
import view.Check_Balance;
import view.WithDrawAmountScreen;

import static javax.swing.JOptionPane.showMessageDialog;

//Todo:  add logic into the controller - error check for invalid card, move to withdraw screen for valid. 
public class Check_Balance_Controller {

	private Check_Balance checkBalance;
	private BankCard bc;

	public Check_Balance_Controller(Check_Balance checkBalance) {
		this.checkBalance = checkBalance;
		this.bc = checkBalance.getCard();
	}

	// Action Listener Events to be added here.
	public void runController() {

		
		checkBalance.getWithdrawButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithDrawAmountScreen withdrawamount = new WithDrawAmountScreen();
				withdrawamount.displayFrame();
				checkBalance.dispose();
			}
		});

		checkBalance.getDepositButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithDrawAmountScreen withdrawamount = new WithDrawAmountScreen();
				withdrawamount.displayFrame();
				checkBalance.dispose();
			}
		});
		//
		// checkBa.getInsertCardButton().addActionListener(new ActionListener() {

		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // System.out.println(welcomeScreen.getCardNumber().getText());

		// int card = Integer.parseInt(welcomeScreen.getCardNumber().getText());
		// BankCard bc = cardDB.getCard(card);
		// if (bc.getCardNumber() == 0000 && bc.getBalance() == 0000 &&
		// bc.isAccountStatus() == false) {
		// showMessageDialog(null, "The card is not valid");
		// welcomeScreen.reset();
		// } else {
		// welcomeScreen.dispose();
		// EnterPinScreen enterPinScreen = new EnterPinScreen(bc);
		// enterPinScreen.displayFrame();
		// }
		// }

		// });
		checkBalance.setBalance(Double.toString(bc.getBalance()));
	}

}
