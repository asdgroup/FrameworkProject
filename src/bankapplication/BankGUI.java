package bankapplication;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bankframework.account.IAccount;
import bankframework.customer.ICustomer;
import bankframework.gui.ASystemGUI;
import bankframework.gui.ISystemGUI;
import bankframework.system.SystemFacade;

public class BankGUI extends ASystemGUI implements IBankGUIViewFunctor {
	private static final long serialVersionUID = 1L;
	protected String accountnr, customerName, street, city, zip, state,
			accountType, customerType, amountDeposit;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private Object rowdata[];

	private int selection; // temporary use
	private String accnr; // temporary use

	// GUIFactory gf = new GUIFactory();

	JPanel JPanel1 = new JPanel();
	JButton JButton_PerAC = new JButton();
	JButton JButton_CompAC = new JButton();
	JButton JButton_Addinterest = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton_Exit = new JButton();

	private SystemFacade bankFacade;

	public BankGUI(String title, String style, SystemFacade sf) {
		super(title, style);
		render();
		setBounds(0, 0, 575, 310);
		setVisible(true);
		this.bankFacade = sf;
	}

	@Override
	public void render() {
		setLayout(null);
		setTopView();
		setRightView();
		setMiddleView();
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
	}

	@Override
	public void setTopView() {
		JButton_PerAC = new JButton("Add personal account");
		JButton_CompAC = new JButton("Add company account");
		JButton_Addinterest = new JButton("Add interest");
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		add(JButton_PerAC);
		add(JButton_CompAC);
		add(JButton_Addinterest);

	}

	@Override
	public void setMiddleView() {
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newaccount = false;

		add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

	}

	@Override
	public void setRightView() {
		JButton_Deposit = new JButton("Deposit");
		JButton_Withdraw = new JButton("Withdraw");
		JButton_Exit = new JButton("Exit");
		JButton_Withdraw.setBounds(460, 164, 96, 33);
		JButton_Deposit.setBounds(460, 104, 96, 33);
		JButton_Exit.setBounds(460, 228, 96, 33);
		add(JButton_Deposit);
		add(JButton_Withdraw);
		add(JButton_Exit);

	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.out.println(bankFacade.generaterReports());
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		ISystemGUI isg = GUIFactory.getBankGUI("person", this, null);
		isg.setVisible(true);
	}

	public void fillData() {
		if (newaccount) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = customerName;
			rowdata[2] = city;
			rowdata[3] = customerType;
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);

			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}
		String[] customerInfo = new String[] { customerType, customerName,
				street, city, state, zip };
		// CustomerInfo ci = new
		// CustomerInfo(customerType,customerName,street,city,state,zip,null,null,0);
		ICustomer customer = bankFacade.createCustomer(customerInfo);
		String[] accountInfo = new String[] { accountType, accountnr };
		IAccount account = bankFacade.createAccount(accountInfo);
		bankFacade.addAccount(customer, account);
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		ISystemGUI isg = GUIFactory.getBankGUI("company", this, null);
		isg.setVisible(true);
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {

		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String) model.getValueAt(selection, 0);
			ISystemGUI isg = GUIFactory.getBankGUI("deposit", this, accnr);
			isg.setVisible(true);
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String) model.getValueAt(selection, 0);
			ISystemGUI isg = GUIFactory.getBankGUI("withdraw", this, accnr);
			isg.setVisible(true);

//			long deposit = Long.parseLong(amountDeposit);
//			String samount = (String) model.getValueAt(selection, 5);
//			long currentamount = Long.parseLong(samount);

		}
	}

	public void operation(String title) {
		double deposit = Double.parseDouble(amountDeposit);
		String samount = (String) model.getValueAt(selection, 5);
		long currentamount = Long.parseLong(samount);
		if (title.equals("Deposite")) {
			double newamount = currentamount + deposit;
			model.setValueAt(String.valueOf(newamount), selection, 5);
			bankFacade.deposite(accnr, deposit);
		} else {
			double newamount = currentamount - deposit;
			model.setValueAt(String.valueOf(newamount), selection, 5);
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" Account " + accnr + " : balance is negative: $"
								+ String.valueOf(newamount) + " !",
						"Warning: negative balance",
						JOptionPane.WARNING_MESSAGE);
			}
			bankFacade.withdrawal(accnr, deposit);
		}
	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		ISystemGUI isg = GUIFactory.getBankGUI("interest", this, "");
		isg.setVisible(true);
	}

	public void addInterest(double amount) {
		int count = model.getRowCount();
		for (int i = 0; i < count; i++) {
			long current = Long.parseLong((String) model.getValueAt(i, 5));
			model.setValueAt(String.valueOf(current + amount), i, 5);
		}
		bankFacade.addInterest(amount);
	}
}
