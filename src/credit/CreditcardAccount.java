package credit;

import framework.account.AAccount;

public class CreditcardAccount extends AAccount{
	public CreditcardAccount(String accountNumber) {
		super(accountNumber);
	}

	private String expDate;
	private CreditcardType type;
	
	public double getMonthlyPayment(){
		//TODO
		return 0.0;
	}
	
	public double getMonthlyInterest(){
		//TODP
		return 0.0;
	}
	
}
