package creditapplication;

import javax.swing.UIManager;

import bankapplication.BankFactory;
import bankapplication.BankGUI;
import bankapplication.BankService;
import bankframework.system.ISystemFactory;
import bankframework.system.ISystemService;
import bankframework.system.SystemFacade;

public class Credit {
	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/

	static public void main(String[] args) {
		SystemFacade creditFacade = new SystemFacade();
		ISystemFactory creditFactory = new BankFactory();
		ISystemService bankService = new BankService();
		creditFacade.setSysFactory(creditFactory);
		creditFacade.setSysService(bankService);
		// ISystemGUI asg = new BankGUI("Bank Application", null, bankFacade);
		new BankGUI("Bank Application", null, creditFacade);
		try {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			(new CreditGUI()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}
}
