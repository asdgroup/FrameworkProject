package creditapplication;

import javax.swing.JFrame;
import javax.swing.UIManager;

public abstract class ASystemGUI extends JFrame implements ISystemGUI {
	
	public ASystemGUI(String title, String style){
		setTitle(title);
		setUIManager(style);		
		setGUIBounds(300, 400, 500, 500);
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object instanceof ASystemGUI) {
				System.exit(1);
			}
		}
	}
		
	public void setVisible(){
		setVisible(true);
	}
	
	public void setUIManager(String style){
		try {
			if((style == null) ||style.equals("")) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());				
			}else{
				UIManager.setLookAndFeel(style);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void setGUIBounds(int x, int y, int width, int height){		
		setBounds(x, y, width, height);		
	}

	
}
