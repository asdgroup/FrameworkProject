package credit.factory;

import credit.account.CreditAccount;
import framework.account.IAccount;
import framework.customer.CompanyCustomer;
import framework.customer.CustomerType;
import framework.customer.ICustomer;
import framework.customer.PersonalCustomer;
import framework.system.ASystemFactory;

public class CreditFactory extends ASystemFactory {

	@Override
	public IAccount createAccount(String[] accountInfo) {
		// TODO Auto-generated method stub
		return new CreditAccount(accountInfo[1], accountInfo[0]);
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
