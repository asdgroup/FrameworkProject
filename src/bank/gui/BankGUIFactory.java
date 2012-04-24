package bank.gui;

import javax.swing.JDialog;

import framework.gui.ISystemGUIFactory;


public class BankGUIFactory implements ISystemGUIFactory {

	private BankGUI parentframe;

	public BankGUIFactory(BankGUI parentframe) {
		this.parentframe = parentframe;
	}

	@Override
	public JDialog getBankSubForm(String type, String accnr) {
		JDialog form = null;
		if (type.equals("deposit")) {
			form = new DepositForm(parentframe, accnr);
		} else if (type.equals("withdraw")) {
			form = new WithdrawalForm(parentframe, accnr);
		} else if (type.equals("company")) {
			form = new CompanyForm(parentframe);
		} else if (type.equals("person")) {
			form = new PersonForm(parentframe);
		} else if (type.equals("interest")) {
			form = new InterestForm(parentframe);
		}
		return form;
	}

}
