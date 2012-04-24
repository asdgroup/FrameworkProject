package bankapplication;

import bankframework.account.AccountType;
import bankframework.account.IAccount;
import bankframework.customer.CompanyCustomer;
import bankframework.customer.CustomerType;
import bankframework.customer.ICustomer;
import bankframework.customer.PersonalCustomer;
import bankframework.system.ASystemFactory;

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
			return new PersonalCustomer(customerInfo[1],
					customerInfo[2], customerInfo[3], customerInfo[4],
					customerInfo[5]);
		} else {
			return new CompanyCustomer(customerInfo[1],
					customerInfo[2], customerInfo[3], customerInfo[4],
					customerInfo[5]);
		}
	}

}
