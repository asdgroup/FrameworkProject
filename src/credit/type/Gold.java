package credit.type;

public class Gold implements CreditType {

	@Override
	public double getMonthlyPaymentRate() {
		// TODO Auto-generated method stub
		return 0.12;
	}

	@Override
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return 0.14;
	}

}
