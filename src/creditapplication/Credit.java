package creditapplication;

public class Credit {
	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/

	static public void main(String[] args) {
		SystemFacade creditFacade = new SystemFacade();
		ISystemFactory creditFactory = new CreditFactory();
		ISystemService creditService = new CreditService();
		creditFacade.setSysFactory(creditFactory);
		creditFacade.setSysService(creditService);
		// ISystemGUI asg = new BankGUI("Bank Application", null, bankFacade);
		new CreditGUI();
	}
}
