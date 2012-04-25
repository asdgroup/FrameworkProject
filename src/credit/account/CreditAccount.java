package credit.account;

import credit.type.Bronze;
import credit.type.CreditType;
import credit.type.Gold;
import credit.type.Silver;
import framework.account.AAccount;
import framework.customer.CompanyCustomer;
import framework.customer.CustomerType;
import framework.customer.PersonalCustomer;

public class CreditAccount extends AAccount {
	public CreditAccount(String accountNumber, String creditType) {
		super(accountNumber);
		if (creditType.equals("Gold")) {
			type = new Gold();
		} else if (creditType.equals("Silver")) {
			type = new Silver();
		} else {
			type = new Bronze();
		}
	}

	private String expDate;
	private CreditType type;

	public double getMonthlyPayment() {
		// TODO
		return 1.0 * type.getMonthlyPaymentRate();
	}

	public double getMonthlyInterest() {
		// TODP
		return 2.0 * type.getMonthlyInterestRate();
	}

}
