package credit.type;

public class Silver implements CreditType {

	@Override
	public double getMonthlyPaymentRate() {
		// TODO Auto-generated method stub
		return 0.14;
	}

	@Override
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return 0.18;
	}

}
