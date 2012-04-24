package framework.customer;

public class CompanyCustomer extends ACustomer implements ICompany{
	
	public CompanyCustomer(String name, String city, String state,
			String street, String zip) {
		super(name, city, state, street, zip);
		this.type = CustomerType.COMPANY;
	}

	protected int numberOfEmployee;

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

}
