package framework.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class AOperationForm extends ASystemSubForm {
	private static final long serialVersionUID = 1L;
	protected JLabel JLabel1 = new JLabel();
	protected JLabel JLabel2 = new JLabel();
	protected JTextField JTextField_NAME = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	protected JTextField JTextField_Deposit = new JTextField();

	@Override
	public void render() {
		getContentPane().setLayout(null);
		setSize(268, 156);
		setVisible(false);
		setModal(true);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 12, 48, 24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 48, 48, 24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 12, 144, 24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36, 84, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 84, 84, 24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84, 48, 144, 24);
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
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
