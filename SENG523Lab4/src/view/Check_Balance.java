package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Check_Balance_Controller;
import model.BankCard;

public class Check_Balance {
	// private SCB scb;
	// private CardDatabase cardDB;
	private BankCard bc;
	private JButton withdraw = new JButton("Withdraw");
	private JButton deposit = new JButton("Deposit");
	private JTextField balance = new JTextField("");
	JFrame frame;

	public Check_Balance() {

	}

	public Check_Balance(BankCard bc) {
		this.bc = bc;
	}

	public void displayFrame() {
		frame = new JFrame("Check your balance!!!");
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.GREEN);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		frame.setLocationRelativeTo(null); // centers frame

		JLabel welcomeMessage = new JLabel(
				"Your available balance is below",
				JLabel.CENTER);
		welcomeMessage.setFont(new Font(welcomeMessage.getFont().toString(), Font.BOLD, 30));

		frame.add("North", welcomeMessage);

		JPanel textfield = new JPanel(new FlowLayout());
		balance.setPreferredSize(new Dimension(400, 20));
		// balance.setText(Double.toString(bc.getBalance()));
		textfield.add(new JLabel("Balance: "));
		textfield.add(balance);
		balance.setEditable(false);

		frame.add("Center", textfield);

		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(withdraw);
		buttons.add(deposit);
		frame.add("South", buttons);

		// frame.pack();
		frame.setVisible(true);

		// WelcomeFrameController welcomeController = new WelcomeFrameController(this);
		// welcomeController.runController();
		Check_Balance_Controller controller = new Check_Balance_Controller(this);
		controller.runController();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public BankCard getCard() {
		return bc;
	}

	public JButton getWithdrawButton() {
		return withdraw;
	}

	public JButton getDepositButton() {
		return deposit;
	}

	// public void reset() {
	// frame.dispose();

	// }
	public JTextField getBalanceField() {
		return balance;
	}

	public void setBalance(String money) {
		balance.setText(money);
	}

	public void dispose() {
		frame.dispose();
	}

	public static void main(String[] args) {
		BankCard card1 = new BankCard(111111111, 1111, 300.0, true);
		Check_Balance checkBalance = new Check_Balance(card1);
		checkBalance.displayFrame();

	}

}