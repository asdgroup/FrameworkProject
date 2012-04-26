package framework.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class AInterestForm extends ASystemSubForm {
	private static final long serialVersionUID = 1L;
	protected JLabel JLabel2 = new JLabel("Interest Amount");
	protected JButton JButton_OK = new JButton("OK");
	protected JButton JButton_Cancel = new JButton("Cancel");
	protected JTextField JTextField_Deposit = new JTextField();

	@Override
	public void render() {
		getContentPane().setLayout(null);
		setSize(268, 156);
		setVisible(false);
		setModal(true);
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(80, 10, 100, 24);

		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(30, 48, 204, 24);

		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

}
