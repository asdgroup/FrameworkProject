package creditapplication;

public class CreditFactory extends ASystemFactory {

	public IAccount createAccount(String accountNumber) {
		return new CreditAccount(accountNumber);

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
