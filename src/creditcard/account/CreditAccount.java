package creditcard.account;

import framework.account.AAccount;

public class CreditAccount extends AAccount{
	
	private double limitation;
	private double monthlyIntest;
	private double monthlyPayment;
	private ICreditType type;
	
	public CreditAccount(String accountNumber,ICreditType type) {
		super(accountNumber);
		this.type = type;
	}
	

	public double getLimitation() {
		return limitation;
	}

	public void setLimitation(double limitation) {
		this.limitation = limitation;
	}

	public double getMonthlyIntest() {
		return monthlyIntest;
	}

	public void setMonthlyIntest(double monthlyIntest) {
		this.monthlyIntest = monthlyIntest;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public ICreditType getType() {
		return type;
	}

	public void setType(ICreditType type) {
		this.type = type;
	}



}
