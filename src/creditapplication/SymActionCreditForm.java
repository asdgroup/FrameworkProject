package creditapplication;

class SymActionCreditForm implements java.awt.event.ActionListener {
	/**
	 * 
	 */
	private final CreditForm creditForm;

	/**
	 * @param creditForm
	 */
	SymActionCreditForm(CreditForm creditForm) {
		this.creditForm = creditForm;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		Object object = event.getSource();
		if (object == this.creditForm.JButton_OK)
			this.creditForm.JButtonOK_actionPerformed(event);
		else if (object == this.creditForm.JButton_Cancel)
			this.creditForm.JButtonCalcel_actionPerformed(event);
	}
}