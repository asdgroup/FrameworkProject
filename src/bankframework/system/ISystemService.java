package bankframework.system;

import bankframework.account.IAccount;
import bankframework.customer.ICustomer;

public interface ISystemService {
	String generateReports();
	void addInterest(double interest);
	void withdrawal(String accountNumber,double amount);
	void deposit(String accountNumber,double amount);
//	void addCustomer(ICustomer customer);
	void addAccount(ICustomer customer, IAccount account);
//	void addAccount(IAccount account);
	
	ICustomer getCustomer(String name);
}
