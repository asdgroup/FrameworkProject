package credit.gui;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

public abstract class ASystemSubForm extends JDialog {

	public abstract void render();

	public abstract void JButtonOK_actionPerformed(ActionEvent event);

	public void JButtonCalcel_actionPerformed(ActionEvent event) {
		dispose();
	}

}
