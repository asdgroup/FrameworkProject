package bankapplication;

import bankframework.system.ISystemFactory;
import bankframework.system.ISystemService;
import bankframework.system.SystemFacade;

public class Bank {
		
	public static void main(String[] args) {
		
		SystemFacade bankFacade = new SystemFacade();
		ISystemFactory bankFactory = new BankFactory();
		ISystemService bankService = new BankService();
		bankFacade.setSysFactory(bankFactory);
		bankFacade.setSysService(bankService);
		new BankGUI("Bank Application", null, bankFacade);
	}

}
