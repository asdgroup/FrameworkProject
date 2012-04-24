package creditapplication;

import java.util.Date;

public class Entry implements IEntry{
	
	private double amount;
	private Date date;
	private String operation;
	
	public Entry(double amount, String operation, Date date){
		this.amount = amount;
		this.date = date;
		this.operation = operation;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("        Date: "+date+"\n");
		sb.append("        Operation: "+operation+"\n");
		sb.append("        Amount: "+amount+"\n\n");
		return sb.toString();
	}

}
