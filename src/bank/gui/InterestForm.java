package bank.gui;

public class InterestForm extends AInterestForm {
	private static final long serialVersionUID = 1L;
	private BankGUI parentframe;

	public InterestForm(BankGUI parentframe) {
		this.parentframe = parentframe;
		super.render();
		setVisible(true);
	}

	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		parentframe.addInterest(Long.parseLong(JTextField_Deposit.getText()));
		dispose();
	}

}
