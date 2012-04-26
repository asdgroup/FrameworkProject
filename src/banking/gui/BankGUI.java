package banking.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.account.IAccount;
import framework.customer.ICustomer;
import framework.gui.ASystemMainForm;
import framework.system.FinancialCompany;


public class BankGUI extends ASystemMainForm {
	private static final long serialVersionUID = 1L;
	protected String accountnr, customerName, street, city, zip, state,
			accountType, customerType, amountDeposit;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private Object rowdata[];

	private BankGUIFactory factory = new BankGUIFactory(this);

	JPanel JPanel1 = new JPanel();
	JButton JButton_PerAC = new JButton("Add personal account");
	JButton JButton_CompAC = new JButton("Add company account");
	JButton JButton_Addinterest = new JButton("Add interest");
	JButton JButton_Deposit = new JButton("Deposit");
	JButton JButton_Withdraw = new JButton("Withdraw");
	JButton JButton_Exit = new JButton("Exit");
	JButton JButton_Reports = new JButton("Report");
	
	private FinancialCompany bankFacade;
	private int selection; // temporary use
	private String accnr; // temporary use

	public BankGUI(FinancialCompany bankFacade) {
		super();
		setTitle("Bank Application");
		render();
		setVisible(true);
		this.bankFacade = bankFacade;
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
		JButton_Reports.addActionListener(lSymAction);
	}

	public void setTopView() {
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		add(JButton_PerAC);
		add(JButton_CompAC);
		add(JButton_Addinterest);
	}

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

	public void setRightView() {
		JButton_Reports.setBounds(460, 90, 96, 33);
		JButton_Deposit.setBounds(460, 134, 96, 33);
		JButton_Withdraw.setBounds(460, 180, 96, 33);		
		JButton_Exit.setBounds(460, 228, 96, 33);
		add(JButton_Reports);
		add(JButton_Deposit);
		add(JButton_Withdraw);
		add(JButton_Exit);

	}

	class SymAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
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
			else if (object == JButton_Reports)
				JButtonGenerateReport_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(ActionEvent event) {
		System.out.println(bankFacade.generaterReports());
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(ActionEvent event) {
		factory.getBankSubForm("person", "");	
	}

	void JButtonCompAC_actionPerformed(ActionEvent event) {
		factory.getBankSubForm("company", "");
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
		ICustomer customer = bankFacade.createCustomer(customerInfo);
		String[] accountInfo = new String[] { accountType, accountnr };
		IAccount account = bankFacade.createAccount(accountInfo);
		bankFacade.addAccount(customer, account);
		
	}

	void JButtonDeposit_actionPerformed(ActionEvent event) {
		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String) model.getValueAt(selection, 0);
			factory.getBankSubForm("deposit", accnr);
		}
	}

	void JButtonWithdraw_actionPerformed(ActionEvent event) {
		selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			accnr = (String) model.getValueAt(selection, 0);
			factory.getBankSubForm("withdraw", accnr);
		}
	}

	public void operation(String title) {
		double deposit = Double.parseDouble(amountDeposit);
		String samount = (String) model.getValueAt(selection, 5);
		double currentamount = Double.parseDouble(samount);
		if (title.equals("Deposit")) {
			double newamount = currentamount + deposit;
			model.setValueAt(String.valueOf(newamount), selection, 5);
			bankFacade.deposite(accnr, deposit);
		} else if (title.equals("Withdrawal")) {
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

	void JButtonAddinterest_actionPerformed(ActionEvent event) {
		factory.getBankSubForm("interest", "");
	}

	public void addInterest(long amount) {
		int count = model.getRowCount();
		for (int i = 0; i < count; i++) {
			double current = Double
					.parseDouble((String) model.getValueAt(i, 5));
			model.setValueAt(String.valueOf(current + amount), i, 5);
		}
		bankFacade.addInterest(amount);
	}
	
	void JButtonGenerateReport_actionPerformed(ActionEvent event){
		
		factory.getBankSubForm("report", bankFacade.generaterReports());
	}
}
