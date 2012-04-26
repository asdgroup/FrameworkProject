package creditcard.gui;

import java.awt.event.ActionEvent;
import framework.gui.AOperationForm;

public class DepositForm extends AOperationForm {
	private static final long serialVersionUID = 1L;
	private CreditGUI parentframe;

	public DepositForm(CreditGUI parentframe, String anncr) {
		this.parentframe = parentframe;
		setTitle("Deposit");
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
