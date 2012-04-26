package framework.system;

import framework.account.IAccount;
import framework.customer.ICustomer;

public interface ISystemService {
	String generateReports();
	void addInterest(double interest);
	void withdrawal(String accountNumber,double amount);
	void deposit(String accountNumber,double amount);
	void addAccount(ICustomer customer, IAccount account);
	ICustomer getCustomer(String name);
}
