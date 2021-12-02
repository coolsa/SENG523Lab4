package model;

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
	// TODO: do something to simulate interaction with port here to disburse money.
	
	// As per Lab 3.
	public void DisburseBills(double DispensingAmount) {
		if (SCB.INSTANCE.isWithdrawing()) {
			SCB.INSTANCE.setWithdrawing(true);
			if (SCB.INSTANCE.getAmountTotal() >= DispensingAmount) {
				DisbursingAmount = Disbursing.OutputtingHundredDollarBill; // begin dispensing hundreds.
				SCB.INSTANCE.setDispenseAmount(100);
				while(SCB.INSTANCE.isWithdrawing() != false) {
					// Verify Bill Availability here.
					if(DispensingAmount >= SCB.INSTANCE.getDispenseAmount() && SCB.INSTANCE.isVerifiedDispense()) {
						switch(DisbursingAmount) {
							case OutputtingHundredDollarBill:
								this.HundredOutputQuantity++;
								DispensingAmount -= 100;
							case OutputtingFiftyDollarBill:
								this.FiftyOutputQuantity++;
								DispensingAmount -= 50;
							case OutputtingTwentyDollarBill:
								this.TwentyOutputQuantity++;
								DispensingAmount -= 20;
							case OutputtingTenDollarBill:
								this.TenOutputQuantity++;
								DispensingAmount -= 10;
							case OutputtingFiveDollarBill:
								this.FiveOutputQuantity++;
								DispensingAmount -= 5;
							default:
								SCB.INSTANCE.setWithdrawing(false);
						}
					} else {
						switch(DisbursingAmount) {
							case OutputtingHundredDollarBill:
								DisbursingAmount = Disbursing.OutputtingFiftyDollarBill;
								SCB.INSTANCE.setDispenseAmount(50);
							case OutputtingFiftyDollarBill:
								DisbursingAmount = Disbursing.OutputtingTwentyDollarBill;
								SCB.INSTANCE.setDispenseAmount(20);
							case OutputtingTwentyDollarBill:
								DisbursingAmount = Disbursing.OutputtingTenDollarBill;
								SCB.INSTANCE.setDispenseAmount(10);
							case OutputtingTenDollarBill:
								DisbursingAmount = Disbursing.OutputtingFiveDollarBill;
								SCB.INSTANCE.setDispenseAmount(5);
							default:
								DisbursingAmount = Disbursing.Inactive;
								SCB.INSTANCE.setDispenseAmount(0);
								//SCB|SM.WithDrawAmountEntered|N = DispenseAmount|N // record leftover
								SCB.INSTANCE.setWithdrawing(false);
						}
					}
				}
			}
			SCB.INSTANCE.setWithdrawing(false); //make sure to set false before exiting. missed in lab3.
		}
	}
}
