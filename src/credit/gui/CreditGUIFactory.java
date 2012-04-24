package credit.gui;

import javax.swing.JDialog;

import credit.JDialogGenBill;
import credit.JDialog_AddCCAccount;
import credit.WithdrawalForm;
import credit.gui.CreditGUI;
import credit.gui.DepositForm;
import framework.gui.ISystemGUIFactory;

public class CreditGUIFactory implements ISystemGUIFactory {

	private CreditGUI parentframe;

	public CreditGUIFactory(CreditGUI parentframe) {
		this.parentframe = parentframe;
	}

	@Override
	public JDialog getBankSubForm(String type, String anncr) {
		JDialog form = null;
		if (type.equals("generatebills")) {
			form = new JDialogGenBill(anncr);
		} else if (type.equals("deposit")) {
			form = new WithdrawalForm(parentframe, anncr);
		} else if (type.equals("withdraw")) {
			form = new DepositForm(parentframe, anncr);
		} else if (type.equals("person")) {
			form = new JDialog_AddCCAccount(parentframe);
		}

		return form;
	}

}
