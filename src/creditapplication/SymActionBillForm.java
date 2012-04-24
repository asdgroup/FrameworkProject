package creditapplication;

class SymActionBillForm implements java.awt.event.ActionListener {
	/**
	 * 
	 */
	private final BillForm billForm;

	/**
	 * @param billForm
	 */
	SymActionBillForm(BillForm billForm) {
		this.billForm = billForm;
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
		Object object = event.getSource();
		if (object == this.billForm.JButton_OK)
			this.billForm.JButtonOK_actionPerformed(event);
	}
}