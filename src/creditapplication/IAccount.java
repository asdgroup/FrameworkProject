package creditapplication;

public interface IAccount {
	void addEntry(IEntry entry);
	boolean deposit(double amount);
	boolean withdrawal(double amount);
	void addInterest(double interest);
	String getAccountNumber();
	double getBalance();
	String printEntries();
	void setTrasactionLimit(double limit);
//	void setAccountNumber(String ac);
}
