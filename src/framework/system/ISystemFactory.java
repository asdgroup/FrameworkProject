package framework.system;

import framework.account.IAccount;
import framework.customer.ICustomer;

public interface ISystemFactory {
	IAccount createAccount(String[] accountInfo);
	ICustomer createCustomer(String[] customerInfo);
}
