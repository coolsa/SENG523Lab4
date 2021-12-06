package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.WelcomeFrameController;

public class BillDisburse {
	private int HundredOutputQuantity;
	private int FiftyOutputQuantity;
	private int TwentyOutputQuantity;
	private int TenOutputQuantity;
	private int FiveOutputQuantity;
	private Disbursing DisbursingAmount;

	public static final BillDisburse INSTANCE = new BillDisburse();

	private enum Disbursing {
		OutputtingHundredDollarBill, OutputtingFiftyDollarBill, OutputtingTwentyDollarBill, OutputtingTenDollarBill,
		OutputtingFiveDollarBill, Inactive
	}
	
	// This function simulates the real dispensing of money.
	public void BillDispense() {
		DisbursingAmount = Disbursing.OutputtingHundredDollarBill;
		while(this.HundredOutputQuantity > 0 
				|| this.FiftyOutputQuantity > 0 
				|| this.TwentyOutputQuantity > 0
				|| this.TenOutputQuantity > 0 
				|| this.FiveOutputQuantity > 0) {
			JLabel welcomeMessage;
			if(this.HundredOutputQuantity > 0) {
				welcomeMessage = new JLabel("$100", JLabel.CENTER);
				this.HundredOutputQuantity --;
				BillStorage.INSTANCE.setAmountHundred(BillStorage.INSTANCE.getAmountHundred()-1);
				BillStorage.INSTANCE.setAmountTotal(BillStorage.INSTANCE.getAmountTotal()-100);
			}
			else if(this.FiftyOutputQuantity > 0) {
				welcomeMessage = new JLabel("$50", JLabel.CENTER);
				this.FiftyOutputQuantity --;
				BillStorage.INSTANCE.setAmountFifty(BillStorage.INSTANCE.getAmountFifty()-1);
				BillStorage.INSTANCE.setAmountTotal(BillStorage.INSTANCE.getAmountTotal()-50);
			}
			else if(this.TwentyOutputQuantity > 0) {
				welcomeMessage = new JLabel("$20", JLabel.CENTER);
				this.TwentyOutputQuantity --;
				BillStorage.INSTANCE.setAmountTwenty(BillStorage.INSTANCE.getAmountTwenty()-1);
				BillStorage.INSTANCE.setAmountTotal(BillStorage.INSTANCE.getAmountTotal()-20);
			}
			else if(this.TenOutputQuantity > 0) {
				welcomeMessage = new JLabel("$10", JLabel.CENTER);
				this.TenOutputQuantity --;
				BillStorage.INSTANCE.setAmountTen(BillStorage.INSTANCE.getAmountTen()-1);
				BillStorage.INSTANCE.setAmountTotal(BillStorage.INSTANCE.getAmountTotal()-10);
			}
			else if(this.FiveOutputQuantity > 0) {
				welcomeMessage = new JLabel("$5", JLabel.CENTER);
				this.FiveOutputQuantity --;
				BillStorage.INSTANCE.setAmountFive(BillStorage.INSTANCE.getAmountFive()-1);
				BillStorage.INSTANCE.setAmountTotal(BillStorage.INSTANCE.getAmountTotal()-5);
			}
			else break;
			JFrame frame;
			frame = new JFrame("ATM Welcome!");
			frame.setLayout(new BorderLayout());
			frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
			frame.setLocationRelativeTo(null); //centers frame 
			
			welcomeMessage.setFont(new Font(welcomeMessage.getFont().toString(), Font.BOLD, 30));
			
			frame.add("North", welcomeMessage);
			JButton acceptButton = new JButton("Accept");
			JPanel buttonField = new JPanel(new FlowLayout());
			buttonField.add(acceptButton);
			frame.add("South", buttonField);
			acceptButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					// Open a new Welcome Screen?
				}
			});
			frame.pack();
			frame.setVisible(true);
			
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		DisbursingAmount = Disbursing.Inactive;
	}

	// As per Lab 3.
	public void DisburseBills(double DispensingAmount) {
		if (!SCB.INSTANCE.isWithdrawing()) {
			SCB.INSTANCE.setWithdrawing(true);
			if (SCB.INSTANCE.getAmountTotal() >= DispensingAmount) {
				DisbursingAmount = Disbursing.OutputtingHundredDollarBill; // begin dispensing hundreds.
				SCB.INSTANCE.setDispenseAmount(100);
				while (SCB.INSTANCE.isWithdrawing() != false) {
					// Verify Bill Availability here.
					BillStorage.INSTANCE.verifyBillAvailability();
					if (DispensingAmount >= SCB.INSTANCE.getDispenseAmount() && SCB.INSTANCE.isVerifiedDispense()) {
						switch (DisbursingAmount) {
						case OutputtingHundredDollarBill:
							this.HundredOutputQuantity++;
							DispensingAmount -= 100;
							break;
						case OutputtingFiftyDollarBill:
							this.FiftyOutputQuantity++;
							DispensingAmount -= 50;
							break;
						case OutputtingTwentyDollarBill:
							this.TwentyOutputQuantity++;
							DispensingAmount -= 20;
							break;
						case OutputtingTenDollarBill:
							this.TenOutputQuantity++;
							DispensingAmount -= 10;
							break;
						case OutputtingFiveDollarBill:
							this.FiveOutputQuantity++;
							DispensingAmount -= 5;
							break;
						default:
							SCB.INSTANCE.setWithdrawing(false);
						}
					} else {
						switch (DisbursingAmount) {
						case OutputtingHundredDollarBill:
							DisbursingAmount = Disbursing.OutputtingFiftyDollarBill;
							SCB.INSTANCE.setDispenseAmount(50);
							break;
						case OutputtingFiftyDollarBill:
							DisbursingAmount = Disbursing.OutputtingTwentyDollarBill;
							SCB.INSTANCE.setDispenseAmount(20);
							break;
						case OutputtingTwentyDollarBill:
							DisbursingAmount = Disbursing.OutputtingTenDollarBill;
							SCB.INSTANCE.setDispenseAmount(10);
							break;
						case OutputtingTenDollarBill:
							DisbursingAmount = Disbursing.OutputtingFiveDollarBill;
							SCB.INSTANCE.setDispenseAmount(5);
							break;
						default:
							DisbursingAmount = Disbursing.Inactive;
							SCB.INSTANCE.setDispenseAmount(0);
							// SCB|SM.WithDrawAmountEntered|N = DispenseAmount|N // record leftover
							SCB.INSTANCE.setWithdrawing(false);
							break;
						}
					}
				}
			}
			SCB.INSTANCE.setWithdrawing(false); // make sure to set false before exiting. missed in lab3.
		}
	}
}
