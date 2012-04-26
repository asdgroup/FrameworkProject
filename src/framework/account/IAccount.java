package framework.account;

public interface IAccount {
	void addEntry(IEntry entry);
	boolean deposit(double amount);
	boolean withdrawal(double amount);
	void addInterest(double interest);
	String getAccountNumber();
	double getBalance();
	String printEntries();
	void setTransactionLimit(double limit);
}
