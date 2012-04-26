package framework.system;

import framework.account.IAccount;
import framework.customer.ICustomer;

public abstract class ASystemFactory implements ISystemFactory{

	@Override
	public abstract IAccount createAccount(String[] accountInfo) ;

	@Override
	public abstract ICustomer createCustomer(String[] customerInfo) ;

}
