package creditapplication;

class SymMouse extends java.awt.event.MouseAdapter {
	/**
	 * 
	 */
	private final CreditForm creditForm;

	/**
	 * @param creditForm
	 */
	SymMouse(CreditForm creditForm) {
		this.creditForm = creditForm;
	}

	public void mouseClicked(java.awt.event.MouseEvent event) {
		Object object = event.getSource();
		if (object == this.creditForm.JRadioButton_Gold)
			this.creditForm.JRadioButtonChk_mouseClicked(event);
		else if (object == this.creditForm.JRadioButton_Silver)
			this.creditForm.JRadioButtonSav_mouseClicked(event);
		else if (object == this.creditForm.JRadioButton_Bronze)
			this.creditForm.JRadioButtonBronze_mouseClicked(event);

	}
}