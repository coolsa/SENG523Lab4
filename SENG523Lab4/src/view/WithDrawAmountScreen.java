package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BankCard;

import controller.EnterPinScreenController;
import controller.WithDrawAmountScreenController;

public class WithDrawAmountScreen {

	private JButton enterButton = new JButton("Enter");
	private JButton cancelButton = new JButton("Cancel");
	private JTextField withdrawField = new JTextField("");
	private BankCard card;
	private JTextField amountInAccount; // Set this to the card passed in's amount.
	JFrame frame;

	public WithDrawAmountScreen(BankCard bc) {
		this.card = bc;
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getWithdrawField() {
		return withdrawField;
	}

	public double getAmountInAccount() {
		return card.getBalance();
	}

	public void setAmountInAccount(JTextField amountInAccount) {
		this.amountInAccount = amountInAccount;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

	public BankCard getCard() {
		return card;
	}

	public void displayFrame() {
		frame = new JFrame("ATM Welcome!");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		frame.setLocationRelativeTo(null); // centers the frame

		JPanel textfield = new JPanel(new FlowLayout());
		withdrawField.setPreferredSize(new Dimension(200, 20));
		textfield.add(new JLabel("Enter amount: "));
		textfield.add(withdrawField);
		frame.add("Center", textfield);

		JPanel buttonField = new JPanel(new FlowLayout());
		buttonField.add(cancelButton);
		buttonField.add(enterButton);

		frame.add("South", buttonField);

		// TO DO: Add funds available / balance on the screen.

		frame.pack();
		frame.setVisible(true);

		WithDrawAmountScreenController withdrawScreenController = new WithDrawAmountScreenController(this);
		withdrawScreenController.runController();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Comment out when not testing.

	/*
	 * public static void main(String[] args) {
	 * WithDrawAmountScreen withdrawScreen = new WithDrawAmountScreen();
	 * withdrawScreen.displayFrame();
	 * }
	 */

}
