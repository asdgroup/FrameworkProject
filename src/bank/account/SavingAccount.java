package bank.account;

import framework.account.AAccount;
import framework.account.AccountType;

public class SavingAccount extends AAccount {
	public SavingAccount(String accountNumber) {
		super(accountNumber);
		this.accountTpye = AccountType.SAVING;
	}

	private double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
