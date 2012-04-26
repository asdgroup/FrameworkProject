package creditcard.account;

public class ACreditType implements ICreditType{
	
	protected double monthlyInterest;
	protected double monthlyPayment;
	
	@Override
	public double getMonthlyInterest() {
		return monthlyInterest;
	}

	@Override
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

}
