package framework.account;

import java.util.Date;

public interface IEntry {
	void setAmount(double amount);
	void setDate(Date date);
	String toString();
}
