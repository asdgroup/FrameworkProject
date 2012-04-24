package bankapplication;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import bankframework.gui.ASystemGUI;

public class OperationForm extends ASystemGUI{
	private static final long serialVersionUID = 1L;

	private String accnr;
	
	private JLabel JLabel1 = new JLabel();
	private JLabel JLabel2 = new JLabel();
	private JTextField JTextField_NAME = new JTextField();
	private JButton JButton_OK = new JButton();
	private JButton JButton_Cancel = new JButton();
	private JTextField JTextField_Deposit = new JTextField();
	
	private BankGUI parentframe;
	
	public OperationForm(BankGUI parentframe, String anncr){
		this.parentframe = parentframe;
		this.accnr = anncr;
		render();
		this.addWindowListener(new WindowAdapter() {						
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();				
			}						
		});	
	}
	
	@Override
	public void render() {		
		getContentPane().setLayout(null);
		setSize(268,156);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
		//}}
	    JTextField_NAME.setText(accnr);
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}
	
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		parentframe.amountDeposit = JTextField_Deposit.getText();
		parentframe.operation(this.getTitle());
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}
