package framework.system;

import framework.account.IAccount;
import framework.customer.CompanyCustomer;
import framework.customer.CustomerType;
import framework.customer.ICustomer;
import framework.customer.PersonalCustomer;

public abstract class ASystemFactory implements ISystemFactory {

	@Override
	public abstract IAccount createAccount(String[] accountInfo);

	@Override
	public ICustomer createCustomer(String[] customerInfo) {
		if (customerInfo[0].equals(CustomerType.PERSONAL)) {
			return new PersonalCustomer(customerInfo[1], customerInfo[2],
					customerInfo[3], customerInfo[4], customerInfo[5]);
		} else {
			return new CompanyCustomer(customerInfo[1], customerInfo[2],
					customerInfo[3], customerInfo[4], customerInfo[5]);
		}
	};

}
