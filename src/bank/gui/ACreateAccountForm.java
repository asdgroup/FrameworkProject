package bank.gui;

import javax.swing.*;

public abstract class ACreateAccountForm extends ASystemSubForm {
	private static final long serialVersionUID = 1L;
	protected JRadioButton JRadioButton_Chk = new JRadioButton();
	protected JRadioButton JRadioButton_Sav = new JRadioButton();
	protected JLabel JLabel1 = new JLabel();
	protected JLabel JLabel2 = new JLabel();
	protected JLabel JLabel3 = new JLabel();
	protected JLabel JLabel4 = new JLabel();
	protected JLabel JLabel5 = new JLabel();
	protected JLabel JLabel7 = new JLabel();
	protected JTextField JTextField_NAME = new JTextField();
	protected JTextField JTextField_CT = new JTextField();
	protected JTextField JTextField_ST = new JTextField();
	protected JTextField JTextField_STR = new JTextField();
	protected JTextField JTextField_ZIP = new JTextField();
	protected JTextField JTextField_EM = new JTextField();
	protected JButton JButton_OK = new JButton();
	protected JButton JButton_Cancel = new JButton();
	protected JTextField JTextField_ACNR = new JTextField();
	protected JLabel JLabel8 = new JLabel();

	protected BankGUI parentframe;

	public ACreateAccountForm(BankGUI parentframe) {
		this.parentframe = parentframe;
	}

	public void setView() {
		getContentPane().setLayout(null);
		setSize(283, 343);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36, 0, 84, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36, 24, 84, 24);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12, 84, 48, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12, 108, 48, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12, 132, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12, 156, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12, 180, 48, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12, 228, 48, 24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84, 84, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84, 132, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84, 156, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84, 108, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84, 180, 156, 20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84, 228, 156, 20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 264, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 264, 84, 24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84, 60, 156, 20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12, 60, 48, 24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);

	}

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);

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
