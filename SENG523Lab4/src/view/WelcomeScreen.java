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

import controller.WelcomeFrameController;
import model.CardDatabase;
import model.SCB;

// The UI for the Welcome Screen.
public class WelcomeScreen {
	private SCB scb;
	private CardDatabase cardDB;
	private JButton insertCardButton = new JButton("Insert Card");
	private JButton instruction = new JButton("Instruction");
	private JTextField cardNumber = new JTextField("");
	JFrame frame;

	public WelcomeScreen(SCB scb, CardDatabase cardDB) {
		this.scb = scb;
		this.cardDB = cardDB;
	}

	public void displayFrame() {
		frame = new JFrame("ATM Welcome!");
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.GREEN);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		frame.setLocationRelativeTo(null); // centers frame

		JLabel welcomeMessage = new JLabel(
				"Welcome! Please Insert a card to begin. Click on the instruction button for more information",
				JLabel.CENTER);
		welcomeMessage.setFont(new Font(welcomeMessage.getFont().toString(), Font.BOLD, 30));

		frame.add("North", welcomeMessage);

		JPanel textfield = new JPanel(new FlowLayout());
		cardNumber.setPreferredSize(new Dimension(400, 20));
		textfield.add(new JLabel("Card Number: "));
		textfield.add(cardNumber);

		frame.add("Center", textfield);

		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(insertCardButton);
		buttons.add(instruction);
		frame.add("South", buttons);

		// frame.pack();
		frame.setVisible(true);

		WelcomeFrameController welcomeController = new WelcomeFrameController(this);
		welcomeController.runController();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JButton getInsertCardButton() {
		return insertCardButton;
	}

	public JTextField getCardNumber() {
		return cardNumber;
	}

	public SCB getScb() {
		return scb;
	}

	public CardDatabase getCardDB() {
		return cardDB;
	}

	public void reset() {
		frame.dispose();
		(new WelcomeScreen(scb, cardDB)).displayFrame();

	}

	public void dispose() {
		frame.dispose();
	}
	// Comment out when testing is done for this.
	/*
	 * public static void main(String [] args) {
	 * WelcomeScreen welcome = new WelcomeScreen();
	 * welcome.displayFrame();
	 * 
	 * }
	 */

}
