package creditapplication;

import java.util.List;
import java.util.Observer;

public interface ICustomer extends Observer {

	void addAccount(IAccount account);

	public List<IAccount> getAccounts();

	void removeAccount();

	public String getName();

	public String getType();

	// public void setName(String name);

	public String getCity();

	// public void setCity(String city);

	public String getState();

	// public void setState(String state);

	public String getStreet();

	// public void setStreet(String street);

	public String getZip();

	// public void setZip(String zip);

	public String getEmail();

	// public void setEmail(String email);

	public String printRecords();

}
