package banking.gui;

import java.awt.event.ActionEvent;
import framework.gui.AOperationForm;

public class DepositForm extends AOperationForm {
	private static final long serialVersionUID = 1L;
	private BankGUI parentframe;
	private String title = "Deposit";

	public DepositForm(BankGUI parentframe, String anncr) {
		this.parentframe = parentframe;
		setTitle(title);
		JTextField_NAME.setText(anncr);
		super.render();
		setVisible(true);
	}

	@Override
	public void JButtonOK_actionPerformed(ActionEvent event) {
		parentframe.amountDeposit = JTextField_Deposit.getText();
		parentframe.operation(title);
		dispose();
	}

}
