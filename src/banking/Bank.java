package banking;

import banking.factory.BankFactory;
import banking.gui.BankGUI;
import framework.system.ISystemFactory;
import framework.system.ISystemService;
import framework.system.FinancialCompany;
import framework.system.SystemService;

public class Bank {

	public static void main(String[] args) {

		FinancialCompany bank = new FinancialCompany();
		ISystemFactory bankFactory = new BankFactory();
		ISystemService bankService = new SystemService();
		bank.setSysFactory(bankFactory);
		bank.setSysService(bankService);
		new BankGUI(bank);
	}

}
