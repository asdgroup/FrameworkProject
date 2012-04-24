package framework.system;

import framework.account.IAccount;
import framework.customer.ICustomer;

public class SystemFacade {
	private ISystemService sysService;
	private ISystemFactory sysFactory;
	
	public void withdrawal(String accountNumber,double amount){
		sysService.withdrawal(accountNumber,amount);
	}
	
	public void deposite(String accountNumber,double amount){
		sysService.deposit(accountNumber,amount);
	}
	
	public void addInterest(double interest){
		sysService.addInterest(interest);
	}
	
	
	public void addAccount(ICustomer customer, IAccount account){
		sysService.addAccount(customer, account);
	}
	
	public String generaterReports(){
		return sysService.generateReports();
	}
	
	public IAccount createAccount(String[] accountInfo){
		return sysFactory.createAccount(accountInfo);
	}
	
	public ICustomer createCustomer(String[] customerInfo){
		return sysFactory.createCustomer(customerInfo);
	}
	

	public void setSysService(ISystemService sysService) {
		this.sysService = sysService;
	}

	public void setSysFactory(ISystemFactory sysFactory) {
		this.sysFactory = sysFactory;
	}
}
