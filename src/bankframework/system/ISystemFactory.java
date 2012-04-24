package bankframework.system;

import bankframework.account.IAccount;
import bankframework.customer.ICustomer;

public interface ISystemFactory {
	IAccount createAccount(String[] accountInfo);
	ICustomer createCustomer(String[] customerInfo);
}
