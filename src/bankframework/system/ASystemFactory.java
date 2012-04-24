package bankframework.system;

import bankframework.account.IAccount;
import bankframework.customer.ICustomer;

public abstract class ASystemFactory implements ISystemFactory{

	@Override
	public abstract IAccount createAccount(String[] accountInfo) ;

	@Override
	public abstract ICustomer createCustomer(String[] customerInfo) ;

}
