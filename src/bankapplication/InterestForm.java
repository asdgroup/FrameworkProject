package bankapplication;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bankframework.gui.ASystemGUI;

public class InterestForm extends ASystemGUI{
	private static final long serialVersionUID = 1L;

	private BankGUI parentframe;
	
	public InterestForm(BankGUI gui){
		this.parentframe = gui;
		render();
		this.addWindowListener(new WindowAdapter() {						
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();				
			}						
		});
	}

	
	private JLabel JLabel2 = new JLabel("Interest Amount");
	
	private JButton JButton_OK = new JButton("OK");
	private JButton JButton_Cancel = new JButton("Cancel");
	private JTextField JTextField_Deposit = new JTextField();
	
	@Override
	public void render() {
		getContentPane().setLayout(null);
		setSize(268,156);
		setVisible(false);
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(80,10,100,24);
		
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(30,48,204,24);
		
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		
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
		parentframe.addInterest(Double.parseDouble(JTextField_Deposit.getText()));		
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}
	
}
