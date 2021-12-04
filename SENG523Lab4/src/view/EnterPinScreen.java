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
import controller.EnterPinScreenController;
import model.BankCard;

// The enter pin screen. Asks for a card pin, and you can either cancel or enter. 
public class EnterPinScreen {

	private JButton enterButton = new JButton("Enter");
	private JButton cancelButton = new JButton("Cancel");
	private JTextField pinField = new JTextField("");
	private BankCard card;
	JFrame frame;

	public EnterPinScreen() {

	}

	public EnterPinScreen(BankCard card) {
		this.card = card;
	}

	public void displayFrame() {
		frame = new JFrame("ATM Welcome!");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
				Toolkit.getDefaultToolkit().getScreenSize().height / 2);
		frame.setLocationRelativeTo(null); // centers the frame

		JPanel textfield = new JPanel(new FlowLayout());
		pinField.setPreferredSize(new Dimension(200, 20));
		textfield.add(new JLabel("Enter your pin: "));
		textfield.add(pinField);
		frame.add("Center", textfield);

		JPanel buttonField = new JPanel(new FlowLayout());
		buttonField.add(cancelButton);
		buttonField.add(enterButton);

		frame.add("South", buttonField);

		frame.pack();
		frame.setVisible(true);

		EnterPinScreenController pinScreenController = new EnterPinScreenController(this);
		pinScreenController.runController();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getPinField() {
		return pinField;
	}

	public BankCard getCard() {
		return card;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

	// Comment out when not testing appearance.
	// public static void main(String[] args) {
	// EnterPinScreen enterPinScreen = new EnterPinScreen();
	// enterPinScreen.displayFrame();
	// }

}
