package creditcard;

import banking.factory.BankFactory;
import banking.gui.BankGUI;
import creditcard.factory.CreditFactory;
import creditcard.gui.CreditGUI;
import framework.system.ISystemFactory;
import framework.system.ISystemService;
import framework.system.SystemFacade;
import framework.system.SystemService;

public class CreditApplication {

	public static void main(String[] args) {
		
		SystemFacade creditFacade = new SystemFacade();
		ISystemFactory creditFactory = new CreditFactory();
		ISystemService creditService = new SystemService();
		creditFacade.setSysFactory(creditFactory);
		creditFacade.setSysService(creditService);
		new CreditGUI(creditFacade);
	
	}

}
