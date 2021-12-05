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
import static javax.swing.JOptionPane.showInputDialog;

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

		checkBalance.setBalance(Double.toString(bc.getBalance()));
		checkBalance.getWithdrawButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WithDrawAmountScreen withdrawamount = new WithDrawAmountScreen(bc);
				withdrawamount.displayFrame();
				checkBalance.dispose();
			}
		});

		checkBalance.getDepositButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(welcomeScreen.getCardNumber().getText());
				String dep = showInputDialog("How much do you want to deposit");
				Double deposit = Double.parseDouble(dep);
				Double newBalance = (bc.getBalance() + deposit);
				bc.setBalance(newBalance);
				checkBalance.setBalance(Double.toString(newBalance));

			}
		});
	}

}
