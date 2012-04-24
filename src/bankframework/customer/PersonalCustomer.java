package bankframework.customer;

import bankframework.account.IAccount;


public class PersonalCustomer extends ACustomer implements IPerson{
	protected String birthDay;
	protected double transactionLimit = 400.0;
	public PersonalCustomer(String name, String city,
			String state, String street, String zip) {
		super(name, city, state, street, zip);
		this.type = CustomerType.PERSONAL;
	}

	@Override
	public String getBirthDay() {
		return birthDay;
	}

	
	public void setBirthDay(String date){
		this.birthDay = date;
	}
	
	@Override
	public void addAccount(IAccount account) {
		account.setTrasactionLimit(transactionLimit);
		super.addAccount(account);
	}
}
