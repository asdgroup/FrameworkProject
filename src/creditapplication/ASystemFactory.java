package creditapplication;

import creditapplication.IAccount;

public abstract class ASystemFactory implements ISystemFactory {

	@Override
	public abstract IAccount createAccount(String accountNumber);

	@Override
	public abstract ICustomer createCustomer(String[] customerInfo);

}
