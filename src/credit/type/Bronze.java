package credit.type;

public class Bronze implements CreditType {

	@Override
	public double getMonthlyPaymentRate() {
		// TODO Auto-generated method stub
		return 0.22;
	}

	@Override
	public double getMonthlyInterestRate() {
		// TODO Auto-generated method stub
		return 0.20;
	}

}
