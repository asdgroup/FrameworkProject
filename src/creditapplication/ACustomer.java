package creditapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class ACustomer implements ICustomer {

	protected List<IAccount> accounts;

	protected String type;
	protected String name;
	protected String city;
	protected String state;
	protected String street;
	protected String zip;
	protected String email;

	public ACustomer(String name, String city, String state, String street,
			String zip) {
		// this.type = type;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		// this.email = email;
		accounts = new ArrayList<IAccount>();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof IAccount) {
			System.out.println("send email to custmer");
		}
	}

	@Override
	public void addAccount(IAccount account) {
		accounts.add(account);
	}

	@Override
	public void removeAccount() {
		// TODO Auto-generated method stub
	}

	@Override
	public String printRecords() {
		StringBuffer sb = new StringBuffer();
		sb.append("Customer name: " + name + "\n");
		for (IAccount a : accounts) {
			sb.append(a.printEntries());
		}
		return sb.toString();
	}

	@Override
	public List<IAccount> getAccounts() {
		return accounts;
	}

	@Override
	public String getName() {
		return name;
	}

	// @Override
	// public void setName(String name) {
	// this.name = name;
	// }

	@Override
	public String getCity() {
		return city;
	}

	// @Override
	// public void setCity(String city) {
	// this.city = city;
	// }

	@Override
	public String getState() {
		return state;
	}

	// @Override
	// public void setState(String state) {
	// this.state = state;
	// }

	public String getStreet() {
		return street;
	}

	// @Override
	// public void setStreet(String street) {
	// this.street = street;
	// }

	@Override
	public String getZip() {
		return zip;
	}

	// @Override
	// public void setZip(String zip) {
	// this.zip = zip;
	// }

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getType() {
		return type;
	}

	// @Override
	// public void setEmail(String email) {
	// this.email = email;
	// }

}
