package framework.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;

public abstract class ASystemMainForm extends JFrame {
	private static final long serialVersionUID = 1L;

	public ASystemMainForm() {
		setBounds(0, 0, 575, 310);
		setLayout(null);
		setUIManager();
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}

	class SymWindow extends WindowAdapter {

		public void windowClosing(WindowEvent event) {
			Object object = event.getSource();
			if (object instanceof ASystemMainForm) {
				System.exit(1);
			}
		}
	}

	public abstract void render();

	public void setUIManager() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
