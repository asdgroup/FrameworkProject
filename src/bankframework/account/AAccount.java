package bankframework.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class AAccount extends Observable implements IAccount {
	
	protected List<IEntry> entries;
	protected double balance;
	protected double transactionLimit;
	protected String accountNumber;
	protected String accountTpye;

	public AAccount(String accountNumber){
		this.accountNumber = accountNumber;
		entries = new ArrayList<IEntry>();
		transactionLimit = 0.0;
		balance = 0.0;
	}
	
	@Override
	public void addEntry(IEntry entry) {
		entries.add(entry);
	}

	@Override
	public boolean deposit(double amount) {
		balance += amount;
		checkAmount(amount);
		addEntry(new Entry(amount,"Deposit",new Date()));
		return true;
	}

	@Override
	public boolean withdrawal(double amount) {
		if(balance>amount){
			balance -= amount;
			checkAmount(amount);
			addEntry(new Entry(amount,"Withdrawal",new Date()));
			return true;
		}
		return false;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}
	
	protected void checkAmount(double amount){
		if((transactionLimit>0.0)&&(amount>=transactionLimit)){
			setChanged();
			notify();
		}	
	}
	
	public double getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(double transactionLimit) {
		this.transactionLimit = transactionLimit;
	}

	@Override
	public String printEntries() {
		StringBuffer sb = new StringBuffer();
		sb.append("    Account Number: "+accountNumber+"\n");
		sb.append("    Account Type: "+accountTpye+"\n");
		for(IEntry e : entries){
			sb.append(e.toString());
		}
		return sb.toString();
	}

	@Override
	public void setTrasactionLimit(double limit) {
		this.transactionLimit = limit;
	}

	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public void addInterest(double interest) {
		balance += interest;
		checkAmount(interest);
		addEntry(new Entry(interest,"Add Interest",new Date()));
		
	}

}
