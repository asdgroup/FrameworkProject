package bank;

import bank.factory.BankFactory;
import bank.gui.BankGUI;
import framework.system.ISystemFactory;
import framework.system.ISystemService;
import framework.system.SystemFacade;
import framework.system.SystemService;

public class Bank {

	public static void main(String[] args) {

		SystemFacade bankFacade = new SystemFacade();
		ISystemFactory bankFactory = new BankFactory();
		ISystemService bankService = new SystemService();
		bankFacade.setSysFactory(bankFactory);
		bankFacade.setSysService(bankService);
		new BankGUI(bankFacade);
	}

}
