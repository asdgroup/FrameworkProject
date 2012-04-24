package bank.account;

import framework.account.AAccount;
import framework.account.AccountType;

public class CheckingAccount extends AAccount {
	public CheckingAccount(String accountNumber) {
		super(accountNumber);
		this.accountTpye = AccountType.CHECKING;
	}

	private double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
