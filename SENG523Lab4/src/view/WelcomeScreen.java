package view;

import java.awt.BorderLayout;
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

// The UI for the Welcome Screen.
public class WelcomeScreen {

	private JButton insertCardButton = new JButton("InsertCard");
	private JTextField cardNumber = new JTextField("Enter bank card number.");
	JFrame frame;
	
	public void displayFrame() {
		frame = new JFrame("ATM Welcome!");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
		frame.setLocationRelativeTo(null); //centers frame 
		
		JLabel welcomeMessage = new JLabel("Welcome! Please Insert a card to begin.", JLabel.CENTER);
		welcomeMessage.setFont(new Font(welcomeMessage.getFont().toString(), Font.BOLD, 30));
		
		frame.add("North", welcomeMessage);
		
		JPanel textfield = new JPanel(new FlowLayout());
		cardNumber.setPreferredSize(new Dimension(400,20));
		textfield.add(new JLabel("Card Number: "));
		textfield.add(cardNumber);
		
		frame.add("Center", textfield);
		
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(insertCardButton);
		frame.add("South", buttons);
		
		frame.pack();
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
	
	
	// Comment out when testing is done for this. 
	/*
	public static void main(String [] args) {
		WelcomeScreen welcome = new WelcomeScreen();
		welcome.displayFrame();
			
	}
	*/
	
}
