package bankframework.system;

import java.util.ArrayList;
import java.util.List;

import bankframework.account.IAccount;
import bankframework.customer.ICustomer;

public class ASystemService implements ISystemService {
	protected List<ICustomer> customers;
	protected List<IAccount> accounts;

	public ASystemService() {
		customers = new ArrayList<ICustomer>();
		accounts = new ArrayList<IAccount>();
	}

	@Override
	public void addAccount(ICustomer customer, IAccount account) {
		ICustomer cm = match(customer);
		if(cm!=null){
			cm.addAccount(account);
		}else{
			customer.addAccount(account);
			customers.add(customer);
		}
		accounts.add(account);
	}

	private ICustomer match(ICustomer customer) {
		if (customers != null) {
			for (ICustomer c : customers) {
				if (c.getType().equals(customer.getType())
						&& c.getName().equals(customer.getName())
						&& c.getStreet().equals(customer.getStreet())
						&& c.getCity().equals(customer.getCity())
						&& c.getState().equals(customer.getState())
						&& c.getZip().equals(customer.getZip())) {
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public ICustomer getCustomer(String name) {
		if (customers.size() != 0) {
			for (ICustomer c : customers) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
			return null;
		}
		return null;
	}


	@Override
	public String generateReports() {
		StringBuffer sb = new StringBuffer();
		for (ICustomer c : customers) {
			sb.append(c.printRecords());
		}
		return sb.toString();
	}

	@Override
	public void addInterest(double interest) {
		for (IAccount a : accounts) {
			a.deposit(interest);
		}

	}

	@Override
	public void withdrawal(String accountNumber, double amount) {
		IAccount account = getAccount(accountNumber);
		if(account!=null){
			account.withdrawal(amount);
		}
	}

	@Override
	public void deposit(String accountNumber, double amount) {
		IAccount account = getAccount(accountNumber);
		if(account!=null){
			account.deposit(amount);
		}

	}

	private IAccount getAccount(String accountNumber) {
		if(accounts!=null){
			for(IAccount a : accounts){
				if(a.getAccountNumber().equals(accountNumber)){
					return a;
				}
			}
		}
		return null;
	}

	

}
