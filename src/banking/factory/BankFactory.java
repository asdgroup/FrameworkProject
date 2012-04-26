package banking.factory;

import banking.account.CheckingAccount;
import banking.account.SavingAccount;
import framework.account.AccountType;
import framework.account.IAccount;
import framework.customer.CompanyCustomer;
import framework.customer.CustomerType;
import framework.customer.ICustomer;
import framework.customer.PersonalCustomer;
import framework.system.ASystemFactory;

public class BankFactory extends ASystemFactory {

	@Override
	public IAccount createAccount(String[] accountInfo) {
		if (accountInfo[0].equals(AccountType.SAVING)) {
			return new SavingAccount(accountInfo[1]);
		} else {
			return new CheckingAccount(accountInfo[1]);
		}
	}

	@Override
	public ICustomer createCustomer(String[] customerInfo) {
		if (customerInfo[0].equals(CustomerType.PERSONAL)) {
			return new PersonalCustomer(customerInfo[1], customerInfo[2],
					customerInfo[3], customerInfo[4], customerInfo[5]);
		} else {
			return new CompanyCustomer(customerInfo[1], customerInfo[2],
					customerInfo[3], customerInfo[4], customerInfo[5]);
		}
	}

}
