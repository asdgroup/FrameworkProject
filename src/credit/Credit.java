package credit;

import credit.factory.CreditFactory;
import credit.gui.CreditGUI;
import framework.system.ISystemFactory;
import framework.system.ISystemService;
import framework.system.SystemFacade;
import framework.system.SystemService;

public class Credit {

	public static void main(String[] args) {
		SystemFacade creditFacade = new SystemFacade();
		ISystemFactory creditFactory = new CreditFactory();
		ISystemService creditService = new SystemService();
		creditFacade.setSysFactory(creditFactory);
		creditFacade.setSysService(creditService);
		CreditGUI cg = new CreditGUI(creditFacade);
	}
}
