package creditapplication;

import javax.swing.UIManager;

public class Test {
	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/

	static public void main(String[] args) {
		try {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			(new CreditGUI()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}
}
