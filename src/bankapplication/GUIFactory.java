package bankapplication;

import bankframework.gui.ISystemGUI;

public class GUIFactory { 
	
	public static ISystemGUI getBankGUI(String type, BankGUI gui, String anncr){
		ISystemGUI form = null;
		if(type.equals("deposit")){
			form = new OperationForm(gui, anncr);
			form.setTitle("Deposite");
		}else if(type.equals("withdraw")){
			form = new OperationForm(gui, anncr);
			form.setTitle("Withdraw");
		}else if(type.equals("company")){
			form = new CompanyForm(gui);
			form.setTitle("Add Company Account");			
		}else if(type.equals("person")){
			form = new PersonForm(gui);
			form.setTitle("Add Personal Account");			
		}else if(type.equals("interest")){
			form = new InterestForm(gui);
			form.setTitle("Add Interest");
		}
		return form;		
	}

}
