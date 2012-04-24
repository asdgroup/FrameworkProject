package creditapplication;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * A basic JFC based application.
 */
public class CreditGUI extends ASystemGUI {

	/****
	 * init variables in the object
	 ****/
	String clientName, street, city, zip, state, accountType, amountDeposit,
			expdate, ccnumber;
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();

	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();

	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	private JScrollPane JScrollPane1;
	private JTable JTable1;
	private DefaultTableModel model;
	boolean newaccount;
	private Object rowdata[];

	CreditGUI thisframe;

	public CreditGUI() {
		super("Credit-card processing Application.", null);
		thisframe = this;
		render();
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		ISystemGUI isg = (ISystemGUI) new OperationForm("Deposite", "");
		System.out.println("deposit account....");
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		BillForm billFrm = new BillForm();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();

	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		CreditForm ccac = new CreditForm(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();
	}

	void ShowAddResult() {
		if (newaccount) {
			// add row to table
			rowdata[0] = clientName;
			rowdata[1] = ccnumber;
			rowdata[2] = expdate;
			rowdata[3] = accountType;
			rowdata[4] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(0);
			newaccount = false;
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		ISystemGUI isg = (ISystemGUI) new OperationForm("Deposite", "");
		System.out.println("deposit account....");
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(true);
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
		// rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);

		JButton_GenBill.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction(this);
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
	}

}
