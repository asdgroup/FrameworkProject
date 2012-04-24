package credit.gui;

import java.awt.event.ActionEvent;


public class DepositForm extends AOperationForm{
	
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
