package bankframework.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

public abstract class ASystemGUI extends JFrame implements ISystemGUI {
	private static final long serialVersionUID = 1L;

	public ASystemGUI(){
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	public ASystemGUI(String title, String style){
		setTitle(title);
		setUIManager(style);
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object.getClass() ==  ASystemGUI.class) {
				System.exit(1);
			}
		}
	}
	
	public void setVisible(boolean flag){
		super.setVisible(flag);
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
	
	@Override
	public void setGUIBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}
}
