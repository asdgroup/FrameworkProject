package creditapplication;

public class SystemFacade {

	private ISystemService sysService;
	private ISystemFactory sysFactory;

	public void withdrawal(String accountNumber, double amount) {
		sysService.withdrawal(accountNumber, amount);
	}

	public void deposite(String accountNumber, double amount) {
		sysService.deposit(accountNumber, amount);
	}

	public void addInterest(double interest) {
		sysService.addInterest(interest);
	}

	// public void addCustomer(ICustomer customer){
	// sysService.addCustomer(customer);
	// }

	public void addAccount(ICustomer customer, IAccount account) {
		sysService.addAccount(customer, account);
	}

	public String generaterReports() {
		return sysService.generateReports();
	}

	public IAccount createAccount(String[] accountInfo) {
		return sysFactory.createAccount(accountInfo[0]);
	}

	public ICustomer createCustomer(String[] customerInfo) {
		return sysFactory.createCustomer(customerInfo);
	}

	// public ISystemService getSysService() {
	// return sysService;
	// }

	public void setSysService(ISystemService sysService) {
		this.sysService = sysService;
	}

	// public ISystemFactory getSysFactory() {
	// return sysFactory;
	// }

	public void setSysFactory(ISystemFactory sysFactory) {
		this.sysFactory = sysFactory;
	}
}
