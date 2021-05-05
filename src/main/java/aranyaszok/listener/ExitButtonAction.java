package main.java.aranyaszok.listener;

import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Exit gombra kattintunk.
 * @author aranyaszok
 *
 */
public class ExitButtonAction implements IMyAction {
	private static final long serialVersionUID = 5075744517125246007L;

	/**
	 *Exit gombra kattintva kilep a program
	 */
	@Override
	public void OnMouseCLick(View w) {
		System.exit(0);
	}
}
