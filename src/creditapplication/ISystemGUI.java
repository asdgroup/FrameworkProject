package creditapplication;

public interface ISystemGUI {

	public void setTitle(String title);

	public void setVisible();

	public void render();

	public void setUIManager(String style);

	public void setGUIBounds(int x, int y, int width, int height);
}
