package creditapplication;

public interface ISystemFactory {

	ICustomer createCustomer(String[] customerInfo);

	IAccount createAccount(String accountNumber);
}
