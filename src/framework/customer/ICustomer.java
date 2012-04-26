package framework.customer;

import java.util.List;
import java.util.Observer;

import framework.account.IAccount;


public interface ICustomer extends Observer {
	
	void addAccount(IAccount account);
	
	public List<IAccount> getAccounts();

	void removeAccount();

	public String getName();
	
	public String getType();

	public String getCity();

	public String getState();

	public String getStreet();

	public String getZip();

	public String getEmail();

	public String printRecords();

}
