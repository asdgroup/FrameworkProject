package creditcard.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.gui.ASystemMainForm;
import framework.system.SystemFacade;

public class CreditGUI extends ASystemMainForm {
	private static final long serialVersionUID = 1L;
	protected String clientName, street, city, zip, state, accountType, amountDeposit,
			expdate, ccnumber;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private Object rowdata[];

	private CreditGUIFactory factory = new CreditGUIFactory(this);

	JPanel JPanel1 = new JPanel();
	JButton JButton_NewCCAccount = new JButton();
	JButton JButton_GenBill = new JButton();

	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Exit = new JButton();
	
	private SystemFacade creditFacade;
	public CreditGUI(SystemFacade creditFacade) {
		setTitle("Credit Card Processing application");
		render();
		setVisible(true);
		this.creditFacade = creditFacade;
	}

	@Override
	public void render() {
		setTopView();
		setRightView();
		setMiddleView();
		JButton_GenBill.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
	}

	public void setTopView() {
		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
	}

	public void setRightView() {
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 228, 96, 31);
	}

	public void setMiddleView() {

		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[7];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
	}

	class SymAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(ActionEvent event) {
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(ActionEvent event) {
		factory.getBankSubForm("person", "");
		if (newaccount) {
			// add row to table
			rowdata[0] = clientName;
			rowdata[1] = ccnumber;
			rowdata[2] = expdate;
			rowdata[3] = accountType;
			rowdata[4] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		factory.getBankSubForm("generatebills", "dddfadf");
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {

		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			factory.getBankSubForm("deposit", name);

			// compute new amount
			long deposit = Long.parseLong(amountDeposit);
			String samount = (String) model.getValueAt(selection, 4);
			long currentamount = Long.parseLong(samount);
			long newamount = currentamount + deposit;
			model.setValueAt(String.valueOf(newamount), selection, 4);
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			factory.getBankSubForm("withdraw", name);

			// compute new amount
			long deposit = Long.parseLong(amountDeposit);
			String samount = (String) model.getValueAt(selection, 4);
			long currentamount = Long.parseLong(samount);
			long newamount = currentamount - deposit;
			model.setValueAt(String.valueOf(newamount), selection, 4);
			if (newamount < 0) {
				JOptionPane.showMessageDialog(
						JButton_Withdraw,
						" " + name + " Your balance is negative: $"
								+ String.valueOf(newamount) + " !",
						"Warning: negative balance",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
