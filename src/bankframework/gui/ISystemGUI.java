package bankframework.gui;

public interface ISystemGUI {
	
	public void setTitle(String title);
	public void setVisible(boolean flag);
	public void render();
	public void setUIManager(String style);
	public void setGUIBounds(int x, int y, int width, int height);
}
