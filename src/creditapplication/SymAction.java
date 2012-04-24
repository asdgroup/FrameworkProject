package creditapplication;

class SymAction implements java.awt.event.ActionListener {
	/**
	 * 
	 */
	private final CreditGUI creditForm;

	/**
	 * @param creditForm
	 */
	SymAction(CreditGUI creditForm) {
		this.creditForm = creditForm;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		Object object = event.getSource();
		if (object == this.creditForm.JButton_Exit)
			this.creditForm.JButtonExit_actionPerformed(event);
		else if (object == this.creditForm.JButton_NewCCAccount)
			this.creditForm.JButtonNewCCAC_actionPerformed(event);
		else if (object == this.creditForm.JButton_GenBill)
			this.creditForm.JButtonGenerateBill_actionPerformed(event);
		else if (object == this.creditForm.JButton_Deposit)
			this.creditForm.JButtonDeposit_actionPerformed(event);
		else if (object == this.creditForm.JButton_Withdraw)
			this.creditForm.JButtonWithdraw_actionPerformed(event);
	}
}