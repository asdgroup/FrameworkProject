package credit.type;

public class Bronze implements CreditType {

	@Override
	public double getMonthlyPaymentRate() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return 5;
	}

}
