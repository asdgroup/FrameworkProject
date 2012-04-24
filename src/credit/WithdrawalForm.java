package credit;

import java.awt.event.ActionEvent;

import credit.gui.CreditGUI;
import framework.gui.AOperationForm;

public class WithdrawalForm extends AOperationForm {

	private CreditGUI parentframe;

	public WithdrawalForm(CreditGUI parentframe, String anncr) {
		this.parentframe = parentframe;
		setTitle("Charge Account");
		JTextField_NAME.setText(anncr);
		super.render();
		setVisible(true);
	}

	@Override
	public void JButtonOK_actionPerformed(ActionEvent event) {
		parentframe.amountDeposit = JTextField_Deposit.getText();
		dispose();
	}

}
