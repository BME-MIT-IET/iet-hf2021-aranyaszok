package main.java.aranyaszok.listener;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a BackToMenu gombra kattintunk.
 * @author aranyaszok
 *
 */

public class BackToMenuAction implements IMyAction {
	private static final long serialVersionUID = 2998010849990374435L;

	
	/**
	 *BackToMenu gombra kattintva visszalepunk a menube.
	 */
	@Override
	public void OnMouseCLick(View w) {
		w.getPanel().GetViewManager().ChangeSelectedPanel("menu");
	}
}
