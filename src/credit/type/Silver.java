package credit.type;

public class Silver implements CreditType {

	@Override
	public double getMonthlyPaymentRate() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return 3;
	}

}
